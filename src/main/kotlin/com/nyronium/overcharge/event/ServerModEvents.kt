package com.nyronium.overcharge.event

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.content.item.custom.TesseractItem
import com.nyronium.overcharge.networking.NetworkHandler
import com.nyronium.overcharge.networking.clientbound.TesseractActivationPacket
import com.nyronium.overcharge.registry.ModItems
import com.nyronium.overcharge.util.BaseUtils
import com.nyronium.overcharge.util.EnergyUtils
import net.minecraft.network.chat.Component
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.EntitySelector
import net.minecraft.world.entity.item.ItemEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.phys.AABB
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent
import net.minecraftforge.event.entity.living.LivingHurtEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.network.PacketDistributor

@Mod.EventBusSubscriber(modid = Overcharge.ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
object ServerModEvents {
    private fun getNearbyPlayers(player: Player, offset: Double): List<Player> {
        val box = AABB(
            player.x - offset, player.y - offset, player.z - offset,
            player.x + offset, player.y + offset, player.z + offset
        )
        return player.level().getEntitiesOfClass(
            Player::class.java,
            box,
            EntitySelector.NO_SPECTATORS
        ).filter { it != player }
    }

    @SubscribeEvent
    fun onEntityTravelToDimension(event: EntityTravelToDimensionEvent) {
        if(event.entity !is ItemEntity) return
        val itemEntity = event.entity as ItemEntity
        val itemStack = itemEntity.item
        if(itemStack.item == ModItems.TITANIUM_INGOT.get() && itemStack.count == 1) {
            if(BaseUtils.chance(25)) {
                itemEntity.item = ModItems.DIMENSION_FRAGMENTED_TITANIUM_INGOT.get().defaultInstance
            }
            event.isCanceled = true
        }
    }

    @SubscribeEvent
    fun onLivingHurt(event: LivingHurtEvent) {
        event.entity.sendSystemMessage(Component.literal("${event.amount} ${event.source}"))

        if(event.entity !is Player) return
        val player = event.entity as ServerPlayer

        val isCritical = event.entity.health-event.amount <= 0f
        val playerHasTesseract = player.inventory.hasAnyMatching { it.item == ModItems.TESSERACT.get() }

        if(isCritical) {
            if(!playerHasTesseract) return

            for(item in player.inventory.items) {
                if(item.item == ModItems.TESSERACT.get()) {
                    val tesseractItem = item.item as TesseractItem
                    if(tesseractItem.getEnergyStorage(item).storedEnergy >= 500_000) {
                        EnergyUtils.consume(player, player.inventory.items, item, player.inventory.findSlotMatchingItem(item), 500_000)
                    } else return

                    NetworkHandler.CHANNEL.send(
                        PacketDistributor.PLAYER.with { player },
                        TesseractActivationPacket(item)
                    )

                    val nearbyPlayers = getNearbyPlayers(player, 25.0)
                    for (nearbyPlayer in nearbyPlayers) {
                        nearbyPlayer.sendSystemMessage(Component.literal("selected"))
                        nearbyPlayer.setDeltaMovement(nearbyPlayer.lookAngle.x, 10.0, nearbyPlayer.lookAngle.z)
                        nearbyPlayer.hurt(player.level().damageSources().generic(), 15f)
                    }
                }
            }
            player.addEffect(MobEffectInstance(MobEffects.REGENERATION, 60, 10, false, false))
            event.isCanceled = true
        }
    }
}
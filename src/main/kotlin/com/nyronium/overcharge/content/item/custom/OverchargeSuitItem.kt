package com.nyronium.overcharge.content.item.custom

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.content.item.ModArmorMaterials
import com.nyronium.overcharge.registry.ModItems
import com.nyronium.overcharge.util.EnergyUtils
import com.nyronium.overcharge.util.KeybindManager
import com.nyronium.overcharge.util.TooltipHelper
import earth.terrarium.botarium.common.energy.base.BotariumEnergyItem
import earth.terrarium.botarium.common.energy.impl.SimpleEnergyContainer
import earth.terrarium.botarium.common.energy.impl.WrappedItemEnergyContainer
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.Style
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.level.Level
import net.minecraft.world.level.gameevent.GameEvent
import net.minecraft.world.phys.Vec3
import kotlin.math.exp
import kotlin.math.roundToLong

class OverchargeSuitItem(
    private val energyCapacity: Long = 5_000_000,
    properties: Properties
) : ArmorItem(ModArmorMaterials.OVERCHARGE, Type.CHESTPLATE, properties), BotariumEnergyItem<WrappedItemEnergyContainer> {

    override fun appendHoverText(
        stack: ItemStack,
        level: Level?,
        tooltip: MutableList<Component>,
        flag: TooltipFlag
    ) {
        val energyStorage = getEnergyStorage(stack)
        tooltip.add(TooltipHelper.getEnergyAnnunciator(energyStorage.storedEnergy, energyStorage.maxCapacity))
        super.appendHoverText(stack, level, tooltip, flag)
    }

    override fun isBarVisible(stack: ItemStack): Boolean {
        val energyStorage = getEnergyStorage(stack)
        val energyStored = energyStorage.storedEnergy
        return energyStored > 0
    }

    override fun getBarWidth(stack: ItemStack): Int {
        val energyStorage = getEnergyStorage(stack)
        return (13 * energyStorage.storedEnergy / energyStorage.maxCapacity.toFloat()).toInt()
    }

    override fun getBarColor(stack: ItemStack): Int {
        return Overcharge.COLOR
    }

    override fun getEnergyStorage(holder: ItemStack): WrappedItemEnergyContainer {
        return WrappedItemEnergyContainer(
            holder,
            object : SimpleEnergyContainer(energyCapacity) {
                override fun maxInsert(): Long {
                    return 2500L
                }
            }
        )
    }

    override fun inventoryTick(pStack: ItemStack, pLevel: Level, pEntity: Entity, pSlotId: Int, pIsSelected: Boolean) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected)
        if(pEntity !is Player) return
        val player: Player = pEntity
        if(player.getItemBySlot(EquipmentSlot.CHEST) != pStack) return

        if(player.abilities.flying) return
        if(player.cooldowns.isOnCooldown(pStack.item)) return
        if(!hasFullSet(player)) return

        if(!canFly(player, pStack)) return

        if(KeybindManager.sprintDown(player) && KeybindManager.jumpDown(player)) {
            val energyUsage = (player.deltaMovement.length()*10).roundToLong()
            horizontalFlight(player)
            EnergyUtils.consume(player, player.inventory.armor, pStack, pSlotId, energyUsage)
        } else if(KeybindManager.jumpDown(player)) {
            val energyUsage = (player.deltaMovement.length()*5).roundToLong()
            verticalFlight(player)
            EnergyUtils.consume(player, player.inventory.armor, pStack, pSlotId, energyUsage)
        }
    }

    fun verticalFlight(player: Player) {
        var acceleration: Double = sigmoidAcceleration(player.tickCount, 5.0, 1.0, 2.0)
        acceleration /= 25.0f
        player.addDeltaMovement(Vec3(0.0, 0.0025.coerceAtLeast(acceleration), 0.0))
        player.fallDistance = (player.fallDistance / 1.5f).coerceAtLeast(0.0f)
    }

    fun horizontalFlight(player: Player) {
        val movement: Vec3 = player.lookAngle.normalize().scale(0.075)
        player.addDeltaMovement(movement)
        player.fallDistance = (player.fallDistance / 1.5f).coerceAtLeast(0.0f)
        if(!player.isFallFlying) {
            player.startFallFlying()
        }
    }

    override fun elytraFlightTick(stack: ItemStack, entity: LivingEntity, flightTicks: Int): Boolean {
        if(entity.level().isClientSide) return true
        if(this.type != Type.CHESTPLATE) return true
        val nextFlightTick: Int = flightTicks + 1
        if(nextFlightTick % 10 == 0) return true

        entity.gameEvent(GameEvent.ELYTRA_GLIDE)

        if(entity is Player) {
            entity.displayClientMessage(Component.literal("Speed: ${(entity.deltaMovement.length()*20).roundToLong()}m/s")
                .withStyle(Style.EMPTY.withColor(Overcharge.COLOR)), true)
        }
        return true
    }

    private fun canFly(player: Player, stack: ItemStack): Boolean {
        return player.isCreative || getEnergyStorage(stack).storedEnergy > 0
    }

    override fun canElytraFly(stack: ItemStack, entity: LivingEntity): Boolean {
        return entity is Player && canFly(entity, stack) && KeybindManager.sprintDown(entity)
    }

    fun sigmoidAcceleration(time: Int, peakTime: Double, peakAccel: Double, initAccel: Double): Double {
        return ((2 * peakAccel) / (1 + exp(-time / peakTime)) - peakAccel) + initAccel
    }

    fun hasFullSet(pPlayer: Player): Boolean {
        return pPlayer.getItemBySlot(EquipmentSlot.HEAD).item == ModItems.OVERCHARGE_HELMET.get() && pPlayer.getItemBySlot(EquipmentSlot.CHEST).item == ModItems.OVERCHARGE_CHESTPLATE.get() && pPlayer.getItemBySlot(EquipmentSlot.LEGS).item == ModItems.OVERCHARGE_LEGGINGS.get() && pPlayer.getItemBySlot(EquipmentSlot.FEET).item == ModItems.OVERCHARGE_BOOTS.get()
    }

    override fun isDamageable(itemstack: ItemStack): Boolean {
        return false
    }

    override fun getDamage(itemstack: ItemStack): Int {
        return 0
    }
}
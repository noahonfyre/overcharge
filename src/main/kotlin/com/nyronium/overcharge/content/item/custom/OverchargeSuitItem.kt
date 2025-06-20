package com.nyronium.overcharge.content.item.custom

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.content.item.ModArmorMaterials
import com.nyronium.overcharge.content.item.base.UnbreakableArmorItem
import com.nyronium.overcharge.registry.ModItems
import com.nyronium.overcharge.util.KeybindManager
import com.nyronium.overcharge.util.TooltipHelper
import earth.terrarium.botarium.common.energy.base.BotariumEnergyItem
import earth.terrarium.botarium.common.energy.impl.SimpleEnergyContainer
import earth.terrarium.botarium.common.energy.impl.WrappedItemEnergyContainer
import net.minecraft.ChatFormatting
import net.minecraft.client.Minecraft
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.Style
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.level.Level
import net.minecraft.world.level.gameevent.GameEvent
import net.minecraft.world.phys.Vec3
import kotlin.math.atan2
import kotlin.math.exp
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.roundToLong
import kotlin.math.sqrt

class OverchargeSuitItem(
    private val energyCapacity: Long,
    properties: Properties
) : UnbreakableArmorItem(ModArmorMaterials.OVERCHARGE, Type.CHESTPLATE, properties), BotariumEnergyItem<WrappedItemEnergyContainer> {

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
                    return 7500L
                }
            }
        )
    }

    override fun inventoryTick(pStack: ItemStack, pLevel: Level, pEntity: Entity, pSlotId: Int, pIsSelected: Boolean) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected)
        if(pEntity !is Player) return
        val player: Player = pEntity
        if(player.getItemBySlot(EquipmentSlot.CHEST) != pStack) return

        if(!KeybindManager.flightEnabled(player)) return
        if(player.abilities.flying) return
        if(player.cooldowns.isOnCooldown(pStack.item)) return
        if(!hasFullSet(player)) return

        if(!canFly(player, pStack)) return

        if(KeybindManager.sprintDown(player) && KeybindManager.jumpDown(player)) {
            val energyUsage = (player.deltaMovement.length()).pow(2).roundToLong().coerceAtMost(25)*10
            horizontalFlight(player)
            getEnergyStorage(pStack).internalExtract(energyUsage, false)
        } else if(KeybindManager.jumpDown(player)) {
            val energyUsage = (player.deltaMovement.length()).pow(2).roundToLong().coerceAtMost(5)*10
            verticalFlight(player)
            getEnergyStorage(pStack).internalExtract(energyUsage, false)
        }
    }

    fun verticalFlight(player: Player) {
        val acceleration: Double = sigmoidAcceleration(player.tickCount, 5.0, 1.0, 2.0) / 18.0f
        player.addDeltaMovement(Vec3(0.0, 0.0025.coerceAtLeast(acceleration), 0.0))
        player.fallDistance = (player.fallDistance / 1.5f).coerceAtLeast(0.0f)
    }

    fun horizontalFlight(player: Player) {
        val movement: Vec3 = player.lookAngle.normalize().scale(0.1)
        if(player.deltaMovement.length()*20 >= 100) return
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
            val player: Player = entity

            val speed = player.deltaMovement.length()*20
            val horizontalMovement = sqrt(player.deltaMovement.x*player.deltaMovement.x + player.deltaMovement.z*player.deltaMovement.z)

            val energyUsage = if(KeybindManager.jumpDown(player)) (player.deltaMovement.length()).pow(2).roundToLong().coerceAtMost(25)*10 else 0
            val energyPercentage = ((getEnergyStorage(stack).storedEnergy.toDouble()/getEnergyStorage(stack).maxCapacity.toDouble())*100).roundToInt()

            val kmh = (speed*3.6).roundToLong()

            val rateOfClimb = ((player.deltaMovement.y*20*3.6)/10).roundToLong()*10
            val altitude = player.y.roundToLong()-62

            val pitch = player.xRot.roundToLong()
            val yaw = player.yRot.roundToLong()
            val angleOfAttack = (atan2(player.deltaMovement.y, horizontalMovement) * 180 / Math.PI).roundToLong()

            player.displayClientMessage(
                Component.literal("${energyUsage}W").withStyle(Style.EMPTY.withColor(ChatFormatting.GOLD))
                    .append(Component.literal(" | ").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)))
                    .append(Component.literal("${energyPercentage}%").withStyle(Style.EMPTY.withColor(ChatFormatting.GOLD)))
                    .append(Component.literal(" | ").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)))
                    .append(Component.literal("${kmh}km/h").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_PURPLE)))
                    .append(Component.literal(" | ").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)))
                    .append(Component.literal("FL${altitude}").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GREEN)))
                    .append(Component.literal(" | ").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)))
                    .append(Component.literal(when {rateOfClimb == 0L -> "LVL"; rateOfClimb < 0L -> "$rateOfClimb DSC"; else -> "+$rateOfClimb CLB"}).withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GREEN)))
                    .append(Component.literal(" | ").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)))
                    .append(Component.literal("${-pitch}°").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_AQUA)))
                    .append(Component.literal(" | ").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)))
                    .append(Component.literal("${yaw}°").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_AQUA)))
                    .append(Component.literal(" | ").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)))
                    .append(Component.literal("AOA ${angleOfAttack}°").withStyle(Style.EMPTY.withColor(ChatFormatting.AQUA))),
                true
            )
        }
        return true
    }

    private fun canFly(player: Player, stack: ItemStack): Boolean {
        return player.isCreative || getEnergyStorage(stack).storedEnergy > 0
    }

    override fun canElytraFly(stack: ItemStack, entity: LivingEntity): Boolean {
        return entity is Player && canFly(entity, stack) && KeybindManager.sprintDown(entity) && KeybindManager.flightEnabled(entity)
    }

    fun sigmoidAcceleration(time: Int, peakTime: Double, peakAccel: Double, initAccel: Double): Double {
        return ((2 * peakAccel) / (1 + exp(-time / peakTime)) - peakAccel) + initAccel
    }

    fun hasFullSet(pPlayer: Player): Boolean {
        return pPlayer.getItemBySlot(EquipmentSlot.HEAD).item == ModItems.OVERCHARGE_HELMET.get() && pPlayer.getItemBySlot(EquipmentSlot.CHEST).item == ModItems.OVERCHARGE_CHESTPLATE.get() && pPlayer.getItemBySlot(EquipmentSlot.LEGS).item == ModItems.OVERCHARGE_LEGGINGS.get() && pPlayer.getItemBySlot(EquipmentSlot.FEET).item == ModItems.OVERCHARGE_BOOTS.get()
    }
}
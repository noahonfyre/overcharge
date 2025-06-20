package com.nyronium.overcharge.content.item.custom

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.util.TooltipHelper
import earth.terrarium.botarium.common.energy.base.BotariumEnergyItem
import earth.terrarium.botarium.common.energy.impl.SimpleEnergyContainer
import earth.terrarium.botarium.common.energy.impl.WrappedItemEnergyContainer
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.Style
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.level.Level

class TesseractItem(properties: Properties, private val maxEnergy: Long) : Item(properties),
    BotariumEnergyItem<WrappedItemEnergyContainer> {
    companion object {
        const val MODE_KEY = "mode"
    }

    enum class Mode(val effect: MobEffectInstance? = null) {
        OFF,
        SPEED(MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1, 1, false, false)),
        HASTE(MobEffectInstance(MobEffects.DIG_SPEED, 1, 1, false, false)),
        RESISTANCE(MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 1, 1, false, false)),
        JUMP_BOOST(MobEffectInstance(MobEffects.JUMP, 1, 1, false, false)),
        STRENGTH(MobEffectInstance(MobEffects.DAMAGE_BOOST, 1, 1, false, false)),
        REGENERATION(MobEffectInstance(MobEffects.REGENERATION, 1, 1, false, false));

        fun next(): Mode = entries[(ordinal + 1) % entries.size]
    }

    private fun switchMode(stack: ItemStack) {
        setMode(stack, getMode(stack).next())
    }

    private fun getMode(stack: ItemStack): Mode {
        val nbt = stack.orCreateTag
        return Mode.entries[nbt.getInt(MODE_KEY)]
    }

    private fun setMode(stack: ItemStack, mode: Mode) {
        val nbt = stack.orCreateTag
        nbt.putInt(MODE_KEY, mode.ordinal)
    }

    override fun getEnergyStorage(holder: ItemStack): WrappedItemEnergyContainer {
        return WrappedItemEnergyContainer(
            holder,
            object : SimpleEnergyContainer(maxEnergy) {
                override fun maxInsert(): Long {
                    return 5000L
                }
            }
        )
    }

    override fun inventoryTick(pStack: ItemStack, pLevel: Level, pEntity: Entity, pSlotId: Int, pIsSelected: Boolean) {
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected)
        if(pEntity !is Player) return
        if(getEnergyStorage(pStack).storedEnergy >= 0) {
            if(getMode(pStack) == Mode.OFF) return
            pEntity.addEffect(getMode(pStack).effect!!)
            getEnergyStorage(pStack).internalExtract(5, false)
        }
    }

    override fun use(pLevel: Level, pPlayer: Player, pUsedHand: InteractionHand): InteractionResultHolder<ItemStack> {
        switchMode(pPlayer.getItemInHand(pUsedHand))
        pPlayer.displayClientMessage(
            Component.literal("Changed mode to: " + getMode(pPlayer.getItemInHand(pUsedHand)).name).withStyle(
                Style.EMPTY.withColor(Overcharge.COLOR)), true)
        return super.use(pLevel, pPlayer, pUsedHand)
    }

    override fun isBarVisible(stack: ItemStack): Boolean {
        val energyStored = getEnergyStorage(stack).storedEnergy
        return energyStored > 0
    }

    override fun getBarWidth(stack: ItemStack): Int {
        val energyStored = getEnergyStorage(stack).storedEnergy
        val energyCapacity = getEnergyStorage(stack).maxCapacity

        return (13 * energyStored / energyCapacity.toFloat()).toInt()
    }

    override fun getBarColor(stack: ItemStack): Int {
        return Overcharge.COLOR
    }

    override fun appendHoverText(
        stack: ItemStack,
        level: Level?,
        tooltip: MutableList<Component>,
        flag: TooltipFlag
    ) {
        val energyStored = getEnergyStorage(stack).storedEnergy
        val energyCapacity = getEnergyStorage(stack).maxCapacity
        tooltip.add(TooltipHelper.getEnergyAnnunciator(energyStored, energyCapacity))
        super.appendHoverText(stack, level, tooltip, flag)
    }
}
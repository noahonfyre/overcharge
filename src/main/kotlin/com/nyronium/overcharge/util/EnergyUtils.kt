package com.nyronium.overcharge.util

import earth.terrarium.botarium.common.energy.base.EnergyContainer
import earth.terrarium.botarium.common.item.ItemStackHolder
import net.minecraft.core.NonNullList
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack

object EnergyUtils {
    fun consume(player: Player, inventory: NonNullList<ItemStack>, stack: ItemStack, slotId: Int, amount: Long) {
        if (player.isCreative || player.isSpectator || player.level().isClientSide()) return
        val stackHolder = ItemStackHolder(stack)
        val container = EnergyContainer.of(stackHolder)
        if (container == null) return
        container.internalExtract(amount, false)
        inventory[slotId] = stackHolder.stack
    }
}
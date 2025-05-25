package com.nyronium.overcharge.content.item.base

import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack

class GlintItem(properties: Properties) : Item(properties) {
    override fun isFoil(pStack: ItemStack): Boolean {
        return true
    }
}
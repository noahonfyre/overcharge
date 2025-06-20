package com.nyronium.overcharge.content.item.base

import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraft.world.item.enchantment.EnchantmentCategory

open class UnbreakableArmorItem(val pMaterial: ArmorMaterial, val pType: Type, pProperties: Properties) : ArmorItem(pMaterial, pType, pProperties) {
    override fun isDamageable(itemstack: ItemStack): Boolean = false
    override fun getDamage(itemstack: ItemStack): Int = 0

    override fun isEnchantable(pStack: ItemStack): Boolean = true
    override fun getEnchantmentValue(): Int = pMaterial.enchantmentValue

    override fun canApplyAtEnchantingTable(stack: ItemStack, enchantment: Enchantment): Boolean {
        val enchantmentCategoryMatch = when(pType) {
            Type.HELMET -> enchantment.category == EnchantmentCategory.ARMOR_HEAD
            Type.CHESTPLATE -> enchantment.category == EnchantmentCategory.ARMOR_CHEST
            Type.LEGGINGS -> enchantment.category == EnchantmentCategory.ARMOR_LEGS
            Type.BOOTS -> enchantment.category == EnchantmentCategory.ARMOR_FEET
        }
        return enchantmentCategoryMatch || enchantment.category == EnchantmentCategory.ARMOR || super.canApplyAtEnchantingTable(stack, enchantment)
    }
}
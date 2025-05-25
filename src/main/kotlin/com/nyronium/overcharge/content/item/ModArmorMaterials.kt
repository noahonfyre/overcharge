package com.nyronium.overcharge.content.item

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.registry.ModItems
import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.ArmorMaterials
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.Ingredient
import java.util.function.Supplier

enum class ModArmorMaterials(
    private val armorName: String,
    private val durabilityMultiplier: Int,
    private val protectionAmounts: IntArray,
    private val enchantmentValue: Int,
    private val equipSound: SoundEvent,
    private val toughness: Float,
    private val knockbackResistance: Float,
    private val repairIngredient: Supplier<Ingredient>
) : ArmorMaterial {
    ALUMINUM("aluminum", 25, intArrayOf(6, 16, 12, 6), 30, SoundEvents.ARMOR_EQUIP_IRON, 2f, 0.5f, Supplier<Ingredient> { Ingredient.of(
        ModItems.ALUMINUM_INGOT.get()
    ) }),
    STEEL("steel", 80, intArrayOf(6, 16, 12, 6), 30, SoundEvents.ARMOR_EQUIP_CHAIN, 3f, 0.5f, Supplier<Ingredient> { Ingredient.of(
        ModItems.STEEL_INGOT.get()
    ) }),
    TITANIUM("TITANIUM", 80, intArrayOf(6, 16, 12, 6), 30, SoundEvents.ARMOR_EQUIP_CHAIN, 4f, 0.5f, Supplier<Ingredient> { Ingredient.of(
        ModItems.TITANIUM_INGOT.get()
    ) }),
    OVERCHARGE("overcharge", 150, intArrayOf(12, 24, 16, 12), 30, SoundEvents.ARMOR_EQUIP_NETHERITE, 6f, 1f, Supplier<Ingredient> { Ingredient.of(

    ) });

    override fun getDurabilityForType(pType: ArmorItem.Type): Int {
        return BASE_DURABILITY[pType.ordinal] * this.durabilityMultiplier
    }

    override fun getDefenseForType(pType: ArmorItem.Type): Int {
        return protectionAmounts[pType.ordinal]
    }

    override fun getEnchantmentValue(): Int {
        return enchantmentValue
    }

    override fun getEquipSound(): SoundEvent {
        return this.equipSound
    }

    override fun getRepairIngredient(): Ingredient {
        return repairIngredient.get()
    }

    override fun getName(): String {
        return Overcharge.ID + ":" + this.armorName
    }

    override fun getToughness(): Float {
        return this.toughness
    }

    override fun getKnockbackResistance(): Float {
        return this.knockbackResistance
    }

    companion object {
        private val BASE_DURABILITY = intArrayOf(11, 16, 16, 13)
    }
}
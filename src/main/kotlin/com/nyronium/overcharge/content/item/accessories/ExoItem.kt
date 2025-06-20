package com.nyronium.overcharge.content.item.accessories

import com.google.common.collect.ImmutableMultimap
import com.google.common.collect.Multimap
import com.nyronium.overcharge.content.item.ItemAttributeModifierExtension
import net.minecraft.world.entity.ai.attributes.Attribute
import net.minecraft.world.entity.ai.attributes.AttributeModifier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraftforge.common.ForgeMod
import top.theillusivec4.curios.api.SlotContext
import top.theillusivec4.curios.api.type.capability.ICurioItem
import java.util.*

class ExoItem(properties: Properties) : Item(properties), ICurioItem, ItemAttributeModifierExtension {
    private val attributeModifiers: Multimap<Attribute, AttributeModifier> = ImmutableMultimap.builder<Attribute, AttributeModifier>()
        .put(ForgeMod.ENTITY_REACH.get(), AttributeModifier(BASE_ENTITY_INTERACTION_RANGE_ID, "Accessory modifier", 3.0, AttributeModifier.Operation.ADDITION))
        .put(ForgeMod.BLOCK_REACH.get(), AttributeModifier(BASE_BLOCK_INTERACTION_RANGE_ID, "Accessory modifier", 3.0, AttributeModifier.Operation.ADDITION))
        .put(Attributes.ARMOR_TOUGHNESS, AttributeModifier(BASE_ARMOR_TOUGHNESS_ID, "Accessory modifier", 8.0, AttributeModifier.Operation.ADDITION))
        .put(Attributes.ARMOR, AttributeModifier(BASE_ARMOR_ID, "Accessory modifier", 12.0, AttributeModifier.Operation.ADDITION))
        .build()

    override fun getAttributeModifiers(slotContext: SlotContext, uuid: UUID, stack: ItemStack): Multimap<Attribute, AttributeModifier> {
        return attributeModifiers
    }
}
package com.nyronium.overcharge.content.item.accessories

import com.google.common.collect.HashMultimap
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
import java.util.UUID

class FractureItem(properties: Properties) : Item(properties), ICurioItem, ItemAttributeModifierExtension {
    private val attributeModifiers: Multimap<Attribute, AttributeModifier> = ImmutableMultimap.builder<Attribute, AttributeModifier>()
        .put(Attributes.ATTACK_SPEED, AttributeModifier(BASE_ATTACK_SPEED_UUID, "Accessory modifier", 0.8, AttributeModifier.Operation.ADDITION))
        .put(Attributes.ARMOR, AttributeModifier(BASE_ARMOR_ID, "Accessory modifier", 4.0, AttributeModifier.Operation.ADDITION))
        .build()

    override fun getAttributeModifiers(slotContext: SlotContext, uuid: UUID, stack: ItemStack): Multimap<Attribute, AttributeModifier> {
        return attributeModifiers
    }
}
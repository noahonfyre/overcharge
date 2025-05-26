package com.nyronium.overcharge.content.item.custom

import com.google.common.collect.HashMultimap
import com.google.common.collect.ImmutableMultimap
import com.google.common.collect.Multimap
import com.nyronium.overcharge.content.item.ItemAttributeModifierExtension
import net.minecraft.world.entity.ai.attributes.Attribute
import net.minecraft.world.entity.ai.attributes.AttributeModifier
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraftforge.common.ForgeMod
import top.theillusivec4.curios.api.SlotContext
import top.theillusivec4.curios.api.type.capability.ICurioItem
import java.util.UUID

class NiagaraItem(properties: Properties) : Item(properties), ICurioItem, ItemAttributeModifierExtension {
    var itemAttributes: Multimap<Attribute, AttributeModifier> = HashMultimap.create()

    init {
        val builder: ImmutableMultimap.Builder<Attribute, AttributeModifier> = ImmutableMultimap.builder()
        builder.put(
            ForgeMod.ENTITY_REACH.get(),
            AttributeModifier(
                BASE_ENTITY_INTERACTION_RANGE_ID,
                "Tool modifier",
                5.0,
                AttributeModifier.Operation.ADDITION
            )
        )
        builder.put(
            ForgeMod.BLOCK_REACH.get(),
            AttributeModifier(
                BASE_BLOCK_INTERACTION_RANGE_ID,
                "Tool modifier",
                5.0,
                AttributeModifier.Operation.ADDITION
            )
        )
        itemAttributes = builder.build()
    }

    override fun getAttributeModifiers(slotContext: SlotContext, uuid: UUID, stack: ItemStack): Multimap<Attribute, AttributeModifier> {
        return itemAttributes
    }
}
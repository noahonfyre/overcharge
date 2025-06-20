package com.nyronium.overcharge.registry

import com.nyronium.overcharge.Overcharge
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.tags.ItemTags
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block

object ModTags {
    object Blocks {
        val MINABLE: TagKey<Block> = forgeTag("minable")

        val NEEDS_ALUMINUM_TOOL: TagKey<Block> = tag("needs_aluminum_tool")
        val NEEDS_STEEL_TOOL: TagKey<Block> = tag("needs_steel_tool")
        val NEEDS_TITANIUM_TOOL: TagKey<Block> = tag("needs_titanium_tool")
        val NEEDS_SYNTHETIC_TOOL: TagKey<Block> = tag("needs_synthetic_tool")
        val NEEDS_OVERCHARGE_TOOL: TagKey<Block> = tag("needs_overcharge_tool")

        private fun tag(name: String): TagKey<Block> {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(Overcharge.ID, name))
        }

        private fun forgeTag(name: String): TagKey<Block> {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("forge", name))
        }
    }

    object Items {
        val CURIO_HEAD_SLOT: TagKey<Item> = curiosTag("head")
        val CURIO_BRACELET_SLOT: TagKey<Item> = curiosTag("bracelet")
        val CURIO_RING_SLOT: TagKey<Item> = curiosTag("ring")
        val CURIO_BACK_SLOT: TagKey<Item> = curiosTag("back")
        val CURIO_HANDS_SLOT: TagKey<Item> = curiosTag("hands")
        val CURIO_BODY_SLOT: TagKey<Item> = curiosTag("body")
        val CURIO_BELT_SLOT: TagKey<Item> = curiosTag("belt")
        val CURIO_CHARM_SLOT: TagKey<Item> = curiosTag("charm")

        private fun tag(name: String): TagKey<Item> {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(Overcharge.ID, name))
        }
        private fun curiosTag(name: String): TagKey<Item> {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("curios", name))
        }

        private fun forgeTag(name: String): TagKey<Item> {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", name))
        }
    }
}
package com.nyronium.overcharged.registry

import com.nyronium.overcharged.Overcharged
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.tags.ItemTags
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block

class ModTags {
    object Blocks {
        val NEEDS_ALUMINUM_TOOL: TagKey<Block> = tag("needs_aluminum_tool")
        val NEEDS_STEEL_TOOL: TagKey<Block> = tag("needs_steel_tool")
        val NEEDS_TITANIUM_TOOL: TagKey<Block> = tag("needs_steel_tool")

        private fun tag(name: String): TagKey<Block> {
            return BlockTags.create(ResourceLocation(Overcharged.ID, name))
        }

        private fun forgeTag(name: String): TagKey<Block> {
            return BlockTags.create(ResourceLocation("forge", name))
        }
    }

    object Items {
        val CURIO_BRACELET_SLOT: TagKey<Item> = curiosTag("bracelet")
        val CURIO_RING_SLOT: TagKey<Item> = curiosTag("ring")
        val CURIO_BACK_SLOT: TagKey<Item> = curiosTag("back")
        val CURIO_BODY_SLOT: TagKey<Item> = curiosTag("body")

        private fun tag(name: String): TagKey<Item> {
            return ItemTags.create(ResourceLocation(Overcharged.ID, name))
        }
        private fun curiosTag(name: String): TagKey<Item> {
            return ItemTags.create(ResourceLocation("curios", name))
        }

        private fun forgeTag(name: String): TagKey<Item> {
            return ItemTags.create(ResourceLocation("forge", name))
        }
    }
}
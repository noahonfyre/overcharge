package com.nyronium.overcharge.content.item

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.registry.ModItems
import com.nyronium.overcharge.registry.ModTags
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.Tier
import net.minecraft.world.item.Tiers
import net.minecraft.world.item.crafting.Ingredient
import net.minecraftforge.common.ForgeTier
import net.minecraftforge.common.TierSortingRegistry

object ModToolTiers {
    var ALUMINUM: Tier = TierSortingRegistry.registerTier(
        ForgeTier(3, 648, 8f, 3f, 30, ModTags.Blocks.NEEDS_ALUMINUM_TOOL) { Ingredient.of(ModItems.ALUMINUM_INGOT.get()) },
        ResourceLocation.tryBuild(Overcharge.ID, "aluminum"), listOf(Tiers.DIAMOND), listOf(Tiers.NETHERITE)
    )
    var LITHIUM: Tier = TierSortingRegistry.registerTier(
        ForgeTier(3, 648, 8f, 3f, 30, ModTags.Blocks.NEEDS_ALUMINUM_TOOL) { Ingredient.of(ModItems.ALUMINUM_INGOT.get()) },
        ResourceLocation.tryBuild(Overcharge.ID, "lithium"), listOf(Tiers.DIAMOND), listOf(Tiers.NETHERITE)
    )
    var STEEL: Tier = TierSortingRegistry.registerTier(
        ForgeTier(4, 2432, 12f, 6f, 30, ModTags.Blocks.NEEDS_STEEL_TOOL) { Ingredient.of(ModItems.STEEL_INGOT.get()) },
        ResourceLocation.tryBuild(Overcharge.ID, "steel"), listOf(Tiers.DIAMOND), listOf(Tiers.NETHERITE)
    )
    var TITANIUM: Tier = TierSortingRegistry.registerTier(
        ForgeTier(5, 4864, 24f, 12f, 30, ModTags.Blocks.NEEDS_TITANIUM_TOOL) { Ingredient.of(ModItems.TITANIUM_INGOT.get()) },
        ResourceLocation.tryBuild(Overcharge.ID, "titanium"), listOf(Tiers.NETHERITE), listOf()
    )
    var OVERCHARGE: Tier = TierSortingRegistry.registerTier(
        ForgeTier(6, 1, 64f, 16f, 30, ModTags.Blocks.NEEDS_OVERCHARGE_TOOL) { Ingredient.of() },
        ResourceLocation.tryBuild(Overcharge.ID, "overcharge"), listOf(TITANIUM), listOf()
    )
}
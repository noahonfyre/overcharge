package com.nyronium.overcharge.infrastructure.worldgen

import net.minecraft.world.level.levelgen.placement.*

object ModOrePlacement {
    private fun orePlacement(pFirstPlacementModifier: PlacementModifier, pSecondPlacementModifier: PlacementModifier): List<PlacementModifier> {
        return listOf(pFirstPlacementModifier, InSquarePlacement.spread(), pSecondPlacementModifier, BiomeFilter.biome())
    }

    fun commonOrePlacement(pCount: Int, pHeightRange: PlacementModifier): List<PlacementModifier> {
        return orePlacement(CountPlacement.of(pCount), pHeightRange)
    }

    fun rareOrePlacement(pChance: Int, pHeightRange: PlacementModifier): List<PlacementModifier> {
        return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange)
    }
}
package com.nyronium.overcharge.infrastructure.worldgen

import com.nyronium.overcharge.Overcharge
import net.minecraft.core.Holder
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.levelgen.VerticalAnchor
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import net.minecraft.world.level.levelgen.placement.PlacementModifier


object ModPlacedFeatures {
    val ALUMINUM_ORE_PLACED_KEY: ResourceKey<PlacedFeature> = registerKey("aluminum_ore_placed")
    val LITHIUM_ORE_PLACED_KEY: ResourceKey<PlacedFeature> = registerKey("lithium_ore_placed")
    val MINERAL_COMPOUND_ORE_PLACED_KEY: ResourceKey<PlacedFeature> = registerKey("mineral_compound_ore_placed")
    val TITANIUM_ORE_PLACED_KEY: ResourceKey<PlacedFeature> = registerKey("titanium_ore_placed")
    val URANIUM_ORE_PLACED_KEY: ResourceKey<PlacedFeature> = registerKey("uranium_ore_placed")

    fun bootstrap(context: BootstapContext<PlacedFeature>) {
        val configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE)

        register(
            context,
            ALUMINUM_ORE_PLACED_KEY,
            configuredFeatures.getOrThrow(ModConfiguredFeatures.ALUMINUM_ORE_KEY),
            ModOrePlacement.commonOrePlacement(
                16,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(319))
            )
        )
        register(
            context,
            LITHIUM_ORE_PLACED_KEY,
            configuredFeatures.getOrThrow(ModConfiguredFeatures.LITHIUM_ORE_KEY),
            ModOrePlacement.commonOrePlacement(
                12,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(319))
            )
        )
        register(
            context,
            MINERAL_COMPOUND_ORE_PLACED_KEY,
            configuredFeatures.getOrThrow(ModConfiguredFeatures.MINERAL_COMPOUND_ORE_KEY),
            ModOrePlacement.commonOrePlacement(
                24,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(319))
            )
        )
        register(
            context,
            TITANIUM_ORE_PLACED_KEY,
            configuredFeatures.getOrThrow(ModConfiguredFeatures.TITANIUM_ORE_KEY),
            ModOrePlacement.commonOrePlacement(
                2,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(319))
            )
        )
        register(
            context,
            URANIUM_ORE_PLACED_KEY,
            configuredFeatures.getOrThrow(ModConfiguredFeatures.URANIUM_ORE_KEY),
            ModOrePlacement.commonOrePlacement(
                4,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(319))
            )
        )
    }


    private fun registerKey(name: String): ResourceKey<PlacedFeature> {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation(Overcharge.ID, name))
    }

    private fun register(
        context: BootstapContext<PlacedFeature>,
        key: ResourceKey<PlacedFeature>,
        configuration: Holder<ConfiguredFeature<*, *>>,
        modifiers: List<PlacementModifier>
    ) {
        context.register(key, PlacedFeature(configuration, java.util.List.copyOf(modifiers)))
    }
}
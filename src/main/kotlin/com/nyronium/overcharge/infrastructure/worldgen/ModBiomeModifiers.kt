package com.nyronium.overcharge.infrastructure.worldgen

import com.nyronium.overcharge.Overcharge
import net.minecraft.core.HolderSet
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BiomeTags
import net.minecraft.world.level.levelgen.GenerationStep
import net.minecraftforge.common.world.BiomeModifier
import net.minecraftforge.common.world.ForgeBiomeModifiers.AddFeaturesBiomeModifier
import net.minecraftforge.registries.ForgeRegistries


object ModBiomeModifiers {
    val ADD_ALUMINUM_ORE: ResourceKey<BiomeModifier> = registerKey("add_aluminum_ore")
    val ADD_LITHIUM_ORE: ResourceKey<BiomeModifier> = registerKey("add_lithium_ore")
    val ADD_MINERAL_COMPOUND_ORE: ResourceKey<BiomeModifier> = registerKey("add_mineral_compound_ore")
    val ADD_NICKEL_ORE: ResourceKey<BiomeModifier> = registerKey("add_nickel_ore")
    val ADD_SILICON_ORE: ResourceKey<BiomeModifier> = registerKey("add_silicon_ore")
    val ADD_TITANIUM_ORE: ResourceKey<BiomeModifier> = registerKey("add_titanium_ore")
    val ADD_URANIUM_ORE: ResourceKey<BiomeModifier> = registerKey("add_uranium_ore")


    fun bootstrap(context: BootstapContext<BiomeModifier>) {
        val placedFeatures = context.lookup(Registries.PLACED_FEATURE)
        val biomes = context.lookup(Registries.BIOME)
        context.register(
            ADD_ALUMINUM_ORE, AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ALUMINUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
            )
        )
        context.register(
            ADD_LITHIUM_ORE, AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LITHIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
            )
        )
        context.register(
            ADD_MINERAL_COMPOUND_ORE, AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.MINERAL_COMPOUND_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
            )
        )
        context.register(
            ADD_NICKEL_ORE, AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NICKEL_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
            )
        )
        context.register(
            ADD_SILICON_ORE, AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SILICON_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
            )
        )
        context.register(
            ADD_TITANIUM_ORE, AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.TITANIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
            )
        )
        context.register(
            ADD_URANIUM_ORE, AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.URANIUM_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES
            )
        )
    }

    private fun registerKey(name: String): ResourceKey<BiomeModifier> {
        return ResourceKey.create(
            ForgeRegistries.Keys.BIOME_MODIFIERS,
            ResourceLocation(Overcharge.ID, name)
        )
    }
}
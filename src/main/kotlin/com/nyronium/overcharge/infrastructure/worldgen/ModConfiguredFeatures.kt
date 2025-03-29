package com.nyronium.overcharge.infrastructure.worldgen

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.registry.ModBlocks
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.DropExperienceBlock
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration.TargetBlockState
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest
import net.minecraftforge.registries.RegistryObject


object ModConfiguredFeatures {
    val ALUMINUM_ORE_KEY: ResourceKey<ConfiguredFeature<*, *>> = registerKey("aluminum_ore")
    val LITHIUM_ORE_KEY: ResourceKey<ConfiguredFeature<*, *>> = registerKey("lithium_ore")
    val MINERAL_COMPOUND_ORE_KEY: ResourceKey<ConfiguredFeature<*, *>> = registerKey("mineral_compound_ore")
    val TITANIUM_ORE_KEY: ResourceKey<ConfiguredFeature<*, *>> = registerKey("titanium_ore")
    val URANIUM_ORE_KEY: ResourceKey<ConfiguredFeature<*, *>> = registerKey("uranium_ore")

    private val stoneReplaceable: RuleTest = TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES)
    private val deepslateReplaceable: RuleTest = TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
    private val netherrackReplacable: RuleTest = BlockMatchTest(Blocks.NETHERRACK)
    private val endReplaceable: RuleTest = BlockMatchTest(Blocks.END_STONE)

    fun bootstrap(context: BootstapContext<ConfiguredFeature<*, *>>) {
        register(
            context,
            ALUMINUM_ORE_KEY,
            Feature.ORE,
            OreConfiguration(overworldOre(ModBlocks.ALUMINUM_ORE, ModBlocks.DEEPSLATE_ALUMINUM_ORE), 12)
        )
        register(
            context,
            LITHIUM_ORE_KEY,
            Feature.ORE,
            OreConfiguration(overworldOre(ModBlocks.LITHIUM_ORE, ModBlocks.DEEPSLATE_LITHIUM_ORE), 8)
        )
        register(
            context,
            MINERAL_COMPOUND_ORE_KEY,
            Feature.ORE,
            OreConfiguration(overworldOre(ModBlocks.MINERAL_COMPOUND_ORE, ModBlocks.DEEPSLATE_MINERAL_COMPOUND_ORE), 8)
        )
        register(
            context,
            TITANIUM_ORE_KEY,
            Feature.ORE,
            OreConfiguration(overworldOre(ModBlocks.TITANIUM_ORE, ModBlocks.DEEPSLATE_TITANIUM_ORE), 6)
        )
        register(
            context,
            URANIUM_ORE_KEY,
            Feature.ORE,
            OreConfiguration(overworldOre(ModBlocks.URANIUM_ORE, ModBlocks.DEEPSLATE_URANIUM_ORE), 8)
        )
    }

    fun overworldOre(default: RegistryObject<DropExperienceBlock>, deepslate: RegistryObject<DropExperienceBlock>): List<TargetBlockState> {
        return listOf(
            OreConfiguration.target(
                stoneReplaceable,
                default.get().defaultBlockState()
            ),
            OreConfiguration.target(
                deepslateReplaceable,
                deepslate.get().defaultBlockState()
            )
        )
    }


    fun registerKey(name: String): ResourceKey<ConfiguredFeature<*, *>> {
        return ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation(Overcharge.ID, name)
        )
    }

    private fun <FC : FeatureConfiguration, F : Feature<FC>> register(
        context: BootstapContext<ConfiguredFeature<*, *>>,
        key: ResourceKey<ConfiguredFeature<*, *>>, feature: F, configuration: FC
    ) {
        context.register(key, ConfiguredFeature(feature, configuration))
    }
}
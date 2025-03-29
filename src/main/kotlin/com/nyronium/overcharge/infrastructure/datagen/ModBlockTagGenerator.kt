package com.nyronium.overcharge.infrastructure.datagen

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.registry.ModBlocks
import com.nyronium.overcharge.registry.ModTags
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.tags.BlockTags
import net.minecraftforge.common.Tags
import net.minecraftforge.common.data.ExistingFileHelper
import java.util.concurrent.CompletableFuture

class ModBlockTagGenerator(
    output: PackOutput,
    lookupProvider: CompletableFuture<HolderLookup.Provider>,
    existingFileHelper: ExistingFileHelper
) : net.minecraftforge.common.data.BlockTagsProvider(output, lookupProvider, Overcharge.ID, existingFileHelper) {
    override fun addTags(provider: HolderLookup.Provider) {
        tag(BlockTags.NEEDS_STONE_TOOL)

        tag(BlockTags.NEEDS_IRON_TOOL)

        tag(BlockTags.NEEDS_DIAMOND_TOOL)

        tag(ModTags.Blocks.NEEDS_ALUMINUM_TOOL)

        tag(ModTags.Blocks.NEEDS_STEEL_TOOL)

        tag(Tags.Blocks.ORES)
            .add(ModBlocks.ALUMINUM_ORE.get())
            .add(ModBlocks.DEEPSLATE_ALUMINUM_ORE.get())

            .add(ModBlocks.LITHIUM_ORE.get())
            .add(ModBlocks.DEEPSLATE_LITHIUM_ORE.get())

            .add(ModBlocks.MINERAL_COMPOUND_ORE.get())
            .add(ModBlocks.DEEPSLATE_MINERAL_COMPOUND_ORE.get())

            .add(ModBlocks.TITANIUM_ORE.get())
            .add(ModBlocks.DEEPSLATE_TITANIUM_ORE.get())

            .add(ModBlocks.URANIUM_ORE.get())
            .add(ModBlocks.DEEPSLATE_URANIUM_ORE.get())

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .add(ModBlocks.ALUMINUM_ORE.get())
            .add(ModBlocks.DEEPSLATE_ALUMINUM_ORE.get())

            .add(ModBlocks.LITHIUM_ORE.get())
            .add(ModBlocks.DEEPSLATE_LITHIUM_ORE.get())

            .add(ModBlocks.MINERAL_COMPOUND_ORE.get())
            .add(ModBlocks.DEEPSLATE_MINERAL_COMPOUND_ORE.get())

            .add(ModBlocks.TITANIUM_ORE.get())
            .add(ModBlocks.DEEPSLATE_TITANIUM_ORE.get())

            .add(ModBlocks.URANIUM_ORE.get())
            .add(ModBlocks.DEEPSLATE_URANIUM_ORE.get())
    }
}
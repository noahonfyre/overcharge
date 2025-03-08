package com.nyronium.overcharged.infrastructure.datagen

import com.nyronium.overcharged.Overcharged
import com.nyronium.overcharged.registry.ModBlocks
import com.nyronium.overcharged.registry.ModTags
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
) : net.minecraftforge.common.data.BlockTagsProvider(output, lookupProvider, Overcharged.ID, existingFileHelper) {
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

            .add(ModBlocks.NICKEL_ORE.get())
            .add(ModBlocks.DEEPSLATE_NICKEL_ORE.get())

            .add(ModBlocks.SILICON_ORE.get())
            .add(ModBlocks.DEEPSLATE_SILICON_ORE.get())

            .add(ModBlocks.TITANIUM_ORE.get())
            .add(ModBlocks.DEEPSLATE_TITANIUM_ORE.get())

            .add(ModBlocks.URANIUM_ORE.get())
            .add(ModBlocks.DEEPSLATE_URANIUM_ORE.get())

            .add(ModBlocks.ZINC_ORE.get())
            .add(ModBlocks.DEEPSLATE_ZINC_ORE.get())

        for(block in ModBlocks.BLOCKS.entries) {
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block.get())
        }
    }
}
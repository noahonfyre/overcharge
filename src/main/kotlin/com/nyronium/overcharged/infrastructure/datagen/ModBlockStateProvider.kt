package com.nyronium.overcharged.infrastructure.datagen

import com.nyronium.overcharged.Overcharged
import com.nyronium.overcharged.registry.ModBlocks
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.LiquidBlock
import net.minecraftforge.common.data.ExistingFileHelper
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject


class ModBlockStateProvider(output: PackOutput, exFileHelper: ExistingFileHelper) : net.minecraftforge.client.model.generators.BlockStateProvider(output, Overcharged.ID, exFileHelper) {
    val WATER_STILL: ResourceLocation = ResourceLocation("block/water_still")

    override fun registerStatesAndModels() {
        for(item in ModBlocks.BLOCKS.entries) {
            if(item.get() is LiquidBlock) {
                simpleBlock(item.get(), models().getBuilder(key(item.get()).path).texture("particle", WATER_STILL.toString()));
                continue
            } else {
                blockWithItem(item)
            }
        }
    }

    private fun blockWithItem(blockRegistryObject: RegistryObject<Block>) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()))
    }

    private fun key(block: Block): ResourceLocation {
        return ForgeRegistries.BLOCKS.getKey(block)!!
    }
}
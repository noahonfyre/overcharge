package com.nyronium.overcharge.registry

import com.nyronium.overcharge.Overcharge
import earth.terrarium.botarium.common.registry.fluid.BotariumLiquidBlock
import net.minecraft.util.valueproviders.UniformInt
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.DropExperienceBlock
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import java.util.function.Supplier


object ModBlocks {
    val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, Overcharge.ID)

    val ALUMINUM_ORE = registerBlock("aluminum_ore") { DropExperienceBlock(BlockBehaviour.Properties.of().strength(4.5f).requiresCorrectToolForDrops(), UniformInt.of(6, 9)) }
    val DEEPSLATE_ALUMINUM_ORE = registerBlock("deepslate_aluminum_ore") { DropExperienceBlock(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops(), UniformInt.of(6, 9)) }
    val LITHIUM_ORE = registerBlock("lithium_ore") { DropExperienceBlock(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops(), UniformInt.of(6, 9)) }
    val DEEPSLATE_LITHIUM_ORE = registerBlock("deepslate_lithium_ore") { DropExperienceBlock(BlockBehaviour.Properties.of().strength(4.5f).requiresCorrectToolForDrops(), UniformInt.of(6, 9)) }
    val MINERAL_COMPOUND_ORE = registerBlock("mineral_compound_ore") { DropExperienceBlock(BlockBehaviour.Properties.of().strength(2f).requiresCorrectToolForDrops(), UniformInt.of(6, 9)) }
    val DEEPSLATE_MINERAL_COMPOUND_ORE = registerBlock("deepslate_mineral_compound_ore") { DropExperienceBlock(BlockBehaviour.Properties.of().strength(3.5f).requiresCorrectToolForDrops(), UniformInt.of(6, 9)) }
    val TITANIUM_ORE = registerBlock("titanium_ore") { DropExperienceBlock(BlockBehaviour.Properties.of().strength(8f).explosionResistance(1200f).requiresCorrectToolForDrops(), UniformInt.of(6, 9)) }
    val DEEPSLATE_TITANIUM_ORE = registerBlock("deepslate_titanium_ore") { DropExperienceBlock(BlockBehaviour.Properties.of().strength(9.5f).explosionResistance(1200f).requiresCorrectToolForDrops(), UniformInt.of(6, 9)) }
    val URANIUM_ORE = registerBlock("uranium_ore") { DropExperienceBlock(BlockBehaviour.Properties.of().strength(5f).explosionResistance(1200f).requiresCorrectToolForDrops(), UniformInt.of(6, 9)) }
    val DEEPSLATE_URANIUM_ORE = registerBlock("deepslate_uranium_ore") { DropExperienceBlock(BlockBehaviour.Properties.of().strength(6.5f).explosionResistance(1200f).requiresCorrectToolForDrops(), UniformInt.of(6, 9)) }

    val OXYGEN: RegistryObject<BotariumLiquidBlock> = BLOCKS.register("oxygen") { BotariumLiquidBlock(ModFluidProperties.OXYGEN, BlockBehaviour.Properties.copy(Blocks.WATER)) }
    val HYDROGEN: RegistryObject<BotariumLiquidBlock> = BLOCKS.register("hydrogen") { BotariumLiquidBlock(ModFluidProperties.HYDROGEN, BlockBehaviour.Properties.copy(Blocks.WATER)) }
    val NITROGEN: RegistryObject<BotariumLiquidBlock> = BLOCKS.register("nitrogen") { BotariumLiquidBlock(ModFluidProperties.NITROGEN, BlockBehaviour.Properties.copy(Blocks.WATER)) }
    val LIQUID_COMPOUND: RegistryObject<BotariumLiquidBlock> = BLOCKS.register("liquid_compound") { BotariumLiquidBlock(ModFluidProperties.LIQUID_COMPOUND, BlockBehaviour.Properties.copy(Blocks.WATER)) }
    val POLYETHYLENE: RegistryObject<BotariumLiquidBlock> = BLOCKS.register("polyethylene") { BotariumLiquidBlock(ModFluidProperties.POLYETHYLENE, BlockBehaviour.Properties.copy(Blocks.WATER)) }


    private fun <T : Block> registerBlock(name: String, block: Supplier<T>): RegistryObject<T> {
        val registeredBlock = BLOCKS.register(name, block)
        registerBlockItem(name, registeredBlock)
        return registeredBlock
    }

    private fun <T : Block> registerBlockItem(name: String, block: RegistryObject<T>): RegistryObject<Item> {
        return ModItems.ITEMS.register(name) { BlockItem(block.get(), Item.Properties()) }
    }
}
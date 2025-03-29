package com.nyronium.overcharge.infrastructure.datagen

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.registry.ModBlocks
import com.nyronium.overcharge.registry.ModItems
import net.minecraft.world.flag.FeatureFlags
import net.minecraft.world.item.Item
import net.minecraft.world.item.enchantment.Enchantments
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.storage.loot.LootTable
import net.minecraft.world.level.storage.loot.entries.LootItem
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator
import net.minecraftforge.registries.ForgeRegistries
import java.util.stream.Collectors


open class ModBlockLootTables : net.minecraft.data.loot.BlockLootSubProvider(setOf<Item>(), FeatureFlags.REGISTRY.allFlags()) {
    private val registered = mutableListOf<Block>()

    override fun generate() {
        addBlockLootTable(ModBlocks.ALUMINUM_ORE.get(), ModItems.RAW_ALUMINUM.get(), 1, 1)
        addBlockLootTable(ModBlocks.DEEPSLATE_ALUMINUM_ORE.get(), ModItems.RAW_ALUMINUM.get(), 1, 1)

        addBlockLootTable(ModBlocks.LITHIUM_ORE.get(), ModItems.RAW_LITHIUM.get(), 1, 1)
        addBlockLootTable(ModBlocks.DEEPSLATE_LITHIUM_ORE.get(), ModItems.RAW_LITHIUM.get(), 1, 1)

        addBlockLootTable(ModBlocks.MINERAL_COMPOUND_ORE.get(), ModItems.MINERAL_COMPOUND.get(), 1, 1)
        addBlockLootTable(ModBlocks.DEEPSLATE_MINERAL_COMPOUND_ORE.get(), ModItems.MINERAL_COMPOUND.get(), 1, 1)

        addBlockLootTable(ModBlocks.TITANIUM_ORE.get(), ModItems.RAW_TITANIUM.get(), 1, 1)
        addBlockLootTable(ModBlocks.DEEPSLATE_TITANIUM_ORE.get(), ModItems.RAW_TITANIUM.get(), 1, 1)

        addBlockLootTable(ModBlocks.URANIUM_ORE.get(), ModItems.RAW_URANIUM.get(), 1, 1)
        addBlockLootTable(ModBlocks.DEEPSLATE_URANIUM_ORE.get(), ModItems.RAW_URANIUM.get(), 1, 1)

        for(item in knownBlocks) {
            if(item !in registered) {
                dropSelf(item)
            }
        }
    }

    private fun addBlockLootTable(block: Block, item: Item, min: Int, max: Int) {
        registered.add(block)
        this.add(block) {
            createOreDrops(
                block,
                item,
                min,
                max
            )
        }
    }

    override fun getKnownBlocks(): Iterable<Block> {
        return ForgeRegistries.BLOCKS.values
            .stream()
            .filter { block: Block? ->
                ForgeRegistries.BLOCKS.getKey(block)!!.namespace == Overcharge.ID
            }
            .collect(Collectors.toSet())
    }

    private fun createOreDrops(pBlock: Block, item: Item, min: Int, max: Int): LootTable.Builder {
        return createSilkTouchDispatchTable(
            pBlock,
            this.applyExplosionDecay(
                pBlock,
                LootItem.lootTableItem(item)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(min.toFloat(), max.toFloat())))
                    .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
            )
        )
    }
}
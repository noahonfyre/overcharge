package com.nyronium.overcharged.infrastructure.datagen

import net.minecraft.data.PackOutput
import net.minecraft.data.loot.LootTableProvider
import net.minecraft.data.loot.LootTableProvider.SubProviderEntry
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets

object ModLootTableProvider {
    fun create(output: PackOutput): LootTableProvider {
        return LootTableProvider(
            output, setOf<ResourceLocation>(), listOf(
                SubProviderEntry({ ModBlockLootTables() }, LootContextParamSets.BLOCK)
            )
        )
    }
}
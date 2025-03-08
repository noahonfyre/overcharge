package com.nyronium.overcharged.infrastructure.datagen

import com.nyronium.overcharged.Overcharged
import com.nyronium.overcharged.infrastructure.worldgen.ModBiomeModifiers
import com.nyronium.overcharged.infrastructure.worldgen.ModConfiguredFeatures
import com.nyronium.overcharged.infrastructure.worldgen.ModPlacedFeatures
import net.minecraft.core.HolderLookup
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.Registries
import net.minecraft.data.PackOutput
import net.minecraftforge.registries.ForgeRegistries
import java.util.concurrent.CompletableFuture


class ModWorldGenProvider(output: PackOutput, registries: CompletableFuture<HolderLookup.Provider>) : net.minecraftforge.common.data.DatapackBuiltinEntriesProvider(output, registries, BUILDER, mutableSetOf(Overcharged.ID)) {
    companion object {
        val BUILDER: RegistrySetBuilder = RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
    }
}
package com.nyronium.overcharged.infrastructure.datagen

import com.nyronium.overcharged.Overcharged
import com.nyronium.overcharged.registry.ModItems
import com.nyronium.overcharged.registry.ModTags
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.tags.ItemTagsProvider
import net.minecraft.world.level.block.Block
import net.minecraftforge.common.data.ExistingFileHelper
import java.util.concurrent.CompletableFuture

class ModItemTagGenerator(
    packOutput: PackOutput,
    providerCompletableFuture: CompletableFuture<HolderLookup.Provider?>,
    tagLookupCompletableFuture: CompletableFuture<TagLookup<Block?>?>,
    existingFileHelper: ExistingFileHelper?
) :
    ItemTagsProvider(packOutput, providerCompletableFuture, tagLookupCompletableFuture, Overcharged.ID, existingFileHelper) {
    override fun addTags(provider: HolderLookup.Provider) {
        tag(ModTags.Items.CURIO_BRACELET_SLOT)

        tag(ModTags.Items.CURIO_RING_SLOT)

        tag(ModTags.Items.CURIO_BACK_SLOT)

        tag(ModTags.Items.CURIO_BODY_SLOT)
    }
}
package com.nyronium.overcharge.infrastructure.datagen

import com.nyronium.overcharge.Overcharge
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod.EventBusSubscriber

@EventBusSubscriber(modid = Overcharge.ID, bus = EventBusSubscriber.Bus.MOD)
object DataGenerators {
    @SubscribeEvent
    fun gatherData(event: GatherDataEvent) {
        val gen = event.generator
        val packOutput = gen.packOutput
        val existingFileHelper = event.existingFileHelper
        val lookupProvider = event.lookupProvider

        gen.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput))

        gen.addProvider(event.includeClient(), ModBlockStateProvider(packOutput, existingFileHelper))
        gen.addProvider(event.includeClient(), ModItemModelProvider(packOutput, existingFileHelper))
        gen.addProvider(event.includeClient(), ModLanguageProvider(packOutput))

        val blockTagGenerator = gen.addProvider(event.includeServer(), ModBlockTagGenerator(packOutput, lookupProvider, existingFileHelper))

        gen.addProvider(event.includeServer(), ModRecipeProvider(packOutput))

        gen.addProvider(event.includeServer(), ModItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper))
        gen.addProvider(event.includeServer(), ModWorldGenProvider(packOutput, lookupProvider))
    }
}
package com.nyronium.overcharged.infrastructure.datagen

import com.nyronium.overcharged.Overcharged
import com.nyronium.overcharged.registry.ModBlocks
import com.nyronium.overcharged.registry.ModItems
import net.minecraft.data.PackOutput
import net.minecraft.world.level.block.LiquidBlock
import net.minecraftforge.common.data.LanguageProvider

class ModLanguageProvider(packOutput: PackOutput,) : LanguageProvider(packOutput, Overcharged.ID, "en_us") {
    override fun addTranslations() {
        add("key.category.overcharged.overcharged", "overcharged")
        add("key.overcharged.suit_flight", "Toggle Suit Flight")

        for (item in ModItems.ITEMS.entries) {
            val id = item.id ?: continue
            val itemName = formatTranslation(id.path)
            addItem(item, itemName)
        }
        for (item in ModBlocks.BLOCKS.entries) {
            if(item.get()::class != LiquidBlock::class) continue
            val id = item.id ?: continue
            val itemName = formatTranslation(id.path)
            addBlock(item, itemName)
        }
//        for (item in ModFluidProperties.FLUID_PROPERTIES.registry.entries) {
//            val id = item.id ?: continue
//            val itemName = formatTranslation(id.path)
//            add("fluid_type.overcharged.${id.path}", itemName)
//        }
    }

    private fun formatTranslation(id: String): String {
        return id.split("_").joinToString(" ") { it.capitalize() }
    }
}
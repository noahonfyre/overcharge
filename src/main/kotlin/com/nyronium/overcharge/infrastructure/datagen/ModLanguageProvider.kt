package com.nyronium.overcharge.infrastructure.datagen

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.registry.ModBlocks
import com.nyronium.overcharge.registry.ModFluidProperties
import com.nyronium.overcharge.registry.ModItems
import com.nyronium.overcharge.registry.ModKeyBindings
import earth.terrarium.botarium.common.registry.fluid.BotariumLiquidBlock
import net.minecraft.data.PackOutput
import net.minecraftforge.common.data.LanguageProvider
import java.util.Locale
import java.util.Locale.getDefault

class ModLanguageProvider(packOutput: PackOutput) : LanguageProvider(packOutput, Overcharge.ID, "en_us") {
    override fun addTranslations() {
        add(ModKeyBindings.KEY_CATEGORY_OVERCHARGE, "Overcharge")
        add(ModKeyBindings.KEY_FLIGHT, "Toggle Flight")
        add(ModKeyBindings.KEY_AUTOPILOT, "Autopilot")
        add(ModKeyBindings.KEY_LEVEL_HOLD, "LVL HLD")
        add(ModKeyBindings.KEY_HEADING_SELECT, "HDG SELECT")

        for (item in ModItems.ITEMS.entries) {
            val id = item.id ?: continue
            val itemName = formatTranslation(id.path)
            addItem(item, itemName)
        }
        for (item in ModBlocks.BLOCKS.entries) {
            if(item.get()::class != BotariumLiquidBlock::class) continue
            val id = item.id ?: continue
            val itemName = formatTranslation(id.path)
            add("block.${Overcharge.ID}.${id.path}", itemName)
        }
        for (item in ModFluidProperties.FLUID_PROPERTIES.registry.entries) {
            val id = item.id ?: continue
            val itemName = formatTranslation(id.path)
            add("fluid_type.${Overcharge.ID}.${id.path}", itemName)
        }
    }

    private fun formatTranslation(id: String): String {
        return id.split("_").joinToString(" ") { it -> it.replaceFirstChar { if (it.isLowerCase()) it.titlecase(getDefault()) else it.toString() } }
    }
}
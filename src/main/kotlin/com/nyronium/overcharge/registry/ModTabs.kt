package com.nyronium.overcharge.registry

import com.nyronium.overcharge.Overcharge
import kotlinx.coroutines.selects.select
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.RegistryObject

object ModTabs {
    val TABS: DeferredRegister<CreativeModeTab> = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Overcharge.ID)

    fun register(eventBus: IEventBus) {
        TABS.register(eventBus)
    }

    val OVERCHARGED_TAB: RegistryObject<CreativeModeTab> = TABS.register(
        "overcharged_tab"
    ) {
        CreativeModeTab.builder()
            .icon { ItemStack(ModItems.ICON.get()) }
            .title(Component.literal(Overcharge.NAME))
            .displayItems { itemDisplayParameters: ItemDisplayParameters, output: CreativeModeTab.Output ->
                for (item in ModItems.ITEMS.entries) {
                    if(item.get() == ModItems.ICON.get()) continue
                    when (item.get()) {
                        ModItems.COPPER_PLATE.get() -> {
                            output.accept(Items.RAW_COPPER)
                            output.accept(Items.COPPER_INGOT)
                            output.accept(item.get())
                        }
                        else -> output.accept(item.get())
                    }
                }
            }.build()
    }
}
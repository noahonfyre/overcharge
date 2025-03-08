package com.nyronium.overcharged.registry

import com.nyronium.overcharged.Overcharged
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters
import net.minecraft.world.item.ItemStack
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.RegistryObject

object ModTabs {
    val TABS: DeferredRegister<CreativeModeTab> = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Overcharged.ID)

    fun register(eventBus: IEventBus) {
        TABS.register(eventBus)
    }

    val OVERCHARGED_TAB: RegistryObject<CreativeModeTab> = TABS.register(
        "overcharged_tab"
    ) {
        CreativeModeTab.builder()
            .icon { ItemStack(ModItems.ICON.get()) }
            .title(Component.literal("Overcharged"))
            .displayItems { itemDisplayParameters: ItemDisplayParameters, output: CreativeModeTab.Output ->
                for (item in ModItems.ITEMS.entries) {
                    if(item.get() == ModItems.ICON.get()) continue
                    output.accept(item.get())

                }
            }.build()
    }
}
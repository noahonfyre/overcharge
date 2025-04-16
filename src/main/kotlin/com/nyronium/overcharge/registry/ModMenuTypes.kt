package com.nyronium.overcharge.registry

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.content.block.electric_smelter.ElectricSmelterMenu
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.inventory.MenuType
import net.minecraftforge.common.extensions.IForgeMenuType
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.network.IContainerFactory
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import java.util.function.Supplier


object ModMenuTypes {
    val MENUS: DeferredRegister<MenuType<*>> = DeferredRegister.create<MenuType<*>>(ForgeRegistries.MENU_TYPES, Overcharge.ID)

    val ELECTRIC_SMELTER_MENU: RegistryObject<MenuType<ElectricSmelterMenu>> = registerMenuType("electric_smelter_menu", ::ElectricSmelterMenu)

    private fun <T : AbstractContainerMenu> registerMenuType(
        name: String,
        factory: IContainerFactory<T>
    ): RegistryObject<MenuType<T>> {
        return MENUS.register(name, Supplier { IForgeMenuType.create(factory) })
    }
}
package com.nyronium.overcharge.content.fluid

import earth.terrarium.botarium.common.registry.fluid.FluidData
import earth.terrarium.botarium.common.registry.fluid.FluidInformation
import earth.terrarium.botarium.common.registry.fluid.FluidProperties
import earth.terrarium.botarium.forge.regsitry.fluid.BotariumFluidType
import earth.terrarium.botarium.forge.regsitry.fluid.ForgeFluidData
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.fluids.FluidType
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

class FluidRegistry(private val id: String) {
    val registry: DeferredRegister<FluidType> = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, id)

    fun register(properties: FluidProperties): FluidData {
        val type = registry.register(
            properties.id().path
        ) { BotariumFluidType.create(properties) }
        return ForgeFluidData(type, properties)
    }

    fun register(information: FluidInformation): FluidData {
        val type = registry.register(
            information.id().path
        ) { BotariumFluidType.create(information) }
        return ForgeFluidData(type, information)
    }

    fun register(id: String, properties: FluidProperties.Builder): FluidData {
        return this.register(properties.build(ResourceLocation.tryBuild(this.id, id)))
    }

    fun register(eventBus: IEventBus) {
        registry.register(eventBus)
    }
}
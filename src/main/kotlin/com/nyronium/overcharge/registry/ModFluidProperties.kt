package com.nyronium.overcharge.registry

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.content.fluid.FluidRegistry
import earth.terrarium.botarium.common.registry.fluid.FluidData
import earth.terrarium.botarium.common.registry.fluid.FluidProperties
import net.minecraft.resources.ResourceLocation

object ModFluidProperties {
    val FLUID_PROPERTIES: FluidRegistry = FluidRegistry(Overcharge.ID)

    val OXYGEN: FluidData = FLUID_PROPERTIES.register("oxygen",
        FluidProperties.create()
            .still(ResourceLocation.parse("block/water_still"))
            .flowing(ResourceLocation.parse("block/water_flow"))
            .overlay(ResourceLocation.parse("block/water_overlay"))
            .screenOverlay(ResourceLocation.parse("textures/misc/underwater.png"))
            .viscosity(0)
            .density(-1)
            .disablePlacing()
            .tintColor(-0x5c0b01)
            .canConvertToSource(false)
    )

    val HYDROGEN: FluidData = FLUID_PROPERTIES.register("hydrogen",
        FluidProperties.create()
            .still(ResourceLocation.parse("block/water_still"))
            .flowing(ResourceLocation.parse("block/water_flow"))
            .overlay(ResourceLocation.parse("block/water_overlay"))
            .screenOverlay(ResourceLocation.parse("textures/misc/underwater.png"))
            .viscosity(0)
            .density(-1)
            .disablePlacing()
            .tintColor(-0x5c5b01)
            .canConvertToSource(false)
    )

    val NITROGEN: FluidData = FLUID_PROPERTIES.register("nitrogen",
        FluidProperties.create()
            .still(ResourceLocation.parse("block/water_still"))
            .flowing(ResourceLocation.parse("block/water_flow"))
            .overlay(ResourceLocation.parse("block/water_overlay"))
            .screenOverlay(ResourceLocation.parse("textures/misc/underwater.png"))
            .viscosity(0)
            .density(-1)
            .disablePlacing()
            .tintColor(-0x125c01)
            .canConvertToSource(false)
    )

    val LIQUID_COMPOUND: FluidData = FLUID_PROPERTIES.register("liquid_compound",
        FluidProperties.create()
            .still(ResourceLocation.tryBuild(Overcharge.ID, "block/liquid_compound_still"))
            .flowing(ResourceLocation.tryBuild(Overcharge.ID, "block/liquid_compound_flow"))
            .overlay(ResourceLocation.parse("textures/block/water_overlay"))
            .screenOverlay(ResourceLocation.parse("textures/misc/underwater.png"))
            .viscosity(1500)
            .density(1500)
            .temperature(273)
            .dropOff(3)
            .canConvertToSource(false)
    )

    val POLYETHYLENE: FluidData = FLUID_PROPERTIES.register("polyethylene",
        FluidProperties.create()
            .still(ResourceLocation.tryBuild(Overcharge.ID, "block/polyethylene_still"))
            .flowing(ResourceLocation.tryBuild(Overcharge.ID, "block/polyethylene_flow"))
            .overlay(ResourceLocation.parse("textures/block/water_overlay"))
            .screenOverlay(ResourceLocation.parse("textures/misc/underwater.png"))
            .viscosity(800)
            .density(800)
            .temperature(273)
            .dropOff(3)
            .canConvertToSource(false)
    )
}
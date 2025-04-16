package com.nyronium.overcharge.registry

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.registry.ModFluidProperties
import earth.terrarium.botarium.common.registry.fluid.BotariumFlowingFluid
import earth.terrarium.botarium.common.registry.fluid.BotariumSourceFluid
import net.minecraft.world.level.material.Fluid
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject


object ModFluids {
    val FLUIDS: DeferredRegister<Fluid> = DeferredRegister.create(ForgeRegistries.FLUIDS, Overcharge.ID)

    val OXYGEN: RegistryObject<Fluid> = FLUIDS.register("oxygen") { BotariumSourceFluid(ModFluidProperties.OXYGEN) }
    val FLOWING_OXYGEN: RegistryObject<Fluid> = FLUIDS.register("flowing_oxygen") { BotariumFlowingFluid(ModFluidProperties.OXYGEN) }

    val HYDROGEN: RegistryObject<Fluid> = FLUIDS.register("hydrogen") { BotariumSourceFluid(ModFluidProperties.HYDROGEN) }
    val FLOWING_HYDROGEN: RegistryObject<Fluid> = FLUIDS.register("flowing_hydrogen") { BotariumFlowingFluid(ModFluidProperties.HYDROGEN) }

    val NITROGEN: RegistryObject<Fluid> = FLUIDS.register("nitrogen") { BotariumSourceFluid(ModFluidProperties.NITROGEN) }
    val FLOWING_NITROGEN: RegistryObject<Fluid> = FLUIDS.register("flowing_nitrogen") { BotariumFlowingFluid(ModFluidProperties.NITROGEN) }

    val LIQUID_COMPOUND: RegistryObject<Fluid> = FLUIDS.register("liquid_compound") { BotariumSourceFluid(ModFluidProperties.LIQUID_COMPOUND) }
    val FLOWING_LIQUID_COMPOUND: RegistryObject<Fluid> = FLUIDS.register("flowing_liquid_compound") { BotariumFlowingFluid(ModFluidProperties.LIQUID_COMPOUND) }

    val POLYETHYLENE: RegistryObject<Fluid> = FLUIDS.register("polyethylene") { BotariumSourceFluid(ModFluidProperties.POLYETHYLENE) }
    val FLOWING_POLYETHYLENE: RegistryObject<Fluid> = FLUIDS.register("flowing_polyethylene") { BotariumFlowingFluid(ModFluidProperties.POLYETHYLENE) }

    val PHOTORESIST: RegistryObject<Fluid> = FLUIDS.register("photoresist") { BotariumSourceFluid(ModFluidProperties.PHOTORESIST) }
    val FLOWING_PHOTORESIST: RegistryObject<Fluid> = FLUIDS.register("flowing_photoresist") { BotariumFlowingFluid(ModFluidProperties.PHOTORESIST) }
}
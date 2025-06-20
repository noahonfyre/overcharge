package com.nyronium.overcharge.registry

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.content.effect.BiodecayEffect
import com.nyronium.overcharge.content.effect.DamageMemoryEffect
import com.nyronium.overcharge.content.effect.EquilibriumEffect
import com.nyronium.overcharge.content.effect.VulnerabilityEffect
import net.minecraft.world.effect.MobEffect
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject

object ModEffects {
    val EFFECTS: DeferredRegister<MobEffect> = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Overcharge.ID)

    val VULNERABILITY: RegistryObject<MobEffect> = EFFECTS.register("vulnerability") { VulnerabilityEffect() }
    val BIODECAY: RegistryObject<MobEffect> = EFFECTS.register("biodecay") { BiodecayEffect() }
    val EQUILIBRIUM: RegistryObject<MobEffect> = EFFECTS.register("equilibrium") { EquilibriumEffect() }
    val DAMAGE_MEMORY: RegistryObject<MobEffect> = EFFECTS.register("damage_memory") { DamageMemoryEffect() }
}
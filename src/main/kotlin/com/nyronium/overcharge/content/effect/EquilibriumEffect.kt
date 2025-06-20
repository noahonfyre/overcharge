package com.nyronium.overcharge.content.effect

import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.entity.LivingEntity
import net.minecraftforge.common.MinecraftForge

class EquilibriumEffect : MobEffect(MobEffectCategory.BENEFICIAL, 0xFCF083) {
    init {
        MinecraftForge.EVENT_BUS.register(this)
    }

    override fun applyEffectTick(pLivingEntity: LivingEntity, pAmplifier: Int) {
        pLivingEntity.activeEffects
            .filter { it.effect.category == MobEffectCategory.HARMFUL }
            .forEach {
                pLivingEntity.removeEffect(it.effect)
            }
    }

    override fun isDurationEffectTick(duration: Int, amplifier: Int): Boolean {
        return true
    }
}
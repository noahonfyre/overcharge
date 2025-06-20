package com.nyronium.overcharge.content.effect

import net.minecraft.network.chat.Component
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.ai.attributes.Attributes
import java.util.function.Supplier

class DamageMemoryEffect : MobEffect(MobEffectCategory.HARMFUL, 0x64DD79) {
    var accumulatedDamage = 0.0f
    var lastHealth = 0.0f

    override fun applyEffectTick(pLivingEntity: LivingEntity, pAmplifier: Int) {
        val effectInstance = pLivingEntity.activeEffects.find { it.effect is DamageMemoryEffect } ?: return
        if(lastHealth != pLivingEntity.health) {
            val damage = (lastHealth-pLivingEntity.health).coerceAtLeast(0.0f)
            accumulatedDamage += damage
            lastHealth = pLivingEntity.health

            pLivingEntity.sendSystemMessage(Component.literal("Accumulated Damage: $accumulatedDamage / Last Health: $lastHealth"))
        }

        if(effectInstance.duration == 2) {
            pLivingEntity.hurt(pLivingEntity.level().damageSources().magic(), accumulatedDamage)
        }
        if(effectInstance.duration == 1) {
            accumulatedDamage = 0f
            lastHealth = 0f
        }
    }

    override fun isDurationEffectTick(pDuration: Int, pAmplifier: Int): Boolean {
        return true
    }
}
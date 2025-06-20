package com.nyronium.overcharge.content.effect

import net.minecraft.client.Minecraft
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.ai.attributes.Attribute
import net.minecraft.world.entity.ai.attributes.AttributeModifier

class BiodecayEffect : MobEffect(MobEffectCategory.HARMFUL, 0x0CD30C) {
    override fun applyEffectTick(entity: LivingEntity, amplifier: Int) {
        entity.hurt(entity.damageSources().magic(), entity.maxHealth/5)
    }

    override fun isDurationEffectTick(duration: Int, amplifier: Int): Boolean {
        return duration % 16 == 0
    }
}
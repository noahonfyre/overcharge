package com.nyronium.overcharge.content.item.base

import net.minecraft.tags.BlockTags
import net.minecraft.world.item.DiggerItem
import net.minecraft.world.item.Tier

class HammerItem(tier: Tier, pAttackDamageModifier: Float, pAttackSpeedModifier: Float, properties: Properties) : DiggerItem(pAttackDamageModifier, pAttackSpeedModifier, tier, BlockTags.MINEABLE_WITH_PICKAXE, properties) {

}
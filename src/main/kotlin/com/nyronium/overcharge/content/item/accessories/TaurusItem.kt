package com.nyronium.overcharge.content.item.accessories

import com.nyronium.overcharge.content.item.CurioUtilityExtension
import com.nyronium.overcharge.content.item.ItemAttributeModifierExtension
import net.minecraft.ChatFormatting
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.Style
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.level.Level
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.event.entity.living.LivingHurtEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import top.theillusivec4.curios.api.type.capability.ICurioItem


class TaurusItem(properties: Properties) : Item(properties), ICurioItem, ItemAttributeModifierExtension, CurioUtilityExtension {
    init {
        MinecraftForge.EVENT_BUS.register(this)
    }

    @SubscribeEvent
    fun onLivingHurt(event: LivingHurtEvent) {
        if (event.source.entity != null && event.source.entity is Player) {
            val player = event.source.entity as Player
            if (!player.level().isClientSide && hasEquipped(player, this)) {
                if(player.health >= player.maxHealth*.5) return
                val healAmount = event.amount * 0.25f
                player.heal(healAmount)
            }
        }
    }

    override fun appendHoverText(pStack: ItemStack, pLevel: Level?, pTooltipComponents: MutableList<Component>, pIsAdvanced: TooltipFlag) {
        pTooltipComponents.add(Component.literal("Absorbs health worth 25% of the caused melee damage when under 50% max health.").withStyle(Style.EMPTY.withColor(ChatFormatting.GOLD)))
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced)
    }
}
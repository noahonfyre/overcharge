package com.nyronium.overcharge.content.item

import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import top.theillusivec4.curios.api.CuriosApi

interface CurioUtilityExtension {
    fun hasEquipped(player: Player, item: Item): Boolean {
        val handlerOpt = CuriosApi.getCuriosInventory(player).resolve()
        if (handlerOpt.isEmpty) return false
        return handlerOpt.get().isEquipped(item)
    }
}
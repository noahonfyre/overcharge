package com.nyronium.overcharge.event

import com.nyronium.overcharge.Overcharge
import net.minecraftforge.event.TickEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(modid = Overcharge.ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
object ServerModEvents {
    @SubscribeEvent
    fun onPlayerTick(e: TickEvent.PlayerTickEvent) {

    }
}
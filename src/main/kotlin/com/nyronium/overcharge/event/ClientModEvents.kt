package com.nyronium.overcharge.event

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.networking.KeybindSyncPacket
import com.nyronium.overcharge.networking.NetworkHandler
import com.nyronium.overcharge.util.KeybindManager
import net.minecraft.client.Minecraft
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.event.TickEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod

@Mod.EventBusSubscriber(modid = Overcharge.ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = [Dist.CLIENT])
object ClientModEvents {
    private var lastSprintState = false
    private var lastJumpState = false
    private var lastFlightState = false

    @SubscribeEvent
    fun onClientTick(event: TickEvent.ClientTickEvent) {
        if (event.phase == TickEvent.Phase.START) {
            val instance = Minecraft.getInstance()
            if(instance != null && instance.player != null) {
                val isSprinting = instance.options.keySprint.isDown
                val isJumping = instance.options.keyJump.isDown
                val flightEnabled = true

                if (isSprinting != lastSprintState || isJumping != lastJumpState) {
                    NetworkHandler.CHANNEL.sendToServer(KeybindSyncPacket(isSprinting, isJumping, flightEnabled))
                    KeybindManager.set(instance.player!!.uuid, KeybindManager.KeyCategory.JUMPING, isJumping)
                    KeybindManager.set(instance.player!!.uuid, KeybindManager.KeyCategory.SPRINTING, isSprinting)
                    KeybindManager.set(instance.player!!.uuid, KeybindManager.KeyCategory.FLIGHT_ENABLED, flightEnabled)
                    lastSprintState = isSprinting
                    lastJumpState = isJumping
                    lastFlightState = flightEnabled
                }
            }
        }
    }
}
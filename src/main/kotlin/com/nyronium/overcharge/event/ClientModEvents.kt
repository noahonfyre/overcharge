package com.nyronium.overcharge.event

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.content.item.custom.OverchargeSuitItem
import com.nyronium.overcharge.networking.serverbound.KeybindSyncPacket
import com.nyronium.overcharge.networking.NetworkHandler
import com.nyronium.overcharge.registry.ModKeyBindings
import com.nyronium.overcharge.util.KeybindManager
import net.minecraft.client.Minecraft
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.Style
import net.minecraft.world.entity.EquipmentSlot
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.client.event.InputEvent
import net.minecraftforge.client.event.RegisterKeyMappingsEvent
import net.minecraftforge.event.TickEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import kotlin.math.roundToLong

@Mod.EventBusSubscriber(modid = Overcharge.ID, value = [Dist.CLIENT])
object ClientModEvents {
    private var lastSprintState = false
    private var lastJumpState = false
    private var lastFlightEnabledState = false

    private var flightEnabled = false

    @SubscribeEvent
    fun onKeyInput(event: InputEvent.Key) {
        when {
            ModKeyBindings.TOGGLE_FLIGHT_KEY.consumeClick() -> {
                if(Minecraft.getInstance().player?.getItemBySlot(EquipmentSlot.CHEST)?.item !is OverchargeSuitItem) return
                flightEnabled = !flightEnabled
                Minecraft.getInstance().player!!.displayClientMessage(Component.literal(if(flightEnabled) "Flight enabled." else "Flight disabled.").withStyle(Style.EMPTY.withColor(Overcharge.COLOR)), true)
            }
        }
    }

    @SubscribeEvent
    fun onClientTick(event: TickEvent.ClientTickEvent) {
        if (event.phase == TickEvent.Phase.START) {
            val instance = Minecraft.getInstance()
            if(instance != null && instance.player != null) {
                val isSprinting = instance.options.keySprint.isDown
                val isJumping = instance.options.keyJump.isDown

                if (isSprinting != lastSprintState || isJumping != lastJumpState || flightEnabled != lastFlightEnabledState) {
                    NetworkHandler.CHANNEL.sendToServer(KeybindSyncPacket(isSprinting, isJumping, flightEnabled))
                    KeybindManager.set(instance.player!!.uuid, KeybindManager.KeyCategory.JUMPING, isJumping)
                    KeybindManager.set(instance.player!!.uuid, KeybindManager.KeyCategory.SPRINTING, isSprinting)
                    KeybindManager.set(instance.player!!.uuid, KeybindManager.KeyCategory.FLIGHT, flightEnabled)
                    lastSprintState = isSprinting
                    lastJumpState = isJumping
                    lastFlightEnabledState = flightEnabled
                }
            }
        }
    }

    @Mod.EventBusSubscriber(modid = Overcharge.ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = [Dist.CLIENT])
    object ClientBusEvents {
        @SubscribeEvent
        fun onKeyRegister(event: RegisterKeyMappingsEvent) {
            event.register(ModKeyBindings.TOGGLE_FLIGHT_KEY)
        }
    }
}
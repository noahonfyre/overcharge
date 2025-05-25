package com.nyronium.overcharge.networking.serverbound

import com.nyronium.overcharge.util.KeybindManager
import net.minecraft.network.FriendlyByteBuf
import net.minecraftforge.network.NetworkEvent
import java.util.function.Supplier

data class KeybindSyncPacket(
    val isSprinting: Boolean,
    val isJumping: Boolean,
) {
    fun encode(buffer: FriendlyByteBuf) {
        buffer.writeBoolean(isSprinting)
        buffer.writeBoolean(isJumping)
    }

    companion object {
        fun decode(buffer: FriendlyByteBuf): KeybindSyncPacket {
            val isSprinting = buffer.readBoolean()
            val isJumping = buffer.readBoolean()
            return KeybindSyncPacket(isSprinting, isJumping)
        }

        fun handle(packet: KeybindSyncPacket, ctxSupplier: Supplier<NetworkEvent.Context>) {
            val ctx = ctxSupplier.get()
            ctx.enqueueWork {
                val player = ctx.sender
                if (player != null) {
                    KeybindManager.set(player.uuid, KeybindManager.KeyCategory.SPRINTING, packet.isSprinting)
                    KeybindManager.set(player.uuid, KeybindManager.KeyCategory.JUMPING, packet.isJumping)
                }
            }
            ctx.packetHandled = true
        }
    }
}
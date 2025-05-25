package com.nyronium.overcharge.networking.clientbound

import net.minecraft.client.Minecraft
import net.minecraft.core.particles.ParticleTypes
import net.minecraft.network.FriendlyByteBuf
import net.minecraft.sounds.SoundEvents
import net.minecraft.sounds.SoundSource
import net.minecraft.world.item.ItemStack
import net.minecraftforge.network.NetworkEvent
import java.util.function.Supplier

data class TesseractActivationPacket(val item: ItemStack) {
    fun encode(buf: FriendlyByteBuf) {
        buf.writeItem(item)
    }

    companion object {
        fun decode(buf: FriendlyByteBuf): TesseractActivationPacket {
            return TesseractActivationPacket(buf.readItem())
        }

        fun handle(packet: TesseractActivationPacket, ctxSupplier: Supplier<NetworkEvent.Context>) {
            val ctx = ctxSupplier.get()
            ctx.enqueueWork {
                val player = Minecraft.getInstance().player
                val level = Minecraft.getInstance().level

                if(player == null || level == null) return@enqueueWork

                level.playLocalSound(
                    player.x, player.y, player.z,
                    SoundEvents.BEACON_ACTIVATE,
                    SoundSource.PLAYERS,
                    1.0f,
                    1.0f,
                    true
                )
            }
            ctx.packetHandled = true
        }
    }
}
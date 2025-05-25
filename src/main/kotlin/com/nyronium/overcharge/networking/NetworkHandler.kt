package com.nyronium.overcharge.networking

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.networking.clientbound.TesseractActivationPacket
import com.nyronium.overcharge.networking.serverbound.KeybindSyncPacket
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.network.NetworkRegistry
import net.minecraftforge.network.simple.SimpleChannel

object NetworkHandler {
    const val PROTOCOL_VERSION = "1.0"
    val CHANNEL: SimpleChannel = NetworkRegistry.newSimpleChannel(
        ResourceLocation.tryBuild(Overcharge.ID, "main"),
        { PROTOCOL_VERSION },
        { PROTOCOL_VERSION == it },
        { PROTOCOL_VERSION == it }
    )

    fun register() {
        var id = 0
        CHANNEL.registerMessage(
            id++,
            KeybindSyncPacket::class.java,
            KeybindSyncPacket::encode,
            KeybindSyncPacket.Companion::decode,
            KeybindSyncPacket::handle)

        CHANNEL.registerMessage(
            id++,
            TesseractActivationPacket::class.java,
            TesseractActivationPacket::encode,
            TesseractActivationPacket.Companion::decode,
            TesseractActivationPacket::handle)
    }
}
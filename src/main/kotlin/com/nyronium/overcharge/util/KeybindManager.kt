package com.nyronium.overcharge.util

import com.nyronium.overcharge.Overcharge
import net.minecraft.world.entity.player.Player
import java.util.UUID
import kotlin.collections.set

object KeybindManager {

    fun sprintDown(player: Player): Boolean {
        return Overcharge.SPRINTING.getOrDefault(player.uuid, false)
    }

    fun jumpDown(player: Player): Boolean {
        return Overcharge.JUMPING.getOrDefault(player.uuid, false)
    }

    fun set(uuid: UUID, category: KeyCategory, value: Boolean) {
        when (category) {
            KeyCategory.JUMPING -> { Overcharge.JUMPING[uuid] = value }
            KeyCategory.SPRINTING -> { Overcharge.SPRINTING[uuid] = value }
            KeyCategory.FLIGHT_ENABLED -> { Overcharge.FLIGHT_ENABLED[uuid] = value }
        }
    }

    enum class KeyCategory {
        SPRINTING,
        JUMPING,
        FLIGHT_ENABLED,
    }
}
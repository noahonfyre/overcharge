package com.nyronium.overcharge.registry

import com.mojang.blaze3d.platform.InputConstants
import net.minecraft.client.KeyMapping
import net.minecraftforge.client.settings.KeyConflictContext
import org.lwjgl.glfw.GLFW

object ModKeyBindings {
    const val KEY_CATEGORY_OVERCHARGE = "key.categories.overcharge"
    const val KEY_FLIGHT = "key.overcharge.toggle_flight"
    const val KEY_AUTOPILOT = "key.overcharge.autopilot"
    const val KEY_LEVEL_HOLD = "key.overcharge.level_hold"
    const val KEY_HEADING_SELECT = "key.overcharge.heading_select"

    val TOGGLE_FLIGHT_KEY = KeyMapping(KEY_FLIGHT, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_GRAVE_ACCENT, KEY_CATEGORY_OVERCHARGE)
    val AUTOPILOT_KEY = KeyMapping(KEY_AUTOPILOT, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_H, KEY_CATEGORY_OVERCHARGE)
    val LEVEL_HOLD_KEY = KeyMapping(KEY_LEVEL_HOLD, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_H, KEY_CATEGORY_OVERCHARGE)
    val HEADING_SELECT_KEY = KeyMapping(KEY_HEADING_SELECT, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_H, KEY_CATEGORY_OVERCHARGE)
}
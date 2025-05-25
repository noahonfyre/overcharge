package com.nyronium.overcharge.registry

import com.mojang.blaze3d.platform.InputConstants
import net.minecraft.client.KeyMapping
import net.minecraftforge.client.settings.KeyConflictContext
import org.lwjgl.glfw.GLFW

object ModKeyBindings {
    const val KEY_CATEGORY_OVERCHARGE = "key.categories.overcharge"
    const val KEY_TOGGLE_FLIGHT = "key.overcharge.toggle_flight"

    val TOGGLE_FLIGHT_KEY = KeyMapping(KEY_TOGGLE_FLIGHT, KeyConflictContext.IN_GAME, InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_T, KEY_CATEGORY_OVERCHARGE)
}
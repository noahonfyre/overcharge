package com.nyronium.overcharge.util

object BaseUtils {
    fun chance(percentage: Int): Boolean {
        return (0..100).random() <= percentage
    }
}
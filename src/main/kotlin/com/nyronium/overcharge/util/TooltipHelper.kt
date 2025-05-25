package com.nyronium.overcharge.util

import net.minecraft.ChatFormatting
import net.minecraft.client.gui.screens.Screen
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.Style
import net.minecraft.network.chat.TextColor
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

object TooltipHelper {
    fun contextualUnitString(value: Long, unit: Unit, scale: Scale? = null): String {
        if (Screen.hasShiftDown()) {
            return value.toUnitString(unit, Scale.BASE)
        }
        return value.toUnitString(unit, scale)
    }

    fun formatLong(long: Long): String {
        return "%,d".format(long)
    }

    fun getFluidAnnunciator(fluid: String, fluidColor: TextColor, baseValue: Long, maxValue: Long): Component {
        return Component.literal(fluid).withStyle(Style.EMPTY.withColor(fluidColor))
            .append(Component.literal(": ").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)))
            .append(Component.literal(contextualUnitString(baseValue, Unit.BUCKET, Scale.MILLI)).withStyle(Style.EMPTY.withColor(fluidColor)))
            .append(Component.literal("/").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)))
            .append(Component.literal(contextualUnitString(maxValue, Unit.BUCKET, Scale.MILLI)).withStyle(Style.EMPTY.withColor(fluidColor)))
    }

    fun getEnergyAnnunciator(baseValue: Long, maxValue: Long): Component {
        return Component.literal("⚡").withStyle(Style.EMPTY.withColor(ChatFormatting.GOLD))
            .append(Component.literal(": ").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)))
            .append(Component.literal(contextualUnitString(baseValue, Unit.WATT_SECOND)).withStyle(Style.EMPTY.withColor(ChatFormatting.GOLD)))
            .append(Component.literal("/").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)))
            .append(Component.literal(contextualUnitString(maxValue, Unit.WATT_SECOND)).withStyle(Style.EMPTY.withColor(ChatFormatting.GOLD)))
    }
}
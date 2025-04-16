package com.nyronium.overcharge.util

import com.nyronium.overcharge.Overcharge
import net.minecraft.ChatFormatting
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent
import net.minecraft.network.chat.Style

object TooltipHelper {
    fun formatLong(long: Long): String {
        return "%,d".format(long).toString()
    }

    fun getFluidAnnunciator(label: MutableComponent, baseValue: Long, maxValue: Long): Component {
        return label
            .append(Component.literal(": ").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)))
            .append(Component.literal(Value(baseValue, Unit.BUCKET).toHumanReadable(Metric.MILLI)).withStyle(Style.EMPTY.withColor(Overcharge.COLOR)))
            .append(Component.literal("/").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)))
            .append(Component.literal(Value(maxValue, Unit.BUCKET).toHumanReadable(Metric.MILLI)).withStyle(Style.EMPTY.withColor(Overcharge.COLOR)))
    }

    fun getEnergyAnnunciator(label: MutableComponent, baseValue: Long, maxValue: Long): Component {
        return label
            .append(Component.literal(": ").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)))
            .append(Component.literal(Value(baseValue, Unit.JOULE).toHumanReadable(Metric.MEGA)).withStyle(Style.EMPTY.withColor(Overcharge.COLOR)))
            .append(Component.literal("/").withStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY)))
            .append(Component.literal(Value(maxValue, Unit.JOULE).toHumanReadable(Metric.MEGA)).withStyle(Style.EMPTY.withColor(Overcharge.COLOR)))
    }
}
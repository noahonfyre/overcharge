package com.nyronium.overcharge.util

import kotlin.math.pow

fun Long.toUnitString(unit: Unit, scale: Scale? = null): String {
    val newScale = scale ?: Scale.bestFit(this)
    return String.format("%,d", newScale.format(this)) + newScale.prefix + unit.symbol
}

enum class Unit(val symbol: String) {
    JOULE("J"), // Used primarily for chemical energy (e.g., energy stored in coal/food).
    WATT_SECOND("Ws"), // Used for electrical energy. 
    WATT("W"), // Used for power (energy per second)
    BUCKET("b"), // Used for fluids
    PASCAL("Pa"), // Used for pressure
}

enum class Scale(val prefix: String, val format: (Long) -> Long) {
    NANO("n", { n -> (n / 10.0.pow(-9)).toLong() }),
    MICRO("µ", { n -> (n / 10.0.pow(-6)).toLong() }),
    MILLI("m", { n -> (n / 10.0.pow(-3)).toLong() }),
    CENTI("c", { n -> (n / 10.0.pow(-2)).toLong() }),
    DECI("d", { n -> (n / 10.0.pow(-1)).toLong() }),
    BASE("", { n -> n }),
    DECA("da", { n -> (n / 10.0.pow(1)).toLong() }),
    HECTO("h", { n -> (n / 10.0.pow(2)).toLong() }),
    KILO("k", { n -> (n / 10.0.pow(3)).toLong() }),
    MEGA("M", { n -> (n / 10.0.pow(6)).toLong() }),
    GIGA("G", { n -> (n / 10.0.pow(9)).toLong() });

    companion object {
        private val ordered = entries.sortedBy { it.format(1_000_000_000) }

        fun bestFit(n: Long): Scale {
            return ordered.firstOrNull {
                it.format(n) >= 1
            } ?: BASE
        }
    }
}
package com.nyronium.overcharge.util

import com.google.common.collect.HashMultimap
import com.google.common.collect.Multimap

object BaseUtils {
    fun chance(percentage: Int): Boolean {
        return (0..100).random() <= percentage
    }

    fun <K, V> combinedMultiMaps(vararg maps: Multimap<K, V>): Multimap<K, V> {
        return maps.fold(HashMultimap.create<K, V>()) { acc, map ->
            acc.putAll(map)
            acc
        }
    }
}
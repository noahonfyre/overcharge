package com.nyronium.overcharge.content.item

import java.util.UUID

// Credits to lender544 on GitHub: https://github.com/lender544/new1.20.1/blob/master/src/main/java/com/github/L_Ender/cataclysm/items/More_Tool_Attribute.java
interface ItemAttributeModifierExtension {
    val BASE_ENTITY_INTERACTION_RANGE_ID: UUID
        get() = UUID.fromString("0CB612AF-CE7C-4FD2-9647-4BFD75B8D8A0")
    val BASE_BLOCK_INTERACTION_RANGE_ID: UUID
        get() = UUID.fromString("E7902C57-6C37-41CB-BBC4-F23AB1F287C0")

    val BASE_ARMOR_ID: UUID
        get() = UUID.fromString("FFB9296F-A5B3-4215-8196-4091D31575C6")
    val BASE_ARMOR_TOUGHNESS_ID: UUID
        get() = UUID.fromString("4A87FDB4-7CCC-471D-96C4-03AC8515E62F")
    val BASE_KNOCKBACK_RESISTANCE_ID: UUID
        get() = UUID.fromString("0F9ECB41-87F5-4787-8731-0A6C693B77F3")
}
package com.nyronium.overcharge.registry

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.content.block.electric_smelter.ElectricSmelterBlockEntity
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject

object ModBlockEntities {
    val BLOCK_ENTITIES: DeferredRegister<BlockEntityType<*>> = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Overcharge.ID)

    val ELECTRIC_SMELTER: RegistryObject<BlockEntityType<ElectricSmelterBlockEntity>> = BLOCK_ENTITIES.register("electric_smelter_entity") { BlockEntityType.Builder.of<ElectricSmelterBlockEntity>(::ElectricSmelterBlockEntity, ModBlocks.ELECTRIC_SMELTER.get()).build(null) }
}
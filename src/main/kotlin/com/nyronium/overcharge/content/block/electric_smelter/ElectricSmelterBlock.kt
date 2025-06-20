package com.nyronium.overcharge.content.block.electric_smelter

import com.nyronium.overcharge.registry.ModBlockEntities
import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerPlayer
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.entity.player.Player
import net.minecraft.world.level.BlockGetter
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.BaseEntityBlock
import net.minecraft.world.level.block.RenderShape
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.entity.BlockEntityTicker
import net.minecraft.world.level.block.entity.BlockEntityType
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.phys.BlockHitResult
import net.minecraft.world.phys.shapes.CollisionContext
import net.minecraft.world.phys.shapes.VoxelShape
import net.minecraftforge.network.NetworkHooks

class ElectricSmelterBlock(pProperties: Properties) : BaseEntityBlock(pProperties) {
    @Deprecated("Deprecated in Java")
    override fun getShape(
        pState: BlockState,
        pLevel: BlockGetter,
        pPos: BlockPos,
        pContext: CollisionContext
    ): VoxelShape {
        return box(0.0, 0.0, 0.0, 16.0, 27.0, 16.0)
    }

    @Deprecated("Deprecated in Java")
    override fun getRenderShape(pState: BlockState): RenderShape {
        return RenderShape.MODEL
    }

    override fun newBlockEntity(
        p0: BlockPos,
        p1: BlockState
    ): BlockEntity {
        return ElectricSmelterBlockEntity(p0, p1)
    }

    @Deprecated("Deprecated in Java")
    override fun onRemove(
        pState: BlockState,
        pLevel: Level,
        pPos: BlockPos,
        pNewState: BlockState,
        pMovedByPiston: Boolean
    ) {
        if(pState.block != pNewState.block) {
            val blockEntity = pLevel.getBlockEntity(pPos)
            if(blockEntity is ElectricSmelterBlockEntity) {
                blockEntity.drops()
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pMovedByPiston)
    }

    @Deprecated("Deprecated in Java")
    override fun use(
        pState: BlockState,
        pLevel: Level,
        pPos: BlockPos,
        pPlayer: Player,
        pHand: InteractionHand,
        pHit: BlockHitResult
    ): InteractionResult {
        if(!pLevel.isClientSide) {
            val blockEntity: BlockEntity? = pLevel.getBlockEntity(pPos)
            if(blockEntity is ElectricSmelterBlockEntity) {
                NetworkHooks.openScreen(pPlayer as ServerPlayer, blockEntity, pPos)
            }
        }
        return InteractionResult.sidedSuccess(pLevel.isClientSide)
    }

    override fun <T : BlockEntity?> getTicker(
        pLevel: Level,
        pState: BlockState,
        pBlockEntityType: BlockEntityType<T?>
    ): BlockEntityTicker<T?>? {
        if(pLevel.isClientSide) return null

        return createTickerHelper(pBlockEntityType, ModBlockEntities.ELECTRIC_SMELTER.get()) { pLevelNew, pPos, pStateNew, pBlockEntity -> pBlockEntity.tick(pLevelNew, pPos, pStateNew) }
    }
}
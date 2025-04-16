package com.nyronium.overcharge.content.block.electric_smelter

import com.nyronium.overcharge.registry.ModBlockEntities
import com.nyronium.overcharge.registry.ModItems
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.nbt.CompoundTag
import net.minecraft.network.chat.Component
import net.minecraft.world.Containers
import net.minecraft.world.MenuProvider
import net.minecraft.world.SimpleContainer
import net.minecraft.world.entity.player.Inventory
import net.minecraft.world.entity.player.Player
import net.minecraft.world.inventory.AbstractContainerMenu
import net.minecraft.world.inventory.ContainerData
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraftforge.common.capabilities.Capability
import net.minecraftforge.common.capabilities.ForgeCapabilities
import net.minecraftforge.common.util.LazyOptional
import net.minecraftforge.items.IItemHandler
import net.minecraftforge.items.ItemStackHandler

open class ElectricSmelterBlockEntity(pPos: BlockPos, pBlockState: BlockState) : BlockEntity(ModBlockEntities.ELECTRIC_SMELTER.get(), pPos, pBlockState), MenuProvider {
    private val itemHandler: ItemStackHandler = ItemStackHandler(2)

    private val INPUT_SLOT = 0
    private val OUTPUT_SLOT = 1

    private var lazyItemHandler: LazyOptional<IItemHandler> = LazyOptional.empty()

    protected val data: ContainerData = object : ContainerData {
        override fun get(p0: Int): Int {
            return when (p0) {
                0 -> this@ElectricSmelterBlockEntity.progress
                1 -> this@ElectricSmelterBlockEntity.maxProgress
                else -> 0
            }
        }

        override fun set(p0: Int, p1: Int) {
            when (p0) {
                0 -> this@ElectricSmelterBlockEntity.progress = p1
                1 -> this@ElectricSmelterBlockEntity.maxProgress = p1
            }
        }

        override fun getCount(): Int {
            return 2
        }

    }

    private var progress = 0
    private var maxProgress = 78

    override fun <T : Any> getCapability(cap: Capability<T>, side: Direction?): LazyOptional<T> {
        if(cap == ForgeCapabilities.ITEM_HANDLER) return lazyItemHandler.cast()

        return super.getCapability(cap, side)
    }

    override fun onLoad() {
        super.onLoad()
        lazyItemHandler = LazyOptional.of { itemHandler }
    }

    override fun getDisplayName(): Component {
        return Component.translatable("block.overcharge.electric_smelter")
    }

    fun drops() {
        val inventory = SimpleContainer(itemHandler.slots)

        for(slot in 0..itemHandler.slots-1) {
            inventory.setItem(slot, itemHandler.getStackInSlot(slot))
        }

        Containers.dropContents(level!!, worldPosition, inventory)
    }

    override fun createMenu(
        p0: Int,
        p1: Inventory,
        p2: Player
    ): AbstractContainerMenu? {
        return ElectricSmelterMenu(p0, p1, this, data)
    }

    override fun saveAdditional(pTag: CompoundTag) {
        pTag.put("inventory", itemHandler.serializeNBT())
        pTag.putInt("electric_smelter.progress", progress)
        super.saveAdditional(pTag)
    }

    override fun load(pTag: CompoundTag) {
        super.load(pTag)
        itemHandler.deserializeNBT(pTag.getCompound("inventory"))
        progress = pTag.getInt("electric_smelter.progress")
    }

    override fun invalidateCaps() {
        super.invalidateCaps()
        lazyItemHandler.invalidate()
    }

    fun tick(pLevel: Level, pPos: BlockPos, pState: BlockState) {
        if(hasRecipe()) {
            progress++
            setChanged(pLevel, pPos, pState)

            if(progress >= maxProgress) {
                craftItem()
                progress = 0
            }
        } else {
            progress = 0
        }
    }

    private fun craftItem() {
        val result = ItemStack(ModItems.ALUMINUM_INGOT.get(), 1)
        this.itemHandler.extractItem(INPUT_SLOT, 1, false)

        this.itemHandler.setStackInSlot(OUTPUT_SLOT, ItemStack(result.item, this.itemHandler.getStackInSlot(OUTPUT_SLOT).count + result.count))
    }

    private fun hasRecipe(): Boolean {
        val hasCraftingItem = this.itemHandler.getStackInSlot(INPUT_SLOT).item == ModItems.RAW_ALUMINUM
        val result = ItemStack(ModItems.ALUMINUM_INGOT.get())

        return hasCraftingItem && canOutputAmount(result.count) && canOutputItem(result.item)
    }

    private fun canOutputAmount(n: Int): Boolean {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).count + n <= this.itemHandler.getStackInSlot(OUTPUT_SLOT).maxStackSize
    }

    private fun canOutputItem(item: Item): Boolean {
        return this.itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty || this.itemHandler.getStackInSlot(OUTPUT_SLOT).`is`(item)
    }
}
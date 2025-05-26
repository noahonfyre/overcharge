package com.nyronium.overcharge.content.item.custom

import com.google.common.collect.HashMultimap
import com.google.common.collect.ImmutableMultimap
import com.google.common.collect.Multimap
import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.content.item.ModToolTiers
import com.nyronium.overcharge.content.item.ItemAttributeModifierExtension
import com.nyronium.overcharge.util.EnergyUtils
import com.nyronium.overcharge.util.TooltipHelper
import earth.terrarium.botarium.common.energy.base.BotariumEnergyItem
import earth.terrarium.botarium.common.energy.impl.SimpleEnergyContainer
import earth.terrarium.botarium.common.energy.impl.WrappedItemEnergyContainer
import net.minecraft.core.BlockPos
import net.minecraft.network.chat.Component
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.ai.attributes.Attribute
import net.minecraft.world.entity.ai.attributes.AttributeModifier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.TieredItem
import net.minecraft.world.item.TooltipFlag
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.state.BlockState
import net.minecraftforge.common.ForgeMod
import net.minecraftforge.common.ToolAction
import net.minecraftforge.common.ToolActions
import kotlin.math.roundToLong


class OverchargeBladeItem(val energyCapacity: Long, properties: Properties) : TieredItem(ModToolTiers.OVERCHARGE, properties), BotariumEnergyItem<WrappedItemEnergyContainer>, ItemAttributeModifierExtension {
    var itemAttributes: Multimap<Attribute, AttributeModifier> = HashMultimap.create()

    init {
        val builder: ImmutableMultimap.Builder<Attribute, AttributeModifier> = ImmutableMultimap.builder()
        builder.put(Attributes.ATTACK_DAMAGE, AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 27.0, AttributeModifier.Operation.ADDITION))
        builder.put(Attributes.ATTACK_SPEED, AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", -2.0, AttributeModifier.Operation.ADDITION))
        builder.put(ForgeMod.ENTITY_REACH.get(), AttributeModifier(BASE_ENTITY_INTERACTION_RANGE_ID, "Tool modifier", 3.0, AttributeModifier.Operation.ADDITION))
        builder.put(ForgeMod.BLOCK_REACH.get(), AttributeModifier(BASE_BLOCK_INTERACTION_RANGE_ID, "Tool modifier", 3.0, AttributeModifier.Operation.ADDITION))
        itemAttributes = builder.build()
    }

    override fun appendHoverText(
        stack: ItemStack,
        level: Level?,
        tooltip: MutableList<Component>,
        flag: TooltipFlag
    ) {
        val energyStored = getEnergyStorage(stack).storedEnergy
        val energyCapacity = getEnergyStorage(stack).maxCapacity
        tooltip.add(TooltipHelper.getEnergyAnnunciator(energyStored, energyCapacity))
        super.appendHoverText(stack, level, tooltip, flag)
    }

    override fun getAttributeModifiers(
        slot: EquipmentSlot,
        stack: ItemStack
    ): Multimap<Attribute, AttributeModifier> {
        return if (slot == EquipmentSlot.MAINHAND) itemAttributes else super.getAttributeModifiers(slot, stack)
    }

    override fun isBarVisible(stack: ItemStack): Boolean {
        val energyStorage = getEnergyStorage(stack)
        val energyStored = energyStorage.storedEnergy
        return energyStored > 0
    }

    override fun getBarWidth(stack: ItemStack): Int {
        val energyStorage = getEnergyStorage(stack)
        return (13 * energyStorage.storedEnergy / energyStorage.maxCapacity.toFloat()).toInt()
    }

    override fun getBarColor(stack: ItemStack): Int {
        return Overcharge.COLOR
    }

    override fun getEnergyStorage(holder: ItemStack): WrappedItemEnergyContainer {
        return WrappedItemEnergyContainer(
            holder,
            object : SimpleEnergyContainer(energyCapacity) {
                override fun maxInsert(): Long {
                    return 2500L
                }
            }
        )
    }

    override fun mineBlock(pStack: ItemStack, pLevel: Level, pState: BlockState, pPos: BlockPos, pMiningEntity: LivingEntity): Boolean {
        if(pMiningEntity !is Player) return super.mineBlock(pStack, pLevel, pState, pPos, pMiningEntity)
        val energyUsage = (pState.getDestroySpeed(pLevel, pPos)*1000).roundToLong()
        // TODO: fix produced flickering
        EnergyUtils.consume(pMiningEntity, pMiningEntity.inventory.items, pStack, pMiningEntity.inventory.findSlotMatchingItem(pStack), energyUsage)
        return super.mineBlock(pStack, pLevel, pState, pPos, pMiningEntity)
    }

    override fun hurtEnemy(pStack: ItemStack, pTarget: LivingEntity, pAttacker: LivingEntity): Boolean {
        if(pAttacker !is Player) return super.hurtEnemy(pStack, pTarget, pAttacker)
        val energyUsage = (pTarget.maxHealth*10).roundToLong()
        // TODO: fix produced flickering
        EnergyUtils.consume(pAttacker, pAttacker.inventory.items, pStack, pAttacker.inventory.findSlotMatchingItem(pStack), energyUsage)
        return super.hurtEnemy(pStack, pTarget, pAttacker)
    }

    override fun canAttackBlock(pState: BlockState, pLevel: Level, pPos: BlockPos, pPlayer: Player): Boolean = getEnergyStorage(pPlayer.mainHandItem).storedEnergy > 0

    override fun canPerformAction(stack: ItemStack, toolAction: ToolAction): Boolean = toolAction == ToolActions.DEFAULT_PICKAXE_ACTIONS || toolAction == ToolActions.DEFAULT_AXE_ACTIONS || toolAction == ToolActions.DEFAULT_SWORD_ACTIONS || toolAction == ToolActions.DEFAULT_SHOVEL_ACTIONS || toolAction == ToolActions.DEFAULT_HOE_ACTIONS

    override fun isCorrectToolForDrops(stack: ItemStack, state: BlockState): Boolean = true

    override fun isDamageable(itemstack: ItemStack): Boolean = false

    override fun getDamage(itemstack: ItemStack): Int = 0

    override fun getDestroySpeed(itemstack: ItemStack, blockstate: BlockState): Float = tier.speed
}
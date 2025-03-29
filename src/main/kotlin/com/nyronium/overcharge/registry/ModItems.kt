package com.nyronium.overcharge.registry

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.registry.ModFluidProperties
import com.nyronium.overcharge.content.item.ModToolTiers
import com.nyronium.overcharge.content.item.base.HammerItem
import com.nyronium.overcharge.content.item.base.WrenchItem
import earth.terrarium.botarium.common.registry.fluid.FluidBucketItem
import earth.terrarium.botarium.common.registry.fluid.FluidProperties
import net.minecraft.world.item.AxeItem
import net.minecraft.world.item.BucketItem
import net.minecraft.world.item.HoeItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import net.minecraft.world.item.PickaxeItem
import net.minecraft.world.item.ShovelItem
import net.minecraft.world.item.SwordItem
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject

object ModItems {
    val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, Overcharge.ID)

    val ICON: RegistryObject<Item> = ITEMS.register("icon") { Item(Item.Properties()) }

    val RAW_ALUMINUM: RegistryObject<Item> = ITEMS.register("raw_aluminum") { Item(Item.Properties()) }
    val ALUMINUM_INGOT: RegistryObject<Item> = ITEMS.register("aluminum_ingot") { Item(Item.Properties()) }
    val ALUMINUM_PLATE: RegistryObject<Item> = ITEMS.register("aluminum_plate") { Item(Item.Properties()) }
    val ALUMINUM_ROD: RegistryObject<Item> = ITEMS.register("aluminum_rod") { Item(Item.Properties()) }
    val ALUMINUM_NUGGET: RegistryObject<Item> = ITEMS.register("aluminum_nugget") { Item(Item.Properties()) }
    val MODULAR_FRAME: RegistryObject<Item> = ITEMS.register("modular_frame") { Item(Item.Properties()) }
    val FAN: RegistryObject<Item> = ITEMS.register("fan") { Item(Item.Properties()) }
    val ACCUMULATOR: RegistryObject<Item> = ITEMS.register("accumulator") { Item(Item.Properties()) }
    val FLUID_TANK: RegistryObject<Item> = ITEMS.register("fluid_tank") { Item(Item.Properties()) }

    val ALUMINUM_SWORD: RegistryObject<Item> = ITEMS.register("aluminum_sword") { SwordItem(ModToolTiers.ALUMINUM, 3, -2.4f, Item.Properties()) }
    val ALUMINUM_AXE: RegistryObject<Item> = ITEMS.register("aluminum_axe") { AxeItem(ModToolTiers.ALUMINUM, 6f, -3.1f, Item.Properties()) }
    val ALUMINUM_PICKAXE: RegistryObject<Item> = ITEMS.register("aluminum_pickaxe") { PickaxeItem(ModToolTiers.ALUMINUM, 1, -2.8f, Item.Properties()) }
    val ALUMINUM_SHOVEL: RegistryObject<Item> = ITEMS.register("aluminum_shovel") { ShovelItem(ModToolTiers.ALUMINUM, 1.5f, -3.0f, Item.Properties()) }
    val ALUMINUM_HOE: RegistryObject<Item> = ITEMS.register("aluminum_hoe") { HoeItem(ModToolTiers.ALUMINUM, -2, -1f, Item.Properties()) }
    val ALUMINUM_WRENCH: RegistryObject<Item> = ITEMS.register("aluminum_wrench") { WrenchItem(ModToolTiers.ALUMINUM, 2f, 2f, Item.Properties()) }
    val ALUMINUM_HAMMER: RegistryObject<Item> = ITEMS.register("aluminum_hammer") { HammerItem(ModToolTiers.ALUMINUM, 2f, 2f, Item.Properties()) }

    val COPPER_PLATE: RegistryObject<Item> = ITEMS.register("copper_plate") { Item(Item.Properties()) }
    val COPPER_ROD: RegistryObject<Item> = ITEMS.register("copper_rod") { Item(Item.Properties()) }
    val COPPER_NUGGET: RegistryObject<Item> = ITEMS.register("copper_nugget") { Item(Item.Properties()) }

    val IRON_PLATE: RegistryObject<Item> = ITEMS.register("iron_plate") { Item(Item.Properties()) }
    val IRON_ROD: RegistryObject<Item> = ITEMS.register("iron_rod") { Item(Item.Properties()) }

    val GOLD_PLATE: RegistryObject<Item> = ITEMS.register("gold_plate") { Item(Item.Properties()) }
    val GOLD_ROD: RegistryObject<Item> = ITEMS.register("gold_rod") { Item(Item.Properties()) }

    val RAW_LITHIUM: RegistryObject<Item> = ITEMS.register("raw_lithium") { Item(Item.Properties()) }
    val LITHIUM_INGOT: RegistryObject<Item> = ITEMS.register("lithium_ingot") { Item(Item.Properties()) }
    val LITHIUM_PLATE: RegistryObject<Item> = ITEMS.register("lithium_plate") { Item(Item.Properties()) }
    val LITHIUM_ROD: RegistryObject<Item> = ITEMS.register("lithium_rod") { Item(Item.Properties()) }
    val LITHIUM_NUGGET: RegistryObject<Item> = ITEMS.register("lithium_nugget") { Item(Item.Properties()) }
    val CHEMICAL_COMPOUND: RegistryObject<Item> = ITEMS.register("chemical_compound") { Item(Item.Properties()) }
    val CHEMICAL_CORE: RegistryObject<Item> = ITEMS.register("chemical_core") { Item(Item.Properties()) }

    val PULVERIZED_SAND: RegistryObject<Item> = ITEMS.register("pulverized_sand") { Item(Item.Properties()) }
    val SILICA: RegistryObject<Item> = ITEMS.register("silica") { Item(Item.Properties()) }
    val SILICON: RegistryObject<Item> = ITEMS.register("silicon") { Item(Item.Properties()) }
    val SILICON_SHARD: RegistryObject<Item> = ITEMS.register("silicon_shard") { Item(Item.Properties()) }
    val WAFER: RegistryObject<Item> = ITEMS.register("wafer") { Item(Item.Properties()) }

    val STEEL_INGOT: RegistryObject<Item> = ITEMS.register("steel_ingot") { Item(Item.Properties()) }
    val STEEL_PLATE: RegistryObject<Item> = ITEMS.register("steel_plate") { Item(Item.Properties()) }
    val STEEL_ROD: RegistryObject<Item> = ITEMS.register("steel_rod") { Item(Item.Properties()) }
    val STEEL_NUGGET: RegistryObject<Item> = ITEMS.register("steel_nugget") { Item(Item.Properties()) }
    val STURDY_MODULAR_FRAME: RegistryObject<Item> = ITEMS.register("sturdy_modular_frame") { Item(Item.Properties()) }
    val TURBINE: RegistryObject<Item> = ITEMS.register("turbine") { Item(Item.Properties()) }
    val HEATER: RegistryObject<Item> = ITEMS.register("heater") { Item(Item.Properties()) }
    val ARM_COMPONENT: RegistryObject<Item> = ITEMS.register("arm_component") { Item(Item.Properties()) }

    val STEEL_SWORD: RegistryObject<Item> = ITEMS.register("steel_sword") { SwordItem(ModToolTiers.STEEL, 1, 1f, Item.Properties()) }
    val STEEL_AXE: RegistryObject<Item> = ITEMS.register("steel_axe") { AxeItem(ModToolTiers.STEEL, 1f, 1f, Item.Properties()) }
    val STEEL_PICKAXE: RegistryObject<Item> = ITEMS.register("steel_pickaxe") { PickaxeItem(ModToolTiers.STEEL, 1, 1f, Item.Properties()) }
    val STEEL_SHOVEL: RegistryObject<Item> = ITEMS.register("steel_shovel") { ShovelItem(ModToolTiers.STEEL, 1f, 1f, Item.Properties()) }
    val STEEL_HOE: RegistryObject<Item> = ITEMS.register("steel_hoe") { HoeItem(ModToolTiers.STEEL, 1, 1f, Item.Properties()) }
    val STEEL_WRENCH: RegistryObject<Item> = ITEMS.register("steel_wrench") { WrenchItem(ModToolTiers.STEEL, 1f, 1f, Item.Properties()) }
    val STEEL_HAMMER: RegistryObject<Item> = ITEMS.register("steel_hammer") { HammerItem(ModToolTiers.STEEL, 1f, 1f, Item.Properties()) }

    val RAW_TITANIUM: RegistryObject<Item> = ITEMS.register("raw_titanium") { Item(Item.Properties()) }
    val TITANIUM_INGOT: RegistryObject<Item> = ITEMS.register("titanium_ingot") { Item(Item.Properties()) }
    val TITANIUM_PLATE: RegistryObject<Item> = ITEMS.register("titanium_plate") { Item(Item.Properties()) }
    val TITANIUM_ROD: RegistryObject<Item> = ITEMS.register("titanium_rod") { Item(Item.Properties()) }
    val TITANIUM_NUGGET: RegistryObject<Item> = ITEMS.register("titanium_nugget") { Item(Item.Properties()) }
    
    val TITANIUM_SWORD: RegistryObject<Item> = ITEMS.register("titanium_sword") { SwordItem(ModToolTiers.TITANIUM, 1, 1f, Item.Properties()) }
    val TITANIUM_AXE: RegistryObject<Item> = ITEMS.register("titanium_axe") { AxeItem(ModToolTiers.TITANIUM, 1f, 1f, Item.Properties()) }
    val TITANIUM_PICKAXE: RegistryObject<Item> = ITEMS.register("titanium_pickaxe") { PickaxeItem(ModToolTiers.TITANIUM, 1, 1f, Item.Properties()) }
    val TITANIUM_SHOVEL: RegistryObject<Item> = ITEMS.register("titanium_shovel") { ShovelItem(ModToolTiers.TITANIUM, 1f, 1f, Item.Properties()) }
    val TITANIUM_HOE: RegistryObject<Item> = ITEMS.register("titanium_hoe") { HoeItem(ModToolTiers.TITANIUM, 1, 1f, Item.Properties()) }
    val TITANIUM_WRENCH: RegistryObject<Item> = ITEMS.register("titanium_wrench") { WrenchItem(ModToolTiers.TITANIUM, 1f, 1f, Item.Properties()) }
    val TITANIUM_HAMMER: RegistryObject<Item> = ITEMS.register("titanium_hammer") { HammerItem(ModToolTiers.TITANIUM, 1f, 1f, Item.Properties()) }

    val RAW_URANIUM: RegistryObject<Item> = ITEMS.register("raw_uranium") { Item(Item.Properties()) }
    val URANIUM_INGOT: RegistryObject<Item> = ITEMS.register("uranium_ingot") { Item(Item.Properties()) }
    val URANIUM_PLATE: RegistryObject<Item> = ITEMS.register("uranium_plate") { Item(Item.Properties()) }
    val URANIUM_ROD: RegistryObject<Item> = ITEMS.register("uranium_rod") { Item(Item.Properties()) }
    val URANIUM_NUGGET: RegistryObject<Item> = ITEMS.register("uranium_nugget") { Item(Item.Properties()) }

    val AMETHYST_DUST: RegistryObject<Item> = ITEMS.register("amethyst_dust") { Item(Item.Properties()) }
    val CRYSTALLIC_FIBERS: RegistryObject<Item> = ITEMS.register("crystallic_fibers") { Item(Item.Properties()) }

    val MINERAL_COMPOUND: RegistryObject<Item> = ITEMS.register("mineral_compound") { Item(Item.Properties()) }
    val ORGANIC_COMPOUND: RegistryObject<Item> = ITEMS.register("organic_compound") { Item(Item.Properties()) }
    val SYNTHETIC: RegistryObject<Item> = ITEMS.register("synthetic") { Item(Item.Properties()) }

    val UNSTABLE_DIAMOND: RegistryObject<Item> = ITEMS.register("unstable_diamond") { Item(Item.Properties()) }
    val TERMINAL: RegistryObject<Item> = ITEMS.register("terminal") { Item(Item.Properties()) }

    val ELECTROLYTIC_CELL: RegistryObject<Item> = ITEMS.register("electrolytic_cell") { Item(Item.Properties()) }
    val GALVANIC_CELL: RegistryObject<Item> = ITEMS.register("galvanic_cell") { Item(Item.Properties()) }
    val FUEL_CELL: RegistryObject<Item> = ITEMS.register("fuel_cell") { Item(Item.Properties()) }

    val PULVERIZED_BASALT: RegistryObject<Item> = ITEMS.register("pulverized_basalt") { Item(Item.Properties()) }
    val BASALT_FIBER: RegistryObject<Item> = ITEMS.register("basalt_fiber") { Item(Item.Properties()) }

    val OXYGEN_BUCKET: RegistryObject<Item> = ITEMS.register("oxygen_bucket") { FluidBucketItem(ModFluidProperties.OXYGEN, Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)) }
    val HYDROGEN_BUCKET: RegistryObject<Item> = ITEMS.register("hydrogen_bucket") { FluidBucketItem(ModFluidProperties.HYDROGEN, Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)) }
    val NITROGEN_BUCKET: RegistryObject<Item> = ITEMS.register("nitrogen_bucket") { FluidBucketItem(ModFluidProperties.NITROGEN, Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)) }
    val LIQUID_COMPOUND_BUCKET: RegistryObject<Item> = ITEMS.register("liquid_compound_bucket") { FluidBucketItem(ModFluidProperties.LIQUID_COMPOUND, Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)) }
    val POLYETHYLENE_BUCKET: RegistryObject<Item> = ITEMS.register("polyethylene_bucket") { FluidBucketItem(ModFluidProperties.POLYETHYLENE, Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)) }
}
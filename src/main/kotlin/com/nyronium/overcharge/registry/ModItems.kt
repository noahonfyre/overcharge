package com.nyronium.overcharge.registry

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.content.item.ModArmorMaterials
import com.nyronium.overcharge.content.item.ModToolTiers
import com.nyronium.overcharge.content.item.accessories.*
import com.nyronium.overcharge.content.item.base.GlintItem
import com.nyronium.overcharge.content.item.base.HammerItem
import com.nyronium.overcharge.content.item.base.UnbreakableArmorItem
import com.nyronium.overcharge.content.item.base.WrenchItem
import com.nyronium.overcharge.content.item.custom.OverchargeBladeItem
import com.nyronium.overcharge.content.item.custom.OverchargeHammerItem
import com.nyronium.overcharge.content.item.custom.OverchargeSuitItem
import com.nyronium.overcharge.content.item.custom.TesseractItem
import earth.terrarium.botarium.common.registry.fluid.FluidBucketItem
import net.minecraft.world.item.*
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
    val TRAY: RegistryObject<Item> = ITEMS.register("tray") { Item(Item.Properties()) }
    val SOLID_STATE_DRIVE: RegistryObject<Item> = ITEMS.register("solid_state_drive") { Item(Item.Properties()) }
    val WIRELESS_MODULE: RegistryObject<Item> = ITEMS.register("wireless_module") { Item(Item.Properties()) }

    val COPPER_PLATE: RegistryObject<Item> = ITEMS.register("copper_plate") { Item(Item.Properties()) }
    val COPPER_ROD: RegistryObject<Item> = ITEMS.register("copper_rod") { Item(Item.Properties()) }
    val COPPER_NUGGET: RegistryObject<Item> = ITEMS.register("copper_nugget") { Item(Item.Properties()) }
    val HEATER: RegistryObject<Item> = ITEMS.register("heater") { Item(Item.Properties()) }

    val RAW_LITHIUM: RegistryObject<Item> = ITEMS.register("raw_lithium") { Item(Item.Properties()) }
    val LITHIUM_INGOT: RegistryObject<Item> = ITEMS.register("lithium_ingot") { Item(Item.Properties()) }
    val LITHIUM_PLATE: RegistryObject<Item> = ITEMS.register("lithium_plate") { Item(Item.Properties()) }
    val LITHIUM_ROD: RegistryObject<Item> = ITEMS.register("lithium_rod") { Item(Item.Properties()) }
    val LITHIUM_NUGGET: RegistryObject<Item> = ITEMS.register("lithium_nugget") { Item(Item.Properties()) }

    val STEEL_INGOT: RegistryObject<Item> = ITEMS.register("steel_ingot") { Item(Item.Properties()) }
    val STEEL_PLATE: RegistryObject<Item> = ITEMS.register("steel_plate") { Item(Item.Properties()) }
    val STEEL_ROD: RegistryObject<Item> = ITEMS.register("steel_rod") { Item(Item.Properties()) }
    val STEEL_NUGGET: RegistryObject<Item> = ITEMS.register("steel_nugget") { Item(Item.Properties()) }
    val STURDY_MODULAR_FRAME: RegistryObject<Item> = ITEMS.register("sturdy_modular_frame") { Item(Item.Properties()) }
    val TURBINE: RegistryObject<Item> = ITEMS.register("turbine") { Item(Item.Properties()) }
    val ARM_COMPONENT: RegistryObject<Item> = ITEMS.register("arm_component") { Item(Item.Properties()) }
    val ACCUMULATOR: RegistryObject<Item> = ITEMS.register("accumulator") { Item(Item.Properties()) }
    val FLUID_TANK: RegistryObject<Item> = ITEMS.register("fluid_tank") { Item(Item.Properties()) }

    val RAW_TITANIUM: RegistryObject<Item> = ITEMS.register("raw_titanium") { Item(Item.Properties()) }
    val TITANIUM_INGOT: RegistryObject<Item> = ITEMS.register("titanium_ingot") { Item(Item.Properties()) }
    val TITANIUM_PLATE: RegistryObject<Item> = ITEMS.register("titanium_plate") { Item(Item.Properties()) }
    val TITANIUM_ROD: RegistryObject<Item> = ITEMS.register("titanium_rod") { Item(Item.Properties()) }
    val TITANIUM_NUGGET: RegistryObject<Item> = ITEMS.register("titanium_nugget") { Item(Item.Properties()) }

    val RAW_URANIUM: RegistryObject<Item> = ITEMS.register("raw_uranium") { Item(Item.Properties()) }
    val URANIUM_INGOT: RegistryObject<Item> = ITEMS.register("uranium_ingot") { Item(Item.Properties()) }
    val URANIUM_PLATE: RegistryObject<Item> = ITEMS.register("uranium_plate") { Item(Item.Properties()) }
    val URANIUM_ROD: RegistryObject<Item> = ITEMS.register("uranium_rod") { Item(Item.Properties()) }
    val URANIUM_NUGGET: RegistryObject<Item> = ITEMS.register("uranium_nugget") { Item(Item.Properties()) }

    val STEEL_SWORD: RegistryObject<Item> = ITEMS.register("steel_sword") { SwordItem(ModToolTiers.STEEL, 1, -2.4f, Item.Properties()) }
    val STEEL_AXE: RegistryObject<Item> = ITEMS.register("steel_axe") { AxeItem(ModToolTiers.STEEL, -1f, -2.4f, Item.Properties()) }
    val STEEL_PICKAXE: RegistryObject<Item> = ITEMS.register("steel_pickaxe") { PickaxeItem(ModToolTiers.STEEL, -1, -2.4f, Item.Properties()) }
    val STEEL_SHOVEL: RegistryObject<Item> = ITEMS.register("steel_shovel") { ShovelItem(ModToolTiers.STEEL, -1f, -2.4f, Item.Properties()) }
    val STEEL_HOE: RegistryObject<Item> = ITEMS.register("steel_hoe") { HoeItem(ModToolTiers.STEEL, -1, -2.4f, Item.Properties()) }
    val STEEL_WRENCH: RegistryObject<Item> = ITEMS.register("steel_wrench") { WrenchItem(ModToolTiers.STEEL, -1f, -2.4f, Item.Properties()) }
    val STEEL_HAMMER: RegistryObject<Item> = ITEMS.register("steel_hammer") { HammerItem(ModToolTiers.STEEL, -1f, -2.4f, Item.Properties()) }

    val STEEL_HELMET: RegistryObject<Item> = ITEMS.register("steel_helmet") { ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.HELMET, Item.Properties()) }
    val STEEL_CHESTPLATE: RegistryObject<Item> = ITEMS.register("steel_chestplate") { ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.CHESTPLATE, Item.Properties()) }
    val STEEL_LEGGINGS: RegistryObject<Item> = ITEMS.register("steel_leggings") { ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.LEGGINGS, Item.Properties()) }
    val STEEL_BOOTS: RegistryObject<Item> = ITEMS.register("steel_boots") { ArmorItem(ModArmorMaterials.STEEL, ArmorItem.Type.BOOTS, Item.Properties()) }

    val TITANIUM_SWORD: RegistryObject<Item> = ITEMS.register("titanium_sword") { SwordItem(ModToolTiers.TITANIUM, 1, -2.4f, Item.Properties()) }
    val TITANIUM_AXE: RegistryObject<Item> = ITEMS.register("titanium_axe") { AxeItem(ModToolTiers.TITANIUM, -1f, -2.4f, Item.Properties()) }
    val TITANIUM_PICKAXE: RegistryObject<Item> = ITEMS.register("titanium_pickaxe") { PickaxeItem(ModToolTiers.TITANIUM, -1, -2.4f, Item.Properties()) }
    val TITANIUM_SHOVEL: RegistryObject<Item> = ITEMS.register("titanium_shovel") { ShovelItem(ModToolTiers.TITANIUM, -1f, -2.4f, Item.Properties()) }
    val TITANIUM_HOE: RegistryObject<Item> = ITEMS.register("titanium_hoe") { HoeItem(ModToolTiers.TITANIUM, -1, -2.4f, Item.Properties()) }
    val TITANIUM_WRENCH: RegistryObject<Item> = ITEMS.register("titanium_wrench") { WrenchItem(ModToolTiers.TITANIUM, -1f, -2.4f, Item.Properties()) }
    val TITANIUM_HAMMER: RegistryObject<Item> = ITEMS.register("titanium_hammer") { HammerItem(ModToolTiers.TITANIUM, -1f, -2.4f, Item.Properties()) }

    val TITANIUM_HELMET: RegistryObject<Item> = ITEMS.register("titanium_helmet") { ArmorItem(ModArmorMaterials.TITANIUM, ArmorItem.Type.HELMET, Item.Properties()) }
    val TITANIUM_CHESTPLATE: RegistryObject<Item> = ITEMS.register("titanium_chestplate") { ArmorItem(ModArmorMaterials.TITANIUM, ArmorItem.Type.CHESTPLATE, Item.Properties()) }
    val TITANIUM_LEGGINGS: RegistryObject<Item> = ITEMS.register("titanium_leggings") { ArmorItem(ModArmorMaterials.TITANIUM, ArmorItem.Type.LEGGINGS, Item.Properties()) }
    val TITANIUM_BOOTS: RegistryObject<Item> = ITEMS.register("titanium_boots") { ArmorItem(ModArmorMaterials.TITANIUM, ArmorItem.Type.BOOTS, Item.Properties()) }

    val GALVANIC_CELL: RegistryObject<Item> = ITEMS.register("galvanic_cell") { Item(Item.Properties()) }
    val SECONDARY_CELL: RegistryObject<Item> = ITEMS.register("secondary_cell") { Item(Item.Properties()) }
    val ELECTROLYTIC_CELL: RegistryObject<Item> = ITEMS.register("electrolytic_cell") { Item(Item.Properties()) }
    val FUEL_CELL: RegistryObject<Item> = ITEMS.register("fuel_cell") { Item(Item.Properties()) }

    val DIMENSIONAL_RESIDUE: RegistryObject<Item> = ITEMS.register("dimensional_residue") { Item(Item.Properties()) }
    val DIMENSION_FRAGMENTED_TITANIUM_INGOT: RegistryObject<Item> = ITEMS.register("dimension_fragmented_titanium_ingot") { Item(Item.Properties()) }
    val PHOSPHORUS: RegistryObject<Item> = ITEMS.register("phosphorus") { Item(Item.Properties()) }
    val SULFURIC_RESIDUE: RegistryObject<Item> = ITEMS.register("sulfuric_residue") { Item(Item.Properties()) }

    val ENDER_DUST: RegistryObject<Item> = ITEMS.register("ender_dust") { Item(Item.Properties()) }
    val ENDERIC_ESSENCE: RegistryObject<Item> = ITEMS.register("enderic_essence") { Item(Item.Properties()) }

    val PULVERIZED_SAND: RegistryObject<Item> = ITEMS.register("pulverized_sand") { Item(Item.Properties()) }
    val SILICA: RegistryObject<Item> = ITEMS.register("silica") { Item(Item.Properties()) }
    val SILICON_SHARD: RegistryObject<Item> = ITEMS.register("silicon_shard") { Item(Item.Properties()) }
    val SILICON: RegistryObject<Item> = ITEMS.register("silicon") { Item(Item.Properties()) }
    val SILICON_INFUSED_PEARL: RegistryObject<Item> = ITEMS.register("silicon_infused_pearl") { Item(Item.Properties()) }

    val REACTIVE_CLUSTERS: RegistryObject<Item> = ITEMS.register("reactive_clusters") { Item(Item.Properties()) }
    val AMETHYST_DUST: RegistryObject<Item> = ITEMS.register("amethyst_dust") { Item(Item.Properties()) }
    val CRYSTALLIC_FIBERS: RegistryObject<Item> = ITEMS.register("crystallic_fibers") { Item(Item.Properties()) }

    val MINERAL_COMPOUND: RegistryObject<Item> = ITEMS.register("mineral_compound") { Item(Item.Properties()) }
    val SYNTHETIC: RegistryObject<Item> = ITEMS.register("synthetic") { Item(Item.Properties()) }
    val ORGANIC_COMPOUND: RegistryObject<Item> = ITEMS.register("organic_compound") { Item(Item.Properties()) }
    val PHOTONIC_COMPOUND: RegistryObject<Item> = ITEMS.register("photonic_compound") { Item(Item.Properties()) }
    val CHEMICAL_COMPOUND: RegistryObject<Item> = ITEMS.register("chemical_compound") { Item(Item.Properties()) }
    val CHEMICAL_CORE: RegistryObject<Item> = ITEMS.register("chemical_core") { Item(Item.Properties()) }
    val TRANSISTOR: RegistryObject<Item> = ITEMS.register("transistor") { Item(Item.Properties()) }

    val PULVERIZED_BASALT: RegistryObject<Item> = ITEMS.register("pulverized_basalt") { Item(Item.Properties()) }
    val BASALT_FIBER: RegistryObject<Item> = ITEMS.register("basalt_fiber") { Item(Item.Properties()) }

    val TITANIUM_UPGRADE_SMITHING_TEMPLATE: RegistryObject<Item> = ITEMS.register("titanium_upgrade_smithing_template") { Item(Item.Properties()) }

    val UNSTABLE_DIAMOND: RegistryObject<Item> = ITEMS.register("unstable_diamond") { Item(Item.Properties()) }
    val KYBERNETIC_CORE: RegistryObject<Item> = ITEMS.register("kybernetic_core") { Item(Item.Properties()) }

    val RADIANCE_DUST: RegistryObject<Item> = ITEMS.register("radiance_dust") { GlintItem(Item.Properties()) }
    val REFINED_RADIANCE: RegistryObject<Item> = ITEMS.register("refined_radiance") { GlintItem(Item.Properties()) }
    val NANITE_PASTE: RegistryObject<Item> = ITEMS.register("nanite_paste") { Item(Item.Properties()) }
    val ARCANE_RESIN: RegistryObject<Item> = ITEMS.register("arcane_resin") { Item(Item.Properties()) }
    val COSMIC_SHARD: RegistryObject<Item> = ITEMS.register("cosmic_shard") { Item(Item.Properties()) }
    val ELYTRIC_DUST: RegistryObject<Item> = ITEMS.register("elytric_dust") { Item(Item.Properties()) }
    val FADED_DIAMOND: RegistryObject<Item> = ITEMS.register("faded_diamond") { Item(Item.Properties()) }

    val SILICON_WAFER: RegistryObject<Item> = ITEMS.register("silicon_wafer") { Item(Item.Properties()) }
    val SILICON_DIE: RegistryObject<Item> = ITEMS.register("silicon_die") { Item(Item.Properties()) }
    val UNSTABLE_WAFER: RegistryObject<Item> = ITEMS.register("unstable_wafer") { Item(Item.Properties()) }
    val UNSTABLE_DIE: RegistryObject<Item> = ITEMS.register("unstable_die") { Item(Item.Properties()) }
    val MICROPROCESSOR: RegistryObject<Item> = ITEMS.register("microprocessor") { Item(Item.Properties()) }
    val FLASH_CHIP: RegistryObject<Item> = ITEMS.register("flash_chip") { Item(Item.Properties()) }
    val LOW_VOLTAGE_PROCESSOR: RegistryObject<Item> = ITEMS.register("low_voltage_processor") { Item(Item.Properties()) }
    val MEDIUM_VOLTAGE_PROCESSOR: RegistryObject<Item> = ITEMS.register("medium_voltage_processor") { Item(Item.Properties()) }
    val HIGH_VOLTAGE_PROCESSOR: RegistryObject<Item> = ITEMS.register("high_voltage_processor") { Item(Item.Properties()) }
    val ULTRA_HIGH_VOLTAGE_PROCESSOR: RegistryObject<Item> = ITEMS.register("ultra_high_voltage_processor") { Item(Item.Properties()) }

    val OVERCHARGE: RegistryObject<Item> = ITEMS.register("overcharge") { Item(Item.Properties()) }
    val TESSERACT: RegistryObject<Item> = ITEMS.register("tesseract") { TesseractItem(Item.Properties().stacksTo(1), 2_000_000) }

    val NIAGARA: RegistryObject<Item> = ITEMS.register("niagara") { NiagaraItem(Item.Properties()) }
    val EXO: RegistryObject<Item> = ITEMS.register("exo") { ExoItem(Item.Properties()) }
    val TAURUS: RegistryObject<Item> = ITEMS.register("taurus") { TaurusItem(Item.Properties()) }
    val NEXUS: RegistryObject<Item> = ITEMS.register("nexus") { NexusItem(Item.Properties()) }
    val FRACTURE: RegistryObject<Item> = ITEMS.register("fracture") { FractureItem(Item.Properties()) }

    val OXYGEN_BUCKET: RegistryObject<Item> = ITEMS.register("oxygen_bucket") { FluidBucketItem(ModFluidProperties.OXYGEN, Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)) }
    val HYDROGEN_BUCKET: RegistryObject<Item> = ITEMS.register("hydrogen_bucket") { FluidBucketItem(ModFluidProperties.HYDROGEN, Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)) }
    val NITROGEN_BUCKET: RegistryObject<Item> = ITEMS.register("nitrogen_bucket") { FluidBucketItem(ModFluidProperties.NITROGEN, Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)) }
    val LIQUID_COMPOUND_BUCKET: RegistryObject<Item> = ITEMS.register("liquid_compound_bucket") { FluidBucketItem(ModFluidProperties.LIQUID_COMPOUND, Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)) }
    val POLYETHYLENE_BUCKET: RegistryObject<Item> = ITEMS.register("polyethylene_bucket") { FluidBucketItem(ModFluidProperties.POLYETHYLENE, Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)) }
    val VOLATILE_SOLUTION_BUCKET: RegistryObject<Item> = ITEMS.register("volatile_solution_bucket") { FluidBucketItem(ModFluidProperties.VOLATILE_SOLUTION, Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)) }
    val DESTABILIZED_SILICON_BUCKET: RegistryObject<Item> = ITEMS.register("destabilized_silicon_bucket") { FluidBucketItem(ModFluidProperties.DESTABILIZED_SILICON, Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)) }
    val PHOTORESIST_BUCKET: RegistryObject<Item> = ITEMS.register("photoresist_bucket") { FluidBucketItem(ModFluidProperties.PHOTORESIST, Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)) }
    val HYPERMESH_BUCKET: RegistryObject<Item> = ITEMS.register("hypermesh_bucket") { FluidBucketItem(ModFluidProperties.HYPERMESH, Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)) }

    val SYNTHETICALLY_REINFORCED_ELYTRA: RegistryObject<Item> = ITEMS.register("synthetically_reinforced_elytra") { ElytraItem(Item.Properties().durability(1248)) }

    val SCHEMATIC_HELMET: RegistryObject<Item> = ITEMS.register("helmet_crafting_schematic") { Item(Item.Properties()) }
    val SCHEMATIC_CHESTPLATE: RegistryObject<Item> = ITEMS.register("chestplate_crafting_schematic") { Item(Item.Properties()) }
    val SCHEMATIC_LEGGINGS: RegistryObject<Item> = ITEMS.register("leggings_crafting_schematic") { Item(Item.Properties()) }
    val SCHEMATIC_BOOTS: RegistryObject<Item> = ITEMS.register("boots_crafting_schematic") { Item(Item.Properties()) }

    val OVERCHARGE_CORE: RegistryObject<Item> = ITEMS.register("overcharge_core") { Item(Item.Properties()) }
    val OVERCHARGE_HELMET: RegistryObject<Item> = ITEMS.register("overcharge_helmet") { UnbreakableArmorItem(ModArmorMaterials.OVERCHARGE, ArmorItem.Type.HELMET, Item.Properties()) }
    val OVERCHARGE_CHESTPLATE: RegistryObject<Item> = ITEMS.register("overcharge_chestplate") { OverchargeSuitItem(5_000_000, Item.Properties()) }
    val OVERCHARGE_LEGGINGS: RegistryObject<Item> = ITEMS.register("overcharge_leggings") { UnbreakableArmorItem(ModArmorMaterials.OVERCHARGE, ArmorItem.Type.LEGGINGS, Item.Properties()) }
    val OVERCHARGE_BOOTS: RegistryObject<Item> = ITEMS.register("overcharge_boots") { UnbreakableArmorItem(ModArmorMaterials.OVERCHARGE, ArmorItem.Type.BOOTS, Item.Properties()) }

    val TOOL_COMPONENT: RegistryObject<Item> = ITEMS.register("tool_component") { Item(Item.Properties()) }
    val OVERCHARGE_BLADE: RegistryObject<Item> = ITEMS.register("overcharge_blade") { OverchargeBladeItem(2_000_000, Item.Properties()) }
    val OVERCHARGE_HAMMER: RegistryObject<Item> = ITEMS.register("overcharge_hammer") { OverchargeHammerItem(2_000_000, Item.Properties()) }
}
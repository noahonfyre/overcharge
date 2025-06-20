package com.nyronium.overcharge.infrastructure.datagen

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.content.item.ModArmorMaterials
import com.nyronium.overcharge.registry.ModBlocks
import com.nyronium.overcharge.registry.ModItems
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.*
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.AbstractCookingRecipe
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.item.crafting.RecipeSerializer
import net.minecraft.world.level.ItemLike
import net.minecraftforge.common.crafting.conditions.IConditionBuilder
import java.util.function.Consumer

class ModRecipeProvider(pOutput: PackOutput) : RecipeProvider(pOutput), IConditionBuilder {
    val ALUMINUM_SMELTABLES = mutableListOf<ItemLike>(ModItems.RAW_ALUMINUM.get(), ModBlocks.ALUMINUM_ORE.get(), ModBlocks.DEEPSLATE_ALUMINUM_ORE.get())
    val LITHIUM_SMELTABLES = mutableListOf<ItemLike>(ModItems.RAW_LITHIUM.get(), ModBlocks.LITHIUM_ORE.get(), ModBlocks.DEEPSLATE_LITHIUM_ORE.get())
    val TITANIUM_SMELTABLES = mutableListOf<ItemLike>(ModItems.RAW_TITANIUM.get(), ModBlocks.TITANIUM_ORE.get(), ModBlocks.DEEPSLATE_TITANIUM_ORE.get())
    val URANIUM_SMELTABLES = mutableListOf<ItemLike>(ModItems.RAW_URANIUM.get(), ModBlocks.URANIUM_ORE.get(), ModBlocks.DEEPSLATE_URANIUM_ORE.get())

    override fun buildRecipes(pWriter: Consumer<FinishedRecipe>) {
        oreSmeltingRecipe(pWriter, ALUMINUM_SMELTABLES, RecipeCategory.MISC, ModItems.ALUMINUM_INGOT.get(), 0.25f, 200, "aluminum")
        oreBlastingRecipe(pWriter, ALUMINUM_SMELTABLES, RecipeCategory.MISC, ModItems.ALUMINUM_INGOT.get(), 0.25f, 100, "aluminum")

        oreSmeltingRecipe(pWriter, LITHIUM_SMELTABLES, RecipeCategory.MISC, ModItems.LITHIUM_INGOT.get(), 0.25f, 200, "lithium")
        oreBlastingRecipe(pWriter, LITHIUM_SMELTABLES, RecipeCategory.MISC, ModItems.LITHIUM_INGOT.get(), 0.25f, 100, "lithium")

        oreSmeltingRecipe(pWriter, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), 0.25f, 200, "titanium")
        oreBlastingRecipe(pWriter, TITANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.TITANIUM_INGOT.get(), 0.25f, 100, "titanium")

        oreSmeltingRecipe(pWriter, URANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.URANIUM_INGOT.get(), 0.25f, 200, "uranium")
        oreBlastingRecipe(pWriter, URANIUM_SMELTABLES, RecipeCategory.MISC, ModItems.URANIUM_INGOT.get(), 0.25f, 100, "uranium")

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.MODULAR_FRAME.get())
            .pattern("PRP")
            .pattern("R R")
            .pattern("PRP")
            .define('P') { ModItems.ALUMINUM_PLATE.get() }
            .define('R') { ModItems.ALUMINUM_ROD.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FAN.get())
            .pattern(" P ")
            .pattern("PRP")
            .pattern(" P ")
            .define('P') { ModItems.ALUMINUM_PLATE.get() }
            .define('R') { ModItems.ALUMINUM_ROD.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STURDY_MODULAR_FRAME.get())
            .pattern("PRP")
            .pattern("R R")
            .pattern("PRP")
            .define('P') { ModItems.STEEL_PLATE.get() }
            .define('R') { ModItems.STEEL_ROD.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TURBINE.get())
            .pattern("PPP")
            .pattern("PRP")
            .pattern("PPP")
            .define('P') { ModItems.STEEL_PLATE.get() }
            .define('R') { ModItems.STEEL_ROD.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ACCUMULATOR.get())
            .pattern("SPS")
            .pattern("YCY")
            .pattern("SSS")
            .define('S') { ModItems.STEEL_PLATE.get() }
            .define('P') { ModItems.COPPER_PLATE.get() }
            .define('Y') { ModItems.SYNTHETIC.get() }
            .define('C') { ModItems.SECONDARY_CELL.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FLUID_TANK.get())
            .pattern("PRP")
            .pattern("YFY")
            .pattern("PPP")
            .define('P') { ModItems.STEEL_PLATE.get() }
            .define('R') { ModItems.STEEL_ROD.get() }
            .define('Y') { ModItems.SYNTHETIC.get() }
            .define('F') { ModItems.STURDY_MODULAR_FRAME.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHEMICAL_CORE.get())
            .pattern("PCP")
            .pattern("PFP")
            .pattern("PCP")
            .define('C') { ModItems.CHEMICAL_COMPOUND.get() }
            .define('P') { ModItems.STEEL_PLATE.get() }
            .define('F') { ModItems.STURDY_MODULAR_FRAME.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.KYBERNETIC_CORE.get())
            .pattern("PUP")
            .pattern("PFP")
            .pattern("PUP")
            .define('U') { ModItems.UNSTABLE_DIAMOND.get() }
            .define('P') { ModItems.STEEL_PLATE.get() }
            .define('F') { ModItems.STURDY_MODULAR_FRAME.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TRANSISTOR.get())
            .pattern("   ")
            .pattern("CCC")
            .pattern("RPR")
            .define('C') { ModItems.CHEMICAL_COMPOUND.get() }
            .define('R') { ModItems.COPPER_ROD.get() }
            .define('P') { ModItems.COPPER_PLATE.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ELECTROLYTIC_CELL.get())
            .pattern("PSP")
            .pattern("PCP")
            .pattern("PSP")
            .define('P') { ModItems.ALUMINUM_PLATE.get() }
            .define('S') { ModItems.STEEL_PLATE.get() }
            .define('C') { ModItems.CHEMICAL_CORE.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GALVANIC_CELL.get())
            .pattern("PSP")
            .pattern("PCP")
            .pattern("PSP")
            .define('P') { ModItems.COPPER_PLATE.get() }
            .define('S') { ModItems.STEEL_PLATE.get() }
            .define('C') { ModItems.CHEMICAL_CORE.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SECONDARY_CELL.get())
            .pattern("PSP")
            .pattern("PCP")
            .pattern("PSP")
            .define('P') { ModItems.LITHIUM_PLATE.get() }
            .define('S') { ModItems.STEEL_PLATE.get() }
            .define('C') { ModItems.CHEMICAL_CORE.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FUEL_CELL.get())
            .pattern("PSP")
            .pattern("PCP")
            .pattern("PSP")
            .define('P') { ModItems.TITANIUM_PLATE.get() }
            .define('S') { ModItems.STEEL_PLATE.get() }
            .define('C') { ModItems.CHEMICAL_CORE.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.HEATER.get())
            .pattern("CCC")
            .pattern("BBB")
            .pattern("CCC")
            .define('C') { ModItems.COPPER_ROD.get() }
            .define('B') { Items.BLAZE_POWDER }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SILICON.get())
            .pattern("XXX")
            .pattern("XXX")
            .pattern("XXX")
            .define('X') { ModItems.SILICON_SHARD.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.ARM_COMPONENT.get())
            .pattern("SRS")
            .pattern("F R")
            .pattern("P S")
            .define('P') { ModItems.HIGH_VOLTAGE_PROCESSOR.get() }
            .define('R') { ModItems.STEEL_ROD.get() }
            .define('F') { ModItems.STURDY_MODULAR_FRAME.get() }
            .define('S') { ModItems.SYNTHETIC.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SOLID_STATE_DRIVE.get())
            .pattern("AFA")
            .pattern("PFA")
            .pattern("AFA")
            .define('F') { ModItems.FLASH_CHIP.get() }
            .define('P') { ModItems.LOW_VOLTAGE_PROCESSOR.get() }
            .define('A') { ModItems.ALUMINUM_PLATE.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OVERCHARGE_CORE.get())
            .pattern("BFB")
            .pattern("BOB")
            .pattern("BFB")
            .define('B') { ModItems.BASALT_FIBER.get() }
            .define('F') { ModItems.STURDY_MODULAR_FRAME.get() }
            .define('O') { ModItems.OVERCHARGE.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TRAY.get())
            .pattern("   ")
            .pattern("A A")
            .pattern("AAA")
            .define('A') { ModItems.ALUMINUM_PLATE.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE.get())
            .pattern("BFB")
            .pattern("BTB")
            .pattern("BBB")
            .define('B') { ModItems.BASALT_FIBER.get() }
            .define('T') { ModItems.TITANIUM_INGOT.get() }
            .define('F') { ModItems.STURDY_MODULAR_FRAME.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.NEXUS.get())
            .pattern("YYY")
            .pattern("FCF")
            .pattern("RPR")
            .define('Y') { ModItems.SYNTHETIC.get() }
            .define('F') { ModItems.BASALT_FIBER.get() }
            .define('C') { ModItems.KYBERNETIC_CORE.get() }
            .define('R') { ModItems.TITANIUM_ROD.get() }
            .define('P') { ModItems.TITANIUM_PLATE.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FRACTURE.get())
            .pattern("FPF")
            .pattern("LCL")
            .pattern("FTF")
            .define('F') { ModItems.BASALT_FIBER.get() }
            .define('L') { ModItems.FLUID_TANK.get() }
            .define('C') { ModItems.KYBERNETIC_CORE.get() }
            .define('P') { ModItems.MICROPROCESSOR.get() }
            .define('T') { ModItems.TURBINE.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.FADED_DIAMOND.get())
            .pattern("ERE")
            .pattern("RUR")
            .pattern("ERE")
            .define('E') { Items.ECHO_SHARD }
            .define('R') { ModItems.REFINED_RADIANCE.get() }
            .define('U') { ModItems.UNSTABLE_DIAMOND.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SYNTHETICALLY_REINFORCED_ELYTRA.get())
            .pattern("YBY")
            .pattern("CXC")
            .pattern("YBY")
            .define('X') { Items.ELYTRA }
            .define('Y') { ModItems.SYNTHETIC.get() }
            .define('B') { ModItems.BASALT_FIBER.get() }
            .define('C') { ModItems.CHEMICAL_CORE.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OVERCHARGE_BLADE.get())
            .pattern(" P ")
            .pattern("BCB")
            .pattern(" X ")
            .define('P') { ModItems.TITANIUM_PLATE.get() }
            .define('X') { ModItems.TOOL_COMPONENT.get() }
            .define('B') { ModItems.BASALT_FIBER.get() }
            .define('C') { ModItems.CHEMICAL_CORE.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.OVERCHARGE_HAMMER.get())
            .pattern("PPP")
            .pattern("PCP")
            .pattern(" X ")
            .define('P') { ModItems.TITANIUM_PLATE.get() }
            .define('X') { ModItems.TOOL_COMPONENT.get() }
            .define('C') { ModItems.CHEMICAL_CORE.get() }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ORGANIC_COMPOUND.get(), 4)
            .requires(Items.KELP)
            .requires(Items.KELP)
            .requires(Items.SUGAR_CANE)
            .requires(Items.SUGAR_CANE)
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.REFINED_RADIANCE.get(), 1)
            .requires(Items.QUARTZ)
            .requires(ModItems.RADIANCE_DUST.get())
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SILICON_DIE.get(), 6)
            .requires(ModItems.SILICON_WAFER.get())
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.UNSTABLE_DIE.get(), 6)
            .requires(ModItems.UNSTABLE_WAFER.get())
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        materialSet(pWriter, ModItems.ALUMINUM_INGOT.get(), ModItems.ALUMINUM_NUGGET.get(), ModItems.ALUMINUM_PLATE.get(), ModItems.ALUMINUM_ROD.get())
        materialSet(pWriter, Items.COPPER_INGOT, ModItems.COPPER_NUGGET.get(), ModItems.COPPER_PLATE.get(), ModItems.COPPER_ROD.get())
        materialSet(pWriter, ModItems.LITHIUM_INGOT.get(), ModItems.LITHIUM_NUGGET.get(), ModItems.LITHIUM_PLATE.get(), ModItems.LITHIUM_ROD.get())
        materialSet(pWriter, ModItems.STEEL_INGOT.get(), ModItems.STEEL_NUGGET.get(), ModItems.STEEL_PLATE.get(), ModItems.STEEL_ROD.get())
        materialSet(pWriter, ModItems.TITANIUM_INGOT.get(), ModItems.TITANIUM_NUGGET.get(), ModItems.TITANIUM_PLATE.get(), ModItems.TITANIUM_ROD.get())
        materialSet(pWriter, ModItems.URANIUM_INGOT.get(), ModItems.URANIUM_NUGGET.get(), ModItems.URANIUM_PLATE.get(), ModItems.URANIUM_ROD.get())

        toolSet(
            pWriter,
            ModItems.STEEL_INGOT.get(),
            ModItems.STEEL_ROD.get(),
            ModItems.STEEL_SWORD.get(),
            ModItems.STEEL_AXE.get(),
            ModItems.STEEL_PICKAXE.get(),
            ModItems.STEEL_SHOVEL.get(),
            ModItems.STEEL_HOE.get(),
            ModItems.STEEL_HAMMER.get(),
            ModItems.STEEL_WRENCH.get()
        )

        armorSet(
            pWriter,
            ModArmorMaterials.STEEL,
            ModItems.STEEL_HELMET.get(),
            ModItems.STEEL_CHESTPLATE.get(),
            ModItems.STEEL_LEGGINGS.get(),
            ModItems.STEEL_BOOTS.get()
        )

        upgradableToolSet(
            pWriter,
            ModItems.TITANIUM_INGOT.get(),
            ModItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE.get(),
            ModItems.STEEL_SWORD.get(),
            ModItems.STEEL_AXE.get(),
            ModItems.STEEL_PICKAXE.get(),
            ModItems.STEEL_SHOVEL.get(),
            ModItems.STEEL_HOE.get(),
            ModItems.STEEL_HAMMER.get(),
            ModItems.STEEL_WRENCH.get(),
            ModItems.TITANIUM_SWORD.get(),
            ModItems.TITANIUM_AXE.get(),
            ModItems.TITANIUM_PICKAXE.get(),
            ModItems.TITANIUM_SHOVEL.get(),
            ModItems.TITANIUM_HOE.get(),
            ModItems.TITANIUM_HAMMER.get(),
            ModItems.TITANIUM_WRENCH.get()
        )

        upgradableArmorSet(
            pWriter,
            ModArmorMaterials.TITANIUM,
            ModItems.TITANIUM_UPGRADE_SMITHING_TEMPLATE.get(),
            ModItems.STEEL_HELMET.get(),
            ModItems.STEEL_CHESTPLATE.get(),
            ModItems.STEEL_LEGGINGS.get(),
            ModItems.STEEL_BOOTS.get(),
            ModItems.TITANIUM_HELMET.get(),
            ModItems.TITANIUM_CHESTPLATE.get(),
            ModItems.TITANIUM_LEGGINGS.get(),
            ModItems.TITANIUM_BOOTS.get(),
        )

        smithingRecipe(pWriter, ModItems.SCHEMATIC_HELMET.get(), ModItems.TITANIUM_HELMET.get(), ModItems.SYNTHETIC.get(), ModItems.OVERCHARGE_HELMET.get())
        smithingRecipe(pWriter, ModItems.SCHEMATIC_CHESTPLATE.get(), ModItems.TITANIUM_CHESTPLATE.get(), ModItems.SYNTHETIC.get(), ModItems.OVERCHARGE_CHESTPLATE.get())
        smithingRecipe(pWriter, ModItems.SCHEMATIC_LEGGINGS.get(), ModItems.TITANIUM_LEGGINGS.get(), ModItems.SYNTHETIC.get(), ModItems.OVERCHARGE_LEGGINGS.get())
        smithingRecipe(pWriter, ModItems.SCHEMATIC_BOOTS.get(), ModItems.TITANIUM_BOOTS.get(), ModItems.SYNTHETIC.get(), ModItems.OVERCHARGE_BOOTS.get())
    }

    fun armorSet(pWriter: Consumer<FinishedRecipe>, material: ArmorMaterial, helmet: Item, chestplate: Item, leggings: Item, boots: Item) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, helmet)
            .pattern("XXX")
            .pattern("X X")
            .pattern("   ")
            .define('X') { material.repairIngredient.items[0].item }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, chestplate)
            .pattern("X X")
            .pattern("XXX")
            .pattern("XXX")
            .define('X') { material.repairIngredient.items[0].item }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, leggings)
            .pattern("XXX")
            .pattern("X X")
            .pattern("X X")
            .define('X') { material.repairIngredient.items[0].item }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, boots)
            .pattern("   ")
            .pattern("X X")
            .pattern("X X")
            .define('X') { material.repairIngredient.items[0].item }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)
    }

    fun upgradableArmorSet(pWriter: Consumer<FinishedRecipe>, material: ArmorMaterial, template: Item, pHelmet: Item, pChestplate: Item, pLeggings: Item, pBoots: Item, sHelmet: Item, sChestplate: Item, sLeggings: Item, sBoots: Item) {
        smithingRecipe(pWriter, template, pHelmet, material.repairIngredient.items.first().item, sHelmet)
        smithingRecipe(pWriter, template, pChestplate, material.repairIngredient.items.first().item, sChestplate)
        smithingRecipe(pWriter, template, pLeggings, material.repairIngredient.items.first().item, sLeggings)
        smithingRecipe(pWriter, template, pBoots, material.repairIngredient.items.first().item, sBoots)
    }

    fun materialSet(pWriter: Consumer<FinishedRecipe>, ingot: Item, nugget: Item, plate: Item, rod: Item) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ingot)
            .pattern("XXX")
            .pattern("XXX")
            .pattern("XXX")
            .define('X') { nugget }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, nugget, 9)
            .requires { ingot }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, plate, 2)
            .pattern("XX ")
            .pattern("   ")
            .pattern("   ")
            .define('X') { ingot }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, rod, 2)
            .pattern("X  ")
            .pattern("X  ")
            .pattern("   ")
            .define('X') { plate }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)
    }

    fun toolSet(pWriter: Consumer<FinishedRecipe>, ingot: Item, rod: Item, sword: Item, axe: Item, pickaxe: Item, shovel: Item, hoe: Item, hammer: Item, wrench: Item) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, sword)
            .pattern(" I ")
            .pattern(" I ")
            .pattern(" R ")
            .define('I') { ingot }
            .define('R') { rod }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, axe)
            .pattern("II ")
            .pattern("IR ")
            .pattern(" R ")
            .define('I') { ingot }
            .define('R') { rod }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, pickaxe)
            .pattern("III")
            .pattern(" R ")
            .pattern(" R ")
            .define('I') { ingot }
            .define('R') { rod }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, shovel)
            .pattern(" I ")
            .pattern(" R ")
            .pattern(" R ")
            .define('I') { ingot }
            .define('R') { rod }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, hoe)
            .pattern("II ")
            .pattern(" R ")
            .pattern(" R ")
            .define('I') { ingot }
            .define('R') { rod }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, hammer)
            .pattern("III")
            .pattern("IRI")
            .pattern(" R ")
            .define('I') { ingot }
            .define('R') { rod }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, wrench)
            .pattern("I I")
            .pattern("IRI")
            .pattern(" R ")
            .define('I') { ingot }
            .define('R') { rod }
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)
    }

    fun upgradableToolSet(pWriter: Consumer<FinishedRecipe>, upgrade: Item, template: Item, pSword: Item, pAxe: Item, pPickaxe: Item, pShovel: Item, pHoe: Item, pHammer: Item, pWrench: Item, sSword: Item, sAxe: Item, sPickaxe: Item, sShovel: Item, sHoe: Item, sHammer: Item, sWrench: Item) {
        smithingRecipe(pWriter, template, pSword, upgrade, sSword)
        smithingRecipe(pWriter, template, pAxe, upgrade, sAxe)
        smithingRecipe(pWriter, template, pPickaxe, upgrade, sPickaxe)
        smithingRecipe(pWriter, template, pShovel, upgrade, sShovel)
        smithingRecipe(pWriter, template, pHoe, upgrade, sHoe)
        smithingRecipe(pWriter, template, pHammer, upgrade, sHammer)
        smithingRecipe(pWriter, template, pWrench, upgrade, sWrench)
    }

    protected fun smithingRecipe(pWriter: Consumer<FinishedRecipe>, template: Item, base: Item, addition: Item, result: Item) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(template), Ingredient.of(base), Ingredient.of(addition), RecipeCategory.MISC, result)
            .unlocks(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter, ResourceLocation.fromNamespaceAndPath(Overcharge.ID, "smithing/" + getItemName(result)))
    }

    protected fun oreSmeltingRecipe(pFinishedRecipeConsumer: Consumer<FinishedRecipe>, pIngredients: MutableList<ItemLike>, pCategory: RecipeCategory, pResult: ItemLike, pExperience: Float, pCookingTIme: Int, pGroup: String) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting")
    }

    protected fun oreBlastingRecipe(pFinishedRecipeConsumer: Consumer<FinishedRecipe>, pIngredients: MutableList<ItemLike>, pCategory: RecipeCategory, pResult: ItemLike, pExperience: Float, pCookingTime: Int, pGroup: String) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting")
    }

    protected fun oreCookingRecipe(pFinishedRecipeConsumer: Consumer<FinishedRecipe>, pCookingSerializer: RecipeSerializer<out AbstractCookingRecipe>, pIngredients: MutableList<ItemLike>, pCategory: RecipeCategory, pResult: ItemLike, pExperience: Float, pCookingTime: Int, pGroup: String, pRecipeName: String) {
        for (itemLike in pIngredients) {
            SimpleCookingRecipeBuilder.generic(
                Ingredient.of(*arrayOf(itemLike)),
                pCategory,
                pResult,
                pExperience,
                pCookingTime,
                pCookingSerializer
            ).group(pGroup).unlockedBy(
                getHasName(itemLike), has(itemLike)
            ).save(pFinishedRecipeConsumer, Overcharge.ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemLike))
        }
    }
}
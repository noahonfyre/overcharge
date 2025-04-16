package com.nyronium.overcharge.infrastructure.datagen

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.registry.ModBlocks
import com.nyronium.overcharge.registry.ModItems
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.FinishedRecipe
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.data.recipes.ShapelessRecipeBuilder
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder
import net.minecraft.tags.ItemTags
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.AbstractCookingRecipe
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.item.crafting.RecipeSerializer
import net.minecraft.world.level.ItemLike
import net.minecraftforge.common.crafting.conditions.IConditionBuilder
import java.util.function.Consumer

open class ModRecipeProvider(pOutput: PackOutput) : RecipeProvider(pOutput), IConditionBuilder {
    val ALUMINUM_SMELTABLES = mutableListOf<ItemLike>(ModItems.RAW_ALUMINUM.get(), ModBlocks.ALUMINUM_ORE.get(), ModBlocks.DEEPSLATE_ALUMINUM_ORE.get())
    val LITHIUM_SMELTABLES = mutableListOf<ItemLike>(ModItems.RAW_LITHIUM.get(), ModBlocks.LITHIUM_ORE.get(), ModBlocks.DEEPSLATE_LITHIUM_ORE.get())
    val TITANIUM_SMELTABLES = mutableListOf<ItemLike>(ModItems.RAW_TITANIUM.get(), ModBlocks.TITANIUM_ORE.get(), ModBlocks.DEEPSLATE_TITANIUM_ORE.get())
    val URANIUM_SMELTABLES = mutableListOf<ItemLike>(ModItems.RAW_URANIUM.get(), ModBlocks.URANIUM_ORE.get(), ModBlocks.DEEPSLATE_URANIUM_ORE.get())

    override fun buildRecipes(pWriter: Consumer<FinishedRecipe>) {
        oreSmeltingRecipe(pWriter, ALUMINUM_SMELTABLES, RecipeCategory.MISC, ModItems.ALUMINUM_INGOT.get(), 0.25f, 200, "aluminum")
        oreBlastingRecipe(pWriter, ALUMINUM_SMELTABLES, RecipeCategory.MISC, ModItems.ALUMINUM_INGOT.get(), 0.25f, 100, "aluminum")

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
            .pattern("SRS")
            .pattern("YCY")
            .pattern("SSS")
            .define('S') { ModItems.STEEL_PLATE.get() }
            .define('R') { ModItems.STEEL_ROD.get() }
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
            .pattern("RCR")
            .pattern("PFP")
            .pattern("RCR")
            .define('R') { ModItems.STEEL_ROD.get() }
            .define('C') { ModItems.CHEMICAL_COMPOUND.get() }
            .define('P') { ModItems.STEEL_PLATE.get() }
            .define('F') { ModItems.STURDY_MODULAR_FRAME.get() }
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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ORGANIC_COMPOUND.get(), 4)
            .requires { Items.KELP }
            .requires(ItemTags.LEAVES)
            .requires { Items.KELP }
            .requires(ItemTags.LEAVES)
            .unlockedBy(getHasName(Items.AIR), has(Items.AIR))
            .save(pWriter)

        materialSet(pWriter, ModItems.ALUMINUM_INGOT.get(), ModItems.ALUMINUM_NUGGET.get(), ModItems.ALUMINUM_PLATE.get(), ModItems.ALUMINUM_ROD.get())
        materialSet(pWriter, Items.COPPER_INGOT, ModItems.COPPER_NUGGET.get(), ModItems.COPPER_PLATE.get(), ModItems.COPPER_ROD.get())
        materialSet(pWriter, Items.IRON_INGOT, Items.IRON_NUGGET, ModItems.IRON_PLATE.get(), ModItems.IRON_ROD.get())
        materialSet(pWriter, Items.GOLD_INGOT, Items.GOLD_NUGGET, ModItems.GOLD_PLATE.get(), ModItems.GOLD_ROD.get())
        materialSet(pWriter, ModItems.LITHIUM_INGOT.get(), ModItems.LITHIUM_NUGGET.get(), ModItems.LITHIUM_PLATE.get(), ModItems.LITHIUM_ROD.get())
        materialSet(pWriter, ModItems.STEEL_INGOT.get(), ModItems.STEEL_NUGGET.get(), ModItems.STEEL_PLATE.get(), ModItems.STEEL_ROD.get())
        materialSet(pWriter, ModItems.TITANIUM_INGOT.get(), ModItems.TITANIUM_NUGGET.get(), ModItems.TITANIUM_PLATE.get(), ModItems.TITANIUM_ROD.get())
        materialSet(pWriter, ModItems.URANIUM_INGOT.get(), ModItems.URANIUM_NUGGET.get(), ModItems.URANIUM_PLATE.get(), ModItems.URANIUM_ROD.get())
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

    protected fun oreSmeltingRecipe(pFinishedRecipeConsumer: Consumer<FinishedRecipe>, pIngredients: MutableList<ItemLike>, pCategory: RecipeCategory, pResult: ItemLike, pExperience: Float, pCookingTIme: Int, pGroup: String) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting")
    }

    protected fun oreBlastingRecipe(pFinishedRecipeConsumer: Consumer<FinishedRecipe>, pIngredients: MutableList<ItemLike>, pCategory: RecipeCategory, pResult: ItemLike, pExperience: Float, pCookingTime: Int, pGroup: String) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting")
    }

    protected fun oreCookingRecipe(pFinishedRecipeConsumer: Consumer<FinishedRecipe>, pCookingSerializer: RecipeSerializer<out AbstractCookingRecipe>, pIngredients: MutableList<ItemLike>, pCategory: RecipeCategory, pResult: ItemLike, pExperience: Float, pCookingTime: Int, pGroup: String, pRecipeName: String) {
        for (itemLike in pIngredients) {
            SimpleCookingRecipeBuilder.generic(
                Ingredient.of(*arrayOf<ItemLike>(itemLike)),
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
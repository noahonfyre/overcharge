package com.nyronium.overcharge.infrastructure.datagen

import com.nyronium.overcharge.Overcharge
import com.nyronium.overcharge.content.item.base.HammerItem
import com.nyronium.overcharge.content.item.base.WrenchItem
import com.nyronium.overcharge.registry.ModItems
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.packs.PackType
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.AxeItem
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.DiggerItem
import net.minecraft.world.item.HoeItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.PickaxeItem
import net.minecraft.world.item.ShovelItem
import net.minecraft.world.item.SwordItem
import net.minecraft.world.item.TieredItem
import net.minecraft.world.item.armortrim.TrimMaterial
import net.minecraft.world.item.armortrim.TrimMaterials
import net.minecraftforge.client.model.generators.ItemModelBuilder
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile
import net.minecraftforge.common.data.ExistingFileHelper
import net.minecraftforge.registries.RegistryObject

class ModItemModelProvider(output: PackOutput, existingFileHelper: ExistingFileHelper) :
    net.minecraftforge.client.model.generators.ItemModelProvider(output, Overcharge.ID, existingFileHelper) {

    override fun registerModels() {
        for(item in ModItems.ITEMS.entries) {
            if (isHandheldItem(item.get())) {
                handheldItem(item)
            } else if(item.get() !is BlockItem) {
                simpleItem(item)
            }
        }
    }

    private fun isHandheldItem(item: Item): Boolean {
        return item is SwordItem || item is AxeItem || item is PickaxeItem || item is HoeItem || item is ShovelItem || item is WrenchItem || item is HammerItem || item is DiggerItem || item is TieredItem
    }

    private fun simpleItem(item: RegistryObject<Item>): ItemModelBuilder {
        return withExistingParent(
            item.id.path,
            ResourceLocation.parse("item/generated")
        ).texture(
            "layer0",
            ResourceLocation.tryBuild(Overcharge.ID, "item/" + item.id.path)
        )
    }

    private fun handheldItem(item: RegistryObject<Item>): ItemModelBuilder {
        return withExistingParent(
            item.id.path,
            ResourceLocation.parse("item/handheld")
        ).texture(
            "layer0",
            ResourceLocation.tryBuild(Overcharge.ID, "item/" + item.id.path)
        )
    }

    private fun handheldCustomItem(name: String): ItemModelBuilder {
        return withExistingParent(
            name,
            ResourceLocation.parse("item/handheld")
        ).texture(
            "layer0",
            ResourceLocation.tryBuild(Overcharge.ID, "item/$name")
        )
    }

    private fun trimmedArmorItem(itemRegistryObject: RegistryObject<Item>) {
        if (itemRegistryObject.get() is ArmorItem) {
            val armorItem = itemRegistryObject.get()
            trimMaterials.forEach { (trimMaterial: ResourceKey<TrimMaterial>, value: Float) ->
                val armorType = when (armorItem.getEquipmentSlot(null)) {
                    EquipmentSlot.HEAD -> "helmet"
                    EquipmentSlot.CHEST -> "chestplate"
                    EquipmentSlot.LEGS -> "leggings"
                    EquipmentSlot.FEET -> "boots"
                    else -> ""
                }

                val armorItemPath = "item/$armorItem"
                val trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().path
                val currentTrimName = armorItemPath + "_" + trimMaterial.location().path + "_trim"
                val armorItemResLoc = ResourceLocation.tryBuild(Overcharge.ID, armorItemPath)
                val trimResLoc = ResourceLocation.parse(trimPath)
                val trimNameResLoc = ResourceLocation.tryBuild(Overcharge.ID, currentTrimName)

                existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures")

                getBuilder(currentTrimName)
                    .parent(UncheckedModelFile("item/generated"))
                    .texture("layer0", armorItemResLoc)
                    .texture("layer1", trimResLoc)
                withExistingParent(
                    itemRegistryObject.id.path,
                    mcLoc("item/generated")
                )
                    .override()
                    .model(UncheckedModelFile(trimNameResLoc))
                    .predicate(mcLoc("trim_type"), value).end()
                    .texture(
                        "layer0",
                        ResourceLocation.tryBuild(
                            Overcharge.ID,
                            "item/" + itemRegistryObject.id.path
                        )
                    )
            }
        }
    }


    companion object {
        private val trimMaterials = LinkedHashMap<ResourceKey<TrimMaterial>, Float>()

        init {
            trimMaterials[TrimMaterials.QUARTZ] = 0.1f
            trimMaterials[TrimMaterials.IRON] = 0.2f
            trimMaterials[TrimMaterials.NETHERITE] = 0.3f
            trimMaterials[TrimMaterials.REDSTONE] = 0.4f
            trimMaterials[TrimMaterials.COPPER] = 0.5f
            trimMaterials[TrimMaterials.GOLD] = 0.6f
            trimMaterials[TrimMaterials.EMERALD] = 0.7f
            trimMaterials[TrimMaterials.DIAMOND] = 0.8f
            trimMaterials[TrimMaterials.LAPIS] = 0.9f
            trimMaterials[TrimMaterials.AMETHYST] = 1.0f
        }
    }
}
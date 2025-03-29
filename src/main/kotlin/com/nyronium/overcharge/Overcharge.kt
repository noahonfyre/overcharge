package com.nyronium.overcharge

import com.nyronium.overcharge.networking.NetworkHandler
import com.nyronium.overcharge.registry.ModBlocks
import com.nyronium.overcharge.registry.ModFluidProperties
import com.nyronium.overcharge.registry.ModFluids
import com.nyronium.overcharge.registry.ModItems
import com.nyronium.overcharge.registry.ModTabs
import com.nyronium.overcharge.registry.ModTags
import net.minecraft.client.Minecraft
import net.minecraft.client.renderer.ItemBlockRenderTypes
import net.minecraft.client.renderer.RenderType
import net.minecraft.world.item.Items
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import thedarkcolour.kotlinforforge.forge.runForDist
import java.util.UUID
import kotlin.text.get

@Mod(Overcharge.ID)
object Overcharge {
    const val ID = "overcharge"
    const val NAME = "Overcharge"
    val LOGGER: Logger = LogManager.getLogger(ID)

    val SPRINTING = mutableMapOf<UUID, Boolean>()
    val JUMPING = mutableMapOf<UUID, Boolean>()
    val FLIGHT_ENABLED = mutableMapOf<UUID, Boolean>()

    init {
        LOGGER.log(Level.INFO, "Hello world!")

        NetworkHandler.register()

        ModBlocks.BLOCKS.register(MOD_BUS)
        ModItems.ITEMS.register(MOD_BUS)
        ModTabs.TABS.register(MOD_BUS)
        ModFluidProperties.FLUID_PROPERTIES.register(MOD_BUS)
        ModFluids.FLUIDS.register(MOD_BUS)

        runForDist(
            clientTarget = {
                MOD_BUS.addListener(::onClientSetup)
                Minecraft.getInstance()
            },
            serverTarget = {
                MOD_BUS.addListener(::onServerSetup)
            }
        )
    }

    private fun onClientSetup(event: FMLClientSetupEvent) {
        LOGGER.log(Level.INFO, "Initializing client...")

        for (item in ModFluids.FLUIDS.entries) {
            ItemBlockRenderTypes.setRenderLayer(item.get(), RenderType.translucent())
        }
    }

    private fun onServerSetup(event: FMLDedicatedServerSetupEvent) {
        LOGGER.log(Level.INFO, "Server starting...")
    }
}
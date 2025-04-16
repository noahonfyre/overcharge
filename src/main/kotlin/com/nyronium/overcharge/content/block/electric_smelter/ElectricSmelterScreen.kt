package com.nyronium.overcharge.content.block.electric_smelter

import com.mojang.blaze3d.systems.RenderSystem
import com.nyronium.overcharge.Overcharge
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen
import net.minecraft.client.renderer.GameRenderer
import net.minecraft.network.chat.Component
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.player.Inventory

class ElectricSmelterScreen(pMenu: ElectricSmelterMenu, pPlayerInventory: Inventory, pTitle: Component) : AbstractContainerScreen<ElectricSmelterMenu>(pMenu, pPlayerInventory, pTitle) {
    private val TEXTURE = ResourceLocation.tryBuild(Overcharge.ID, "textures/gui/container/electric_smelter.png")!!

    override fun renderBg(pGuiGraphics: GuiGraphics, p1: Float, p2: Int, p3: Int) {
        RenderSystem.setShader { GameRenderer.getPositionTexShader() }
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F)
        RenderSystem.setShaderTexture(0, TEXTURE)
        val x = (width - imageWidth) / 2
        val y = (height - imageHeight) / 2

        pGuiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight)

        renderProgressArrow(pGuiGraphics, x, y)
    }

    private fun renderProgressArrow(guiGraphics: GuiGraphics, x: Int, y: Int) {
        if(menu.isCrafting) {
            guiGraphics.blit(TEXTURE, x + 85, y + 30, 176, 0, 8, menu.scaledProgress)
        }
    }

    override fun render(guiGraphics: GuiGraphics, mouseX: Int, mouseY: Int, delta: Float) {
        renderBackground(guiGraphics)
        super.render(guiGraphics, mouseX, mouseY, delta)
        renderTooltip(guiGraphics, mouseX, mouseY)
    }
}
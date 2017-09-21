package com.jlgm.redbrew.client.gui;

import com.jlgm.redbrew.inventory.ContainerAutomaticBrewer;
import com.jlgm.redbrew.lib.RedBrewConstants;
import com.jlgm.redbrew.tileentity.TileEntityAutomaticBrewer;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.items.IItemHandler;

public class GuiAutomaticBrewer extends GuiContainer{
	
	private static ResourceLocation texture;
	
	private final TileEntityAutomaticBrewer tile;
	
	private int textureWidth = 176;
	private int textureHeight = 222;
	
	public GuiAutomaticBrewer(TileEntityAutomaticBrewer automaticBrewer, ContainerAutomaticBrewer containerAutomaticBrewer){
		super(containerAutomaticBrewer);
		texture = new ResourceLocation(RedBrewConstants.MODID + ":" + "textures/gui/automaticbrewer.png");
		tile = automaticBrewer;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {

		mc.getTextureManager().bindTexture(texture);
		int basePointX = this.width/2 - textureWidth/2;
		int basePointY = this.height/2 - textureHeight/2;
		
		this.drawTexturedModalRect(basePointX, basePointY, 0, 0, textureWidth, textureHeight);
		
		this.fontRenderer.drawString(new TextComponentString(I18n.format(tile.getName())).getUnformattedText(), basePointX + 8, basePointY + 8, 0x404040);
	}
}

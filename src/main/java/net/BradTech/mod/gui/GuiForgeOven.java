package net.BradTech.mod.gui;

import org.lwjgl.opengl.GL11;

import net.BradTech.mod.BradTech;
import net.BradTech.mod.container.ContainerForgeOven;
import net.BradTech.mod.tileentity.TileEntityForgeOven;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiForgeOven extends GuiContainer {

	public static final ResourceLocation bkGround = new ResourceLocation(BradTech.modid + ":" + "textures/gui/GuiForgeOven.png");
	
	public TileEntityForgeOven forgeOven;
	
	public GuiForgeOven(InventoryPlayer inventoryPlayer, TileEntityForgeOven entity) {
		super(new ContainerForgeOven(inventoryPlayer, entity));

		this.forgeOven = entity;
		
		this.xSize = 176;
		this.ySize = 166;
		
		
	}
	
	
	public void drawGuiContainerForegroundLayer(int par1, int par2) {
		//this.forgeOven.hasCustomInventoryName() ? this.forgeOven.getInventoryName() : I18n.format(this.forgeOven.getInventoryName(), new Object[0]);
		String name = I18n.format("container.ForgeOven", new Object[0]); 
		
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
	}

	
	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(bkGround);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		if(this.forgeOven.isBurning()) {
			int k = this.forgeOven.getBurnTimeRemainingScaled(48);
			int j = 48 - k;
			
			drawTexturedModalRect(guiLeft + 76, guiTop + 54, 176, 0, 48 - j, 8); 
		}
		
		int p = this.forgeOven.getCookProgressScaled(24);
		drawTexturedModalRect(guiLeft + 72, guiTop + 21, 176, 9, p, 17);
	}
	
	

}

package net.BradTech.mod.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import net.BradTech.mod.BradTech;
import net.BradTech.mod.renderer.ItemRenderObsidianTable;
import net.BradTech.mod.renderer.RenderInsulatedCopperWire;
import net.BradTech.mod.renderer.RenderObsidianTable;
import net.BradTech.mod.tileentity.TileEntityInsulatedCopperWire;
import net.BradTech.mod.tileentity.TileEntityObsidianTable;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

public class ClientProxy extends CommonProxy {
	
	public void registerRenderThings() {
		// Obsidian Table
		TileEntitySpecialRenderer rendererObsidianTable = new RenderObsidianTable();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityObsidianTable.class, rendererObsidianTable);
		// Register the Obsidian table in the inventory.
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(BradTech.blockObsidianTable), new ItemRenderObsidianTable(rendererObsidianTable, new TileEntityObsidianTable()));
		
		// Insulated Copper Wire
		TileEntitySpecialRenderer rendererInsulatedCopperWire = new RenderInsulatedCopperWire();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityInsulatedCopperWire.class, rendererInsulatedCopperWire);
	}
	
	
	public void registerTileEntitySpecialRenderer() {
		
	}

}

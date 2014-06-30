package net.BradTech.mod.handler;

import net.BradTech.mod.BradTech;
import net.BradTech.mod.container.ContainerForgeOven;
import net.BradTech.mod.container.ContainerMachinistsTable;
import net.BradTech.mod.gui.GuiForgeOven;
import net.BradTech.mod.gui.GuiMachinistsTable;
import net.BradTech.mod.tileentity.TileEntityForgeOven;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null) {
			switch(ID) {
			case BradTech.guiIDForgeOven:
				if (entity instanceof TileEntityForgeOven) {
					return new ContainerForgeOven(player.inventory, (TileEntityForgeOven) entity);
				}
				
				return null;
			}
		}
		
		if(ID == BradTech.guiIDMachinistsTable) {
			return ID == BradTech.guiIDMachinistsTable && world.getBlock(x, y, z) == BradTech.blockMachinistsTable ? new ContainerMachinistsTable(player.inventory, world, x, y, z) : null;
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null) {
			switch(ID) {
			case BradTech.guiIDForgeOven:
				if (entity instanceof TileEntityForgeOven) {
					return new GuiForgeOven(player.inventory, (TileEntityForgeOven) entity);
				}
				
				return null;
			}
		}
		
		if(ID == BradTech.guiIDMachinistsTable) {
			return ID == BradTech.guiIDMachinistsTable && world.getBlock(x, y, z) == BradTech.blockMachinistsTable ? new GuiMachinistsTable(player.inventory, world, x, y, z) : null;
		}

		return null;
	}
	
}

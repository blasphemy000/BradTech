package net.BradTech.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.BradTech.mod.BradTech;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class MachinistsTable extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon machinistsTableTop;
	
	
	public MachinistsTable() {
		super(Material.wood);
		
		this.setHardness(3.5F);
		this.setResistance(5.0F);
		this.setCreativeTab(BradTech.bradTechTools);
	}
	
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return side == 1 ? this.machinistsTableTop : this.blockIcon;
	}
	
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(BradTech.modid + ":" + "MachinistsTable_Side");
		this.machinistsTableTop = iconRegister.registerIcon(BradTech.modid + ":" + "MachinistsTable_Top");
	}
	
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		if(!player.isSneaking()) {
			player.openGui(BradTech.instance, BradTech.guiIDMachinistsTable, world, x, y, z);
			return true;
		} else {
			return false;
		}
	}

}

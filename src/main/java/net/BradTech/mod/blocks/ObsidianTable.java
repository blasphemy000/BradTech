package net.BradTech.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.BradTech.mod.BradTech;
import net.BradTech.mod.tileentity.TileEntityObsidianTable;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ObsidianTable extends BlockContainer {

	public ObsidianTable(Material material) {
		super(material);

		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setBlockBounds(0F, 0F, 0F, 1F, 0.875F, 1F);
		this.setCreativeTab(BradTech.bradTechTools);
	}
	
	
	public int getRenderType() {
		return -1;
	}
	
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(BradTech.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	

	@Override
	public TileEntity createNewTileEntity(World world, int var2) {
		return new TileEntityObsidianTable();
	}
	
	
}

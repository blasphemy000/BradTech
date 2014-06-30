package net.BradTech.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.BradTech.mod.BradTech;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.World;

public class MetalBlock extends Block {

	public MetalBlock(Material material) {
		super(material);
		
		this.setHardness(5.0F);
		this.setResistance(8.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setStepSound(soundTypeMetal);
		this.setCreativeTab(BradTech.bradTechTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(BradTech.modid + ":" + this.getUnlocalizedName().substring(5));
	}

}

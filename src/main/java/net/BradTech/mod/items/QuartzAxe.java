package net.BradTech.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.BradTech.mod.BradTech;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemAxe;

public class QuartzAxe extends ItemAxe {

	public QuartzAxe(ToolMaterial toolMaterial) {
		super(toolMaterial);
		this.setCreativeTab(BradTech.bradTechTools);
	}
	
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(BradTech.modid + ":" + this.getUnlocalizedName().substring(5));
	}
}

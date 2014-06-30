package net.BradTech.mod.armor;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.BradTech.mod.BradTech;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class QuartzArmor extends ItemArmor {
	
	public QuartzArmor(ArmorMaterial material, int armorID, int slot) {
		super(material, armorID, slot);
		
		this.setCreativeTab(BradTech.bradTechTools);
	}
	
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(BradTech.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	
	
	public String getArmorTexture(ItemStack itemStack, Entity entity, int slot, String type) {
		if(itemStack.getItem() == BradTech.armorQuartzHelmet || itemStack.getItem() == BradTech.armorQuartzChestplate || itemStack.getItem() == BradTech.armorQuartzBoots)
			return BradTech.modid + ":textures/models/armor/quartz_layer_1.png";
		else if(itemStack.getItem() == BradTech.armorQuartzLeggings)
			return BradTech.modid + ":textures/models/armor/quartz_layer_2.png";
		else
			return null;
	}
	
}

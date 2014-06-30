package net.BradTech.mod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.BradTech.mod.BradTech;
import net.BradTech.mod.PlayerHelper;
import net.BradTech.mod.blocks.IWrenchable;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SonicScrewdriver extends Item {

	public SonicScrewdriver() {
		this.setCreativeTab(BradTech.bradTechTools);
	}
	
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) {
		this.itemIcon = iconRegister.registerIcon(BradTech.modid + ":" + this.getUnlocalizedName().substring(5));	
	}
	
	
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer entityPlayer)
    {
    	//blockLookAtInfo[3] == -1
    	//Signifies no block to look at.
    	int[] blockLookAtInfo = new int[]{0, 0, 0, 0, 0};
    	
    	blockLookAtInfo = PlayerHelper.getBlockInFrontInfo(world, entityPlayer, 5);
    	
    	if(blockLookAtInfo[3] != -1) {
    		Block blockLookAt = world.getBlock(blockLookAtInfo[0], blockLookAtInfo[1], blockLookAtInfo[2]);
    		
    		if(blockLookAt instanceof IWrenchable) {
    			if(!entityPlayer.isSneaking()) {
    				((IWrenchable)blockLookAt).onWrenchRightClick(world, entityPlayer, blockLookAtInfo[0], blockLookAtInfo[1], blockLookAtInfo[2], blockLookAtInfo[3], blockLookAtInfo[4]);
    			} else {
    				((IWrenchable)blockLookAt).onWrenchSneakRightClick(world, entityPlayer, blockLookAtInfo[0], blockLookAtInfo[1], blockLookAtInfo[2], blockLookAtInfo[3], blockLookAtInfo[4]);
    			}
    		}
    	}
    	
        return itemStack;
    }

		
}

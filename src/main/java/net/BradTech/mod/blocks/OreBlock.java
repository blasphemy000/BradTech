package net.BradTech.mod.blocks;

import java.util.Random;

import net.BradTech.mod.BradTech;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OreBlock extends Block {

	public OreBlock(Material material) {
		super(material);
		
		this.setHardness(3.0F);
		this.setResistance(10.0F);
		this.setHarvestLevel("pickaxe", 1);
		this.setStepSound(soundTypeStone);
		this.setCreativeTab(BradTech.bradTechTab);
	}
	
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(BradTech.modid + ":" + this.getUnlocalizedName().substring(5));
	}
	

	@Override
    public Block setBlockName(String name)
    {
		if(name == "BlueQuartzOre") 
			this.setHarvestLevel("pickaxe", 2);

        return super.setBlockName(name);
    }
	
	
	@Override
	public Item getItemDropped(int metaData, Random random, int fortune) {
		
		if(this == BradTech.oreBlueQuartzOre) {
			return BradTech.itemBlueQuartzGem;
		}
		
		// Return the item of the block if breaking the block DOESN'T drop items.
		return Item.getItemFromBlock(this);
		
	}
	

	@Override
    public int quantityDropped(Random random)
    {
		//return this == Blocks.lapis_ore ? 4 + random.nextInt(5) : 1;
		//return this == BradTech.oreBlueQuartzOre ? 1 + random.nextInt(3) : 1;
		
		if(this == BradTech.oreBlueQuartzOre)
			return 1 + random.nextInt(3);
		else
			return 1;
    }
	
	
    private Random rand = new Random();
    @Override
    public int getExpDrop(IBlockAccess world, int metadata, int fortune)
    {
        if (this.getItemDropped(metadata, rand, fortune) != Item.getItemFromBlock(this))
        {
            int j1 = 0;

            if (this == BradTech.oreBlueQuartzOre)
            {
                j1 = MathHelper.getRandomIntegerInRange(rand, 1, 3);
            }

            return j1;
        }
        return 0;
    }
	
}



package net.BradTech.mod.blocks;

import java.util.List;
import java.util.Random;

import net.BradTech.mod.BradTech;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class NetherOreBlock extends Block {
	
	private static int pigmenRange = 32;

	public NetherOreBlock(Material material) {
		super(material);
		
		/*	Harvest Levels
	     *     Wood:    0
	     *     Stone:   1
	     *     Iron:    2
	     *     Diamond: 3
	     *     Gold:    0
		 */
		this.setHardness(3.0F);
		this.setResistance(10.0F);
		this.setHarvestLevel("pickaxe", 2);
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
		if(name == "NetherBlueQuartzOre") 
			this.setHarvestLevel("pickaxe", 3);
		else if(name == "NetherRedstoneOre") 
			this.setHarvestLevel("pickaxe", 3);
		else if(name == "NetherDiamondOre") 
			this.setHarvestLevel("pickaxe", 3);
		else if(name == "NetherEmeraldOre") 
			this.setHarvestLevel("pickaxe", 3);

        return super.setBlockName(name);
    }
	
	
	@Override
	public Item getItemDropped(int metaData, Random random, int fortune) {
		
		if(this == BradTech.oreNetherBlueQuartzOre) {
			return BradTech.itemBlueQuartzGem;
		} else if(this == BradTech.oreNetherDiamondOre) {
			return Items.diamond;
		} else if(this == BradTech.oreNetherEmeraldOre) {
			return Items.emerald;
		} else if(this == BradTech.oreNetherRedstoneOre) {
			return Items.redstone;
		} else if(this == BradTech.oreNetherCoalOre) {
			return Items.coal;
		} else {
			// Return the item of the block if breaking the block DOESN'T drop items.
			return Item.getItemFromBlock(this);
		}
	}
	

	@Override
    public int quantityDropped(Random random)
    {
		if(this == BradTech.oreNetherBlueQuartzOre)
			return 1 + random.nextInt(3);
		else if(this == BradTech.oreNetherDiamondOre)
			return 1 + random.nextInt(2);
		else if(this == BradTech.oreNetherEmeraldOre)
			return 1 + random.nextInt(2);
		else if(this == BradTech.oreNetherRedstoneOre)
			return 1 + random.nextInt(5);
		else if(this == BradTech.oreNetherCoalOre)
			return 1 + random.nextInt(5);
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

            if (this == BradTech.oreNetherBlueQuartzOre) {
                j1 = MathHelper.getRandomIntegerInRange(rand, 1, 4);
            } else if (this == BradTech.oreNetherDiamondOre) {
                j1 = MathHelper.getRandomIntegerInRange(rand, 3, 5);
            } else if (this == BradTech.oreNetherEmeraldOre) {
                j1 = MathHelper.getRandomIntegerInRange(rand, 3, 5);
            } else if (this == BradTech.oreNetherRedstoneOre) {
                j1 = MathHelper.getRandomIntegerInRange(rand, 1, 4);
            } else if (this == BradTech.oreNetherCoalOre) {
                j1 = MathHelper.getRandomIntegerInRange(rand, 1, 4);
            }
              
            return j1;
        }
        return 0;
    }
    
    
    public static void angerPigmen(EntityPlayer player, World world, int x, int y, int z)
	{
		if(BradTech.bradTechConfig.getNetherMiningAngersPigmen())
		{
			List<EntityPigZombie> list = world.getEntitiesWithinAABB(EntityPigZombie.class, AxisAlignedBB.getBoundingBox(x - pigmenRange, y - pigmenRange, z - pigmenRange, x + pigmenRange + 1, y + pigmenRange + 1, z + pigmenRange + 1));

			for(int j = 0; j < list.size(); j++) {}
				//list.get(j).becomeAngryAt(player);
		}
	}    
	
}











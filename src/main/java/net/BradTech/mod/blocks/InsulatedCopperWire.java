package net.BradTech.mod.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.BradTech.mod.BradTech;
import net.BradTech.mod.tileentity.TileEntityInsulatedCopperWire;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class InsulatedCopperWire extends BlockContainer implements IWrenchable {

	/*
	private Block upBlock = null;
	private Block downBlock = null;
	private Block northBlock = null;
	private Block southBlock = null;
	private Block eastBlock = null;
	private Block westBlock = null;
	*/
	
	
	public InsulatedCopperWire() {
		super(Material.ground);

		this.setHardness(2.0F);
		this.setResistance(5.0F);
		//this.setBlockBounds(0.3125F, 0.3125F, 0.3125F, 0.6875F, 0.6875F, 0.6875F);
		this.setCreativeTab(BradTech.bradTechTab);
	}
	
	
	public void onWrenchRightClick(World world, EntityPlayer player, int x, int y, int z, int side, int metadata) {
		TileEntityInsulatedCopperWire tileEntity = (TileEntityInsulatedCopperWire)world.getTileEntity(x, y, z);
		tileEntity.toggleConnectionStatus();
	}
	
	
	public void onWrenchSneakRightClick(World world, EntityPlayer player, int x, int y, int z, int side, int metadata) {
		world.getBlock(x, y, z).dropBlockAsItem(world, x, y, z, metadata, 0);
		world.setBlockToAir(x, y, z);
	}
	
	
    @Override
    public void onNeighborChange(IBlockAccess world, int x, int y, int z, int tileX, int tileY, int tileZ) {

    	if(!((World)world).isRemote) {
    		String nte = "";
    		
	    	TileEntity tileEntity = world.getTileEntity(x, y, z);
	    	TileEntity neighborTileEntity = world.getTileEntity(tileX, tileY, tileZ);
	    	
	    	if(neighborTileEntity != null) {
		    	nte = neighborTileEntity.toString();
	    	} else {
	    		nte = "Block is not a TileEntity!";
	    	}
	    	
	    	System.out.printf("This TileEntity: %s\n", tileEntity.toString());
	    	
	    	if(y < tileY) {
	    		//UP
	    		System.out.println("New UpBlock: " + nte);
	    	} else if(y > tileY) {
	    		//DOWN
	    		System.out.println("New DownBlock: " + nte);
	    	} else if(z > tileZ) {
	    		//NORTH
	    		System.out.println("New NorthBlock: " + nte);
	    	} else if(z < tileZ) {
	    		//SOUTH
	    		System.out.println("New SouthBlock: " + nte);
	    	} else if(x < tileX) {
	    		//EAST
	    		System.out.println("New EastBlock: " + nte);
	    	} else if(x > tileX) {
	    		//WEST
	    		System.out.println("New WestBlock: " + nte);
	    	}
    	}

    }
	
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighborBlock) {
		super.onNeighborBlockChange(world, x, y, z, neighborBlock);

		// UP:		+Y	DOWN:	-Y
		// NORTH	-Z	SOUTH:	+Z
		// EAST		+X	WEST:	-X
		
		// Check each of the surrounding blocks to see which one is different from the ones that were there when the block
		// was placed or this method was last called. Then update the local variables containing the surrounding blocks.
		/*
		Block newUpBlock = world.getBlock(x, y + 1, z);
		Block newDownBlock = world.getBlock(x, y - 1, z);
		Block newNorthBlock = world.getBlock(x, y, z - 1);
		Block newSouthBlock = world.getBlock(x, y, z + 1);
		Block newEastBlock = world.getBlock(x + 1, y, z);
		Block newWestBlock = world.getBlock(x - 1, y, z);
		
		
		if(newUpBlock != upBlock) {
			System.out.printf("UpBlock changed from: %s  to: %s\n", upBlock.getUnlocalizedName(), newUpBlock.getUnlocalizedName());
			upBlock = newUpBlock;
			
			if(upBlock == BradTech.blockInsulatedCopperWire) {
				System.out.println("New UpBlock is a wire!");
			}
		} else if(newDownBlock != downBlock) {
			System.out.printf("DownBlock changed from: %s  to: %s\n", downBlock.getUnlocalizedName(), newDownBlock.getUnlocalizedName());
			downBlock = newDownBlock;
			
			if(downBlock == BradTech.blockInsulatedCopperWire) {
				System.out.println("New DownBlock is a wire!");
			}
		} else if(newNorthBlock != northBlock) {
			System.out.printf("NorthBlock changed from: %s  to: %s\n", northBlock.getUnlocalizedName(), newNorthBlock.getUnlocalizedName());
			northBlock = newNorthBlock;
			
			if(northBlock == BradTech.blockInsulatedCopperWire) {
				System.out.println("New NorthBlock is a wire!");
			}
		} else if(newSouthBlock != southBlock) {
			System.out.printf("SouthBlock changed from: %s  to: %s\n", southBlock.getUnlocalizedName(), newSouthBlock.getUnlocalizedName());
			southBlock = newSouthBlock;

			if(southBlock == BradTech.blockInsulatedCopperWire) {
				System.out.println("New SouthBlock is a wire!");
			}
		} else if(newEastBlock != eastBlock) {
			System.out.printf("EastBlock changed from: %s  to: %s\n", eastBlock.getUnlocalizedName(), newEastBlock.getUnlocalizedName());
			eastBlock = newEastBlock;
			
			if(eastBlock == BradTech.blockInsulatedCopperWire) {
				System.out.println("New EastBlock is a wire!");
			}
		} else if(newWestBlock != westBlock) {
			System.out.printf("WestBlock changed from: %s  to: %s\n", westBlock.getUnlocalizedName(), newWestBlock.getUnlocalizedName());
			westBlock = newWestBlock;
			
			if(westBlock == BradTech.blockInsulatedCopperWire) {
				System.out.println("New WestBlock is a wire!");
			}
		}
		*/
	}
	
	
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		
		/*
		upBlock = world.getBlock(x, y + 1, z);
		downBlock = world.getBlock(x, y - 1, z);
		northBlock = world.getBlock(x, y, z - 1);
		southBlock = world.getBlock(x, y, z + 1);
		eastBlock = world.getBlock(x + 1, y, z);
		westBlock = world.getBlock(x - 1, y, z);		
		
		System.out.printf("UpBlock: %s\n", upBlock.getUnlocalizedName());
		System.out.printf("DownBlock: %s\n", downBlock.getUnlocalizedName());
		System.out.printf("NorthBlock: %s\n", northBlock.getUnlocalizedName());
		System.out.printf("SouthBlock: %s\n", southBlock.getUnlocalizedName());
		System.out.printf("EastBlock: %s\n", eastBlock.getUnlocalizedName());
		System.out.printf("WestBlock: %s\n", westBlock.getUnlocalizedName());
		*/
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
		return new TileEntityInsulatedCopperWire();
	}
	
}

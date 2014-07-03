package net.BradTech.mod.blocks;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.BradTech.mod.BradTech;
import net.BradTech.mod.tileentity.TileEntityInsulatedCopperWire;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class InsulatedCopperWire extends BlockContainer implements IWrenchable {

	/*
	private float lastHitX;
	private float lastHitY;
	private float lastHitZ;
	*/
	
	public InsulatedCopperWire() {
		super(Material.ground);

		this.setHardness(2.0F);
		this.setResistance(5.0F);
		
		this.setCreativeTab(BradTech.bradTechTab);
	}

	
	private AxisAlignedBB[] getParts(TileEntityInsulatedCopperWire wTE) {
		
		boolean cUp = wTE.getRenderUp();
		boolean cDown = wTE.getRenderDown();
		boolean cNorth = wTE.getRenderNorth();
		boolean cSouth = wTE.getRenderSouth();
		boolean cEast = wTE.getRenderEast();
		boolean cWest = wTE.getRenderWest();
		
		AxisAlignedBB[] parts = new AxisAlignedBB[13];
		
		// Wire Core
		parts[0] = AxisAlignedBB.getBoundingBox(0.3125F, 0.3125F, 0.3125F, 0.6875F, 0.6875F, 0.6875F);
		
		// Up Side - Works
		parts[1] = cUp ? AxisAlignedBB.getBoundingBox(0.3125F, 0.6875F, 0.3125F, 0.6875F, 0.8125F, 0.6875F) : null;
		parts[2] = cUp ? AxisAlignedBB.getBoundingBox(0.3125F, 0.8125F, 0.3125F, 0.6875F, 1.0F, 0.6875F) : null;
		
		// Down Side
		parts[3] = cDown ? AxisAlignedBB.getBoundingBox(0.3125F, 0.1875F, 0.3125F, 0.6875F, 0.3125F, 0.6875F) : null;
		parts[4] = cDown ? AxisAlignedBB.getBoundingBox(0.3125F, 0.0F, 0.3125F, 0.6875F, 0.1875F, 0.6875F) : null;
		
		// North Side
		parts[5] = cNorth ? AxisAlignedBB.getBoundingBox(0.3125F, 0.3125F, 0.1875F, 0.6875F, 0.6875F, 0.3125F) : null;
		parts[6] = cNorth ? AxisAlignedBB.getBoundingBox(0.3125F, 0.3125F, 0.0F, 0.6875F, 0.6875F, 0.1875F) : null;
		
		// South Side - Works
		parts[7] = cSouth ? AxisAlignedBB.getBoundingBox(0.3125F, 0.3125F, 0.6875F, 0.6875F, 0.6875F, 0.8125F) : null;
		parts[8] = cSouth ? AxisAlignedBB.getBoundingBox(0.3125F, 0.3125F, 0.8125F, 0.6875F, 0.6875F, 1.0F) : null;
		
		// East Side - Works
		parts[9] = cEast ? AxisAlignedBB.getBoundingBox(0.6875F, 0.3125F, 0.3125F, 0.8125F, 0.6875F, 0.6875F) : null;
		parts[10] = cEast ? AxisAlignedBB.getBoundingBox(0.8125F, 0.3125F, 0.3125F, 1.0F, 0.6875F, 0.6875F) : null;
		
		// West Side
		parts[11] = cWest ? AxisAlignedBB.getBoundingBox(0.1875F, 0.3125F, 0.3125F, 0.3125F, 0.6875F, 0.6875F) : null;
		parts[12] = cWest ? AxisAlignedBB.getBoundingBox(0.0F, 0.3125F, 0.3125F, 0.1875F, 0.6875F, 0.6875F) : null;
		
		return parts;
	}
	
	
	private int getPartClicked(EntityPlayer player, double reachDistance, TileEntityInsulatedCopperWire tileEntity) {

		AxisAlignedBB[] wireParts = getParts(tileEntity);
		
		Vec3 playerPosition = Vec3.createVectorHelper(player.posX - tileEntity.xCoord, player.posY - tileEntity.yCoord + player.getEyeHeight(), player.posZ - tileEntity.zCoord);
		Vec3 playerLook = player.getLookVec();
		
		Vec3 playerViewOffset = Vec3.createVectorHelper(playerPosition.xCoord + playerLook.xCoord * reachDistance, playerPosition.yCoord + playerLook.yCoord * reachDistance, playerPosition.zCoord + playerLook.zCoord * reachDistance);
		
		int closest = -1;
		double closestDistance = Double.MAX_VALUE;
		
		for(int i = 0; i < wireParts.length; i++) {
			AxisAlignedBB part = wireParts[i];
			if(part == null)
				continue;
			
			MovingObjectPosition hit = part.calculateIntercept(playerPosition, playerViewOffset);
			if(hit != null) {
				double distance = playerPosition.distanceTo(hit.hitVec);
				if(distance < closestDistance) {
					closestDistance = distance;
					closest = i;
				}
			}
		}
		
		return closest;
	}
	
	
	@Override
	public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB collisionTest, List collisionBoxList, Entity entity) {
		
		TileEntity wire = world.getTileEntity(x, y, z);
		
		if(wire instanceof TileEntityInsulatedCopperWire) {
			for(AxisAlignedBB aabb : getParts((TileEntityInsulatedCopperWire)wire)) {
				if(aabb == null)
					continue;
				
				aabb = AxisAlignedBB.getBoundingBox(aabb.minX, aabb.minY, aabb.minZ, aabb.maxX, aabb.maxY, aabb.maxZ);
				aabb.minX += x;
				aabb.minY += y;
				aabb.minZ += z;
				aabb.maxX += x;
				aabb.maxY += y;
				aabb.maxZ += z;
				
				if(collisionTest.intersectsWith(aabb)) {
					collisionBoxList.add(aabb);
				}
			}
		} else {
			super.addCollisionBoxesToList(world, x, y, z, collisionTest, collisionBoxList, entity);
		}
		
	}
	
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		
		float xMin = 1, yMin = 1, zMin = 1;
		float xMax = 0, yMax = 0, zMax = 0;
		
		TileEntity wire = world.getTileEntity(x, y, z);
		
		if(wire instanceof TileEntityInsulatedCopperWire) {
			for(AxisAlignedBB aabb : getParts((TileEntityInsulatedCopperWire)wire)) {
				if(aabb == null)
					continue;
				
				xMin = Math.min(xMin, (float)aabb.minX);
				yMin = Math.min(yMin, (float)aabb.minY);
				zMin = Math.min(zMin, (float)aabb.minZ);
				xMax = Math.max(xMax, (float)aabb.maxX);
				yMax = Math.max(yMax, (float)aabb.maxY);
				zMax = Math.max(zMax, (float)aabb.maxZ);
			}
			this.setBlockBounds(xMin, yMin, zMin, xMax, yMax, zMax);
		} else {
			super.setBlockBoundsBasedOnState(world, x, y, z);
		}
		
	}
	
	
	public void onWrenchRightClick(World world, EntityPlayer player, int x, int y, int z, int side, int metadata) {
		TileEntity te = world.getTileEntity(x, y, z);
		//tileEntity.toggleConnectionStatus();

		if(te instanceof TileEntityInsulatedCopperWire) {
			TileEntityInsulatedCopperWire wire = (TileEntityInsulatedCopperWire)te;
			
			int partHit = this.getPartClicked(player, 3.0F, wire);
			
			if(partHit < 0)
				return;
			
			switch(partHit) {
			case 2:
				wire.setAllowConnUp(!wire.getAllowConnUp());
				break;
			case 4:
				wire.setAllowConnDown(!wire.getAllowConnDown());
				break;
			case 6:
				wire.setAllowConnNorth(!wire.getAllowConnNorth());
				break;
			case 8:
				wire.setAllowConnSouth(!wire.getAllowConnSouth());
				break;
			case 10:
				wire.setAllowConnEast(!wire.getAllowConnEast());
				break;
			case 12:
				wire.setAllowConnWest(!wire.getAllowConnWest());
				break;
			}
		}
		
	}
	
	
	public void onWrenchSneakRightClick(World world, EntityPlayer player, int x, int y, int z, int side, int metadata) {
		world.getBlock(x, y, z).dropBlockAsItem(world, x, y, z, metadata, 0);
		world.setBlockToAir(x, y, z);
	}
	
	
    @Override
    public void onNeighborChange(IBlockAccess world, int x, int y, int z, int tileX, int tileY, int tileZ) {

    	Block nBlock = world.getBlock(tileX, tileY, tileZ);
    	TileEntity tTE = world.getTileEntity(x, y, z);
    	TileEntity nTE = world.getTileEntity(tileX, tileY, tileZ);
    	
    	//if(!((World)world).isRemote) {
	    	if(y < tileY) {
	    		//UP
	    		if(nBlock instanceof InsulatedCopperWire) {
	    			((TileEntityInsulatedCopperWire)tTE).setRenderUp(true);
	    			((TileEntityInsulatedCopperWire)tTE).setConnectUp(false);
	    			((TileEntityInsulatedCopperWire)nTE).setRenderDown(true);
	    			((TileEntityInsulatedCopperWire)nTE).setConnectDown(false);
	    		} else if(nBlock instanceof IElectricalDevice) {
	    			((TileEntityInsulatedCopperWire)tTE).setRenderUp(true);
	    			((TileEntityInsulatedCopperWire)tTE).setConnectUp(true);
	    		} else {
	    			((TileEntityInsulatedCopperWire)tTE).setRenderUp(false);
	    			((TileEntityInsulatedCopperWire)tTE).setConnectUp(false);
	    		}
	    	} else if(y > tileY) {
	    		//DOWN
	    		if(nBlock instanceof InsulatedCopperWire) {
	    			((TileEntityInsulatedCopperWire)tTE).setRenderDown(true);
	    			((TileEntityInsulatedCopperWire)tTE).setConnectDown(false);
	    			((TileEntityInsulatedCopperWire)nTE).setRenderUp(true);
	    			((TileEntityInsulatedCopperWire)nTE).setConnectUp(false);
	    		} else if(nBlock instanceof IElectricalDevice) {
	    			((TileEntityInsulatedCopperWire)tTE).setRenderDown(true);
	    			((TileEntityInsulatedCopperWire)tTE).setConnectDown(true);
	    		} else {
	    			((TileEntityInsulatedCopperWire)tTE).setRenderDown(false);
	    			((TileEntityInsulatedCopperWire)tTE).setConnectDown(false);
	    		}
	    	} else if(z > tileZ) {
	    		//NORTH
	    		if(nBlock instanceof InsulatedCopperWire) {
	    			((TileEntityInsulatedCopperWire)tTE).setRenderNorth(true);
	    			((TileEntityInsulatedCopperWire)tTE).setConnectNorth(false);
	    			((TileEntityInsulatedCopperWire)nTE).setRenderSouth(true);
	    			((TileEntityInsulatedCopperWire)nTE).setConnectSouth(false);
	    		} else if(nBlock instanceof IElectricalDevice) {
	    			((TileEntityInsulatedCopperWire)tTE).setRenderNorth(true);
	    			((TileEntityInsulatedCopperWire)tTE).setConnectNorth(true);
	    		} else {
	    			((TileEntityInsulatedCopperWire)tTE).setRenderNorth(false);
	    			((TileEntityInsulatedCopperWire)tTE).setConnectNorth(false);
	    		}
	    	} else if(z < tileZ) {
	    		//SOUTH
	    		if(nBlock instanceof InsulatedCopperWire) {
	    			((TileEntityInsulatedCopperWire)tTE).setRenderSouth(true);
	    			((TileEntityInsulatedCopperWire)tTE).setConnectSouth(false);
	    			((TileEntityInsulatedCopperWire)nTE).setRenderNorth(true);
	    			((TileEntityInsulatedCopperWire)nTE).setConnectNorth(false);
	    		} else if(nBlock instanceof IElectricalDevice) {
	    			((TileEntityInsulatedCopperWire)tTE).setRenderSouth(true);
	    			((TileEntityInsulatedCopperWire)tTE).setConnectSouth(true);
	    		} else {
	    			((TileEntityInsulatedCopperWire)tTE).setRenderSouth(false);
	    			((TileEntityInsulatedCopperWire)tTE).setConnectSouth(false);
	    		}
	    	} else if(x < tileX) {
	    		//EAST
	    		if(nBlock instanceof InsulatedCopperWire) {
	    			((TileEntityInsulatedCopperWire)tTE).setRenderEast(true);
	    			((TileEntityInsulatedCopperWire)tTE).setConnectEast(false);
	    			((TileEntityInsulatedCopperWire)nTE).setRenderWest(true);
	    			((TileEntityInsulatedCopperWire)nTE).setConnectWest(false);
	    		} else if(nBlock instanceof IElectricalDevice) {
	    			((TileEntityInsulatedCopperWire)tTE).setRenderEast(true);
	    			((TileEntityInsulatedCopperWire)tTE).setConnectEast(true);
	    		} else {
	    			((TileEntityInsulatedCopperWire)tTE).setRenderEast(false);
	    			((TileEntityInsulatedCopperWire)tTE).setConnectEast(false);
	    		}
	    	} else if(x > tileX) {
	    		//WEST
	    		if(nBlock instanceof InsulatedCopperWire) {
	    			((TileEntityInsulatedCopperWire)tTE).setRenderWest(true);
	    			((TileEntityInsulatedCopperWire)tTE).setConnectWest(false);
	    			((TileEntityInsulatedCopperWire)nTE).setRenderEast(true);
	    			((TileEntityInsulatedCopperWire)nTE).setConnectEast(false);
	    		} else if(nBlock instanceof IElectricalDevice) {
	    			((TileEntityInsulatedCopperWire)tTE).setRenderWest(true);
	    			((TileEntityInsulatedCopperWire)tTE).setConnectWest(true);
	    		} else {
	    			((TileEntityInsulatedCopperWire)tTE).setRenderWest(false);
	    			((TileEntityInsulatedCopperWire)tTE).setConnectWest(false);
	    		}
	    	}
    	//}

    }
	
	
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		
		TileEntity tTE = world.getTileEntity(x, y, z);
		
		Block upBlock = world.getBlock(x, y + 1, z);
		
		if(upBlock instanceof IElectricalDevice) {
			((TileEntityInsulatedCopperWire)tTE).setRenderUp(true);
			((TileEntityInsulatedCopperWire)tTE).setConnectUp(true);
		}
		
		Block downBlock = world.getBlock(x, y - 1, z);
		
		if(downBlock instanceof IElectricalDevice) {
			((TileEntityInsulatedCopperWire)tTE).setRenderDown(true);
			((TileEntityInsulatedCopperWire)tTE).setConnectDown(true);
		}
		
		Block northBlock = world.getBlock(x, y, z - 1);
		
		if(northBlock instanceof IElectricalDevice) {
			((TileEntityInsulatedCopperWire)tTE).setRenderNorth(true);
			((TileEntityInsulatedCopperWire)tTE).setConnectNorth(true);
		}
		
		Block southBlock = world.getBlock(x, y, z + 1);
		
		if(southBlock instanceof IElectricalDevice) {
			((TileEntityInsulatedCopperWire)tTE).setRenderSouth(true);
			((TileEntityInsulatedCopperWire)tTE).setConnectSouth(true);
		}
		
		Block eastBlock = world.getBlock(x + 1, y, z);
		
		if(eastBlock instanceof IElectricalDevice) {
			((TileEntityInsulatedCopperWire)tTE).setRenderEast(true);
			((TileEntityInsulatedCopperWire)tTE).setConnectEast(true);
		}
		
		Block westBlock = world.getBlock(x - 1, y, z);
		
		if(westBlock instanceof IElectricalDevice) {
			((TileEntityInsulatedCopperWire)tTE).setRenderWest(true);
			((TileEntityInsulatedCopperWire)tTE).setConnectWest(true);
		}
	}
	
	
	/*
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
    	
    	if(player.getHeldItem() != null) {
    		if(player.getHeldItem().getItem() == BradTech.itemSonicScrewdriver) {
        		lastHitX = hitX;
        		lastHitY = hitY;
        		lastHitZ = hitZ;
    		}
    	}
    	
    	return super.onBlockActivated(world, x, y, z, player, side, hitX, hitY, hitZ);
    }
    */


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

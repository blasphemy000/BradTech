package net.BradTech.mod.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.BradTech.mod.blocks.InsulatedCopperWire;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityInsulatedCopperWire extends TileEntity {

	private boolean canConnectToMachines;
	
	
	public boolean getConnectionStatus() {
		return this.canConnectToMachines;
	}
	
	
	public void setConnectionStatus(boolean canConnect) {
		this.canConnectToMachines = canConnect;
		this.markDirty();
	}
	
	
	public void toggleConnectionStatus() {
		this.canConnectToMachines = !this.canConnectToMachines;
		this.markDirty();
	}
	
	
	@Override
    public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 2, nbt);
    }
	
	
    @Override
    public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
    	super.onDataPacket(net, packet);
    	readFromNBT(packet.func_148857_g());
    }
	
	
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);

		canConnectToMachines = nbt.getBoolean("canConnectToMachines");
		
		if(canConnectToMachines)
			System.out.println("Read \"true\" from NBT...");
		else
			System.out.println("Read \"false\" from NBT...");
	}
	
	
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		
		nbt.setBoolean("canConnectToMachines", canConnectToMachines);

		if(canConnectToMachines)
			System.out.println("Wrote \"true\" to NBT...");
		else
			System.out.println("Wrote \"false\" to NBT...");
	}

	
}

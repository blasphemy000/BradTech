package net.BradTech.mod;

import cpw.mods.fml.common.registry.GameRegistry;
import net.BradTech.mod.blocks.ForgeOven;
import net.BradTech.mod.blocks.InsulatedCopperWire;
import net.BradTech.mod.blocks.MachinistsTable;
import net.BradTech.mod.blocks.ObsidianTable;
import net.BradTech.mod.tileentity.*;
import net.minecraft.block.material.Material;

public class InitMachines {
	
	public static void SetupMachineBlocks() {
		BradTech.blockObsidianTable = new ObsidianTable(Material.rock).setBlockName("ObsidianTable");
		GameRegistry.registerBlock(BradTech.blockObsidianTable, "ObsidianTable");		
		
		BradTech.blockForgeOvenIdle = new ForgeOven(false).setBlockName("ForgeOvenIdle").setCreativeTab(BradTech.bradTechMachines);
		GameRegistry.registerBlock(BradTech.blockForgeOvenIdle, "ForgeOvenIdle");
		
		BradTech.blockForgeOvenActive = new ForgeOven(true).setBlockName("ForgeOvenActive").setLightLevel(0.625F);
		GameRegistry.registerBlock(BradTech.blockForgeOvenActive, "ForgeOvenActive");
		
		BradTech.blockMachinistsTable = new MachinistsTable().setBlockName("MachinistsTable");
		GameRegistry.registerBlock(BradTech.blockMachinistsTable, "MachinistsTable");
		
		BradTech.blockInsulatedCopperWire = new InsulatedCopperWire().setBlockName("InsulatedCopperWire");
		GameRegistry.registerBlock(BradTech.blockInsulatedCopperWire, "InsulatedCopperWire");
	}
	
	
	public static void SetupTileEntities() {
		GameRegistry.registerTileEntity(TileEntityForgeOven.class, "ForgeOven");
		GameRegistry.registerTileEntity(TileEntityInsulatedCopperWire.class, "TileEntityInsulatedCopperWire");
	}

}

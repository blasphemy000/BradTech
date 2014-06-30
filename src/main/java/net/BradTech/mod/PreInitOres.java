package net.BradTech.mod;

import net.BradTech.mod.blocks.MetalBlock;
import net.BradTech.mod.blocks.NetherOreBlock;
import net.BradTech.mod.blocks.OreBlock;
import net.BradTech.mod.items.BTItems;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;

public class PreInitOres {

	public static void SetupBradTechOres() {
		// Items
		BradTech.itemCopperIngot = new BTItems().setUnlocalizedName("CopperIngot");
		GameRegistry.registerItem(BradTech.itemCopperIngot, "CopperIngot");
		
		BradTech.itemTinIngot = new BTItems().setUnlocalizedName("TinIngot");
		GameRegistry.registerItem(BradTech.itemTinIngot, "TinIngot");
		
		BradTech.itemNickelIngot = new BTItems().setUnlocalizedName("NickelIngot");
		GameRegistry.registerItem(BradTech.itemNickelIngot, "NickelIngot");
		
		BradTech.itemAluminumIngot = new BTItems().setUnlocalizedName("AluminumIngot");
		GameRegistry.registerItem(BradTech.itemAluminumIngot, "AluminumIngot");
		
		BradTech.itemPlatinumIngot = new BTItems().setUnlocalizedName("PlatinumIngot");
		GameRegistry.registerItem(BradTech.itemPlatinumIngot, "PlatinumIngot");

		BradTech.itemUraniumIngot = new BTItems().setUnlocalizedName("UraniumIngot");
		GameRegistry.registerItem(BradTech.itemUraniumIngot, "UraniumIngot");
		
		BradTech.itemBronzeIngot = new BTItems().setUnlocalizedName("BronzeIngot");
		GameRegistry.registerItem(BradTech.itemBronzeIngot, "BronzeIngot");
		
		BradTech.itemSteelIngot = new BTItems().setUnlocalizedName("SteelIngot");
		GameRegistry.registerItem(BradTech.itemSteelIngot, "SteelIngot");
		
		BradTech.itemBlueQuartzGem = new BTItems().setUnlocalizedName("BlueQuartzGem");
		GameRegistry.registerItem(BradTech.itemBlueQuartzGem, "BlueQuartzGem");
		
		BradTech.itemBlueQuartzDust = new BTItems().setUnlocalizedName("BlueQuartzDust");
		GameRegistry.registerItem(BradTech.itemBlueQuartzDust, "BlueQuartzDust");
	
		
		// Surface Ores
		BradTech.oreCopperOre = new OreBlock(Material.rock).setBlockName("CopperOre");
		GameRegistry.registerBlock(BradTech.oreCopperOre, "CopperOre");
		
		BradTech.oreTinOre = new OreBlock(Material.rock).setBlockName("TinOre");
		GameRegistry.registerBlock(BradTech.oreTinOre, "TinOre");

		BradTech.oreNickelOre = new OreBlock(Material.rock).setBlockName("NickelOre");
		GameRegistry.registerBlock(BradTech.oreNickelOre, "NickelOre");

		BradTech.oreAluminumOre = new OreBlock(Material.rock).setBlockName("AluminumOre");
		GameRegistry.registerBlock(BradTech.oreAluminumOre, "AluminumOre");
		
		BradTech.orePlatinumOre = new OreBlock(Material.rock).setBlockName("PlatinumOre");
		GameRegistry.registerBlock(BradTech.orePlatinumOre, "PlatinumOre");

		BradTech.oreUraniumOre = new OreBlock(Material.rock).setBlockName("UraniumOre");
		GameRegistry.registerBlock(BradTech.oreUraniumOre, "UraniumOre");
		
		BradTech.oreBlueQuartzOre = new OreBlock(Material.rock).setBlockName("BlueQuartzOre");
		GameRegistry.registerBlock(BradTech.oreBlueQuartzOre, "BlueQuartzOre");

		
		// Nether Ores
		BradTech.oreNetherIronOre = new NetherOreBlock(Material.rock).setBlockName("NetherIronOre");
		GameRegistry.registerBlock(BradTech.oreNetherIronOre, "NetherIronOre");
		
		BradTech.oreNetherGoldOre = new NetherOreBlock(Material.rock).setBlockName("NetherGoldOre");
		GameRegistry.registerBlock(BradTech.oreNetherGoldOre, "NetherGoldOre");
		
		BradTech.oreNetherCopperOre = new NetherOreBlock(Material.rock).setBlockName("NetherCopperOre");
		GameRegistry.registerBlock(BradTech.oreNetherCopperOre, "NetherCopperOre");
		
		BradTech.oreNetherTinOre = new NetherOreBlock(Material.rock).setBlockName("NetherTinOre");
		GameRegistry.registerBlock(BradTech.oreNetherTinOre, "NetherTinOre");

		BradTech.oreNetherNickelOre = new NetherOreBlock(Material.rock).setBlockName("NetherNickelOre");
		GameRegistry.registerBlock(BradTech.oreNetherNickelOre, "NetherNickelOre");
		
		BradTech.oreNetherAluminumOre = new NetherOreBlock(Material.rock).setBlockName("NetherAluminumOre");
		GameRegistry.registerBlock(BradTech.oreNetherAluminumOre, "NetherAluminumOre");
		
		BradTech.oreNetherPlatinumOre = new NetherOreBlock(Material.rock).setBlockName("NetherPlatinumOre");
		GameRegistry.registerBlock(BradTech.oreNetherPlatinumOre, "NetherPlatinumOre");
		
		BradTech.oreNetherUraniumOre = new NetherOreBlock(Material.rock).setBlockName("NetherUraniumOre");
		GameRegistry.registerBlock(BradTech.oreNetherUraniumOre, "NetherUraniumOre");
		
		BradTech.oreNetherBlueQuartzOre = new NetherOreBlock(Material.rock).setBlockName("NetherBlueQuartzOre");
		GameRegistry.registerBlock(BradTech.oreNetherBlueQuartzOre, "NetherBlueQuartzOre");
		
		BradTech.oreNetherDiamondOre = new NetherOreBlock(Material.rock).setBlockName("NetherDiamondOre");
		GameRegistry.registerBlock(BradTech.oreNetherDiamondOre, "NetherDiamondOre");
		
		BradTech.oreNetherEmeraldOre = new NetherOreBlock(Material.rock).setBlockName("NetherEmeraldOre");
		GameRegistry.registerBlock(BradTech.oreNetherEmeraldOre, "NetherEmeraldOre");
		
		BradTech.oreNetherRedstoneOre = new NetherOreBlock(Material.rock).setBlockName("NetherRedstoneOre");
		GameRegistry.registerBlock(BradTech.oreNetherRedstoneOre, "NetherRedstoneOre");
		
		BradTech.oreNetherCoalOre = new NetherOreBlock(Material.rock).setBlockName("NetherCoalOre");
		GameRegistry.registerBlock(BradTech.oreNetherCoalOre, "NetherCoalOre");
		
		
		// Blocks
		BradTech.blockCopperBlock = new MetalBlock(Material.iron).setBlockName("CopperBlock");
		GameRegistry.registerBlock(BradTech.blockCopperBlock, "CopperBlock");
		
		BradTech.blockTinBlock = new MetalBlock(Material.iron).setBlockName("TinBlock");
		GameRegistry.registerBlock(BradTech.blockTinBlock, "TinBlock");
		
		BradTech.blockNickelBlock = new MetalBlock(Material.iron).setBlockName("NickelBlock");
		GameRegistry.registerBlock(BradTech.blockNickelBlock, "NickelBlock");
		
		BradTech.blockAluminumBlock = new MetalBlock(Material.iron).setBlockName("AluminumBlock");
		GameRegistry.registerBlock(BradTech.blockAluminumBlock, "AluminumBlock");
		
		BradTech.blockPlatinumBlock = new MetalBlock(Material.iron).setBlockName("PlatinumBlock");
		GameRegistry.registerBlock(BradTech.blockPlatinumBlock, "PlatinumBlock");
		
		BradTech.blockUraniumBlock = new MetalBlock(Material.iron).setBlockName("UraniumBlock");
		GameRegistry.registerBlock(BradTech.blockUraniumBlock, "UraniumBlock");

		BradTech.blockBronzeBlock = new MetalBlock(Material.iron).setBlockName("BronzeBlock");
		GameRegistry.registerBlock(BradTech.blockBronzeBlock, "BronzeBlock");

		BradTech.blockSteelBlock = new MetalBlock(Material.iron).setBlockName("SteelBlock");
		GameRegistry.registerBlock(BradTech.blockSteelBlock, "SteelBlock");
	}
	
}

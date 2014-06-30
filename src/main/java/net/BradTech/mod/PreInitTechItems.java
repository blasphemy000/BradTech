package net.BradTech.mod;

import net.BradTech.mod.armor.QuartzArmor;
import net.BradTech.mod.blocks.ForgeOven;
import net.BradTech.mod.blocks.InsulatedCopperWire;
import net.BradTech.mod.blocks.ObsidianTable;
import net.BradTech.mod.items.*;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class PreInitTechItems {

	public static void SetupTechItems() {

		// Setup and register these "Tab Icon" items. These items are not present in the game.
		// Not using this right now...
		
		// Standard items this mod adds.
		BradTech.itemWoodCog = new BTItems().setUnlocalizedName("WoodCog");
		GameRegistry.registerItem(BradTech.itemWoodCog, "WoodCog");
		
		BradTech.itemStoneCog = new BTItems().setUnlocalizedName("StoneCog");
		GameRegistry.registerItem(BradTech.itemStoneCog, "StoneCog");

		BradTech.itemAluminumCog = new BTItems().setUnlocalizedName("AluminumCog");
		GameRegistry.registerItem(BradTech.itemAluminumCog, "AluminumCog");

		BradTech.itemTinCog = new BTItems().setUnlocalizedName("TinCog");
		GameRegistry.registerItem(BradTech.itemTinCog, "TinCog");

		BradTech.itemIronCog = new BTItems().setUnlocalizedName("IronCog");
		GameRegistry.registerItem(BradTech.itemIronCog, "IronCog");
		
		BradTech.itemBronzeCog = new BTItems().setUnlocalizedName("BronzeCog");
		GameRegistry.registerItem(BradTech.itemBronzeCog, "BronzeCog");

		BradTech.itemDiamondCog = new BTItems().setUnlocalizedName("DiamondCog");
		GameRegistry.registerItem(BradTech.itemDiamondCog, "DiamondCog");

		BradTech.itemRawRubber = new BTItems().setUnlocalizedName("RawRubber");
		GameRegistry.registerItem(BradTech.itemRawRubber, "RawRubber");
		
		BradTech.itemProcessedRubber = new BTItems().setUnlocalizedName("ProcessedRubber");
		GameRegistry.registerItem(BradTech.itemProcessedRubber, "ProcessedRubber");
	
		BradTech.itemPlastic = new BTItems().setUnlocalizedName("Plastic");
		GameRegistry.registerItem(BradTech.itemPlastic, "Plastic");
		
		BradTech.itemLaminate = new BTItems().setUnlocalizedName("Laminate");
		GameRegistry.registerItem(BradTech.itemLaminate, "Laminate");
		
		BradTech.itemCopperWire = new BTItems().setUnlocalizedName("CopperWire");
		GameRegistry.registerItem(BradTech.itemCopperWire, "CopperWire");

		
		// Blocks
		// Block initialization goes here...
		
		
		// Tools/Weapons
		BradTech.itemIronExtruder = new IronExtruder().setUnlocalizedName("IronExtruder");
		GameRegistry.registerItem(BradTech.itemIronExtruder, "IronExtruder");
		
		BradTech.itemQuartzSword = new QuartzSword(BradTech.matQuartzMaterial).setUnlocalizedName("QuartzSword");
		GameRegistry.registerItem(BradTech.itemQuartzSword, "QuartzSword");
		
		BradTech.itemQuartzPickAxe = new QuartzPickAxe(BradTech.matQuartzMaterial).setUnlocalizedName("QuartzPickAxe");
		GameRegistry.registerItem(BradTech.itemQuartzPickAxe, "QuartzPickAxe");
		
		BradTech.itemQuartzShovel = new QuartzShovel(BradTech.matQuartzMaterial).setUnlocalizedName("QuartzShovel");
		GameRegistry.registerItem(BradTech.itemQuartzShovel, "QuartzShovel");
		
		BradTech.itemQuartzAxe = new QuartzAxe(BradTech.matQuartzMaterial).setUnlocalizedName("QuartzAxe");
		GameRegistry.registerItem(BradTech.itemQuartzAxe, "QuartzAxe");
		
		BradTech.itemQuartzHoe = new QuartzHoe(BradTech.matQuartzMaterial).setUnlocalizedName("QuartzHoe");
		GameRegistry.registerItem(BradTech.itemQuartzHoe, "QuartzHoe");
		
		BradTech.armorQuartzHelmet = new QuartzArmor(BradTech.matQuartzArmorMaterial, BradTech.armorIDQuartzHelmet, 0).setUnlocalizedName("QuartzHelmet");
		GameRegistry.registerItem(BradTech.armorQuartzHelmet, "QuartzHelmet");
		
		BradTech.armorQuartzChestplate = new QuartzArmor(BradTech.matQuartzArmorMaterial, BradTech.armorIDQuartzChestplate, 1).setUnlocalizedName("QuartzChestplate");
		GameRegistry.registerItem(BradTech.armorQuartzChestplate, "QuartzChestplate");
		
		BradTech.armorQuartzLeggings = new QuartzArmor(BradTech.matQuartzArmorMaterial, BradTech.armorIDQuartzLeggings, 2).setUnlocalizedName("QuartzLeggings");
		GameRegistry.registerItem(BradTech.armorQuartzLeggings, "QuartzLeggings");
		
		BradTech.armorQuartzBoots = new QuartzArmor(BradTech.matQuartzArmorMaterial, BradTech.armorIDQuartzBoots, 3).setUnlocalizedName("QuartzBoots");
		GameRegistry.registerItem(BradTech.armorQuartzBoots, "QuartzBoots");
		
		BradTech.itemSonicScrewdriver = new SonicScrewdriver().setUnlocalizedName("SonicScrewdriver");
		GameRegistry.registerItem(BradTech.itemSonicScrewdriver, "SonicScrewdriver");
	}
	
}

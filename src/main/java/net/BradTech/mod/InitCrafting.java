package net.BradTech.mod;

import net.BradTech.mod.crafting.MachinistsTableCraftingManager;
import net.BradTech.mod.crafting.RecipeRemover;
import net.BradTech.mod.handler.FuelHandler;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class InitCrafting {

	public static void SetupCraftingRecipes() {
		
		// Remove unwanted recipes.
		RecipeRemover.removeCraftingRecipes();

		
		// Modified Vanilla Recipes
		// {
			GameRegistry.addRecipe(new ItemStack(Items.book), new Object[]{"LPP", "LPP", "LPP", 'L', Items.leather, 'P', Items.paper});
			
		// }
		
		
		// BradTech Recipes
		// {
			// Shaped Recipes
			GameRegistry.addRecipe(new ItemStack(BradTech.blockCopperBlock), new Object[]{"CCC", "CCC", "CCC", 'C', BradTech.itemCopperIngot});
			GameRegistry.addRecipe(new ItemStack(BradTech.blockTinBlock), new Object[]{"CCC", "CCC", "CCC", 'C', BradTech.itemTinIngot});
			GameRegistry.addRecipe(new ItemStack(BradTech.blockNickelBlock), new Object[]{"CCC", "CCC", "CCC", 'C', BradTech.itemNickelIngot});
			GameRegistry.addRecipe(new ItemStack(BradTech.blockAluminumBlock), new Object[]{"CCC", "CCC", "CCC", 'C', BradTech.itemAluminumIngot});
			GameRegistry.addRecipe(new ItemStack(BradTech.blockPlatinumBlock), new Object[]{"CCC", "CCC", "CCC", 'C', BradTech.itemPlatinumIngot});
			GameRegistry.addRecipe(new ItemStack(BradTech.blockUraniumBlock), new Object[]{"CCC", "CCC", "CCC", 'C', BradTech.itemUraniumIngot});
			GameRegistry.addRecipe(new ItemStack(BradTech.blockBronzeBlock), new Object[]{"CCC", "CCC", "CCC", 'C', BradTech.itemBronzeIngot});
			GameRegistry.addRecipe(new ItemStack(BradTech.blockSteelBlock), new Object[]{"CCC", "CCC", "CCC", 'C', BradTech.itemSteelIngot});
			
			
			GameRegistry.addRecipe(new ItemStack(BradTech.itemWoodCog), new Object[]{" S ", "SFS", " S ", 'S', Items.stick, 'F', Items.flint});
			GameRegistry.addRecipe(new ItemStack(BradTech.itemStoneCog), new Object[]{" S ", "SWS", " S ", 'S', Blocks.stone, 'W', BradTech.itemWoodCog});
			GameRegistry.addRecipe(new ItemStack(BradTech.itemAluminumCog), new Object[]{" A ", "ASA", " A ", 'A', BradTech.itemAluminumIngot, 'S', BradTech.itemStoneCog});
			GameRegistry.addRecipe(new ItemStack(BradTech.itemTinCog), new Object[]{" T ", "TST", " T ", 'T', BradTech.itemTinIngot, 'S', BradTech.itemStoneCog});
			GameRegistry.addRecipe(new ItemStack(BradTech.itemIronCog), new Object[]{" I ", "IAI", " I ", 'I', Items.iron_ingot, 'A', BradTech.itemAluminumCog});
			GameRegistry.addRecipe(new ItemStack(BradTech.itemIronCog), new Object[]{" I ", "ITI", " I ", 'I', Items.iron_ingot, 'T', BradTech.itemTinCog});
			GameRegistry.addRecipe(new ItemStack(BradTech.itemBronzeCog), new Object[]{" B ", "BIB", " B ", 'B', BradTech.itemBronzeIngot, 'I', BradTech.itemIronCog});
			GameRegistry.addRecipe(new ItemStack(BradTech.itemDiamondCog), new Object[]{" D ", "DBD", " D ", 'D', Items.diamond, 'B', BradTech.itemBronzeCog});
			
			GameRegistry.addRecipe(new ItemStack(BradTech.itemLaminate, 4), new Object[]{"PP", "PP", 'P', BradTech.itemPlastic});
			GameRegistry.addRecipe(new ItemStack(BradTech.blockInsulatedCopperWire, 3), new Object[]{"RRR", "CCC", "RRR", 'R', BradTech.itemProcessedRubber, 'C', BradTech.itemCopperWire});
			
			GameRegistry.addRecipe(new ItemStack(BradTech.blockMachinistsTable), new Object[]{"III", "WWW","WWW", 'I', Items.iron_ingot, 'W', Blocks.planks});
			
	
			// Tool Recipes
			GameRegistry.addRecipe(new ItemStack(BradTech.itemIronExtruder), new Object[]{" II", " II", "S  ", 'I', Items.iron_ingot, 'S', Items.stick});
			GameRegistry.addRecipe(new ItemStack(BradTech.itemQuartzSword), new Object[]{" Q ", " Q ", " S ", 'Q', BradTech.itemBlueQuartzGem, 'S', Items.stick});
			GameRegistry.addRecipe(new ItemStack(BradTech.itemQuartzPickAxe), new Object[]{"QQQ", " S ", " S ", 'Q', BradTech.itemBlueQuartzGem, 'S', Items.stick});
			GameRegistry.addRecipe(new ItemStack(BradTech.itemQuartzShovel), new Object[]{" Q ", " S ", " S ", 'Q', BradTech.itemBlueQuartzGem, 'S', Items.stick});
			GameRegistry.addRecipe(new ItemStack(BradTech.itemQuartzAxe), new Object[]{"QQ ", "QS ", " S ", 'Q', BradTech.itemBlueQuartzGem, 'S', Items.stick});
			GameRegistry.addRecipe(new ItemStack(BradTech.itemQuartzHoe), new Object[]{"QQ ", " S ", " S ", 'Q', BradTech.itemBlueQuartzGem, 'S', Items.stick});
			GameRegistry.addRecipe(new ItemStack(BradTech.armorQuartzHelmet), new Object[]{"   ", "QQQ", "Q Q", 'Q', BradTech.itemBlueQuartzGem});
			GameRegistry.addRecipe(new ItemStack(BradTech.armorQuartzChestplate), new Object[]{"Q Q", "QQQ", "QQQ", 'Q', BradTech.itemBlueQuartzGem});
			GameRegistry.addRecipe(new ItemStack(BradTech.armorQuartzLeggings), new Object[]{"QQQ", "Q Q", "Q Q", 'Q', BradTech.itemBlueQuartzGem});
			GameRegistry.addRecipe(new ItemStack(BradTech.armorQuartzBoots), new Object[]{"   ", "Q Q", "Q Q", 'Q', BradTech.itemBlueQuartzGem});
			
			
			// Shapeless Recipes
			GameRegistry.addShapelessRecipe(new ItemStack(BradTech.itemBronzeIngot, 4), new Object[]{BradTech.itemCopperIngot, BradTech.itemCopperIngot, BradTech.itemCopperIngot, BradTech.itemTinIngot});
			GameRegistry.addShapelessRecipe(new ItemStack(BradTech.blockBronzeBlock, 4), new Object[]{BradTech.blockCopperBlock, BradTech.blockCopperBlock, BradTech.blockCopperBlock, BradTech.blockTinBlock});
			
			
			// Tool Use Recipes
			GameRegistry.addRecipe(new ItemStack(BradTech.itemCopperWire, 6), new Object[]{"EC", 'E', new ItemStack(BradTech.itemIronExtruder, 1, OreDictionary.WILDCARD_VALUE), 'C', BradTech.itemCopperIngot});
		
			
			// Machine Recipes
			GameRegistry.addRecipe(new ItemStack(BradTech.blockForgeOvenIdle), new Object[]{"III", "I I", "III", 'I', Items.iron_ingot});
			GameRegistry.addRecipe(new ItemStack(BradTech.blockForgeOvenIdle), new Object[]{" I ", "I I", "IFI", 'I', Items.iron_ingot, 'F', Blocks.furnace});
		// }

		// Machinist's Table Recipes (5x5)
		// {
			MachinistsTableCraftingManager.getInstance().addRecipe(new ItemStack(BradTech.itemSonicScrewdriver, 1), new Object[] { "EQ   ", "QNB  ", " BSB ", "  BSB", "   BB", 'E', Items.emerald, 'Q', BradTech.itemBlueQuartzGem, 'N', BradTech.itemNickelIngot, 'B', BradTech.itemBronzeIngot, 'S', Items.stick });
		// }
	}
	
	
	public static void SetupSmeltingRecipes() {
		RecipeRemover.removeSmeltingRecipes();
	
		
		// Modified Vanilla Recipes
		// {
			/*	I was going to change the smelting recipes to give two ingots. I reset it back to default when I added Nether Ores.
			GameRegistry.addSmelting(Blocks.iron_ore, new ItemStack(Items.iron_ingot, 2), 1.0F);
			GameRegistry.addSmelting(Blocks.gold_ore, new ItemStack(Items.gold_ingot, 2), 1.0F);
			*/
		// }
		
		
		// BradTech Recipes
		// {
			// BradTech Ores
			GameRegistry.addSmelting(BradTech.oreCopperOre, new ItemStack(BradTech.itemCopperIngot), 1.0F);
			GameRegistry.addSmelting(BradTech.oreTinOre, new ItemStack(BradTech.itemTinIngot), 1.0F);
			GameRegistry.addSmelting(BradTech.oreNickelOre, new ItemStack(BradTech.itemNickelIngot), 1.0F);
			GameRegistry.addSmelting(BradTech.oreAluminumOre, new ItemStack(BradTech.itemAluminumIngot), 1.0F);
			GameRegistry.addSmelting(BradTech.orePlatinumOre, new ItemStack(BradTech.itemPlatinumIngot), 1.5F);
			GameRegistry.addSmelting(BradTech.oreUraniumOre, new ItemStack(BradTech.itemUraniumIngot), 2.0F);
			
			// BradTech Nether Ores
			GameRegistry.addSmelting(BradTech.oreNetherIronOre, new ItemStack(Items.iron_ingot, 2), 1.0F);
			GameRegistry.addSmelting(BradTech.oreNetherGoldOre, new ItemStack(Items.gold_ingot, 2), 1.0F);
			GameRegistry.addSmelting(BradTech.oreNetherCopperOre, new ItemStack(BradTech.itemCopperIngot, 2), 1.0F);
			GameRegistry.addSmelting(BradTech.oreNetherTinOre, new ItemStack(BradTech.itemTinIngot, 2), 1.0F);
			GameRegistry.addSmelting(BradTech.oreNetherNickelOre, new ItemStack(BradTech.itemNickelIngot, 2), 1.0F);
			GameRegistry.addSmelting(BradTech.oreNetherAluminumOre, new ItemStack(BradTech.itemAluminumIngot, 2), 1.0F);
			GameRegistry.addSmelting(BradTech.oreNetherPlatinumOre, new ItemStack(BradTech.itemPlatinumIngot, 2), 1.5F);
			GameRegistry.addSmelting(BradTech.oreNetherUraniumOre, new ItemStack(BradTech.itemUraniumIngot, 2), 2.0F);
			
			// BradTech Rubber/Plastic
			GameRegistry.addSmelting(BradTech.itemRawRubber, new ItemStack(BradTech.itemProcessedRubber), 0.5F);
			GameRegistry.addSmelting(BradTech.itemProcessedRubber, new ItemStack(BradTech.itemPlastic), 0.5F);
		// }
	}
	
	
	public static void SetupFuelSources() {

		GameRegistry.registerFuelHandler(new FuelHandler());
		
	}
	
}

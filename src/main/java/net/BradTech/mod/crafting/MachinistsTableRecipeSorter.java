package net.BradTech.mod.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class MachinistsTableRecipeSorter implements Comparator {
	
	final MachinistsTableCraftingManager machinistsTable;

	
	public MachinistsTableRecipeSorter(MachinistsTableCraftingManager machinistsTableCraftingManager) {
		this.machinistsTable = machinistsTableCraftingManager;
	}
	
	
	public int compareRecipies(IRecipe recipe1, IRecipe recipe2) {
		return recipe1 instanceof MachinistsTableShapelessRecipes && recipe2 instanceof MachinistsTableShapedRecipes ? 1 : (recipe2 instanceof MachinistsTableShapelessRecipes && recipe1 instanceof MachinistsTableShapedRecipes ? -1 : (recipe2.getRecipeSize() > recipe1.getRecipeSize() ? -1 : (recipe2.getRecipeSize() > recipe1.getRecipeSize() ? 1 : 0)));
	}
	
	
	@Override
	public int compare(Object recipe1, Object recipe2) {
		return this.compareRecipies((IRecipe)recipe1, (IRecipe)recipe2);
	}

}

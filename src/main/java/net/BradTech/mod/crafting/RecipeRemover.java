package net.BradTech.mod.crafting;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;

public class RecipeRemover {

	public static void removeCraftingRecipes() {
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		
		Iterator<IRecipe> remover = recipes.iterator();
		
		while(remover.hasNext()) {
			ItemStack itemStack = remover.next().getRecipeOutput();
			
			if(itemStack != null && itemStack.getItem() == Items.book)
				remover.remove();
			//else if(itemStack != null && itemStack.getItem() == Item.getItemFromBlock(Blocks.furnace))
			//	remover.remove();
			
		}
	}

	
	public static void removeSmeltingRecipes() {
		Map<ItemStack, ItemStack> smeltingRecipes = FurnaceRecipes.smelting().getSmeltingList();
		Iterator iterator = smeltingRecipes.entrySet().iterator();
		Entry entry;
		ItemStack input;
		ItemStack output;
		
		while(iterator.hasNext()) {
			entry = (Entry)iterator.next();			
			
			if(entry != null) {
				input = (ItemStack)entry.getKey();
				output = (ItemStack)entry.getValue();
				
				if(input != null && output != null) {
					/*	I was going to change the smelting recipes to give two ingots. I reset it back to default when I added Nether Ores.
					if(input.getItem() == Item.getItemFromBlock(Blocks.iron_ore) && output.getItem() == Items.iron_ingot)
						iterator.remove();
					else if(input.getItem() == Item.getItemFromBlock(Blocks.gold_ore) && output.getItem() == Items.gold_ingot)
						iterator.remove();
					*/
				}
			}
		}
	}
	
}










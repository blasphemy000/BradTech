package net.BradTech.mod.handler;

import net.BradTech.mod.BradTech;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler {

	@Override
	public int getBurnTime(ItemStack fuel) {
		
		if(fuel.getItem() == BradTech.itemRawRubber)
			return 400;
		
		return 0;
	}
	
	
	public int getItemBurnTime(Item fuel) {
		
		if(fuel == BradTech.itemRawRubber)
			return 400;
		
		return 0;
	}

}

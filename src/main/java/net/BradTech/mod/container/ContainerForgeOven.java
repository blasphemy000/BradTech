package net.BradTech.mod.container;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.BradTech.mod.tileentity.TileEntityForgeOven;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;

public class ContainerForgeOven extends Container {

	private TileEntityForgeOven forgeOven;
	public int lastBurnTime;				// The number of ticks that the furnace will keep burning.
	public int lastCurrentItemBurnTime;		// The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for.
	public int lastCookTime;				// The number of ticks that the current item has been cooking for.

	
	public ContainerForgeOven(InventoryPlayer inventory, TileEntityForgeOven tileEntity) {
		this.forgeOven = tileEntity;
		
		this.addSlotToContainer(new Slot(tileEntity, 0, 51, 21));
		this.addSlotToContainer(new Slot(tileEntity, 1, 54, 50));
		this.addSlotToContainer(new SlotFurnace(inventory.player, tileEntity, 2, 109, 22));
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++){
				this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for(int i = 0; i < 9; i++) {
			this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
		}
	}
	
	
	public void addCraftingToCrafters(ICrafting crafting) {
		super.addCraftingToCrafters(crafting);
		
		crafting.sendProgressBarUpdate(this, 0, this.forgeOven.cookTime);
		crafting.sendProgressBarUpdate(this, 1, this.forgeOven.burnTime);
		crafting.sendProgressBarUpdate(this, 2, this.forgeOven.currentItemBurnTime);
	}
	
	
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
		
		for(int i = 0; i < this.crafters.size(); i++) {
			ICrafting crafting = (ICrafting)this.crafters.get(i);
			
			if(this.lastCookTime != this.forgeOven.cookTime)
				crafting.sendProgressBarUpdate(this, 0, this.forgeOven.cookTime);

			if(this.lastBurnTime != this.forgeOven.cookTime)
				crafting.sendProgressBarUpdate(this, 1, this.forgeOven.burnTime);

			if(this.lastCurrentItemBurnTime != this.forgeOven.cookTime)
				crafting.sendProgressBarUpdate(this, 2, this.forgeOven.currentItemBurnTime);
		}
		
		this.lastCookTime = this.forgeOven.cookTime;
		this.lastBurnTime = this.forgeOven.burnTime;
		this.lastCurrentItemBurnTime = this.forgeOven.currentItemBurnTime;
	}
	
	
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int slot, int newValue) {
		if(slot == 0)
			this.forgeOven.cookTime = newValue;
		
		if(slot == 1)
			this.forgeOven.burnTime = newValue;
		
		if(slot == 2)
			this.forgeOven.currentItemBurnTime = newValue;
	}
	
	
	@Override
	public boolean canInteractWith(EntityPlayer entityPlayer) {
		return true;
	}
	
	
    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (par2 == 2) {
                if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (par2 != 1 && par2 != 0) {
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null) {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false)) {
                        return null;
                    }
                } else if (TileEntityForgeOven.isItemFuel(itemstack1)) {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false)) {
                        return null;
                    }
                } else if (par2 >= 3 && par2 < 30) {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false)) {
                        return null;
                    }
                } else if (par2 >= 30 && par2 < 39 && !this.mergeItemStack(itemstack1, 3, 30, false)) {
                    return null;
                }
            } else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
                return null;
            }

            if (itemstack1.stackSize == 0)
                slot.putStack((ItemStack)null);
            else
                slot.onSlotChanged();

            if (itemstack1.stackSize == itemstack.stackSize)
                return null;

            slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
        }

        return itemstack;
    }
}





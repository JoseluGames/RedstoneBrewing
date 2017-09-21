package com.jlgm.redbrew.inventory;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerAutomaticBrewer extends Container{
	
	private final IItemHandler automaticBrewerInventory;
	
	public ContainerAutomaticBrewer(IInventory playerInventory, IItemHandler automaticBrewerInventory) {
		this.automaticBrewerInventory = automaticBrewerInventory;
		
		//Automatic brewer inventory
		for(int i = 0; i < 9; ++i) {
			this.addSlotToContainer(new SlotItemHandler(automaticBrewerInventory, i, 8 + i * 18, 80));
		}
		
		//Automatic brewer brew inventory
		for(int i = 0; i < 4; ++i) {
			this.addSlotToContainer(new SlotItemHandler(automaticBrewerInventory, 9 + i, 50 + i * 20, 4));
		}
		
		//Tank inventory
		this.addSlotToContainer(new SlotItemHandler(automaticBrewerInventory, 13, 8, 60));
		
		this.addSlotToContainer(new SlotItemHandler(automaticBrewerInventory, 14, 134, 60));
		
		this.addSlotToContainer(new SlotItemHandler(automaticBrewerInventory, 15, 152, 60));
		
		// Player inventory
		for(int i = 0; i < 3; ++i){
			for(int j = 0; j < 9; ++j){
				this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 112 + i * 18));
			}
		}
		
		// Player hotbar
		for(int i = 0; i < 9; ++i){
			this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 112 + 3 * 18 + 4));
		}
	}
	
	@Nullable
	@Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < 16)
            {
                if (!this.mergeItemStack(itemstack1, 16, this.inventorySlots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, 16, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }
	
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return true;
	}
}

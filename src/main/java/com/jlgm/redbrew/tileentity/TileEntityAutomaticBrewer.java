package com.jlgm.redbrew.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.world.IWorldNameable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityAutomaticBrewer extends TileEntity implements ITickable, IWorldNameable{
	
	public ItemStackHandler inventoryLogic;
	
	public TileEntityAutomaticBrewer() {
		this.inventoryLogic = new ItemStackHandler(16);
	}
	
	@Override	
	public String getName() {
		return "Automatic Brewer";
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
	public void update() {
		
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound tagCompound){
		super.writeToNBT(tagCompound);
		tagCompound.setTag("InventoryLogic", this.inventoryLogic.serializeNBT());
		return tagCompound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tagCompound){
		super.readFromNBT(tagCompound);
		this.inventoryLogic.deserializeNBT(tagCompound.getCompoundTag("InventoryLogic"));
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> T getCapability(Capability<T> capability, EnumFacing facing){
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
			return (T) this.inventoryLogic;
		}
		return super.getCapability(capability, facing);
	}
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing){
		if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
			return true;
		}
		return super.hasCapability(capability, facing);
	}
}

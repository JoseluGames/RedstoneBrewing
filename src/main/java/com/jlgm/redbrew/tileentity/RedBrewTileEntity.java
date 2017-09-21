package com.jlgm.redbrew.tileentity;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class RedBrewTileEntity{
	public static void registerTileEntity(){
		GameRegistry.registerTileEntity(TileEntityAutomaticBrewer.class, "automaticBrewer_tileEntity");
	}
}

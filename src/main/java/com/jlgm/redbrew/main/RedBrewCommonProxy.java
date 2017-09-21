package com.jlgm.redbrew.main;

import com.jlgm.redbrew.block.RedBrewBlock;
import com.jlgm.redbrew.client.gui.RedBrewGuiHandler;
//import com.jlgm.redbrew.network.RedBrewPacketHandler;
import com.jlgm.redbrew.tileentity.RedBrewTileEntity;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod.EventBusSubscriber
public class RedBrewCommonProxy{

	public void preInit(FMLPreInitializationEvent preInitEvent){
		//RedBrewPacketHandler.registerMessage();
		RedBrewTileEntity.registerTileEntity();
	}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event){
		RedBrewBlock.registerBlocks(event);
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event){
		RedBrewBlock.registerItemBlocks(event);
	}
	

	public void init(FMLInitializationEvent initEvent){
		NetworkRegistry.INSTANCE.registerGuiHandler(RedBrewMain.instance, new RedBrewGuiHandler());
	}

	public void postInit(FMLPostInitializationEvent postInitEvent){

	}
}

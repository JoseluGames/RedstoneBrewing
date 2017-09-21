package com.jlgm.redbrew.main;

import com.jlgm.redbrew.lib.RedBrewConstants;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = RedBrewConstants.MODID,
	name = RedBrewConstants.NAME,
	version = RedBrewConstants.VERSION,
	acceptedMinecraftVersions = RedBrewConstants.ACCEPTEDMINECRAFTVERSIONS,
	updateJSON = RedBrewConstants.UPDATEJSON)

public class RedBrewMain{

	@SidedProxy(clientSide = RedBrewConstants.CLIENT_PROXY, serverSide = RedBrewConstants.SERVER_PROXY)
	public static RedBrewCommonProxy proxy;
	@Mod.Instance(RedBrewConstants.MODID)
	public static RedBrewMain instance;

	@Mod.EventHandler
	public static void PreInit(FMLPreInitializationEvent preInitEvent){
		proxy.preInit(preInitEvent);
	}

	@Mod.EventHandler
	public static void Init(FMLInitializationEvent initEvent){
		proxy.init(initEvent);
	}

	@Mod.EventHandler
	public static void PostInit(FMLPostInitializationEvent postInitEvent){
		proxy.postInit(postInitEvent);
	}
}

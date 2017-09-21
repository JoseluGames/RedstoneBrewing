package com.jlgm.redbrew.main;

import com.jlgm.redbrew.block.RedBrewBlock;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class RedBrewClientProxy extends RedBrewCommonProxy{

	@Override
	public void preInit(FMLPreInitializationEvent preInitEvent){
		super.preInit(preInitEvent);
	}

	@Override
	public void init(FMLInitializationEvent initEvent){
		super.init(initEvent);
		RedBrewBlock.renderBlock();
	}

	@Override
	public void postInit(FMLPostInitializationEvent postInitEvent){
		super.postInit(postInitEvent);
	}
}

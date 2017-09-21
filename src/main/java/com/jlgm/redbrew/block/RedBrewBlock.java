package com.jlgm.redbrew.block;

import com.jlgm.redbrew.lib.RedBrewConstants;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;

public class RedBrewBlock{
	
	public static Block automaticBrewer_Block;
	public static ItemBlock automaticBrewer_ItemBlock;
	
	public static void registerBlocks(RegistryEvent.Register<Block> event){
		automaticBrewer_Block = new BlockAutomaticBrewer(Material.ROCK).setUnlocalizedName("automaticbrewer").setHardness(0.7F).setResistance(0.5F).setCreativeTab(CreativeTabs.REDSTONE);
		event.getRegistry().register(automaticBrewer_Block.setRegistryName("automaticbrewer"));
	}

	public static void registerItemBlocks(RegistryEvent.Register<Item> event){
		automaticBrewer_ItemBlock = new ItemBlock(automaticBrewer_Block);
		event.getRegistry().register(automaticBrewer_ItemBlock.setRegistryName(automaticBrewer_Block.getRegistryName()));
	}
	
	public static void renderBlock(){
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		
		renderItem.getItemModelMesher().register(automaticBrewer_ItemBlock, 0,
				new ModelResourceLocation(RedBrewConstants.MODID + ":" + "automaticbrewer", "inventory"));
		
	}
}

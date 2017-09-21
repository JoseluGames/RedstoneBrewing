package com.jlgm.redbrew.block;

import com.jlgm.redbrew.client.gui.RedBrewGuiHandler;
import com.jlgm.redbrew.main.RedBrewMain;
import com.jlgm.redbrew.tileentity.TileEntityAutomaticBrewer;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockAutomaticBrewer extends BlockContainer{

	protected BlockAutomaticBrewer(Material materialIn) {
		super(materialIn);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ){
		if(worldIn.isRemote){
			playerIn.openGui(RedBrewMain.instance, RedBrewGuiHandler.GUI_ID, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state){
		return EnumBlockRenderType.MODEL;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityAutomaticBrewer();
	}
}

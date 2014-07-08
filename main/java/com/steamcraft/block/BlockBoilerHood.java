package com.steamcraft.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.steamcraft.SteamCraft;
import com.steamcraft.tileentity.TileEntityBoilerHood;
import com.steamcraft.tileentity.TileEntitySteamPipe;

public class BlockBoilerHood extends BlockContainer {
	protected BlockBoilerHood() {
		super(Material.iron);
		setCreativeTab(SteamCraft.tabSteamCraft);
		setHardness(3F);
		setResistance(5F);
		setBlockName("boilerHood");
		setBlockTextureName("steamcraft:BoilerHood");
	}
	
	public boolean isOpaqueCube() {
		return false;
	}

	// You don't want the normal render type, or it wont render properly.
	@Override
	public int getRenderType() {
		return -1;
	}

	// It's not a normal block, so you need this too.
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World paramWorld, int paramInt) {
		// TODO Auto-generated method stub
		return new TileEntityBoilerHood();
	}
}

package com.steamcraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;

import com.steamcraft.SteamCraft;
import com.steamcraft.fluid.SteamCraftFluid;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSteamFluid extends BlockFluidClassic {
	
	@SideOnly(Side.CLIENT)
	protected IIcon theIcon;
	
	public BlockSteamFluid() {
		super(SteamCraftFluid.fluidSteam, Material.water);
		setCreativeTab(SteamCraft.tabSteamCraft);
		setBlockName("steamBlock");
		setBlockTextureName("steamcraft:Steam");
	}

	@Override
	public boolean canDisplace(IBlockAccess world, int x, int y, int z) {
		if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
		return super.canDisplace(world, x, y, z);
	}

	@Override
	public boolean displaceIfPossible(World world, int x, int y, int z) {
		if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) return false;
		return super.displaceIfPossible(world, x, y, z);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		theIcon = par1IconRegister.registerIcon(SteamCraft.MODID + ":" + "Steam");
	}
	
	@Override
	public IIcon getIcon(int i, int j) {
		return theIcon;
	}
}

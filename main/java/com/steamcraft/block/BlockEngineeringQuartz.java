package com.steamcraft.block;

import com.steamcraft.SteamCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockEngineeringQuartz extends Block{
	public BlockEngineeringQuartz(){
		super(Material.rock);
		setCreativeTab(SteamCraft.tabSteamCraft);
		setHardness(3F);
		setResistance(5F);
		setBlockName("engineeringQuartzBlock");
		setBlockTextureName("steamcraft:engineeringQuartzBlock");
	}
}

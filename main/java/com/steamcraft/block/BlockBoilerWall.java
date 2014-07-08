package com.steamcraft.block;

import com.steamcraft.SteamCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBoilerWall extends Block {
	public BlockBoilerWall(){
		super(Material.iron);
		setCreativeTab(SteamCraft.tabSteamCraft);
		setHardness(3F);
		setResistance(5F);
		setBlockName("boilerWall");
		setBlockTextureName("steamcraft:boilerWall");
	}
}

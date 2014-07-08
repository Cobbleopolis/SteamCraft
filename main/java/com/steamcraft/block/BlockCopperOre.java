package com.steamcraft.block;

import com.steamcraft.SteamCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCopperOre extends Block {
	public BlockCopperOre(){
		super(Material.rock);
		setCreativeTab(SteamCraft.tabSteamCraft);
		setHardness(3F);
		setResistance(5F);
		setBlockName("copperOre");
		setBlockTextureName("steamcraft:oreCopper");
	}
}

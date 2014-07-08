package com.steamcraft.block;

import com.steamcraft.SteamCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockZincOre extends Block {
	public BlockZincOre(){
		super(Material.rock);
		setCreativeTab(SteamCraft.tabSteamCraft);
		setHardness(3F);
		setResistance(5F);
		setBlockName("zincOre");
		setBlockTextureName("steamcraft:oreZinc");
	}
}

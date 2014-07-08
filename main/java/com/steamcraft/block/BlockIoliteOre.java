package com.steamcraft.block;

import java.util.Random;

import com.steamcraft.SteamCraft;
import com.steamcraft.item.SteamCraftItem;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockIoliteOre extends Block {
	public BlockIoliteOre(){
		super(Material.rock);
		setCreativeTab(SteamCraft.tabSteamCraft);
		setHardness(3F);
		setResistance(5F);
		setBlockName("ioliteOre");
		setBlockTextureName("steamcraft:oreIolite");
	}
	
	public Item getItemDropped(int int1, Random rand,
			int int2) {
		return SteamCraftItem.gemIolite;
	}

	public int quantityDroppedWithBonus(int base, Random rand) {
		return (quantityDropped(rand) + rand
				.nextInt(base + 1));
	}

	public int quantityDropped(Random rand) {
		return (4 + rand.nextInt(2));
	}
}

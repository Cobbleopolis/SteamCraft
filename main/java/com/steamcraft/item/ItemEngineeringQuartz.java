package com.steamcraft.item;

import com.steamcraft.SteamCraft;

import net.minecraft.item.Item;

public class ItemEngineeringQuartz extends Item {
	public ItemEngineeringQuartz(){
		setCreativeTab(SteamCraft.tabSteamCraft);
		setUnlocalizedName("engineeringQuartz");
		setTextureName("steamcraft:engineeringQuartz");
	}
}

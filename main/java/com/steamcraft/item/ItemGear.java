package com.steamcraft.item;

import com.steamcraft.SteamCraft;

import net.minecraft.item.Item;

public class ItemGear extends Item {
	public ItemGear(){
		setCreativeTab(SteamCraft.tabSteamCraft);
		setUnlocalizedName("gear");
		setTextureName("steamcraft:gear");
	}
}

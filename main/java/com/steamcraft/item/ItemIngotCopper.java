package com.steamcraft.item;

import com.steamcraft.SteamCraft;

import net.minecraft.item.Item;

public class ItemIngotCopper extends Item {
	public ItemIngotCopper(){
		setCreativeTab(SteamCraft.tabSteamCraft);
		setUnlocalizedName("ingotCopper");
		setTextureName("steamcraft:ingotCopper");
	}
}

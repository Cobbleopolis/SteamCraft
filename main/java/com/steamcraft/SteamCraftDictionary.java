package com.steamcraft;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.steamcraft.item.SteamCraftItem;

public class SteamCraftDictionary {
	public static void loadOreDictionary() {
		OreDictionary.registerOre("ingotCopper", new ItemStack(SteamCraftItem.ingotCopper));
		OreDictionary.registerOre("ingotZinc", new ItemStack(SteamCraftItem.ingotZinc));
		OreDictionary.registerOre("ingotBrass", new ItemStack(SteamCraftItem.ingotBrass));
	}
}

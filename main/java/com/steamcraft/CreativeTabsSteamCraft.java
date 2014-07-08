package com.steamcraft;

import com.steamcraft.block.SteamCraftBlock;
import com.steamcraft.item.SteamCraftItem;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabsSteamCraft extends CreativeTabs {

	public CreativeTabsSteamCraft(String tabLabel) {
		super(tabLabel);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return Item.getItemFromBlock(SteamCraftBlock.gearBox);
	}

}

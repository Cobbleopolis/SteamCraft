package com.steamcraft.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

import com.steamcraft.SteamCraft;
import com.steamcraft.block.SteamCraftBlock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSteamBucket extends ItemBucket {
	public ItemSteamBucket() {
		super(SteamCraftBlock.blockSteamFluid);
		setCreativeTab(SteamCraft.tabSteamCraft);
		setUnlocalizedName("steamBucket");
		setContainerItem(Items.bucket);
		setTextureName("steamcraft:bucketSteam");
	}
}

package com.steamcraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.steamcraft.SteamCraft;
import com.steamcraft.tileentity.TileEntitySteamPipe;

public class ItemTestPipe extends Item {
	public ItemTestPipe() {
		setCreativeTab(SteamCraft.tabSteamCraft);
		setUnlocalizedName("testPipeItem");
		setTextureName("steamcraft:ingotBrass");
	}

	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer entityPlayer,
			World world, int x, int y, int z, int sideHit, float hitVecX,
			float hitVecY, float hitVecZ) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if (world.isRemote && tile == new TileEntitySteamPipe()) {
			tile = (TileEntitySteamPipe) tile;
		}
		return true;
	}
}

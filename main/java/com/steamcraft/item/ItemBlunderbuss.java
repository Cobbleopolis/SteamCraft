package com.steamcraft.item;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.steamcraft.SteamCraft;
import com.steamcraft.entity.EntityBlunderbussShot;

public class ItemBlunderbuss extends Item {
	public ItemBlunderbuss() {
		setCreativeTab(SteamCraft.tabSteamCraft);
		setUnlocalizedName("blunderbuss");
		setTextureName("steamcraft:ingotBlunderbuss");
	}

	public ItemStack onItemRightClick(ItemStack itemStack, World world,
			EntityPlayer player) {
		if (player.capabilities.isCreativeMode
				|| player.inventory.hasItem(SteamCraftItem.brassBallBearing)) {
			if (!player.capabilities.isCreativeMode) {
				player.inventory
						.consumeInventoryItem(SteamCraftItem.brassBallBearing);
			}
			world.playSoundAtEntity(player, "steamcraft:shotgunshot", 6F,
					0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!world.isRemote) {
				world.spawnEntityInWorld(new EntityBlunderbussShot(world,
						(EntityLivingBase) player));
			}
		} else {
			world.playSoundAtEntity(player, "steamcraft:reload", 6F,
					0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		}
		return itemStack;
	}
}

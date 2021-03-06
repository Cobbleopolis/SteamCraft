package com.steamcraft.event;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.steamcraft.block.SteamCraftBlock;
import com.steamcraft.item.SteamCraftItem;
import com.steamcraft.tileentity.TileEntitySteamPipe;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class BucketHandler {

	public static BucketHandler INSTANCE = new BucketHandler();
	public Map<Block, Item> buckets = new HashMap<Block, Item>();

	private BucketHandler() {
	}

	@SubscribeEvent
	public void onBucketFill(FillBucketEvent event) {
		ItemStack result = fillCustomBucket(event.world, event.target, event.current, event.entityPlayer);

		if (result == null)
			return;

		event.result = result;
		event.setResult(Result.ALLOW);
	}

	private ItemStack fillCustomBucket(World world, MovingObjectPosition pos, ItemStack current, EntityPlayer player) {

		ItemStack out = current;
		
		Block block = world.getBlock(pos.blockX, pos.blockY, pos.blockZ);

		if (current.getItem() == Items.bucket
				&& world.getBlockMetadata(pos.blockX, pos.blockY, pos.blockZ) == 0 && block == SteamCraftBlock.blockSteamFluid) {
			world.setBlockToAir(pos.blockX, pos.blockY, pos.blockZ);
			out = new ItemStack(SteamCraftItem.steamBucket);
		} else {
			out = null;
		}
		return out;
	}
}

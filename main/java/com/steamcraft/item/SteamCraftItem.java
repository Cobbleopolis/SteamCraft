package com.steamcraft.item;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidStack;

import com.steamcraft.fluid.SteamCraftFluid;

import cpw.mods.fml.common.registry.GameRegistry;

public class SteamCraftItem {
	public static Item engineeringQuartz;
	public static Item gear;
	public static Item ingotCopper;
	public static Item ingotZinc;
	public static Item ingotBrass;
	public static Item gemIolite;
	public static Item steamBucket;
	public static Item testPipe;
	public static Item blunderbuss;
	public static Item brassBallBearing;

	public static void initItem() {
		engineeringQuartz = new ItemEngineeringQuartz();
		gear = new ItemGear();
		ingotCopper = new ItemIngotCopper();
		ingotZinc = new ItemIngotZinc();
		ingotBrass = new ItemIngotBrass();
		gemIolite = new ItemGemIolite();
		steamBucket = new ItemSteamBucket();
		testPipe = new ItemTestPipe();
		blunderbuss = new ItemBlunderbuss();
		brassBallBearing = new ItemBrassBallBearing();
	}

	public static void registerItem() {
		GameRegistry.registerItem(engineeringQuartz,
				engineeringQuartz.getUnlocalizedName());
		GameRegistry.registerItem(gear, gear.getUnlocalizedName());
		GameRegistry
				.registerItem(ingotCopper, ingotCopper.getUnlocalizedName());
		GameRegistry.registerItem(ingotZinc, ingotZinc.getUnlocalizedName());
		GameRegistry.registerItem(ingotBrass, ingotBrass.getUnlocalizedName());
		GameRegistry.registerItem(gemIolite, gemIolite.getUnlocalizedName());
		GameRegistry
				.registerItem(steamBucket, steamBucket.getUnlocalizedName());
		FluidContainerRegistry.registerFluidContainer(new FluidStack(
				SteamCraftFluid.fluidSteam,
				FluidContainerRegistry.BUCKET_VOLUME), new ItemStack(
				steamBucket), new ItemStack(Items.bucket));
		GameRegistry
		.registerItem(testPipe, testPipe.getUnlocalizedName());
		GameRegistry
		.registerItem(blunderbuss, blunderbuss.getUnlocalizedName());
		GameRegistry
		.registerItem(brassBallBearing, brassBallBearing.getUnlocalizedName());
	}
}

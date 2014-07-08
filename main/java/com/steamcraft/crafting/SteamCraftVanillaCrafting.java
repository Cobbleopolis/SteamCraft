package com.steamcraft.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.oredict.ShapedOreRecipe;

import com.steamcraft.block.SteamCraftBlock;
import com.steamcraft.item.SteamCraftItem;

import cpw.mods.fml.common.registry.GameRegistry;

public class SteamCraftVanillaCrafting {
	public static void loadRecipes() {
		GameRegistry.addRecipe(new ItemStack(
				SteamCraftBlock.engineeringQuartzBlock), new Object[] { "QQQ",
				"QQQ", "QQQ", 'Q', SteamCraftItem.engineeringQuartz });
		GameRegistry.addRecipe(new ItemStack(SteamCraftBlock.copperBlock),
				new Object[] { "CCC", "CCC", "CCC", 'C',
						SteamCraftItem.ingotCopper });
		GameRegistry.addRecipe(new ItemStack(SteamCraftBlock.zincBlock),
				new Object[] { "ZZZ", "ZZZ", "ZZZ", 'Z',
						SteamCraftItem.ingotZinc });
		GameRegistry.addRecipe(new ItemStack(SteamCraftBlock.brassBlock),
				new Object[] { "BBB", "BBB", "BBB", 'B',
						SteamCraftItem.ingotBrass });
		GameRegistry.addRecipe(new ItemStack(SteamCraftBlock.ioliteBlock),
				new Object[] { "III", "III", "III", 'I',
						SteamCraftItem.gemIolite });
	}

	public static void loadOreRecipes() {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
				SteamCraftItem.ingotBrass, 4), true, new Object[] { "CC", "CZ",
				'C', "ingotCopper", 'Z', "ingotZinc" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(SteamCraftItem.gear, true,
				new Object[] { "-B-", "BSB", "-B-", 'B', "ingotBrass", 'S',
						Items.stick }));
		GameRegistry.addRecipe(new ShapedOreRecipe(SteamCraftBlock.gearBox,
				true, new Object[] { "PBP", "BGB", "PBP", 'B', "ingotBrass",
						'P', Blocks.planks, 'G', SteamCraftItem.gear }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
				SteamCraftItem.brassBallBearing, 16), true, new Object[] {
				"-B-", "BBB", "-B-", 'B', "ingotBrass" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
				SteamCraftBlock.boilerBase), true, new Object[] { "ZZZ", "ZBZ",
				"ZZZ", 'Z', "ingotZinc", 'B', "ingotBrass" }));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(
				SteamCraftBlock.boilerWall), true, new Object[] { "ZZZ", "ZCZ",
				"ZZZ", 'Z', "ingotZinc", 'C', "ingotCopper" }));
	}

	public static void loadFurnaceRecipes() {
		FurnaceRecipes.smelting().func_151393_a(
				SteamCraftBlock.engineeringQuartzOre,
				new ItemStack(SteamCraftItem.engineeringQuartz), 0.7F);
		FurnaceRecipes.smelting().func_151393_a(SteamCraftBlock.copperOre,
				new ItemStack(SteamCraftItem.ingotCopper), 0.7F);
		FurnaceRecipes.smelting().func_151393_a(SteamCraftBlock.zincOre,
				new ItemStack(SteamCraftItem.ingotZinc), 0.7F);
		FurnaceRecipes.smelting().func_151396_a(Items.water_bucket,
				new ItemStack(SteamCraftItem.steamBucket), 0.7F);
	}

}

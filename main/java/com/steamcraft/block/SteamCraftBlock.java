package com.steamcraft.block;

import net.minecraft.block.Block;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import com.steamcraft.fluid.SteamCraftFluid;
import com.steamcraft.tileentity.TileEntityBoiler;
import com.steamcraft.tileentity.TileEntityBoilerBase;
import com.steamcraft.tileentity.TileEntityBoilerHood;
import com.steamcraft.tileentity.TileEntitySteamPipe;

import cpw.mods.fml.common.registry.GameRegistry;

public class SteamCraftBlock {
	public static Block engineeringQuartzBlock;
	public static Block engineeringQuartzOre;
	public static Block copperOre;
	public static Block zincOre;
	public static Block ioliteOre;
	public static Block copperBlock;
	public static Block zincBlock;
	public static Block brassBlock;
	public static Block ioliteBlock;
	public static Block gearBox;
	public static Block blockSteamFluid;
	public static Block steamPipe;
	public static Block boilerBase;
	public static Block boilerWall;
	public static Block boilerHood;
	public static Block boiler;

	public static void initBlock() {
		engineeringQuartzOre = new BlockEngineeringQuartzOre();
		copperOre = new BlockCopperOre();
		zincOre = new BlockZincOre();
		ioliteOre = new BlockIoliteOre();
		engineeringQuartzBlock = new BlockEngineeringQuartz();
		copperBlock = new BlockCopper();
		zincBlock = new BlockZinc();
		brassBlock = new BlockBrass();
		ioliteBlock = new BlockIolite();
		gearBox = new BlockGearBox();
		blockSteamFluid = new BlockSteamFluid();
		steamPipe = new BlockSteamPipe();
		boilerBase = new BlockBoilerBase();
		boilerWall = new BlockBoilerWall();
		boilerHood = new BlockBoilerHood();
		boiler = new BlockBoiler();
	}

	public static void registerBlocks() {
		GameRegistry.registerBlock(engineeringQuartzOre,
				engineeringQuartzOre.getUnlocalizedName());
		GameRegistry.registerBlock(copperOre, copperOre.getUnlocalizedName());
		GameRegistry.registerBlock(zincOre, zincOre.getUnlocalizedName());
		GameRegistry.registerBlock(ioliteOre, ioliteOre.getUnlocalizedName());
		GameRegistry.registerBlock(engineeringQuartzBlock,
				engineeringQuartzBlock.getUnlocalizedName());
		GameRegistry.registerBlock(copperBlock,
				copperBlock.getUnlocalizedName());
		GameRegistry.registerBlock(zincBlock, zincBlock.getUnlocalizedName());
		GameRegistry.registerBlock(brassBlock, brassBlock.getUnlocalizedName());
		GameRegistry.registerBlock(ioliteBlock, ioliteBlock.getUnlocalizedName());
		GameRegistry.registerBlock(gearBox, gearBox.getUnlocalizedName());
		GameRegistry.registerBlock(blockSteamFluid, blockSteamFluid.getUnlocalizedName());
		GameRegistry.registerBlock(steamPipe, steamPipe.getUnlocalizedName());
		GameRegistry.registerBlock(boilerBase, boilerBase.getUnlocalizedName());
		GameRegistry.registerBlock(boilerWall, boilerWall.getUnlocalizedName());
		GameRegistry.registerBlock(boilerHood, boilerHood.getUnlocalizedName());
		GameRegistry.registerBlock(boiler, boiler.getUnlocalizedName());
		registerTileEntity();
	}

	public static void registerTileEntity() {
		GameRegistry.registerTileEntity(TileEntitySteamPipe.class,
				"containerSteamPipe");
		GameRegistry.registerTileEntity(TileEntityBoilerBase.class,
				"containerBoilerBase");
		GameRegistry.registerTileEntity(TileEntityBoilerHood.class,
				"containerBoilerHood");
		GameRegistry.registerTileEntity(TileEntityBoiler.class,
				"containerBoiler");
	}
}

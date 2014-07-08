package com.steamcraft.fluid;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import com.steamcraft.block.SteamCraftBlock;

public class SteamCraftFluid extends Fluid{
	
	private static Fluid steamCraftFluidSteam;
	public static Fluid fluidSteam;
	
	
	
	public SteamCraftFluid(String name)
	  {
	    super(name);
	  }
	
	public static void setupFluids(){
		steamCraftFluidSteam = new FluidSteam();
	}
	
	public static void registerFluids(){
		FluidRegistry.registerFluid(steamCraftFluidSteam);
	}
	
	public static void initUsedFluidVars(){
		fluidSteam = FluidRegistry.getFluid(steamCraftFluidSteam.getName());
	}
	
	public static void setupFluidTextures(){
		fluidSteam.setIcons(SteamCraftBlock.blockSteamFluid.getIcon(0,0));
	}
}

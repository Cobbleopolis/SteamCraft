package com.steamcraft.fluid;

import com.steamcraft.block.SteamCraftBlock;

import net.minecraftforge.fluids.Fluid;

public class FluidSteam extends SteamCraftFluid {

	public FluidSteam() {
		super("fluidSteam");
		setBlock(SteamCraftBlock.blockSteamFluid);
		setGaseous(true);
		setDensity(-250);
		setViscosity(0);
	}

}

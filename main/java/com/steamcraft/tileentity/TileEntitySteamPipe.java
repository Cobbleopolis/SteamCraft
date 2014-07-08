package com.steamcraft.tileentity;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTankInfo;
import net.minecraftforge.fluids.IFluidHandler;
import buildcraft.api.transport.IPipeTile;
import buildcraft.api.transport.IPipeTile.PipeType;
import buildcraft.api.transport.PipeWire;

import com.steamcraft.util.UtilPipe;
import com.steamcraft.util.UtilWorld;

public class TileEntitySteamPipe extends TileEntity implements IFluidHandler {

	// Order: Up, Down, North, South, East, West
	public boolean[] connections = new boolean[6];

	// Tile Entity
	@Override
	public void updateEntity() {
		checkConnections(worldObj, xCoord, yCoord, zCoord);
	}

	//Fluid
	
	@Override
	public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public FluidStack drain(ForgeDirection from, FluidStack resource,
			boolean doDrain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FluidStack drain(ForgeDirection from, int maxDrain, boolean doDrain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean canFill(ForgeDirection from, Fluid fluid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canDrain(ForgeDirection from, Fluid fluid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public FluidTankInfo[] getTankInfo(ForgeDirection from) {
		// TODO Auto-generated method stub
		return null;
	}

	// Custom

	public void checkConnections(World world, int x, int y, int z) {
		if (world.isRemote) {
			for (int i = 0; i < UtilWorld.oderdForgeDirections.length; i++) {
				if (UtilPipe.checkValidTileEntity(UtilWorld
						.tileEntityFromForgeDirection(world, x, y, z,
								UtilWorld.oderdForgeDirections[i]))) {
					connections[i] = true;
				} else {
					connections[i] = false;
				}
			}
		}
	}
}

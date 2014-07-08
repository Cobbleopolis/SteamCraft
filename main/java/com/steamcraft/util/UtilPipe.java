package com.steamcraft.util;

import com.steamcraft.tileentity.TileEntitySteamPipe;

import buildcraft.api.transport.IPipeTile;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.IFluidHandler;

public class UtilPipe {

	public static TileEntity[] TEBlackList = {};
	
	public static boolean checkValidTileEntity(TileEntity te){
		if(te instanceof TileEntitySteamPipe){
			return true;
		}
		return true;
	}
}

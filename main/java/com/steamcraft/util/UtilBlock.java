package com.steamcraft.util;

import net.minecraft.world.World;

public class UtilBlock {
	
	public static boolean reciveingRedstone(World world, int x, int y, int z){
			return world.isBlockIndirectlyGettingPowered(x, y, z);
	}

}

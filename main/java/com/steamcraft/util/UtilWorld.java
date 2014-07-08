package com.steamcraft.util;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class UtilWorld {

	public static final ForgeDirection[] oderdForgeDirections = {
			ForgeDirection.UP, ForgeDirection.DOWN, ForgeDirection.NORTH,
			ForgeDirection.SOUTH, ForgeDirection.EAST, ForgeDirection.WEST };

	public static Block blockFromForgeDirection(World world, int x, int y,
			int z, ForgeDirection direction) {
		if (world == null || direction == ForgeDirection.UNKNOWN
				|| world.isRemote) {
			return null;
		}
		if (direction == ForgeDirection.UP) {
			return world.getBlock(x, y + 1, z);
		}
		if (direction == ForgeDirection.DOWN) {
			return world.getBlock(x, y - 1, z);
		}
		if (direction == ForgeDirection.NORTH) {
			return world.getBlock(x, y, z - 1);
		}
		if (direction == ForgeDirection.SOUTH) {
			return world.getBlock(x, y, z + 1);
		}
		if (direction == ForgeDirection.EAST) {
			return world.getBlock(x + 1, y, z);
		}
		if (direction == ForgeDirection.WEST) {
			return world.getBlock(x - 1, y, z);
		}
		return null;
	}

	public static TileEntity tileEntityFromForgeDirection(World world, int x,
			int y, int z, ForgeDirection direction) {
		if (world == null || direction == ForgeDirection.UNKNOWN
				|| world.isRemote) {
			return null;
		}
		if (direction == ForgeDirection.UP) {
			return world.getTileEntity(x, y + 1, z);
		}
		if (direction == ForgeDirection.DOWN) {
			return world.getTileEntity(x, y - 1, z);
		}
		if (direction == ForgeDirection.NORTH) {
			return world.getTileEntity(x, y, z - 1);
		}
		if (direction == ForgeDirection.SOUTH) {
			return world.getTileEntity(x, y, z + 1);
		}
		if (direction == ForgeDirection.EAST) {
			return world.getTileEntity(x + 1, y, z);
		}
		if (direction == ForgeDirection.WEST) {
			return world.getTileEntity(x - 1, y, z);
		}
		return null;
	}

	public static Block[] getAllSurroundingBlocks3D(World world, int x, int y,
			int z) {
		Block[] blocks = new Block[6];
		if (!world.isRemote) {
			for (ForgeDirection direction : oderdForgeDirections) {
				blocks[direction.ordinal()] = blockFromForgeDirection(world, x,
						y, z, direction);
			}
		}
		return blocks;
	}

	public static Block[] getAllSurroundingBlocks2D(World world, int x, int y,
			int z) {
		Block[] blocks = new Block[6];
		if (!world.isRemote) {
			for (ForgeDirection direction : oderdForgeDirections) {
				if (direction != ForgeDirection.UP
						&& direction != ForgeDirection.DOWN) {
					blocks[direction.ordinal()] = blockFromForgeDirection(
							world, x, y, z, direction);
				}
			}
		}
		return blocks;
	}

	public static TileEntity[] getAllSurroundingTileEntitys3D(World world,
			int x, int y, int z) {
		TileEntity[] TEs = new TileEntity[6];
		if (!world.isRemote) {
			for (ForgeDirection direction : oderdForgeDirections) {

				TEs[direction.ordinal()] = tileEntityFromForgeDirection(world,
						x, y, z, direction);

			}
		}
		return TEs;
	}

	public static TileEntity[] getAllSurroundingTileEntitys2D(World world,
			int x, int y, int z) {
		TileEntity[] TEs = new TileEntity[6];
		if (!world.isRemote) {
			for (ForgeDirection direction : oderdForgeDirections) {
				if (direction != ForgeDirection.UP
						&& direction != ForgeDirection.DOWN) {
					TEs[direction.ordinal()] = tileEntityFromForgeDirection(
							world, x, y, z, direction);
				}
			}
		}
		return TEs;
	}
}

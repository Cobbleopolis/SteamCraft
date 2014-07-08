package com.steamcraft.tileentity;

import com.steamcraft.SteamCraft;
import com.steamcraft.block.SteamCraftBlock;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityBoiler extends TileEntity {

	public static TileEntityBoilerBase tile;
	public static int heatLevel;
	public int cooldown = 20;
	public int heatMax = 4;
	public int cooldownMax = 20;

	public TileEntityBoiler() {
		heatLevel = 1;
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		if (!worldObj.isRemote
				&& SteamCraft.commonProxy.getTicks(worldObj) % 60 == 0) {
			Block tmpBlock = worldObj.getBlock(xCoord, yCoord + 1, zCoord);
			boolean hasFuel = false;

			if (worldObj.getBlock(xCoord, yCoord - 1, zCoord) == Blocks.fire) {
				hasFuel = true;
			} else {
				hasFuel = false;
				cooldown = cooldownMax;
				heatLevel = 0;
			}

			boolean[] foundBlocks = new boolean[4];
			boolean hasAll = true;
			for (int i = 0; i < foundBlocks.length; i++) {
				foundBlocks[i] = false;
			}
			for (int i = 0; i <= 4; i++) {
				if (worldObj.getBlock(xCoord + i, yCoord + 1, zCoord) == SteamCraftBlock.boilerWall) {
					foundBlocks[0] = true;
				}
				if (worldObj.getBlock(xCoord - i, yCoord + 1, zCoord) == SteamCraftBlock.boilerWall) {
					foundBlocks[1] = true;
				}
				if (worldObj.getBlock(xCoord, yCoord + 1, zCoord + i) == SteamCraftBlock.boilerWall) {
					foundBlocks[2] = true;
				}
				if (worldObj.getBlock(xCoord, yCoord + 1, zCoord - i) == SteamCraftBlock.boilerWall) {
					foundBlocks[3] = true;
				}
			}

			if (foundBlocks[0] && foundBlocks[1] && foundBlocks[2]
					&& foundBlocks[3]) {
				hasAll = true;
			} else {
				hasAll = false;
			}

			if (hasFuel) {
				if (cooldown > 0) {
					cooldown--;
				} else {
					if (heatLevel < heatMax) {
						heatLevel++;
					}
					if (heatLevel == heatMax
							&& worldObj.getBlock(xCoord, yCoord + 1, zCoord) == Blocks.water
							&& hasAll) {
						worldObj.setBlock(xCoord, yCoord + 1, zCoord,
								SteamCraftBlock.blockSteamFluid);
					}
					cooldown = cooldownMax;
				}

			}
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound par1) {
		super.writeToNBT(par1);
		par1.setInteger("heatLevel", heatLevel);
		par1.setInteger("cooldown", cooldown);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1) {
		super.readFromNBT(par1);
		this.heatLevel = par1.getInteger("heatLevel");
		this.cooldown = par1.getInteger("cooldown");
	}
	
	public static int getHeatLevel(){
		return heatLevel;
	}

	public String getInventoryName() {
		// TODO Auto-generated method stub
		return "Boiler";
	}

	public int getState() {
		// TODO Auto-generated method stub
		return 0;
	}
}

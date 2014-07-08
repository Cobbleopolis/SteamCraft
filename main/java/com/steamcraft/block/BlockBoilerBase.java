package com.steamcraft.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.steamcraft.SteamCraft;
import com.steamcraft.gui.SteamCraftGuiID;
import com.steamcraft.tileentity.TileEntityBoilerBase;

public class BlockBoilerBase extends BlockContainer {
	public BlockBoilerBase() {
		super(Material.iron);
		setCreativeTab(SteamCraft.tabSteamCraft);
		setHardness(3F);
		setResistance(5F);
		setBlockName("boilerBase");
		setBlockTextureName("steamcraft:boilerBase");
	}

    @Override
    public TileEntity createNewTileEntity(World world, int var2) {
            return new TileEntityBoilerBase();
    }

}

package com.steamcraft.block;

import com.steamcraft.SteamCraft;
import com.steamcraft.gui.SteamCraftGuiID;
import com.steamcraft.tileentity.TileEntityBoiler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;

public class BlockBoiler extends BlockContainer {
	public BlockBoiler() {
		super(Material.iron);
		setCreativeTab(SteamCraft.tabSteamCraft);
		setHardness(3F);
		setResistance(5F);
		setBlockName("boiler");
		setBlockTextureName("steamcraft:boiler");
	}

    @Override
    public TileEntity createNewTileEntity(World world, int var2) {
            return new TileEntityBoiler();
    }
    
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int faceHit, float par7, float par8, float par9)
    {
        if (player.isSneaking())
        {
            return false;
        }
        else
        {
            if (!world.isRemote)
            {
                if (world.getTileEntity(x, y, z) instanceof TileEntityBoiler)
                {
                    player.openGui(SteamCraft.INSTANCE, SteamCraftGuiID.BOILER_GUI_ID, world, x, y, z);
                }
            }
            return true;
        }
    }
}

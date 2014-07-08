package com.steamcraft.gui;

import com.steamcraft.container.ContainerBoiler;
import com.steamcraft.tileentity.TileEntityBoiler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class SteamCraftGuiHandler implements IGuiHandler {
	// returns an instance of the Container you made earlier
	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (id == 0) {
			return new ContainerBoiler(player.inventory,
					(TileEntityBoiler) tileEntity);
		} else {
			return null;
		}
	}

	// returns an instance of the Gui you made earlier
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getTileEntity(x, y, z);
		if (id == 0) {
			return new GuiBoiler(player.inventory,
					(TileEntityBoiler) tileEntity);
		} else {
			return null;
		}
	}
}

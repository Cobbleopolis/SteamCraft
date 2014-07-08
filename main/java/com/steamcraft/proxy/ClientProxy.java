package com.steamcraft.proxy;

import ibxm.Player;

import java.io.File;

import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.network.Packet;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;

import com.steamcraft.block.SteamCraftBlock;
import com.steamcraft.entity.EntityBlunderbussShot;
import com.steamcraft.item.SteamCraftItem;
import com.steamcraft.renderer.block.RendererBoilerHood;
import com.steamcraft.renderer.block.RendererSteamPipe;
import com.steamcraft.tileentity.TileEntityBoilerHood;
import com.steamcraft.tileentity.TileEntitySteamPipe;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;

public class ClientProxy extends CommonProxy implements ISteamCraftProxy{

	@Override
	public void registerRenderers() {
		//Steam Pipe
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySteamPipe.class,
				new RendererSteamPipe());
		MinecraftForgeClient.registerItemRenderer(
				Item.getItemFromBlock(SteamCraftBlock.steamPipe),
				new RendererSteamPipe());
		//Boiler Hood
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBoilerHood.class,
				new RendererBoilerHood());
		MinecraftForgeClient.registerItemRenderer(
				Item.getItemFromBlock(SteamCraftBlock.boilerHood),
				new RendererBoilerHood());
		//Blunderbuss Shot
		RenderingRegistry.registerEntityRenderingHandler(
				EntityBlunderbussShot.class, new RenderSnowball(SteamCraftItem.brassBallBearing));
	}

	@Override
	public void registerSound() {
	}
	
	@Override
	public long getTicks(World worldObj) {
		if (worldObj != null) { return worldObj.getTotalWorldTime(); }
		World cWorld = getClientWorld();
		if (cWorld != null) return cWorld.getTotalWorldTime();
		return 0;
	}

	@Override
	public boolean isServerOnly() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isServerThread() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public World getClientWorld() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public World getServerWorld(int dimension) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityPlayer getThePlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isClientPlayer(Entity player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void sendPacketToPlayer(Player player, Packet packet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sendPacketToServer(Packet packet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public File getMinecraftDir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getLogFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IGuiHandler wrapHandler(IGuiHandler modSpecificHandler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void preInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setNowPlayingTitle(String nowPlaying) {
		// TODO Auto-generated method stub
		
	}
}

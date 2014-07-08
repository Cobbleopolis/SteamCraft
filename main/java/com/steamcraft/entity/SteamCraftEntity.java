package com.steamcraft.entity;

import com.steamcraft.SteamCraft;

import cpw.mods.fml.common.registry.EntityRegistry;

public class SteamCraftEntity {
	public static void registerEntity(){
		EntityRegistry.registerModEntity(EntityBlunderbussShot.class, "BlunderbussShot", 1, SteamCraft.INSTANCE, 120, 3, true );
	}
}

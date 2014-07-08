package com.steamcraft.event;

import com.steamcraft.SteamCraft;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class SoundHandler {
	public static void onEntityPlay(String soundName, World world, Entity entityName, float volume, float pitch){
		world.playSoundAtEntity(entityName, (SteamCraft.MODID + ":" + soundName), (float)volume, (float)pitch);
	}
}

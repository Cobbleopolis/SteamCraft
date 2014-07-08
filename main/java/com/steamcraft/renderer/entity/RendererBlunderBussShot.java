package com.steamcraft.renderer.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderFireball;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RendererBlunderBussShot extends Render  {

	private float field_77002_a;

	public RendererBlunderBussShot(float p_i1254_1_) {
		this.field_77002_a = p_i1254_1_;
	}

	@Override
	public void doRender(Entity bolt, double paramDouble1,
			double paramDouble2, double paramDouble3, float paramFloat1,
			float paramFloat2) {
		System.out.println("Render");
	}

	protected ResourceLocation getEntityTexture(Entity paramEntity) {
		return TextureMap.locationItemsTexture;
	}

}

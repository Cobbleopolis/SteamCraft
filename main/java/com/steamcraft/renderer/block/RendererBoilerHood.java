package com.steamcraft.renderer.block;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.obj.WavefrontObject;

import org.lwjgl.opengl.GL11;

public class RendererBoilerHood extends TileEntitySpecialRenderer implements
IItemRenderer {

	private final WavefrontObject model;
	
	public RendererBoilerHood() {
		this.model = new WavefrontObject(new ResourceLocation(
				"steamcraft:models/boilerHood.obj"));
	}
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		switch (type) {
			case ENTITY:
				return true;
			case EQUIPPED:
				return true;
			case EQUIPPED_FIRST_PERSON:
				return true;
			case INVENTORY:
				return true;
			default:
				return false;
		}
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glPushMatrix();
		switch (type) {
		case INVENTORY:
			GL11.glTranslated(0F, -0.5F, 0F);
		default:
		}
		ResourceLocation textures = (new ResourceLocation(
				"steamcraft:textures/blocks/boilerHood.png"));
		Minecraft.getMinecraft().renderEngine.bindTexture(textures);
		this.model.renderAll();
		GL11.glPopMatrix();
	}

	@Override
	public void renderTileEntityAt(TileEntity te, double x, double y,
			double z, float paramFloat) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y, (float) z + 0.5F);
		ResourceLocation textures = (new ResourceLocation(
				"steamcraft:textures/blocks/boilerHood.png"));
		Minecraft.getMinecraft().renderEngine.bindTexture(textures);
		GL11.glPushMatrix();
		this.model.renderAll();
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
	}

}

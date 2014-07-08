package com.steamcraft.renderer.block;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.model.obj.WavefrontObject;

import org.lwjgl.opengl.GL11;

import com.steamcraft.tileentity.TileEntitySteamPipe;

public class RendererSteamPipe extends TileEntitySpecialRenderer implements
		IItemRenderer {

	private final WavefrontObject model;
	static String[] extentionNames = {"Extention_Up", "Extention_Down", "Extention_North", "Extention_South", "Extention_East", "Extention_West"};
	
	public RendererSteamPipe() {
		this.model = new WavefrontObject(new ResourceLocation(
				"steamcraft:models/pipeModel.obj"));
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
	public void renderItem(ItemRenderType type,
			ItemStack paramItemStack, Object... paramArrayOfObject) {
		GL11.glPushMatrix();
		if(type == ItemRenderType.INVENTORY){
			GL11.glTranslated(0F, -0.5F, 0F);
		}else if(type ==  ItemRenderType.EQUIPPED_FIRST_PERSON){
			GL11.glTranslated(0F, .5F, 0.5F);
		}
		ResourceLocation textures = (new ResourceLocation(
				"steamcraft:textures/blocks/steamPipe.png"));
		Minecraft.getMinecraft().renderEngine.bindTexture(textures);
		GL11.glDisable(GL11.GL_CULL_FACE);
		this.model.renderOnly("Base");
		this.model.renderOnly("Extention_Up", "Extention_Down");
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glPopMatrix();
	}

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z,
			float paramFloat) {
		TileEntitySteamPipe te = (TileEntitySteamPipe) tile;
		int worldX = te.xCoord;
		int worldY = te.yCoord;
		int worldZ = te.zCoord;
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.0F, (float) z + 0.5F);
		ResourceLocation textures = (new ResourceLocation(
				"steamcraft:textures/blocks/steamPipe.png"));
		Minecraft.getMinecraft().renderEngine.bindTexture(textures);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glDisable(GL11.GL_CULL_FACE);
		this.model.renderPart("Base");
		for(int i = 0; i < 6; i++){
			if(te.connections[i]){
				this.model.renderPart(extentionNames[i]);
			}
		}
		GL11.glEnable(GL11.GL_CULL_FACE);
		GL11.glPopMatrix();
		GL11.glPopMatrix();

	}

}

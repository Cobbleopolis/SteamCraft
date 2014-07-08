package com.steamcraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;

import com.steamcraft.block.SteamCraftBlock;
import com.steamcraft.crafting.SteamCraftVanillaCrafting;
import com.steamcraft.entity.EntityBlunderbussShot;
import com.steamcraft.event.BucketHandler;
import com.steamcraft.fluid.SteamCraftFluid;
import com.steamcraft.gui.SteamCraftGuiHandler;
import com.steamcraft.item.SteamCraftItem;
import com.steamcraft.proxy.CommonProxy;
import com.steamcraft.tileentity.TileEntityBoilerBase;
import com.steamcraft.world.SteamCraftWorldGenerator;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = SteamCraft.MODID, version = SteamCraft.VERSION)
public class SteamCraft {

	@Instance(SteamCraft.MODID)
	public static SteamCraft INSTANCE;

	public static final String MODID = "steamcraft";
	public static final String VERSION = "1.0";

	@SidedProxy(clientSide = "com.steamcraft.proxy.ClientProxy", serverSide = "com.steamcraft.proxy.CommonProxy")
	public static CommonProxy commonProxy;

	public static CreativeTabs tabSteamCraft = new CreativeTabsSteamCraft(
			"SteamCraft");

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println("Loading SteamCraft...");
		System.out.println("Loading SteamCraft Fluids...");
		SteamCraftFluid.setupFluids();
		SteamCraftFluid.registerFluids();
		SteamCraftFluid.initUsedFluidVars();
		System.out.println("Finished Loading SteamCraft Fluids...");
		System.out.println("Loading SteamCraft Blocks...");
		SteamCraftBlock.initBlock();
		SteamCraftBlock.registerBlocks();
		System.out.println("Finished Loading SteamCraft Blocks...");
		System.out.println("Loading SteamCraft Items...");
		SteamCraftItem.initItem();
		SteamCraftItem.registerItem();
		System.out.println("Finished Loading SteamCraft Items...");
		System.out.println("Adding Items & Blocks to Ore Dictionary...");
		SteamCraftDictionary.loadOreDictionary();
		System.out.println("Finished Adding Items & Blocks to Ore Dictionary...");
		System.out.println("Loading SteamCraft Recipes...");
		SteamCraftVanillaCrafting.loadRecipes();
		SteamCraftVanillaCrafting.loadOreRecipes();
		SteamCraftVanillaCrafting.loadFurnaceRecipes();
		System.out.println("Finished Loading SteamCraft Recipes...");
		System.out.println("Loading SteamCraft Entitys...");
		registerEntity(this);
		System.out.println("Finished Loading SteamCraft Entitys...");
		System.out.println("Loading SteamCraft Tile Entitys...");
		registerTileEntity();
		System.out.println("Finished Loading SteamCraft Tile Entitys...");
		System.out.println("Loading SteamCraft Event Hadlers...");
		registerEvents();
		System.out.println("Finished Loading SteamCraft Event Hadlers...");
		System.out.println("Loading SteamCraft Gui Hadler...");
		registerGuiHandlers(this);
		System.out.println("Finished Loading SteamCraft Gui Hadler...");
		System.out.println("Loading SteamCraft Renderers...");
		commonProxy.registerRenderers();
		System.out.println("Finished Loading SteamCraft Renderers...");
		System.out.println("Finished Loading SteamCraft...");
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		GameRegistry.registerWorldGenerator(new SteamCraftWorldGenerator(), 1);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

	public static void registerEntity(Object object) {
		int entityID = 0;
		EntityRegistry.registerModEntity(EntityBlunderbussShot.class,
				"BlunderbussShot", entityID++, object, 64, 10, true);
	}
	
	public static void registerTileEntity(){
		GameRegistry.registerTileEntity(TileEntityBoilerBase.class, "steamcraft.boiler");
	}
	
	public static void registerEvents() {
		BucketHandler.INSTANCE.buckets.put(SteamCraftBlock.blockSteamFluid,
				SteamCraftItem.steamBucket);
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
	}
	
	public static void registerGuiHandlers(Object object){
		NetworkRegistry.INSTANCE.registerGuiHandler(object,
				new SteamCraftGuiHandler());
	}
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void textureHook(TextureStitchEvent.Post event) {
		if (event.map.getTextureType() == 0) {
			SteamCraftFluid.setupFluidTextures();
		}
	}
}

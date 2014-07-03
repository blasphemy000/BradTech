package net.BradTech.mod;

import net.BradTech.mod.blocks.*;
import net.BradTech.mod.handler.CraftingHandler;
import net.BradTech.mod.handler.GuiHandler;
import net.BradTech.mod.handler.KeyInputHandler;
import net.BradTech.mod.items.*;
import net.BradTech.mod.proxy.CommonProxy;
import net.BradTech.mod.tileentity.TileEntityForgeOven;
import net.BradTech.mod.worldgen.BradTechWorldGen;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid=BradTech.modid, version=BradTech.version)

public class BradTech {
	// Mod information.
	public static final String modid="BradTech";
	public static final String version="Alpha v0.1";
	
	
	// Needed for the custom ore generation. (WorldGen)
	BradTechWorldGen eventWorldGen = new BradTechWorldGen();
	
	
	// Instance variable for this mod.
	@Instance(modid)
	public static BradTech instance;
	
	
	// Instance variable for this mod's configuration class.
	public static CfgHelper bradTechConfig;
	
	
	// Creative Tab
	public static CreativeTabs bradTechTab;
	public static CreativeTabs bradTechTools;
	public static CreativeTabs bradTechMachines;
	
	
	// Materials
	public static ToolMaterial  matQuartzMaterial = EnumHelper.addToolMaterial("QuartzMaterial", 3, 750, 6.0F, 2.0F, 20);
	public static ArmorMaterial matQuartzArmorMaterial = EnumHelper.addArmorMaterial("QuartzArmor", 24, new int[]{3, 6, 4, 3}, 20);

	
	// Tools
	public static Item itemIronExtruder;
	public static Item itemQuartzSword;
	public static Item itemQuartzPickAxe;
	public static Item itemQuartzShovel;
	public static Item itemQuartzAxe;
	public static Item itemQuartzHoe;
	public static Item itemSonicScrewdriver;
	
	
	// Armor
	public static int armorIDQuartzHelmet;
	public static int armorIDQuartzChestplate;
	public static int armorIDQuartzLeggings;
	public static int armorIDQuartzBoots;

	public static Item armorQuartzHelmet;
	public static Item armorQuartzChestplate;
	public static Item armorQuartzLeggings;
	public static Item armorQuartzBoots;

	
	
	// Items
	public static Item itemCopperIngot;
	public static Item itemTinIngot;
	public static Item itemNickelIngot;
	public static Item itemAluminumIngot;
	public static Item itemPlatinumIngot;
	public static Item itemUraniumIngot;
	public static Item itemBronzeIngot;
	public static Item itemSteelIngot;
	public static Item itemBlueQuartzGem;
	public static Item itemBlueQuartzDust;
	
	public static Item itemWoodCog;
	public static Item itemStoneCog;
	public static Item itemAluminumCog;
	public static Item itemTinCog;
	public static Item itemIronCog;
	public static Item itemBronzeCog;
	public static Item itemDiamondCog;
	
	public static Item itemRawRubber;			// Can also be used as fuel...
	public static Item itemProcessedRubber;
	public static Item itemPlastic;
	public static Item itemLaminate;
	
	
	// Blocks
	public static Block oreCopperOre;
	public static Block oreTinOre;
	public static Block oreNickelOre;
	public static Block oreAluminumOre;
	public static Block orePlatinumOre;
	public static Block oreUraniumOre;
	public static Block oreBlueQuartzOre;
	
	public static Block oreNetherIronOre;
	public static Block oreNetherGoldOre;
	public static Block oreNetherRedstoneOre;
	public static Block oreNetherDiamondOre;
	public static Block oreNetherEmeraldOre;
	public static Block oreNetherCopperOre;
	public static Block oreNetherTinOre;
	public static Block oreNetherNickelOre;
	public static Block oreNetherAluminumOre;
	public static Block oreNetherPlatinumOre;
	public static Block oreNetherUraniumOre;
	public static Block oreNetherBlueQuartzOre;
	public static Block oreNetherCoalOre;
	
	public static Block blockCopperBlock;
	public static Block blockTinBlock;
	public static Block blockNickelBlock;
	public static Block blockAluminumBlock;
	public static Block blockPlatinumBlock;
	public static Block blockUraniumBlock;
	public static Block blockBronzeBlock;
	public static Block blockSteelBlock;
	
	
	//	Energy Transfer System
	public static Item itemCopperWire;
	public static Block blockInsulatedCopperWire;
	
	
	// Interface Blocks
	public static Block blockObsidianTable;
	public static final int guiIDObsidianTable = 1003;		// This is not used/implemented yet.
	
	public static Block blockMachinistsTable;
	public static final int guiIDMachinistsTable = 1002;
	
	// Machine Blocks
	public static Block blockForgeOvenIdle;
	public static Block blockForgeOvenActive;
	public static final int guiIDForgeOven = 1001;
	
	
	@SidedProxy(clientSide = "net.BradTech.mod.proxy.ClientProxy", serverSide = "net.BradTech.mod.proxy.CommonProxy")
	public static CommonProxy bradTechProxy;
	
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent) {
		
		// Setup and load the configuration file for BradTech.
		bradTechConfig = new CfgHelper(preEvent);

		// Setup the creative tabs for this mod.
		bradTechTab = new CreativeTabs("BradTech") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return Item.getItemFromBlock(BradTech.oreCopperOre);
			}
		};
		
		bradTechTools = new CreativeTabs("BradTechTools") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return BradTech.itemQuartzSword;
			}
		};
		
		
		bradTechMachines = new CreativeTabs("BradTechMachines") {
			@SideOnly(Side.CLIENT)
			public Item getTabIconItem() {
				return Item.getItemFromBlock(BradTech.blockForgeOvenActive);
			}
		};

		
		// PreInit the Ores
		PreInitOres.SetupBradTechOres();
		
		// PreInit the Techy Items
		PreInitTechItems.SetupTechItems();
		
		// PreInit the Machine Blocks
		InitMachines.SetupMachineBlocks();
		
		// Spawn
		GameRegistry.registerWorldGenerator(eventWorldGen, 0);
		
		// Renderers
		bradTechProxy.registerRenderThings();
	}
	
	
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		
		KeyBindings.SetupKeyBindings();
		FMLCommonHandler.instance().bus().register(new KeyInputHandler());
		
		// Setup the crafting handler for our durable crafting tools.
		FMLCommonHandler.instance().bus().register(new CraftingHandler());
		
		// Setup the GUI Handler class for handling our machine's GUIs.
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

		// Setup the TileEntities for our custom machines.
		InitMachines.SetupTileEntities();
		
		// Setup the crafting recipes.
		InitCrafting.SetupCraftingRecipes();
		
		// Setup the smelting recipes.
		InitCrafting.SetupSmeltingRecipes();
		
		// Setup the added fuel sources.
		InitCrafting.SetupFuelSources();
		
	}
	
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent) {
		
	}
}








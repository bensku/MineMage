package MineMage.common;

import net.minecraft.block.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.block.material.*;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.world.Teleporter;
import net.minecraft.world.biome.*;
import cpw.mods.fml.common.registry.EntityRegistry;
import BenskuLib.common.*;

@Mod(modid="bensku_MineMage_mod", name="MineMage", version="alpha")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class MainMod {
	//!!Items
	public static Item ItemCopperIngot;
	public static Item ItemPortalWand;
	//!!Blocks
	public static Block BlockCopperOre;
	public static Block BlockSkyPortal;
	//!!Creative tabs
    public static CreativeTabs tabMineMage = new CreativeTabs("tabMineMage") {
        public ItemStack getIconItemStack() {
                return new ItemStack(Item.eyeOfEnder, 1, 0);
        }
    };
	@Instance("MainMod")
	public static MainMod instance;
	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide="MineMage.common.client.ClientProxy", serverSide="MineMage.common.CommonProxy")
	public static CommonProxy proxy;
	
	//!!Biomes
	public static BiomeGenBase BiomeRainLand;
	public static BiomeGenBase BiomeSky;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
		// Stub Method
	}
	
	@Init
	public void load(FMLInitializationEvent event) {
		//!!Items
		//Copper ingot
		ItemCopperIngot = new ItemCopperIngot(250);
		LanguageRegistry.addName(ItemCopperIngot, "Copper ingot");
		//Portal wand
		ItemPortalWand = new ItemPortalWand(251);
		LanguageRegistry.addName(ItemPortalWand, "Wand of portalling");
		//!!Blocks
		//Copper ore block
		BlockCopperOre = new BlockCopperOre(500, 1, Material.rock);
		LanguageRegistry.addName(BlockCopperOre, "Copper ore");
		MinecraftForge.setBlockHarvestLevel(BlockCopperOre, "pickaxe", 0);
		GameRegistry.registerBlock(BlockCopperOre, "minemage_block_copperOre");
		//Sky portal block
		BlockSkyPortal = new BlockSkyPortal(501);
		LanguageRegistry.addName(BlockSkyPortal, "Portal to Sky dimension");
		GameRegistry.registerBlock(BlockSkyPortal, "minemage_block_skyPortal");
		//!!Crafting recipes
		//9 cobblestone to 1 stone
		ItemStack cobbleStack = new ItemStack(Block.cobblestone);
		GameRegistry.addRecipe(new ItemStack(Block.stone), "aaa", "aaa", "aaa",
		        'a', cobbleStack);
		//!!Smelting recipes
		//1 stone to 16 cobblestone
		GameRegistry.addSmelting(Block.stone.blockID,
				new ItemStack(Block.cobblestone, 16), 0.1f);
		//1 copper ore to 1 copper ingot
		GameRegistry.addSmelting(BlockCopperOre.blockID,
				new ItemStack(ItemCopperIngot, 1), 0.5f);
		//!!Entities/mobs:
		//Forest/normal elf
		//ModLoader.registerEntityID(EntityElf.class, "Forest elf", ModLoader.getUniqueEntityId(), 1111, 11111);
		//ModLoader.addSpawn(EntityElf.class, 10, 1, 2, EnumCreatureType.creature, BiomeGenBase.forest);
		//ModLoader.addSpawn(EntityElf.class, 10, 1, 2, EnumCreatureType.creature, BiomeGenBase.forestHills);
		//LanguageRegistry.instance().addStringLocalization("entity.bensku_MineMage_mod.Common.EntityElf", "Forest elf");
		//!!Biomes
		//Rainland (always rains :D)
		BiomeRainLand = new BiomeGenRainLand(BiomeLib.getBiomeId(1)).setColor(112).setBiomeName("Rainland").setTemperatureRainfall(0.5F, 2.0F);
        GameRegistry.addBiome(BiomeRainLand);
        //Sky (for sky dimension, no longer end biome with endermen...)
		BiomeSky = new BiomeGenSky(BiomeLib.getBiomeId(2)).setColor(112).setBiomeName("Sky");
        GameRegistry.addBiome(BiomeSky);
        //!!Dimensions
        //Sky
        DimensionManager.registerProviderType(DimensionLib.getDimId(1), WorldProviderSky.class, false);
        DimensionManager.registerDimension(DimensionLib.getDimId(1), DimensionLib.getDimId(1));
        //!!World generators
        GameRegistry.registerWorldGenerator(new ModWorldGenerator());
        //!!Creative tabs
        LanguageRegistry.instance().addStringLocalization("itemGroup.tabMineMage", "en_US", "MineMage");
        
        proxy.registerRenderers();
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		// Stub Method
	}
}

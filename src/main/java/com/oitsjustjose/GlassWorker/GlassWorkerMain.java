package com.oitsjustjose.GlassWorker;

import com.oitsjustjose.GlassWorker.Util.Recipes;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.oitsjustjose.GlassWorker.Blocks.ModBlocks;
import com.oitsjustjose.GlassWorker.Util.ClientProxy;
import com.oitsjustjose.GlassWorker.Util.CommonProxy;
import com.oitsjustjose.GlassWorker.Util.Reference;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = Reference.MODID, version = Reference.VERSION)
public class GlassWorkerMain
{

    @Instance(Reference.MODID)
    public static GlassWorkerMain instance;

    @SidedProxy(clientSide = "com.oitsjustjose.GlassWorker.Util.ClientProxy", serverSide = "com.oitsjustjose.GlassWorker.Util.CommonProxy")
    public static CommonProxy proxy;
    
    public static CreativeTabs tabGlass;
    
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{		
		tabGlass = new CreativeTabs("tabGlass")
		{
			@Override
			public ItemStack getIconItemStack()
			{
				return new ItemStack(ModBlocks.BlockGlass);
			}

			@Override
			public Item getTabIconItem() { return null; }
		};
		
		ModBlocks.init();
        Recipes.init();
		proxy.init();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{

	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
}

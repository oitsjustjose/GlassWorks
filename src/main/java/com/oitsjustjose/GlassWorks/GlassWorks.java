package com.oitsjustjose.GlassWorks;

import com.oitsjustjose.GlassWorks.Blocks.ModBlocks;
import com.oitsjustjose.GlassWorks.Event.CropEvent;
import com.oitsjustjose.GlassWorks.Event.SawEvent;
import com.oitsjustjose.GlassWorks.Item.ModItems;
import com.oitsjustjose.GlassWorks.Util.CommonProxy;
import com.oitsjustjose.GlassWorks.Util.ConfigHandler;
import com.oitsjustjose.GlassWorks.Util.Recipes;
import com.oitsjustjose.GlassWorks.Util.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, version = Reference.VERSION, guiFactory = Reference.GUIFACTORY)
public class GlassWorks
{

    @Instance(Reference.MODID)
    public static GlassWorks instance;

    @SidedProxy(clientSide = "com.oitsjustjose.GlassWorks.Util.ClientProxy", serverSide = "com.oitsjustjose.GlassWorks.Util.CommonProxy")
    public static CommonProxy proxy;
    
    public static CreativeTabs GlassWorksTab;
    
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{		
		initTab();
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		
        FMLCommonHandler.instance().bus().register(new ConfigHandler());
        MinecraftForge.EVENT_BUS.register(new SawEvent());
        MinecraftForge.EVENT_BUS.register(new CropEvent());
        
		ModBlocks.init();
		ModItems.init();
		
        Recipes.init();
		proxy.preInit();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init();
	}
	
	void initTab()
	{
		GlassWorksTab = new CreativeTabs("GlassWorksTab")
		{
			@Override
			public ItemStack getIconItemStack()
			{
				return new ItemStack(Blocks.anvil);
			}

			@Override
			public Item getTabIconItem() { return null; }
		};
	}
}

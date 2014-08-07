package com.oitsjustjose.GlassWorks.Util;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import com.oitsjustjose.GlassWorks.Item.ItemSaw;
import com.oitsjustjose.GlassWorks.Item.ModItems;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigHandler
{
    public static Configuration configuration;
    public static boolean reduceUses = false;
    public static boolean allowCropFeature = true;
    
    public static void init(File configFile)
    {
        // Create the configuration object from the given configuration file
        if (configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        reduceUses = configuration.getBoolean("Reduce Saw's Durability?", configuration.CATEGORY_GENERAL, false, 
        		"Setting this to true will halve the max durability of the saw, default durability is 1561.");

        allowCropFeature = configuration.getBoolean("Allow Premium Crop Harvesting?", configuration.CATEGORY_GENERAL, true,
        		"Setting this to false will disable the right-click-to-harvest feature on crops");
        
        if (configuration.hasChanged())
        {
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if (event.modID.equalsIgnoreCase(Reference.MODID))
        {
            loadConfiguration();
        }
    }
}
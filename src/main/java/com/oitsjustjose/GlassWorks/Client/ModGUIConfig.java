package com.oitsjustjose.GlassWorks.Client;

import com.oitsjustjose.GlassWorks.Util.ConfigHandler;
import com.oitsjustjose.GlassWorks.Util.Reference;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;

public class ModGUIConfig extends GuiConfig
{
    public ModGUIConfig(GuiScreen guiScreen)
    {
        super(guiScreen,
                new ConfigElement(ConfigHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                Reference.MODID,
                false,
                true,
                GuiConfig.getAbridgedConfigPath(ConfigHandler.configuration.toString()));
    }
}
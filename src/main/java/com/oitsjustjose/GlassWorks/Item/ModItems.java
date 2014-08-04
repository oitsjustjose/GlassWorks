package com.oitsjustjose.GlassWorks.Item;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.oitsjustjose.GlassWorks.Util.ConfigHandler;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems
{
	public static final Item sawDiamond = new ItemSaw();
	
	public static void init()
	{	
		GameRegistry.registerItem(sawDiamond, "Saw");
	}
}

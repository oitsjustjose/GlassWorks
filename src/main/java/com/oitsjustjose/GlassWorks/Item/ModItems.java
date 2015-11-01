package com.oitsjustjose.GlassWorks.Item;

import com.oitsjustjose.GlassWorks.Util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ModItems
{
	public static Item sawDiamond;
	
	public static void init()
	{	
		sawDiamond = new ItemSaw();
	}
}

package com.oitsjustjose.GlassWorks.Item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems
{
	public static final Item sawDiamond = new ItemSaw();
	
	public static void init()
	{	
		GameRegistry.registerItem(sawDiamond, "Saw");
	}
}

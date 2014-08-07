package com.oitsjustjose.GlassWorks.Item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems
{
	public static final Item sawDiamond = new ItemSaw();
	
	public static void init()
	{	
		GameRegistry.registerItem(sawDiamond, "Saw");
		
		OreDictionary.registerOre("dyeRed", sawDiamond);
	}
}

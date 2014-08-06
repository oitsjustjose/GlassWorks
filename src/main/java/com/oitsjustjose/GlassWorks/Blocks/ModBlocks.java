package com.oitsjustjose.GlassWorks.Blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import com.oitsjustjose.GlassWorks.Item.Block.ItemBlockGlass;
import com.oitsjustjose.GlassWorks.Item.Block.ItemBlockPillar;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks
{
	public static Block BlockGlass;
	public static Block BlockPillar;
	
	public static void init()
	{
		BlockGlass = new BlockGlass().setBlockName("BlockGlass");
		BlockPillar = new BlockPillar().setBlockName("BlockPillar");

		GameRegistry.registerBlock(BlockGlass, ItemBlockGlass.class, "GlassWorks Glass");
		GameRegistry.registerBlock(BlockPillar, ItemBlockPillar.class, "Pillar Block");

		for(int i = 0; i < 6; i++)
		{
			OreDictionary.registerOre("blockGlass", new ItemStack(BlockGlass, 1, i));
		}
	}
}
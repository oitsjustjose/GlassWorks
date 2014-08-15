package com.oitsjustjose.GlassWorks.FMP;

import codechicken.microblock.BlockMicroMaterial;
import codechicken.microblock.MicroMaterialRegistry;

import com.oitsjustjose.GlassWorks.Blocks.ModBlocks;

public class FMPHandler
{
	public static void init()
	{
		for(int i = 0; i < 7; i++)
			BlockMicroMaterial.createAndRegister(ModBlocks.BlockGlass, i, (ModBlocks.BlockGlass.getLocalizedName() + i));
		for(int i = 0; i < 3; i++)
			BlockMicroMaterial.createAndRegister(ModBlocks.BlockPillar, i, (ModBlocks.BlockPillar.getLocalizedName() + i));
		
		MicroMaterialRegistry.registerMaterial(new CTMMicroMaterial(ModBlocks.BlockGlass, 0), "CTM Glass");
		
		
	}
}

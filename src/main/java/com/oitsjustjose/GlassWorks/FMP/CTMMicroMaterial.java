package com.oitsjustjose.GlassWorks.FMP;

import net.minecraft.block.Block;
import codechicken.microblock.BlockMicroMaterial;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CTMMicroMaterial extends BlockMicroMaterial
{
	public CTMMicroMaterial(Block block, int meta)
	{
		super(block, meta);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void loadIcons()
	{
		//what now?!?
	}

}

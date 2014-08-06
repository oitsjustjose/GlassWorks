package com.oitsjustjose.GlassWorks.Util;

import com.oitsjustjose.GlassWorks.Client.RenderPane;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{	
	@Override
	public void preInit()
	{
		RenderingRegistry.registerBlockHandler(new RenderPane());
	}
	
	@Override
	public void init()
	{

	}
}

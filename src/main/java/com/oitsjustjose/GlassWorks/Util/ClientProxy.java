package com.oitsjustjose.GlassWorks.Util;

import com.oitsjustjose.GlassWorks.Item.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ClientProxy extends CommonProxy
{	
	@Override
	public void preInit()
	{
	}
	
	@Override
	public void init()
	{
		this.registerItemRender(ModItems.sawDiamond);
	}
	
	public static void registerItemRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}

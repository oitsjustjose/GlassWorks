package com.oitsjustjose.GlassWorks.Util;

import com.oitsjustjose.GlassWorks.Blocks.BlockGlass;
import com.oitsjustjose.GlassWorks.Blocks.EGlassTypes;
import com.oitsjustjose.GlassWorks.Blocks.ModBlocks;
import com.oitsjustjose.GlassWorks.Item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ClientProxy extends CommonProxy
{	
	@Override
	public void preInit()
	{
	}
	
	@Override
	public void init()
	{
		this.registerRender(ModItems.sawDiamond);
		BlockGlass.inventoryRender();
	}
	
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
		.register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	

}

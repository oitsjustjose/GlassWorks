package com.oitsjustjose.GlassWorks.Event;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;

import com.google.common.eventbus.Subscribe;
import com.oitsjustjose.GlassWorks.Item.ItemSaw;

public class SawEvent
{
	@Subscribe
	public void onHarvestBlocks(BlockEvent.HarvestDropsEvent event)
	{
		EntityPlayer player = event.harvester;
		ItemStack heldItem = player.inventory.getCurrentItem();
		Block block = event.block;
		
		ItemStack plank = findPlank(block);
		
		if(player != null && heldItem != null && heldItem.getItem() instanceof ItemSaw && plank != null)
		{
			event.drops.remove(block);
			for(int i = 0; i < 2; i++)
				event.drops.add(plank);
				
		}
		System.out.println("Block Borked");
	}
	
	public static ItemStack findPlank(Block inputBlock)
	{
		List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();
		for (int i = 0; i < recipes.size(); i++)
		{
			IRecipe tmpRecipe = recipes.get(i);
			if (tmpRecipe instanceof IRecipe)
			{
				IRecipe recipe = tmpRecipe;
				
				if(recipe.equals(new Object[] {"D", 'D', inputBlock}))
				{
						ItemStack recipeResult = recipe.getRecipeOutput();
						return recipeResult;
				}
			}
		}
		return null;
	}
}

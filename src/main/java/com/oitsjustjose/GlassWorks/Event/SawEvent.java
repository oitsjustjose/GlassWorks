package com.oitsjustjose.GlassWorks.Event;

import java.util.List;
import java.util.Random;

import com.oitsjustjose.GlassWorks.Item.ItemSaw;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;
 
public class SawEvent
{	
	@SubscribeEvent
	public void onHarvestBlocks(BlockEvent.HarvestDropsEvent event)
	{
		Block block = event.state.getBlock();
		EntityPlayer player = event.harvester;
	
		if(player != null && player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() instanceof ItemSaw)
		{
			if(isLog(block) && findPlank(block, event) != null)
			{
				ItemStack plank = new ItemStack(findPlank(block, event).getItem(), dropQuantity(event), findPlank(block, event).getItemDamage());
				
				event.drops.clear();
				event.drops.add(plank);
			}
		}
	}
		
	public static int dropQuantity(BlockEvent.HarvestDropsEvent event)
	{
		ItemStack heldItem = event.harvester.inventory.getCurrentItem();
		int fortune = event.fortuneLevel;
		
		Random random = new Random();
		
		if(heldItem != null && heldItem.getItem() instanceof ItemSaw)
		{
			if(fortune > 0)
				return 6 + random.nextInt(fortune + 1);
			return 6;
		}
		return 0;
	}
	
	public static ItemStack findPlank(Block block, BlockEvent.HarvestDropsEvent event)
	{
		World world = event.world;
		
		if(isLog(block))
		{
			ItemStack blockStack = new ItemStack(block, 1, event.state.getBlock().getMetaFromState(event.state));
			
	        InventoryCrafting craftMatrix = new InventoryCrafting(event.harvester.inventoryContainer, 3, 3);
	        craftMatrix.setInventorySlotContents(0, blockStack);
	        IRecipe recipe = findRecipe(craftMatrix, world);
	        craftMatrix.closeInventory(event.harvester);

			if (recipe == null)
				return null;
			return recipe.getCraftingResult(craftMatrix);	
		}
		return null;
	}
	
	public static boolean isLog(Block block)
	{
		return OreDictionary.itemMatches(new ItemStack(Blocks.log, 1, Short.MAX_VALUE), new ItemStack(block), false);
	}
	
	private static IRecipe findRecipe(InventoryCrafting crafting, World world)
	{
		for (IRecipe recipe : (List<IRecipe>)CraftingManager.getInstance().getRecipeList())
			if (recipe.matches(crafting, world))
				return recipe;
		return null;
	}
}
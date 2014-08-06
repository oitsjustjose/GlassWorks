package com.oitsjustjose.GlassWorks.Event;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;

import com.oitsjustjose.GlassWorks.Item.ItemSaw;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
 
public class SawEvent
{
	/* 
	 * Main function of this class, checks to see if the block
	 * extends BlockLog, and will continue if the held item is
	 * the diamond saw. Calculates what the corresponding 
	 * plank for the log is by trying to craft just 1 of them
	 * in a simulated crafting grid (see @findPlank).
	 */
	
	@SubscribeEvent
	public void onHarvestBlocks(BlockEvent.HarvestDropsEvent event)
	{
		Block block = event.block;
		EntityPlayer player = event.harvester;
		ItemStack heldItem = player.inventory.getCurrentItem();
		ItemStack plank = findPlank(block, event.world, event.x, event.y, event.z);
		
		if(player != null && heldItem != null && heldItem.getItem() instanceof ItemSaw && block instanceof BlockLog)
		{
			event.drops.remove(block);
			event.drops.add(plank);
			
			System.out.println("Log Block Broken");
		}
	}
	
	/*
	 * Calculates how many planks to drop based on the saw's
	 * level of fortune (this is a simple way, unsure if I'll
	 * be keeping it).
	 */
		
	public static int dropQuantity(BlockEvent.HarvestDropsEvent event)
	{
		ItemStack heldItem = event.harvester.inventory.getCurrentItem();
		int fortune = event.fortuneLevel;
		
		Random random = new Random();
		
		if(heldItem != null && heldItem.getItem() instanceof ItemSaw)
		{
			if(fortune > 0)
				return 6 + random.nextInt(fortune);
			return 6;
		}
		return 0;
	}
	
	
	/*
	 * 
	 * Many thanks to @copygirl for the help from BetterStorage on this. I was lost without you!
	 * 
	 */
	
	
	public static ItemStack findPlank(Block block, World world, int x, int y, int z)
	{
		InventoryCrafting crafting = new InventoryCrafting(null, 3, 3);
		crafting.setInventorySlotContents(0, new ItemStack(block, 1, block.getDamageValue(world, x, y, z)));
		IRecipe recipe = findRecipe(crafting, world);
		if(recipe == null)
			return null;
		return recipe.getCraftingResult(crafting);
	}
	

	private static IRecipe findRecipe(InventoryCrafting crafting, World world)
	{
		for (IRecipe recipe : (List<IRecipe>)CraftingManager.getInstance().getRecipeList())
			if (recipe.matches(crafting, world))
				return recipe;
		return null;
	}
}
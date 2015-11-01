package com.oitsjustjose.GlassWorks.Event;

import com.oitsjustjose.GlassWorks.Util.ConfigHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CropEvent
{
	@SubscribeEvent
	public void PlayerRightClickEvent(PlayerInteractEvent event)
	{
		if(ConfigHandler.allowCropFeature)
		{
			Block crop = event.world.getBlockState(event.pos).getBlock();
			if(event.entityPlayer.getCurrentEquippedItem() == null && event.action == Action.RIGHT_CLICK_BLOCK &&
					crop != null)
			{	
				EntityPlayer player = event.entityPlayer;
				World world = event.world;
				IBlockState cropState = event.world.getBlockState(event.pos);
				int dropRate = event.world.rand.nextInt(3) + 1;
				ItemStack drops = new ItemStack(crop.getItemDropped(cropState, event.world.rand, Short.MAX_VALUE), dropRate);
				
				if(crop instanceof BlockCrops && crop.getMetaFromState(cropState) >= 7)
				{
					event.entityPlayer.swingItem();
					if(!world.isRemote)
					{
						EntityItem droppedItem = new EntityItem(world, event.pos.getX(), event.pos.getY(), event.pos.getZ(), drops);
						world.setBlockState(event.pos, crop.getDefaultState());
						world.spawnEntityInWorld(droppedItem);
					}
				}
			}
		}
	}
}

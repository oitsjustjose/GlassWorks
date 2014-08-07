package com.oitsjustjose.GlassWorks.Event;

import com.oitsjustjose.GlassWorks.Util.ConfigHandler;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.Action;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class CropEvent
{
	@SubscribeEvent
	public void PlayerRightClickEvent(PlayerInteractEvent event)
	{
		if(ConfigHandler.allowCropFeature)
		{
			EntityPlayer player = event.entityPlayer;
			World world = event.world;
			Block crop = world.getBlock(event.x, event.y, event.z);
			int cropMeta = world.getBlockMetadata(event.x, event.y, event.z);
			int dropRate = event.world.rand.nextInt(3) + 1;
			ItemStack drops = new ItemStack(crop.getItemDropped(cropMeta, event.world.rand, Short.MAX_VALUE), dropRate);
			
			
			if(player.getCurrentEquippedItem() == null && event.action == Action.RIGHT_CLICK_BLOCK && crop != null)
			{	
				if(crop instanceof BlockCrops && cropMeta >= 7)
				{
					event.entityPlayer.swingItem();
					if(!world.isRemote)
					{
						EntityItem droppedItem = new EntityItem(world, event.x, event.y, event.z, drops);
						world.setBlockMetadataWithNotify(event.x, event.y, event.z, 0, 3);
						world.spawnEntityInWorld(droppedItem);
					}
				}
			}
		}
	}
}

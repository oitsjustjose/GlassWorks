package com.oitsjustjose.GlassWorks.Item;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.oitsjustjose.GlassWorks.GlassWorks;
import com.oitsjustjose.GlassWorks.Util.ConfigHandler;
import com.oitsjustjose.GlassWorks.Util.OreDictUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSaw extends ItemAxe
{
	IIcon icon;
	
	public ItemSaw()
	{
		super(ToolMaterial.EMERALD);
		setCreativeTab(GlassWorks.tabGlass);
		setContainerItem(this);
		setMaxStackSize(1);
		setUnlocalizedName("Saw");
		setMaxDamage(ConfigHandler.reduceUses ? (1561 / 2) : 1561);
		canRepair = false;
	}
	
	@Override
    public ItemStack getContainerItem(ItemStack itemStack)
    {
        if (!hasContainerItem())
            return null;
        int meta = itemStack.getItemDamage();
        return new ItemStack(this, 1, meta);
    }
	
	@Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemstack)
    {
		return false;
    }
	
	@Override
	public boolean onLeftClickEntity(ItemStack itemstack, EntityPlayer player, Entity entity)
	{
		DamageSource dmgSrc = new DamageSource("String");
		entity.attackEntityFrom(dmgSrc.causePlayerDamage(player), 5.0F);
		itemstack.damageItem(1, player);
		return false;
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		icon = register.registerIcon("GlassWorks:Saw");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int meta)
	{
		return icon;
	}
	
//	@Override
//	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ )
//	{
//		Block getBlock = world.getBlock(x, y, z);
//		Random random = new Random();
//		int meta = world.getBlockMetadata(x, y, z);
//		int woodRand = random.nextInt(3) + 1;
//		ItemStack planks;
//		
//		if(!world.isRemote)
//		{
//			if(getBlock == Blocks.log)
//			{
//				world.setBlock(x, y, z, Blocks.air);
//				world.playSoundAtEntity(player, "random.wood_click", 1.0F, 1.0F);
//				world.spawnParticle("iconcrack_1", (double)hitX, (double)hitY, (double)hitZ, 0.0D, 1.0D, 0.0D);
//				itemstack.damageItem(1, player);
//				player.worldObj.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Blocks.planks, 8, OreDictUtils.LogConverter1(meta))));
//				return true;
//			}
//			else if(getBlock == Blocks.log2)
//			{
//				world.setBlock(x, y, z, Blocks.air);
//				world.playSoundAtEntity(player, "random.wood_click", 1.0F, 1.0F);
//				world.spawnParticle("iconcrack_1", (double)hitX, (double)hitY, (double)hitZ, 0.0D, 1.0D, 0.0D);
//				itemstack.damageItem(1, player);
//				player.worldObj.spawnEntityInWorld(new EntityItem(world, x, y, z, new ItemStack(Blocks.planks, 8, OreDictUtils.LogConverter2(meta))));
//				return true;
//			}
//
//			return false;
//		}
//		return false;
//	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return false;
	}
}

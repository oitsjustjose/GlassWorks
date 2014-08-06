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
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}
}

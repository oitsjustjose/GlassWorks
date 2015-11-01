package com.oitsjustjose.GlassWorks.Item;

import com.oitsjustjose.GlassWorks.GlassWorks;
import com.oitsjustjose.GlassWorks.Util.ConfigHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSaw extends ItemAxe
{
	
	public ItemSaw()
	{
		super(ToolMaterial.EMERALD);
		setCreativeTab(GlassWorks.GlassWorksTab);
		setContainerItem(this);
		setMaxStackSize(1);
		setUnlocalizedName("Saw");
		setMaxDamage(ConfigHandler.reduceUses ? (1561 / 2) : 1561);
		GameRegistry.registerItem(this, "Saw");
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack itemstack, EntityPlayer player, Entity entity)
	{
		DamageSource dmgSrc = new DamageSource("String");
		entity.attackEntityFrom(dmgSrc.causePlayerDamage(player), 5.0F);
		itemstack.damageItem(1, player);
		return false;
	}
}

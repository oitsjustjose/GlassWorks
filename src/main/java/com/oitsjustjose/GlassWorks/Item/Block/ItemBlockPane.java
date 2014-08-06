package com.oitsjustjose.GlassWorks.Item.Block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;

public class ItemBlockPane extends ItemBlock
{
	public ItemBlockPane(Block block)
	{
		super(block);
        setMaxDamage(0);
        setHasSubtypes(true);
	}

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
    	int meta = MathHelper.clamp_int(itemStack.getItemDamage(), 0, 7);
        return super.getUnlocalizedName() + meta;
    }
    
    @Override
    public int getMetadata(int par1)
    {
        return par1;
    }
}
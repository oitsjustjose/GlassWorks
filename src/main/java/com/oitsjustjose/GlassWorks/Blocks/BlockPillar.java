//package com.oitsjustjose.GlassWorks.Blocks;
//
//import java.util.List;
//
//import com.oitsjustjose.GlassWorks.GlassWorks;
//
//import net.minecraft.block.Block;
//import net.minecraft.block.material.Material;
//import net.minecraft.creativetab.CreativeTabs;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.world.IBlockAccess;
//import net.minecraftforge.fml.relauncher.Side;
//import net.minecraftforge.fml.relauncher.SideOnly;
//
//public class BlockPillar extends Block
//{
//
//	public BlockPillar()
//	{
//		super(Material.rock);
//		setCreativeTab(GlassWorks.GlassWorksTab);
//		setResistance(4.0F);
//		setHardness(2.0F);
//		setStepSound(Block.soundTypeStone);
//	}
//
//    @Override
//    public int damageDropped(int par1)
//    {
//    	return par1;
//    }
//    
//    @Override
//    @SideOnly(Side.CLIENT)
//    public int getBlockColor()
//    {
//    	return this.getRenderColor(Block.getIdFromBlock(this));
//    }
//    
//    @Override
//    @SideOnly(Side.CLIENT)
//    public int getRenderColor(int par1)
//    {
//    	switch(par1)
//    	{
//    	case 0:return 2960685;
//    	case 1:return 8947848;
//    	case 2:return 16777215;
//    	case 3:return 2960685;
//    	case 4:return 16777215;
//    	default:return 0;
//    	}
//    }
//    
//    @Override
//    @SideOnly(Side.CLIENT)
//    public int colorMultiplier(IBlockAccess world, int x, int y, int z)
//    {
//    	int meta = world.getBlockMetadata(x, y, z);
//    	switch(meta)	
//    	{
//    	case 0:return 2960685;
//    	case 1:return 8947848;
//    	case 2:return 16777215;
//    	case 3:return 2960685;
//    	case 4:return 16777215;
//    	default:return 0;
//    	}
//    }
//           
//    @Override
//    @SideOnly(Side.CLIENT)
//    public void getSubBlocks(Item item, CreativeTabs tab, List list)
//    {
//    	for(int meta=0;meta<5;meta++)
//    		list.add(new ItemStack(item, 1, meta));
//    }
//}
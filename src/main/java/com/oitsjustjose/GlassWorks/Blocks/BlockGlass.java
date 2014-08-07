package com.oitsjustjose.GlassWorks.Blocks;

import com.oitsjustjose.GlassWorks.GlassWorks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import java.util.List;

public class BlockGlass extends Block
{
	public static IIcon[] OakTextures = new IIcon[47];
	public static IIcon[] SpruceTextures = new IIcon[47];
	public static IIcon[] BirchTextures = new IIcon[47];
	public static IIcon[] JungleTextures = new IIcon[47];
	public static IIcon[] DarkOakTextures = new IIcon[47];
	public static IIcon[] AcaciaTextures = new IIcon[47];
    public static IIcon[] ClearTextures = new IIcon[47];

    public static int[] textureRefByID = { 0, 0, 6, 6, 0, 0, 6, 6, 3, 3, 19, 15,
		3, 3, 19, 15, 1, 1, 18, 18, 1, 1, 13, 13, 2, 2, 23, 31, 2, 2, 27, 14, 0, 
		0, 6, 6, 0, 0, 6, 6, 3, 3, 19, 15, 3, 3, 19, 15, 1, 1, 18, 18, 1, 1, 13, 
		13, 2, 2, 23, 31, 2, 2, 27, 14, 4, 4, 5, 5, 4, 4, 5, 5, 17, 17, 22, 26, 
		17, 17, 22, 26, 16, 16, 20, 20, 16, 16, 28, 28, 21, 21, 46, 42, 21, 21, 
		43, 38, 4, 4, 5, 5, 4, 4, 5, 5, 9, 9, 30, 12, 9, 9, 30, 12, 16, 16, 20, 
		20, 16, 16, 28, 28, 25, 25, 45, 37, 25, 25, 40, 32, 0, 0, 6, 6, 0, 0, 6, 
		6, 3, 3, 19, 15, 3, 3, 19, 15, 1, 1, 18, 18, 1, 1, 13, 13, 2, 2, 23, 31, 
		2, 2, 27, 14, 0, 0, 6, 6, 0, 0, 6, 6, 3, 3, 19, 15, 3, 3, 19, 15, 1, 1, 
		18, 18, 1, 1, 13, 13, 2, 2, 23, 31, 2, 2, 27, 14, 4, 4, 5, 5, 4, 4, 5, 5, 
		17, 17, 22, 26, 17, 17, 22, 26, 7, 7, 24, 24, 7, 7, 10, 10, 29, 29, 44, 41, 
		29, 29, 39, 33, 4, 4, 5, 5, 4, 4, 5, 5, 9, 9, 30, 12, 9, 9, 30, 12, 7, 7, 
		24, 24, 7, 7, 10, 10, 8, 8, 36, 35, 8, 8, 34, 11 };

	public BlockGlass()
	{
		super(Material.glass);
		setCreativeTab(GlassWorks.GlassWorksTab);
		setResistance(1.0F);
		setHardness(0.5F);
		setStepSound(Block.soundTypeGlass);
	}

	@Override
	public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side)
	{
		boolean[] bitMatrix = new boolean[8];
		int meta = world.getBlockMetadata(x, y, z);

		if(Minecraft.isFancyGraphicsEnabled())
		{
			if(side == 0 || side == 1)
			{
				bitMatrix[0] = world.getBlock(x-1, y, z-1) == this && world.getBlockMetadata(x-1, y, z-1) == meta;
	            bitMatrix[1] = world.getBlock(x, y, z-1) == this && world.getBlockMetadata(x, y, z-1) == meta;
	            bitMatrix[2] = world.getBlock(x+1, y, z-1) == this && world.getBlockMetadata(x+1, y, z-1) == meta;
	            bitMatrix[3] = world.getBlock(x-1, y, z) == this && world.getBlockMetadata(x-1, y, z) == meta;
	            bitMatrix[4] = world.getBlock(x+1, y, z) == this && world.getBlockMetadata(x+1, y, z) == meta;
	            bitMatrix[5] = world.getBlock(x-1, y, z+1) == this && world.getBlockMetadata(x-1, y, z+1) == meta;
	            bitMatrix[6] = world.getBlock(x, y, z+1) == this && world.getBlockMetadata(x, y, z+1) == meta;
	            bitMatrix[7] = world.getBlock(x+1, y, z+1) == this && world.getBlockMetadata(x+1, y, z+1) == meta;
			}
			else if(side == 2 || side == 3)
			{
				bitMatrix[0] = world.getBlock(x+(side==2?1:-1), y+1, z) == this && world.getBlockMetadata(x+(side==2?1:-1), y+1, z) == meta;
	            bitMatrix[1] = world.getBlock(x, y+1, z) == this && world.getBlockMetadata(x, y+1, z) == meta;
	            bitMatrix[2] = world.getBlock(x+(side==3?1:-1), y+1, z) == this && world.getBlockMetadata(x+(side==3?1:-1), y+1, z) == meta;
	            bitMatrix[3] = world.getBlock(x+(side==2?1:-1), y, z) == this && world.getBlockMetadata(x+(side==2?1:-1), y, z) == meta;
	            bitMatrix[4] = world.getBlock(x+(side==3?1:-1), y, z) == this && world.getBlockMetadata(x+(side==3?1:-1), y, z) == meta;
	            bitMatrix[5] = world.getBlock(x+(side==2?1:-1), y-1, z) == this && world.getBlockMetadata(x+(side==2?1:-1), y-1, z) == meta;
	            bitMatrix[6] = world.getBlock(x, y-1, z) == this && world.getBlockMetadata(x, y-1, z) == meta;
	            bitMatrix[7] = world.getBlock(x+(side==3?1:-1), y-1, z) == this && world.getBlockMetadata(x+(side==3?1:-1), y-1, z) == meta;
			}
			else if(side == 4 || side == 5)
			{
	            bitMatrix[0] = world.getBlock(x, y+1, z+(side==5?1:-1)) == this && world.getBlockMetadata(x, y+1, z+(side==5?1:-1)) == meta;
	            bitMatrix[1] = world.getBlock(x, y+1, z) == this && world.getBlockMetadata(x, y+1, z) == meta;
	            bitMatrix[2] = world.getBlock(x, y+1, z+(side==4?1:-1)) == this && world.getBlockMetadata(x, y+1, z+(side==4?1:-1)) == meta;
	            bitMatrix[3] = world.getBlock(x, y, z+(side==5?1:-1)) == this && world.getBlockMetadata(x, y, z+(side==5?1:-1)) == meta;
	            bitMatrix[4] = world.getBlock(x, y, z+(side==4?1:-1)) == this && world.getBlockMetadata(x, y, z+(side==4?1:-1)) == meta;
	            bitMatrix[5] = world.getBlock(x, y-1, z+(side==5?1:-1)) == this && world.getBlockMetadata(x, y-1, z+(side==5?1:-1)) == meta;
	            bitMatrix[6] = world.getBlock(x, y-1, z) == this && world.getBlockMetadata(x, y-1, z) == meta;
	            bitMatrix[7] = world.getBlock(x, y-1, z+(side==4?1:-1)) == this && world.getBlockMetadata(x, y-1, z+(side==4?1:-1)) == meta;
			}

			int idBuilder = 0;
			for(int i=0;i<=7;i++)
				idBuilder = idBuilder + (bitMatrix[i]?(i==0?1:(i==1?2:(i==2?4:(i==3?8:(i==4?16:(i==5?32:(i==6?64:128))))))):0);

			switch(meta)
			{
				case 0:return idBuilder>255 || idBuilder<0 ? OakTextures[0]:OakTextures[textureRefByID[idBuilder]];
				case 1:return idBuilder>255 || idBuilder<0 ? SpruceTextures[0]:SpruceTextures[textureRefByID[idBuilder]];
				case 2:return idBuilder>255 || idBuilder<0 ? BirchTextures[0]:BirchTextures[textureRefByID[idBuilder]];
				case 3:return idBuilder>255 || idBuilder<0 ? JungleTextures[0]:JungleTextures[textureRefByID[idBuilder]];
				case 4:return idBuilder>255 || idBuilder<0 ? AcaciaTextures[0]:AcaciaTextures[textureRefByID[idBuilder]];
                case 5:return idBuilder>255 || idBuilder<0 ? DarkOakTextures[0]:DarkOakTextures[textureRefByID[idBuilder]];
                case 6:return idBuilder>255 || idBuilder<0 ? ClearTextures[0]:ClearTextures[textureRefByID[idBuilder]];
                default:return idBuilder>255 || idBuilder<0 ? OakTextures[0]:OakTextures[textureRefByID[idBuilder]];
			}	
		}

		else
		{
			switch(meta)
			{
				case 0:return OakTextures[0];
				case 1:return SpruceTextures[0];
				case 2:return BirchTextures[0];
				case 3:return JungleTextures[0];
				case 4:return AcaciaTextures[0];
                case 5:return DarkOakTextures[0];
                case 6:return ClearTextures[0];
                default:return OakTextures[0];
			}
		}
	}

	@Override
    public IIcon getIcon(int side, int meta)
    {
		switch(meta)
		{
			case 0:return OakTextures[0];
			case 1:return SpruceTextures[0];
			case 2:return BirchTextures[0];
			case 3:return JungleTextures[0];
			case 4:return AcaciaTextures[0];
            case 5:return DarkOakTextures[0];
            case 6:return ClearTextures[0];
            default:return OakTextures[0];
		}
    }
    
    @Override
	public void registerBlockIcons(IIconRegister IIconRegistry)
	{
		for(int i=0;i<47;i++)
		{
			OakTextures[i] = IIconRegistry.registerIcon("GlassWorks:CTM/Glass/Oak/" + (i+1));
			BirchTextures[i] = IIconRegistry.registerIcon("GlassWorks:CTM/Glass/Birch/" + (i+1));
			SpruceTextures[i] = IIconRegistry.registerIcon("GlassWorks:CTM/Glass/Spruce/" + (i+1));
			JungleTextures[i] = IIconRegistry.registerIcon("GlassWorks:CTM/Glass/Jungle/" + (i+1));
			AcaciaTextures[i] = IIconRegistry.registerIcon("GlassWorks:CTM/Glass/Acacia/" + (i+1));
            DarkOakTextures[i] = IIconRegistry.registerIcon("GlassWorks:CTM/Glass/Dark Oak/" + (i+1));
            ClearTextures[i] = IIconRegistry.registerIcon("GlassWorks:CTM/Glass/Clear/" + (i+1));
        }
	}

    @Override
    public int damageDropped(int par1)
    {
    	return par1;
    }
    
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public int getRenderBlockPass()
    {
        return 0;
    }
    
    @Override
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
        Block i1 = par1IBlockAccess.getBlock(par2, par3, par4);
        return i1 == this ? false : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
    }
    
    @Override
    public void getSubBlocks(Item item, CreativeTabs tab, List list)
    {
    	for(int meta=0;meta<7;meta++)
    		list.add(new ItemStack(item, 1, meta));
    }
}
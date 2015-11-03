package com.oitsjustjose.GlassWorks.Blocks;

import java.util.List;

import com.oitsjustjose.GlassWorks.GlassWorks;
import com.oitsjustjose.GlassWorks.Item.Block.ItemBlockGlass;
import com.oitsjustjose.GlassWorks.Util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGlass extends Block
{
	public static final PropertyEnum VARIANT = PropertyEnum.create("type", EGlassTypes.class);
	public static String unlocName = "BlockGlass";
	
	public BlockGlass()
	{
		super(Material.glass);
		this.setCreativeTab(GlassWorks.GlassWorksTab);
		this.setResistance(1.0F);
		this.setHardness(0.5F);
		this.setStepSound(Block.soundTypeGlass);
		this.setUnlocalizedName(unlocName);
		GameRegistry.registerBlock(this, ItemBlockGlass.class, unlocName);
	}
	
	@Override
	public int damageDropped(IBlockState state)
	{
		return ((EGlassTypes) state.getValue(VARIANT)).getMetadata();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, EGlassTypes.byMetadata(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((EGlassTypes) state.getValue(VARIANT)).getMetadata();
	}
	
	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] { VARIANT });
	}
	
	public static void inventoryRender()
	{
		Item itemBlockBrickVariants = GameRegistry.findItem(Reference.MODID, unlocName);
		
		for(int meta = 0; meta < 8; meta++)
			ModelBakery.addVariantName(itemBlockBrickVariants, "glassworks:glass_" + meta);
		
		Item itemBlockVariants = GameRegistry.findItem(Reference.MODID, unlocName);
		EGlassTypes[] aenumtype = EGlassTypes.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			EGlassTypes enumtype = aenumtype[j];
			ModelResourceLocation itemModelResourceLocation = new ModelResourceLocation(Reference.MODID + ":" + "glass_" + j, "inventory");
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(itemBlockVariants, enumtype.getMetadata(), itemModelResourceLocation);
		}
	}
	
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
    
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
	{
		EGlassTypes[] aenumtype = EGlassTypes.values();
		int i = aenumtype.length;
		
		for (int j = 0; j < i; ++j)
		{
			EGlassTypes enumtype = aenumtype[j];
			list.add(new ItemStack(itemIn, 1, enumtype.getMetadata()));
		}
	}
}
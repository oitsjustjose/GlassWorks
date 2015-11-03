package com.oitsjustjose.GlassWorks.Blocks;

import net.minecraft.util.IStringSerializable;

public enum EPillarTypes implements IStringSerializable
{
	BLACKPILLAR(0, "blackPillar"),
	GRAYPILLAR(1, "grayPillar"),
	WHITEPILLAR(2, "whitePillar"),
	BLACKBRICK(3, "blackBrick"),
	WHITEBRICK(4, "whiteBrick");
	
	
	private static final EPillarTypes[]	META_LOOKUP	= new EPillarTypes[values().length];
	private final int					meta;
	private final String				name;
	private final String				unlocalizedName;
	
	private EPillarTypes(int meta, String name)
	{
		this(meta, name, name);
	}
	
	private EPillarTypes(int meta, String name, String unlocalizedName)
	{
		this.meta = meta;
		this.name = name;
		this.unlocalizedName = unlocalizedName;
	}
	
	public int getMetadata()
	{
		return this.meta;
	}
	
	@Override
	public String toString()
	{
		return this.name;
	}
	
	public static EPillarTypes byMetadata(int meta)
	{
		if (meta < 0 || meta >= META_LOOKUP.length)
		{
			meta = 0;
		}
		
		return META_LOOKUP[meta];
	}
	
	@Override
	public String getName()
	{
		return this.name;
	}
	
	public String getUnlocalizedName()
	{
		return this.unlocalizedName;
	}
	
	static
	{
		EPillarTypes[] var0 = values();
		int var1 = var0.length;
		
		for (int var2 = 0; var2 < var1; ++var2)
		{
			EPillarTypes var3 = var0[var2];
			META_LOOKUP[var3.getMetadata()] = var3;
		}
	}
}
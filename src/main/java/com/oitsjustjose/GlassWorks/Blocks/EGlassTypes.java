package com.oitsjustjose.GlassWorks.Blocks;

import net.minecraft.util.IStringSerializable;

public enum EGlassTypes implements IStringSerializable
{
	OAK(0, "oak"),
	SPRUCE(1, "spruce"),
	BIRCH(2, "birch"),
	JUNGLE(3, "jungle"),
	ACACIA(4, "acacia"),
	DARKOAK(5, "darkoak"),
	CLEAR(6, "clear");
	
	
	private static final EGlassTypes[]	META_LOOKUP	= new EGlassTypes[values().length];
	private final int					meta;
	private final String				name;
	private final String				unlocalizedName;
	
	private EGlassTypes(int meta, String name)
	{
		this(meta, name, name);
	}
	
	private EGlassTypes(int meta, String name, String unlocalizedName)
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
	
	public static EGlassTypes byMetadata(int meta)
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
		EGlassTypes[] var0 = values();
		int var1 = var0.length;
		
		for (int var2 = 0; var2 < var1; ++var2)
		{
			EGlassTypes var3 = var0[var2];
			META_LOOKUP[var3.getMetadata()] = var3;
		}
	}
}
package com.oitsjustjose.GlassWorks.Util;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictUtils
{
	public static String[] dyes = new String[] {"dyeBlack", "dyeRed", "dyeGreen", "dyeBrown", "dyeBlue", "dyePurple", "dyeCyan", "dyeLightGray",
			"dyeGray", "dyePink", "dyeLime", "dyeYellow", "dyeLightBlue", "dyeMagenta", "dyeOrange", "dyeWhite"};
	
	public static String[] COLORS = new String[] {"Black", "Red", "Green", "Brown", "Blue", "Purple", "Cyan", "Light Gray", "Gray", "Pink", "Lime", "Yellow", "Light Blue",
		"Magenta", "Orange", "White"};
	
	public static int WoolConverter(int input)
	{
		switch(input)
		{
		case 0:return 15;
		case 1:return 14;
		case 2:return 13;
		case 3:return 12;
		case 4:return 11;
		case 5:return 10;
		case 6:return 9;
		case 7:return 8;
		case 8:return 7;
		case 9:return 6;
		case 10:return 5;
		case 11:return 4;
		case 12:return 3;
		case 13:return 2;
		case 14:return 1;
		case 15:return 0;
		default:return 0;
		}
	}
	
	public static int LogConverter1(int input)
	{
		switch(input)
		{
		case 0:return 0;
		case 1:return 1;
		case 2:return 2;
		case 3:return 3;
		case 4:return 0;
		case 5:return 1;
		case 6:return 2;
		case 7:return 3;
		case 8:return 0;
		case 9:return 1;
		case 10:return 2;
		case 11:return 3;
		case 12:return 0;
		case 13:return 1;
		case 14:return 2;
		case 15:return 3;
		default:return 0;
		}
	}
	
	public static int LogConverter2(int input)
	{
		switch(input)
		{
		case 0:return 4;
		case 1:return 5;
		case 4:return 4;
		case 5:return 5;
		case 8:return 4;
		case 9:return 5;
		case 12:return 4;
		case 13:return 5;
		default:return 0;
		}
	}
}

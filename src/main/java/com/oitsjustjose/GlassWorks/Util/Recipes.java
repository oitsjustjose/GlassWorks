package com.oitsjustjose.GlassWorks.Util;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import com.oitsjustjose.GlassWorks.Blocks.ModBlocks;
import com.oitsjustjose.GlassWorks.Item.ModItems;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes
{
	public static int black = 3;
	public static int white = 4;
	
    public static void init()
    {
    	//Glass Recipes
    	
        for(int i = 0; i < 6; ++i)
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.BlockGlass, 8, i),
                    "GGG", "GDG", "GGG", 'G', "blockGlass", 'D', new ItemStack(Blocks.planks, 1, i)
            ));

       	GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.sawDiamond),
       			"  S", " SA", "SD ", 'S', "stickWood", 'D', Items.diamond, 'A', Items.diamond_axe));
        
       	GameRegistry.addSmelting(Blocks.glass, new ItemStack(ModBlocks.BlockGlass, 1, 6), 0.0F);
       	stoneRecipes();
    }
    
    static void stoneRecipes()
    {
    	//Pillar Recipes
        GameRegistry.addRecipe(new ItemStack(ModBlocks.BlockPillar, 2, 1), new Object[]{
            "S", "S", 'S', new ItemStack(Blocks.stonebrick, 1, Short.MAX_VALUE)
        });
        
        GameRegistry.addRecipe(new ItemStack(ModBlocks.BlockPillar, 2, 0), new Object[]{
            "S", "S", 'S', new ItemStack(ModBlocks.BlockPillar, 1, black)
        });
        
        GameRegistry.addRecipe(new ItemStack(ModBlocks.BlockPillar, 2, 2), new Object[]{
            "S", "S", 'S', new ItemStack(ModBlocks.BlockPillar, 1, white)
        });
        
        //Brick Recipes
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.BlockPillar, 1, black),
        		"BBB", "BDB", "BBB", 'B', Blocks.stonebrick, 'D', "dyeBlack"
        ));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.BlockPillar, 1, white),
        		"BBB", "BDB", "BBB", 'B', Blocks.stonebrick, 'D', "dyeWhite"
        ));
    }
}

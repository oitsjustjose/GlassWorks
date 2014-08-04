package com.oitsjustjose.GlassWorks.Util;

import com.oitsjustjose.GlassWorks.Blocks.ModBlocks;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class Recipes
{
    public static void init()
    {
        for(int i = 0; i < 6; ++i)
        {
            GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.BlockGlass, 8, i),
                    "GGG", "GDG", "GGG", 'G', "blockGlass", 'D', new ItemStack(Blocks.planks, 1, i)
            ));
        }

        GameRegistry.addRecipe(new ItemStack(ModBlocks.BlockPillar, 2, 1), new Object[]{
            "S", "S", 'S', new ItemStack(Blocks.stonebrick, 1, Short.MAX_VALUE)
        });

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.BlockPillar, 8, 0),
                "PPP", "PDP", "PPP", 'P', new ItemStack(ModBlocks.BlockPillar, 1, Short.MAX_VALUE), 'D', "dyeBlack"
        ));

        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.BlockPillar, 1, 0),
                "dyeBlack", new ItemStack(ModBlocks.BlockPillar, 1, Short.MAX_VALUE)));

        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModBlocks.BlockPillar, 8, 2),
                "PPP", "PDP", "PPP", 'P', new ItemStack(ModBlocks.BlockPillar, 1, Short.MAX_VALUE), 'D', "dyeWhite"
        ));

        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModBlocks.BlockPillar, 1, 2),
                "dyeWhite", new ItemStack(ModBlocks.BlockPillar, 1, Short.MAX_VALUE)));

        GameRegistry.addSmelting(Blocks.glass, new ItemStack(ModBlocks.BlockGlass, 1, 6), 0.0F);
    }
}

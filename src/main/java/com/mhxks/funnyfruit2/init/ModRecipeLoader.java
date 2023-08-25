package com.mhxks.funnyfruit2.init;

import com.mhxks.funnyfruit2.block.BlockWithTileEntity;
import ic2.api.item.IC2Items;
import ic2.api.recipe.Recipes;
import ic2.core.block.BlockTileEntity;
import ic2.core.block.TeBlockRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ModRecipeLoader {
    public ModRecipeLoader(){
        Recipes.advRecipes.addRecipe(new ItemStack(ModBlockLoader.DOUBLE_FUNNY_FRUIT_GENERATOR),
                new Object[]{
                        "ABA",
                        "CDC",
                        "AEA",
                        'A',IC2Items.getItem("crafting","alloy"),
                        'B',getAllTypeStack(IC2Items.getItem("energy_crystal")),
                        'C',IC2Items.getItem("crafting","advanced_circuit"),
                        'D',ModItemLoader.GOLDEN_FUNNY_FRUIT,
                        'E',ModBlockLoader.NORMAL_FUNNY_FRUIT_GENERATOR
                });
        //三级发电机
        Recipes.advRecipes.addRecipe(new ItemStack(ModBlockLoader.TRIPLE_FUNNY_FRUIT_GENERATOR),
                new Object[]{
                        "ABA",
                        "CDC",
                        "AEA",
                        //合金板
                        'A',IC2Items.getItem("crafting","alloy"),
                        //获取兰波顿所有形态
                        'B',getAllTypeStack(IC2Items.getItem("lapotron_crystal")),
                        //高级电路板
                        'C',IC2Items.getItem("crafting","advanced_circuit"),
                        'D',ModItemLoader.DIAMOND_FUNNY_FRUIT,
                        'E',ModBlockLoader.DOUBLE_FUNNY_FRUIT_GENERATOR

                });
        //碧波能量水晶
        Recipes.advRecipes.addRecipe(new ItemStack(ModItemLoader.DIAMOND_IRIDIUM_CRYSTAL),
                new Object[]{
                        "ABA",
                        "CDC",
                        "ABA",
                        'A',ModItemLoader.DIAMOND_IRIDIUM,
                        'B',IC2Items.getItem("dust","diamond"),
                        'C',IC2Items.getItem("crafting","advanced_circuit"),
                        'D',getAllTypeStack(IC2Items.getItem("lapotron_crystal")),
                }
                );
        //钻石铱量子甲
        Recipes.advRecipes.addRecipe(new ItemStack(ModItemLoader.DIAMOND_IRIDIUM_CHEST),
                new Object[]{
                        "CBC",
                        "ADA",
                        "CEC",
                        'A',IC2Items.getItem("crafting","alloy"),
                        'B',getAllTypeStack(IC2Items.getItem("quantum_chestplate")),
                        'C',ModItemLoader.DIAMOND_IRIDIUM,
                        'D',getAllTypeStack(new ItemStack(ModItemLoader.DIAMOND_IRIDIUM_CRYSTAL)),
                        'E',ModItemLoader.FUNNY_ESSENCE
                });
        Recipes.advRecipes.addRecipe(new ItemStack(ModItemLoader.DIAMOND_IRIDIUM_HELMENT),
                new Object[]{
                        "CBC",
                        "ADA",
                        "CEC",
                        'A',IC2Items.getItem("crafting","alloy"),
                        'B',getAllTypeStack(IC2Items.getItem("quantum_helmet")),
                        'C',ModItemLoader.DIAMOND_IRIDIUM,
                        'D',getAllTypeStack(new ItemStack(ModItemLoader.DIAMOND_IRIDIUM_CRYSTAL)),
                        'E',ModItemLoader.FUNNY_ESSENCE
                });

        Recipes.advRecipes.addRecipe(new ItemStack(ModItemLoader.DIAMOND_IRIDIUM_BOOTS),
                new Object[]{
                        "CBC",
                        "ADA",
                        "CEC",
                        'A',IC2Items.getItem("crafting","alloy"),
                        'B',getAllTypeStack(IC2Items.getItem("quantum_boots")),
                        'C',ModItemLoader.DIAMOND_IRIDIUM,
                        'D',getAllTypeStack(new ItemStack(ModItemLoader.DIAMOND_IRIDIUM_CRYSTAL)),
                        'E',ModItemLoader.FUNNY_ESSENCE
                });
        Recipes.advRecipes.addRecipe(new ItemStack(ModItemLoader.DIAMOND_IRIDIUM_LEGGINGS),
                new Object[]{
                        "CBC",
                        "ADA",
                        "CEC",
                        'A',IC2Items.getItem("crafting","alloy"),
                        'B',getAllTypeStack(IC2Items.getItem("quantum_leggings")),
                        'C',ModItemLoader.DIAMOND_IRIDIUM,
                        'D',getAllTypeStack(new ItemStack(ModItemLoader.DIAMOND_IRIDIUM_CRYSTAL)),
                        'E',ModItemLoader.FUNNY_ESSENCE
                });


        //方块
        BlockTileEntity teblock = TeBlockRegistry.get(BlockWithTileEntity.loc);
        //获取disu储电方块
        ItemStack disuStack = teblock.getItemStack(BlockWithTileEntity.disu);
        Recipes.advRecipes.addRecipe(disuStack,
                new Object[]{
                        "ABA",
                        "ACA",
                        "ADA",
                        'A',getAllTypeStack(new ItemStack(ModItemLoader.DIAMOND_IRIDIUM_CRYSTAL)),
                        'B',IC2Items.getItem("crafting","advanced_circuit"),
                        'C',IC2Items.getItem("te","mfsu"),
                        'D',ModItemLoader.FUNNY_ESSENCE
                });
        ItemStack disuChargedStack = teblock.getItemStack(BlockWithTileEntity.disu_charged);

        Recipes.advRecipes.addRecipe(disuChargedStack,
                new Object[]{
                        "   ",
                        "ABA",
                        "CDC",
                        'A',IC2Items.getItem("crafting","advanced_circuit"),
                        'B',Item.getItemFromBlock(Blocks.STONE_PRESSURE_PLATE),
                        'C',IC2Items.getItem("crafting","rubber"),
                        'D',disuStack
                });
        Recipes.advRecipes.addRecipe(new ItemStack(ModItemLoader.DIAMOND_IRIDIUM_ROTOR_TEMPLATE),
                new Object[]{
                        "ABA",
                        "BCB",
                        "DBD",
                        'A',ModItemLoader.DIAMOND_IRIDIUM,
                        'B',IC2Items.getItem("crafting","carbon_rotor_blade"),
                        'C',IC2Items.getItem("crafting","advanced_circuit"),
                        'D',IC2Items.getItem("cable","type:glass,insulation:0")
                });

    }
    public static ItemStack getAllTypeStack(ItemStack itemstack) {
        return new ItemStack(itemstack.getItem(), 1, OreDictionary.WILDCARD_VALUE);
    }
}

package com.mhxks.funnyfruit2.jei;

import com.mhxks.funnyfruit2.FunnyFruit2Main;
import com.mhxks.funnyfruit2.init.ModBlockLoader;
import com.mhxks.funnyfruit2.init.ModItemLoader;
import com.mhxks.funnyfruit2.inventory.ContainerNormalFunnyFruitGenerator;
import com.mhxks.funnyfruit2.jei.vanilla.generator.GeneratorCategory;
import com.mhxks.funnyfruit2.jei.vanilla.generator.GeneratorWrapper;
import mezz.jei.api.*;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import mezz.jei.api.recipe.IRecipeCategory;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@JEIPlugin
public class FunnyFruit2JEI
implements IModPlugin {
    //一个Category对应N个Wrapper
    //Wrapper包裹的该机器的其中某个合成
    //Category对应一个页面
    //Wrapper是category这个页面的每页
    @Override
    public void register(IModRegistry registry) {
        //展示什么内容
        registry.addRecipes(

                generatorWrapperList(new Item[]{ModItemLoader.FUNNY_FRUIT,ModItemLoader.GOLDEN_FUNNY_FRUIT}),
                UID.NORMAL_GENERATOR);
        //由何物品按U展示配方
        registry.addRecipeCatalyst(new ItemStack(ModBlockLoader.NORMAL_FUNNY_FRUIT_GENERATOR),UID.NORMAL_GENERATOR);

        registry.addRecipes(

                generatorWrapperList(new Item[]{ModItemLoader.FUNNY_FRUIT,ModItemLoader.GOLDEN_FUNNY_FRUIT}),
                UID.DOUBLE_GENERATOR);
        registry.addRecipeCatalyst(new ItemStack(ModBlockLoader.DOUBLE_FUNNY_FRUIT_GENERATOR),UID.DOUBLE_GENERATOR);

        registry.addRecipes(

                generatorWrapperList(new Item[]{ModItemLoader.FUNNY_FRUIT,ModItemLoader.GOLDEN_FUNNY_FRUIT}),
                UID.TRIPLE_GENERATOR);
        registry.addRecipeCatalyst(new ItemStack(ModBlockLoader.TRIPLE_FUNNY_FRUIT_GENERATOR),UID.TRIPLE_GENERATOR);

        registry.addRecipes(

                generatorWrapperList(new Item[]{ModItemLoader.FUNNY_FRUIT,ModItemLoader.GOLDEN_FUNNY_FRUIT,ModItemLoader.FUNNY_ESSENCE}),
                UID.ULTIMATE_GENERATOR);
        registry.addRecipeCatalyst(new ItemStack(ModBlockLoader.ULTIMATE_FUNNY_FRUIT_GENERATOR),UID.ULTIMATE_GENERATOR);
    }


    @Override
    public void registerCategories(IRecipeCategoryRegistration registry) {
        //gui绘制工具，要给Catogory类进行绘制
        IJeiHelpers jeiHelpers = registry.getJeiHelpers();
        IGuiHelper helper = jeiHelpers.getGuiHelper();
        //添加分类
        registry.addRecipeCategories(new GeneratorCategory(helper,UID.NORMAL_GENERATOR,ModBlockLoader.NORMAL_FUNNY_FRUIT_GENERATOR.getUnlocalizedName()));
        registry.addRecipeCategories(new GeneratorCategory(helper,UID.DOUBLE_GENERATOR,ModBlockLoader.DOUBLE_FUNNY_FRUIT_GENERATOR.getUnlocalizedName()));
        registry.addRecipeCategories(new GeneratorCategory(helper,UID.TRIPLE_GENERATOR,ModBlockLoader.TRIPLE_FUNNY_FRUIT_GENERATOR.getUnlocalizedName()));
        registry.addRecipeCategories(new GeneratorCategory(helper,UID.ULTIMATE_GENERATOR,ModBlockLoader.ULTIMATE_FUNNY_FRUIT_GENERATOR.getUnlocalizedName()));
    }


    @Override
    public void registerIngredients(IModIngredientRegistration registry) {
        IModPlugin.super.registerIngredients(registry);
    }
    //根据物品生成对应的多个Wrapper
    public static List<GeneratorWrapper> generatorWrapperList(ItemStack[] itemStacks){
        List<GeneratorWrapper> list = new ArrayList<>();
        for (ItemStack itemStack : itemStacks) {
            list.add(new GeneratorWrapper(itemStack));
        }
        return list;
    }
    public static List<GeneratorWrapper> generatorWrapperList(Item[] item){
        ItemStack[] itemStacks = new ItemStack[item.length];
        for (int i = 0; i < item.length; i++) {
            itemStacks[i] = new ItemStack(item[i]);
        }
        return generatorWrapperList(itemStacks);
    }
}

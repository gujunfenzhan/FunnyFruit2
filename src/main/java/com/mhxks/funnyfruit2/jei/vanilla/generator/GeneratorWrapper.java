package com.mhxks.funnyfruit2.jei.vanilla.generator;

import com.mhxks.funnyfruit2.init.ModItemLoader;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.ingredients.VanillaTypes;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

import java.util.List;

public class GeneratorWrapper
implements IRecipeWrapper {
    private ItemStack input;

    public GeneratorWrapper(ItemStack itemStack) {
        this.input = itemStack;
    }

    @Override
    public void getIngredients(IIngredients iIngredients) {
        iIngredients.setInput(VanillaTypes.ITEM,input);

    }

    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        IRecipeWrapper.super.drawInfo(minecraft, recipeWidth, recipeHeight, mouseX, mouseY);
    }

    @Override
    public List<String> getTooltipStrings(int mouseX, int mouseY) {
        return IRecipeWrapper.super.getTooltipStrings(mouseX, mouseY);
    }

    @Override
    public boolean handleClick(Minecraft minecraft, int mouseX, int mouseY, int mouseButton) {
        return IRecipeWrapper.super.handleClick(minecraft, mouseX, mouseY, mouseButton);
    }
}

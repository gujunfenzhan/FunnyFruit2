package com.mhxks.funnyfruit2.jei.vanilla.generator;

import com.mhxks.funnyfruit2.FunnyFruit2Main;
import com.mhxks.funnyfruit2.client.gui.GuiFunnyFruitGenerator;
import com.mhxks.funnyfruit2.inventory.ContainerFunnyFruitGenerator;
import com.mhxks.funnyfruit2.jei.LeftToRightNote;
import com.mhxks.funnyfruit2.jei.UID;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

import java.util.List;

public class GeneratorCategory
implements IRecipeCategory<GeneratorWrapper> {
    private final IDrawable background;
    private String uid;
    private String unName;
    private final IDrawable fuel;
    private final IDrawable energy;
    public GeneratorCategory(IGuiHelper helper,String uid,String unName) {
        this.background = helper.createDrawable(GuiFunnyFruitGenerator.TEXTURES,5, 5, 166,81);
        this.uid = uid;
        this.unName = unName;
        this.fuel = helper.drawableBuilder(GuiFunnyFruitGenerator.TEXTURES,0,171,100,2).buildAnimated(new LeftToRightNote(100), IDrawableAnimated.StartDirection.LEFT);
        this.energy = helper.drawableBuilder(GuiFunnyFruitGenerator.TEXTURES,176,0,24,17).buildAnimated(new LeftToRightNote(24), IDrawableAnimated.StartDirection.LEFT);
    }

    @Override
    public String getUid() {
        return uid;
    }

    @Override
    public String getTitle() {
        return I18n.format(unName+".name");
    }

    @Override
    public String getModName() {
        return FunnyFruit2Main.MODID;
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public void setRecipe(IRecipeLayout iRecipeLayout, GeneratorWrapper generatorWrapper, IIngredients iIngredients) {
        IGuiItemStackGroup iGuiItemStackGroup = iRecipeLayout.getItemStacks();
        iGuiItemStackGroup.init(0,true,74,51);
        iGuiItemStackGroup.set(iIngredients);
    }

    @Override
    public void drawExtras(Minecraft minecraft) {
        this.fuel.draw(minecraft,33,76);
        this.energy.draw(minecraft,71,14);
    }
}

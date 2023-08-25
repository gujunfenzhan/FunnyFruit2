package com.mhxks.funnyfruit2.creativetab;

import com.mhxks.funnyfruit2.init.ModItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabFunnyFruit
extends CreativeTabs {
    public CreativeTabFunnyFruit() {
        super("creativeTab.funnyfruit");
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ModItemLoader.FUNNY_FRUIT);
    }
}

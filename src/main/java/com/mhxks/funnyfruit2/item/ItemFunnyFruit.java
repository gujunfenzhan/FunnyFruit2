package com.mhxks.funnyfruit2.item;

import com.mhxks.funnyfruit2.init.ModCreativeTabLoader;
import net.minecraft.item.ItemFood;

public class ItemFunnyFruit
extends ItemFood {
    public ItemFunnyFruit() {
        super(6, false);
        this.setCreativeTab(ModCreativeTabLoader.FUNNY_FRUIT);
    }
}

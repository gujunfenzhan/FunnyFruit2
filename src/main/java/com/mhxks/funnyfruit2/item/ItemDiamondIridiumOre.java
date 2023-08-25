package com.mhxks.funnyfruit2.item;

import com.mhxks.funnyfruit2.init.ModCreativeTabLoader;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemDiamondIridiumOre
extends Item {
    public ItemDiamondIridiumOre() {
        this.setCreativeTab(ModCreativeTabLoader.FUNNY_FRUIT);
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }
}

package com.mhxks.funnyfruit2.item;

import com.mhxks.funnyfruit2.init.ModCreativeTabLoader;
import ic2.api.item.IElectricItem;
import ic2.core.item.ElectricItemManager;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemDiamondIridiumCrystal
    extends Item
implements IElectricItem {
    public ItemDiamondIridiumCrystal() {
        this.setCreativeTab(ModCreativeTabLoader.FUNNY_FRUIT);
        this.setMaxDamage(27);

    }
    //创造栏添加双形态水晶
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
        if (this.isInCreativeTab(tab)) {
            ElectricItemManager.addChargeVariants(this, subItems);
        }
    }
    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean canProvideEnergy(ItemStack stack) {
        return true;
    }

    @Override
    public double getMaxCharge(ItemStack stack) {
        return 100000000;
    }
    //电源等级
    @Override
    public int getTier(ItemStack stack) {
        return 5;
    }
    //传输限制，每个tick传输多少电量
    @Override
    public double getTransferLimit(ItemStack stack) {
        return 50000;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }
}

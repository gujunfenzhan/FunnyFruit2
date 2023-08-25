package com.mhxks.funnyfruit2.item;

import ic2.api.item.IElectricItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashSet;

public class ItemElectricTool extends ItemTool implements IElectricItem {
    // Vars
    protected String name;
    protected double operationCost;

    // -------------- IElectricItem vars -------------- //
    protected int energyTier;
    protected double maxCharge;
    protected double transferLimit;
    protected boolean providesEnergy;

    public ItemElectricTool(String name, int energyTier, double maxCharge, double transferLimit, boolean providesEnergy) {
        super(1.0F, -2.8F, ToolMaterial.DIAMOND,new HashSet<>());
        this.name = name;
        this.energyTier = energyTier;
        this.maxCharge = maxCharge;
        this.transferLimit = transferLimit;
        this.providesEnergy = providesEnergy;

        setUnlocalizedName(this.name);
        setMaxDamage(27);
        setMaxStackSize(1);
        setNoRepair();
    }

    // -------------- Item methods -------------- //
    @Override
    public int getItemEnchantability() {
        return 0;
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }

    @Override
    public boolean isRepairable() {
        return false;
    }

    @Override
    public boolean getIsRepairable(ItemStack itemStack1, ItemStack itemStack2) {
        return false;
    }

    @Override
    public boolean hitEntity(ItemStack itemstack, EntityLivingBase entityliving, EntityLivingBase entityliving1) {
        return true;
    }





    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemStack) {
        return false;
    }



    // -------------- IElectricItem implementation -------------- //
    @Override
    public boolean canProvideEnergy(ItemStack itemStack) {
        return this.providesEnergy;
    }



    @Override
    public double getMaxCharge(ItemStack itemStack) {
        return this.maxCharge;
    }

    @Override
    public int getTier(ItemStack itemStack) {
        return this.energyTier;
    }

    @Override
    public double getTransferLimit(ItemStack itemStack) {
        return this.transferLimit;
    }
}

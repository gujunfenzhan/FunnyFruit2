package com.mhxks.funnyfruit2.item;

import com.mhxks.funnyfruit2.init.ModCreativeTabLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemDiamondFunnyFruit
extends ItemFood {
    public ItemDiamondFunnyFruit() {
        super(20,false);
        this.setAlwaysEdible();
        this.setCreativeTab(ModCreativeTabLoader.FUNNY_FRUIT);
    }
    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {

        player.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 3600, 1));
        player.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 3600, 1));
        player.addPotionEffect(new PotionEffect(Potion.getPotionById(13), 3600, 1));
        player.addPotionEffect(new PotionEffect(Potion.getPotionById(3), 3600, 2));
        player.addPotionEffect(new PotionEffect(Potion.getPotionById(5), 3600, 2));
        player.addPotionEffect(new PotionEffect(Potion.getPotionById(10), 1800, 2));
        player.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 18000, 2));
        player.addPotionEffect(new PotionEffect(Potion.getPotionById(12), 18000, 1));
        super.onFoodEaten(stack, worldIn, player);
    }
}

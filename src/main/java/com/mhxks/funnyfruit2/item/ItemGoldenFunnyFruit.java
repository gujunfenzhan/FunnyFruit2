package com.mhxks.funnyfruit2.item;

import com.mhxks.funnyfruit2.init.ModCreativeTabLoader;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemGoldenFunnyFruit extends ItemFood {
    public ItemGoldenFunnyFruit() {
        super(10, false);
        this.setAlwaysEdible();
        this.setCreativeTab(ModCreativeTabLoader.FUNNY_FRUIT);
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        player.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 1200, 1));
        player.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 1200, 1));
        player.addPotionEffect(new PotionEffect(Potion.getPotionById(13), 1200, 1));
        player.addPotionEffect(new PotionEffect(Potion.getPotionById(3), 1200, 2));
        player.addPotionEffect(new PotionEffect(Potion.getPotionById(5), 1200, 2));
        player.addPotionEffect(new PotionEffect(Potion.getPotionById(10), 600, 2));
        player.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 6000, 2));
        player.addPotionEffect(new PotionEffect(Potion.getPotionById(12), 6000, 1));
        super.onFoodEaten(stack, worldIn, player);
    }
}

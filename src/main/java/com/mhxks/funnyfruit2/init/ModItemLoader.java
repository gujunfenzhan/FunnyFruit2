package com.mhxks.funnyfruit2.init;

import com.mhxks.funnyfruit2.item.*;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;

public interface ModItemLoader {
    public static final Item FUNNY_FRUIT = ((Item)new ItemFunnyFruit().setRegistryName("funny_fruit")).setUnlocalizedName("funnyFruit");
    public static final Item GOLDEN_FUNNY_FRUIT = ((Item)new ItemGoldenFunnyFruit().setRegistryName("golden_funny_fruit")).setUnlocalizedName("goldenFunnyFruit");
    public static final Item DIAMOND_IRIDIUM = ((Item)new ItemDiamondIridium().setRegistryName("diamond_iridium")).setUnlocalizedName("diamondIridium");
    public static final Item DIAMOND_IRIDIUM_ORE = ((Item)new ItemDiamondIridiumOre().setRegistryName("diamond_iridium_ore")).setUnlocalizedName("diamondIridiumOre");
    public static final Item FUNNY_ESSENCE = ((Item)new ItemFunnyEssence().setRegistryName("funny_essence")).setUnlocalizedName("funnyEssence");
    public static final Item DRILL_DIAMOND_IRIDIUM = new ItemDrillDiamondIridium().setRegistryName("drill_diamond_iridium").setUnlocalizedName("drillDiamondIridium");
    public static final Item DIAMOND_IRIDIUM_ROTOR = new ItemDiamondIridiumRotor().setRegistryName("diamond_iridium_rotor").setUnlocalizedName("diamondIridiumRotor");
    public static final Item DIAMOND_FUNNY_FRUIT = new ItemDiamondFunnyFruit().setRegistryName("diamond_funny_fruit").setUnlocalizedName("diamondFunnyFruit");
    public static final Item DIAMOND_IRIDIUM_CRYSTAL = new ItemDiamondIridiumCrystal().setRegistryName("diamond_iridium_crystal").setUnlocalizedName("diamondIridiumCrystal");
    public static final Item DIAMOND_IRIDIUM_ROTOR_TEMPLATE = new ItemDiamondIridiumRotorTemplate().setRegistryName("diamond_iridium_rotor_template").setUnlocalizedName("diamondIridiumRotorTemplate");

    //钻石铱量子甲
    public static final Item DIAMOND_IRIDIUM_HELMENT = new ItemDiamondIridiumSuit(EntityEquipmentSlot.HEAD,0).setRegistryName("diamond_iridium_helmet").setUnlocalizedName("diamondIridiumHelmet");
    public static final Item DIAMOND_IRIDIUM_CHEST = new ItemDiamondIridiumSuit(EntityEquipmentSlot.CHEST,1).setRegistryName("diamond_iridium_chest").setUnlocalizedName("diamondIridiumChest");
    public static final Item DIAMOND_IRIDIUM_LEGGINGS = new ItemDiamondIridiumSuit(EntityEquipmentSlot.LEGS,2).setRegistryName("diamond_iridium_leggings").setUnlocalizedName("diamondIridiumLeggings");
    public static final Item DIAMOND_IRIDIUM_BOOTS = new ItemDiamondIridiumSuit(EntityEquipmentSlot.FEET,3).setRegistryName("diamond_iridium_boots").setUnlocalizedName("diamondIridiumBoots");


}


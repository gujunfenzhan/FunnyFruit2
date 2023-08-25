package com.mhxks.funnyfruit2.client;

import com.mhxks.funnyfruit2.common.CommonProxy;
import com.mhxks.funnyfruit2.init.ModBlockLoader;
import com.mhxks.funnyfruit2.init.ModItemLoader;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy
extends CommonProxy {
    @SubscribeEvent
    public void registerModels(final ModelRegistryEvent reg) {
        this.registerBlockModel(ModBlockLoader.SAPLING_FUNNY_FRUIT);
        this.registerBlockModel(ModBlockLoader.LOG_FUNNY_FRUIT);
        this.registerBlockModel(ModBlockLoader.LEVEL_FUNNY_FRUIT);
        this.registerBlockModel(ModBlockLoader.LEVEL_FUNNY);
        this.registerBlockModel(ModBlockLoader.NORMAL_FUNNY_FRUIT_GENERATOR);
        this.registerBlockModel(ModBlockLoader.DOUBLE_FUNNY_FRUIT_GENERATOR);
        this.registerBlockModel(ModBlockLoader.TRIPLE_FUNNY_FRUIT_GENERATOR);
        this.registerBlockModel(ModBlockLoader.ULTIMATE_FUNNY_FRUIT_GENERATOR);
        this.registerItemModel(ModItemLoader.FUNNY_FRUIT);
        this.registerItemModel(ModItemLoader.GOLDEN_FUNNY_FRUIT);
        this.registerItemModel(ModItemLoader.DIAMOND_IRIDIUM);
        this.registerItemModel(ModItemLoader.DIAMOND_IRIDIUM_ORE);
        this.registerItemModel(ModItemLoader.FUNNY_ESSENCE);
        this.registerItemModel(ModItemLoader.DRILL_DIAMOND_IRIDIUM);
        this.registerItemModel(ModItemLoader.DIAMOND_IRIDIUM_ROTOR);
        this.registerItemModel(ModItemLoader.DIAMOND_FUNNY_FRUIT);
        this.registerItemModel(ModItemLoader.DIAMOND_IRIDIUM_CRYSTAL);
        this.registerItemModel(ModItemLoader.DIAMOND_IRIDIUM_HELMENT);
        this.registerItemModel(ModItemLoader.DIAMOND_IRIDIUM_CHEST);
        this.registerItemModel(ModItemLoader.DIAMOND_IRIDIUM_LEGGINGS);
        this.registerItemModel(ModItemLoader.DIAMOND_IRIDIUM_BOOTS);
        this.registerItemModel(ModItemLoader.DIAMOND_IRIDIUM_ROTOR_TEMPLATE);
    }

    public void registerItemModel(final Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    public void registerBlockModel(final Block block) {
        this.registerItemModel(Item.getItemFromBlock(block));
    }
}

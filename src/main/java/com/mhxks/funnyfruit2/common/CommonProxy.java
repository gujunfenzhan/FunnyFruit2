package com.mhxks.funnyfruit2.common;

import com.mhxks.funnyfruit2.block.BlockWithTileEntity;
import com.mhxks.funnyfruit2.init.ModBlockLoader;
import com.mhxks.funnyfruit2.init.ModCreativeTabLoader;
import com.mhxks.funnyfruit2.init.ModItemLoader;
import com.mhxks.funnyfruit2.init.ModRecipeLoader;
import ic2.api.event.TeBlockFinalCallEvent;
import ic2.api.item.IC2Items;
import ic2.api.item.IItemAPI;
import ic2.api.tile.IEnergyStorage;
import ic2.core.IC2;
import ic2.core.apihelper.ItemAPI;
import ic2.core.block.BlockTileEntity;
import ic2.core.block.TeBlockRegistry;
import ic2.core.util.StackUtil;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingDestroyBlockEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CommonProxy {

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> reg) {
        this.registerItemBlock(reg, ModBlockLoader.SAPLING_FUNNY_FRUIT);
        this.registerItemBlock(reg, ModBlockLoader.LOG_FUNNY_FRUIT);
        this.registerItemBlock(reg, ModBlockLoader.LEVEL_FUNNY_FRUIT);
        this.registerItemBlock(reg, ModBlockLoader.LEVEL_FUNNY);
        this.registerItemBlock(reg, ModBlockLoader.NORMAL_FUNNY_FRUIT_GENERATOR);
        this.registerItemBlock(reg, ModBlockLoader.DOUBLE_FUNNY_FRUIT_GENERATOR);
        this.registerItemBlock(reg, ModBlockLoader.TRIPLE_FUNNY_FRUIT_GENERATOR);
        this.registerItemBlock(reg, ModBlockLoader.ULTIMATE_FUNNY_FRUIT_GENERATOR);
        reg.getRegistry().register(ModItemLoader.FUNNY_FRUIT);
        reg.getRegistry().register(ModItemLoader.GOLDEN_FUNNY_FRUIT);
        reg.getRegistry().register(ModItemLoader.DIAMOND_IRIDIUM);
        reg.getRegistry().register(ModItemLoader.DIAMOND_IRIDIUM_ORE);
        reg.getRegistry().register(ModItemLoader.FUNNY_ESSENCE);
        reg.getRegistry().register(ModItemLoader.DRILL_DIAMOND_IRIDIUM);
        reg.getRegistry().register(ModItemLoader.DIAMOND_IRIDIUM_ROTOR);
        reg.getRegistry().register(ModItemLoader.DIAMOND_FUNNY_FRUIT);
        reg.getRegistry().register(ModItemLoader.DIAMOND_IRIDIUM_CRYSTAL);
        reg.getRegistry().register(ModItemLoader.DIAMOND_IRIDIUM_HELMENT);
        reg.getRegistry().register(ModItemLoader.DIAMOND_IRIDIUM_CHEST);
        reg.getRegistry().register(ModItemLoader.DIAMOND_IRIDIUM_LEGGINGS);
        reg.getRegistry().register(ModItemLoader.DIAMOND_IRIDIUM_BOOTS);
        reg.getRegistry().register(ModItemLoader.DIAMOND_IRIDIUM_ROTOR_TEMPLATE);

    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> reg) {

        reg.getRegistry().register(ModBlockLoader.SAPLING_FUNNY_FRUIT);
        reg.getRegistry().register(ModBlockLoader.LOG_FUNNY_FRUIT);
        reg.getRegistry().register(ModBlockLoader.LEVEL_FUNNY_FRUIT);
        reg.getRegistry().register(ModBlockLoader.LEVEL_FUNNY);
        reg.getRegistry().register(ModBlockLoader.NORMAL_FUNNY_FRUIT_GENERATOR);
        reg.getRegistry().register(ModBlockLoader.DOUBLE_FUNNY_FRUIT_GENERATOR);
        reg.getRegistry().register(ModBlockLoader.TRIPLE_FUNNY_FRUIT_GENERATOR);
        reg.getRegistry().register(ModBlockLoader.ULTIMATE_FUNNY_FRUIT_GENERATOR);

    }

    //钻石铱钻头挖矿有奇效
    @SubscribeEvent
    public void onPlayerDestoryBlock(BlockEvent.HarvestDropsEvent event){
        EntityPlayer harvester = event.getHarvester();
        if(harvester==null)return;
        if(!harvester.world.isRemote){
            if(harvester.getHeldItemMainhand().getItem()==ModItemLoader.DRILL_DIAMOND_IRIDIUM){
                List<ItemStack> newList = new ArrayList<>();
                Random random = harvester.world.rand;
                IItemAPI itemAPI = IC2Items.getItemAPI();
                for (ItemStack drop : event.getDrops()) {
                    if(drop.getItem()==itemAPI.getItem("resource")&&drop.getMetadata()==1){
                        newList.add(new ItemStack(itemAPI.getItem("crushed"),getRandomIngot(random), 0));
                    }
                    else if(drop.getItem()==itemAPI.getItem("resource")&&drop.getMetadata()==2){
                        newList.add(new ItemStack(itemAPI.getItem("crushed"),getRandomIngot(random),3));
                    }
                    //锡
                    else if(drop.getItem()==itemAPI.getItem("resource")&&drop.getMetadata()==3){
                        newList.add(new ItemStack(itemAPI.getItem("crushed"),getRandomIngot(random),5));
                    }
                    //铀矿
                    else if(drop.getItem()==itemAPI.getItem("resource")&&drop.getMetadata()==4){
                        newList.add(new ItemStack(itemAPI.getItem("crushed"),getRandomIngot(random),6));
                    }
                    else if(drop.getItem()==Item.getItemFromBlock(Blocks.IRON_ORE)){
                        newList.add(new ItemStack(itemAPI.getItem("crushed"),getRandomIngot(random),2));
                    }
                    else if(drop.getItem()==Item.getItemFromBlock(Blocks.GOLD_ORE)){
                        newList.add(new ItemStack(itemAPI.getItem("crushed"),getRandomIngot(random),1));
                    }
                    else if(drop.getItem()== Items.COAL){
                        newList.add(new ItemStack(itemAPI.getItem("dust"),getRandomIngot(random),2));
                    }
                    else if(drop.getItem()==Items.DIAMOND){
                        newList.add(new ItemStack(itemAPI.getItem("dust"),getRandomIngot(random),5));
                    }

                    else{
                        newList.add(drop);
                    }
                }
                event.getDrops().clear();
                event.getDrops().addAll(newList);

            }
        }
    }
    public int getRandomIngot(Random random){
        return random.nextInt(4)+3;
    }

    public void registerItemBlock(RegistryEvent.Register<Item> reg, final Block block) {
        reg.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
    }
    //注册方块，自动添加物品到创造栏
    @SubscribeEvent
    public void onTeBlockInit(TeBlockFinalCallEvent event){
        //IC2的注册系统
        TeBlockRegistry.addAll(BlockWithTileEntity.class,BlockWithTileEntity.loc);
        //添加机器或储电盒到创造栏，一个无电状态一个有电状态
        TeBlockRegistry.addCreativeRegisterer((list, block, itemblock, tab) -> {
            if (tab == CreativeTabs.SEARCH || tab == ModCreativeTabLoader.FUNNY_FRUIT) {
                block.getAllTypes().forEach(type -> {
                    if (type.hasItem()) {
                        list.add(block.getItemStack(type));
                        if (type.getDummyTe() instanceof IEnergyStorage) {
                            ItemStack filled = block.getItemStack(type);
                            StackUtil.getOrCreateNbtData(filled).setDouble("energy",
                                    ((IEnergyStorage) type.getDummyTe()).getCapacity());
                            list.add(filled);
                        }
                    }
                });
            }
        }, BlockWithTileEntity.loc);
    }
}

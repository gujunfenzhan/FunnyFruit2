/*    */ package com.mhxks.funnyfruit2.init;
/*    */ import com.mhxks.funnyfruit2.block.*;
import com.mhxks.funnyfruit2.tileentity.TileEntityDISU;
import net.minecraft.block.Block;
/*    */
/*    */ public interface ModBlockLoader {
    /* 14 */   public static final Block SAPLING_FUNNY_FRUIT = ((Block)(new BlockSaplingFunnyFruit()).setRegistryName("sapling_funny_fruit")).setUnlocalizedName("SaplingFunnyFruit");
    /* 15 */   public static final Block LOG_FUNNY_FRUIT = ((Block)(new BlockLogFunnyFruit()).setRegistryName("log_funny_fruit")).setUnlocalizedName("logFunnyFruit");
    /* 16 */   public static final Block LEVEL_FUNNY_FRUIT = ((Block)(new BlockLevelFunnyFruit()).setRegistryName("level_funny_fruit")).setUnlocalizedName("levelFunnyFruit");
    /* 17 */   public static final Block LEVEL_FUNNY = ((Block)(new BlockLevelFunny()).setRegistryName("level_funny")).setUnlocalizedName("levelFunny");
    /* 18 */   public static final Block NORMAL_FUNNY_FRUIT_GENERATOR = ((Block)(new BlockNormalFunnyFruitGenerator()).setRegistryName("normal_funny_fruit_generator")).setUnlocalizedName("normalFunnyFruitGenerator");
    /* 19 */   public static final Block DOUBLE_FUNNY_FRUIT_GENERATOR = ((Block)(new BlockDoubleFunnyFruitGenerator()).setRegistryName("double_funny_fruit_generator")).setUnlocalizedName("doubleFunnyFruitGenerator");
    /* 20 */   public static final Block TRIPLE_FUNNY_FRUIT_GENERATOR = ((Block)(new BlockTripleFunyFruitGenerator()).setRegistryName("triple_funny_fruit_generator")).setUnlocalizedName("tripleFunnyFruitGenerator");
    /* 21 */   public static final Block ULTIMATE_FUNNY_FRUIT_GENERATOR = ((Block)(new BlockUltimateFunnyFruitGenerator()).setRegistryName("ultimate_funny_fruit_generator")).setUnlocalizedName("ultimateFunnyFruitGenerator");

}


/* Location:              E:\minecraft\客户端\.minecraft\mods\FunnyFruitGenerator.jar!\ink\mhxk\funnyfruit\init\ModBlockLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
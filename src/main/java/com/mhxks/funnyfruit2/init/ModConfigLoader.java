/*    */
package com.mhxks.funnyfruit2.init;
/*    */
/*    */

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */
/*    */ public class ModConfigLoader
        /*    */ {
    /*    */   public static double normalFunnyFruitGeneratorCapacity;
    /*    */   public static double doubleFunnyFruitGeneratorCapacity;
    /*    */   public static double tripleFunnyFruitGeneratorCapacity;
    /*    */   public static int normalFunnyFruitGeneratorTickEnergy;
    /*    */   public static int doubleFunnyFruitGeneratorTickEnergy;
    /*    */   public static int tripleFunnyFruitGeneratorTickEnergy;
    /*    */   //public static int normalFunnyFruitGeneratorBurnTime;
    //public static int doubleFunnyFruitGeneratorBurnTime;
    //public static int tripleFunnyFruitGeneratorBurnTime;
    public static int normalFunnyFruitBurnTime;
    public static int goldenFunnyFruitBurnTime;
    public static int normalFunnyFruitGeneratorTier;
    public static int doubleFunnyFruitGeneratorTier;
    public static int tripleFunnyFruitGeneratorTier;
    public static double ultimateFunnyFruitGeneratorCapacity;
    public static int ultimateFunnyFruitGeneratorTickEnergy;
    public static int ultimateFunnyFruitGeneratorTier;
    //碳转效率
    public static double diamondIridiumRotorEfficiency;
    /*    */   private static Configuration config;

    //钻石铱甲伤害吸收每点伤害需要的电量
    public static int diamondIridiumArmorEnergyPerDamage;
    /*    */
    /*    */
    public ModConfigLoader(FMLPreInitializationEvent event) {
        /* 24 */
        config = new Configuration(event.getSuggestedConfigurationFile());
        /* 25 */
        config.load();
        /* 26 */
        load();
        /*    */
    }

    /*    */
    public void load() {
        /* 29 */
        normalFunnyFruitGeneratorCapacity = config.get("general", "normalFunnyFruitGeneratorCapacity", 100000.0D, "NormalFunnyFruitGenerator capacity.").getDouble();
        /* 30 */
        doubleFunnyFruitGeneratorCapacity = config.get("general", "doubleFunnyFruitGeneratorCapacity", 1000000.0D, "DoubleFunnyFruitGeneratorCapacity capacity.").getDouble();
        /* 31 */
        tripleFunnyFruitGeneratorCapacity = config.get("general", "tripleFunnyFruitGeneratorCapacity", 1.0E7D, "TripleFunnyFruitGeneratorCapacity capacity.").getDouble();
        /* 32 */
        normalFunnyFruitGeneratorTickEnergy = config.get("general", "normalFunnyFruitGeneratorTickEnergy", 32, "NormalFunnyFruitGenerator output per tick.").getInt();
        /* 33 */
        doubleFunnyFruitGeneratorTickEnergy = config.get("general", "doubleFunnyFruitGeneratorTickEnergy", 128, "DoubleFunnyFruitGenerator output per tick.").getInt();
        /* 34 */
        tripleFunnyFruitGeneratorTickEnergy = config.get("general", "tripleFunnyFruitGeneratorTickEnergy", 256, "TripleFunnyFruitGenerator output per tick.").getInt();
        /* 35 */     //normalFunnyFruitGeneratorBurnTime = config.get("general", "normalFunnyFruitGeneratorBurnTime", 1000, "NormalFunnyFruitGenerator burn time.").getInt();
        /* 36 */     //doubleFunnyFruitGeneratorBurnTime = config.get("general", "doubleFunnyFruitGeneratorBurnTime", 1500, "DoubleFunnyFruitGenerator burn time.").getInt();
        /* 37 */     //tripleFunnyFruitGeneratorBurnTime = config.get("general", "tripleFunnyFruitGeneratorBurnTime", 2000, "TripleFunnyFruitGenerator burn time.").getInt();
        //普通滑稽燃烧时间
        normalFunnyFruitBurnTime = config.get("general", "normalFunnyFruitBurnTime", 1000, "NormalFunnyFruit burn time.").getInt();
        //黄金滑稽
        goldenFunnyFruitBurnTime = config.get("general", "goldenFunnyFruitBurnTime", 20000, "GoldenFunnyFruit burn time.").getInt();

        /* 38 */
        normalFunnyFruitGeneratorTier = config.get("general", "normalFunnyFruitGeneratorTier", 1, "NormalFunnyFruitGenerator voltage level.").getInt();
        /* 39 */
        doubleFunnyFruitGeneratorTier = config.get("general", "doubleFunnyFruitGeneratorTier", 2, "DoubleFunnyFruitGenerator voltage level.").getInt();
        /* 40 */
        tripleFunnyFruitGeneratorTier = config.get("general", "tripleFunnyFruitGeneratorTier", 3, "TripleFunnyFruitGenerator voltage level.").getInt();
        /* 41 */
        ultimateFunnyFruitGeneratorCapacity = config.get("general", "ultimateFunnyFruitGeneratorCapacity", 1.0E8D, "UltimeFunnyFruitGenerator capacity.").getDouble();
        /* 42 */
        ultimateFunnyFruitGeneratorTickEnergy = config.get("general", "ultimateFunnyFruitGeneratorTickEnergy", 4096, "UltimateFunnyFruitGenerator output per tick.").getInt();
        /* 43 */
        ultimateFunnyFruitGeneratorTier = config.get("general", "ultimateFunnyFruitGeneratorTier", 5, "UltimateFunnyFruitGenerator voltage level.").getInt();
        /* 44 *///
//一转
        diamondIridiumRotorEfficiency = config.get("general","diamondIridiumRotorEfficiency",2.0f,"diamondIridiumRotor Efficiency.").getDouble();

        diamondIridiumArmorEnergyPerDamage = config.get("general","diamondIridiumArmorEnergyPerDamage",30000,"diamondIridiumArmor energy of per damage").getInt();

        config.save();
        /*    */
    }
    /*    */
}


/* Location:              E:\minecraft\客户端\.minecraft\mods\FunnyFruitGenerator.jar!\ink\mhxk\funnyfruit\init\ModConfigLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
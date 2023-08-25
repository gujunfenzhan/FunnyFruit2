/*    */
package com.mhxks.funnyfruit2.tileentity;

import com.mhxks.funnyfruit2.init.ModConfigLoader;
import com.mhxks.funnyfruit2.init.ModItemLoader;
import net.minecraft.item.Item;
import net.minecraft.world.World;

/*    */ public class TileEntityUltimateFunnyFruitGenerator
        /*    */ extends TileEntityFunnyFruitGenerator
        /*    */ {
    /*    */
    public TileEntityUltimateFunnyFruitGenerator() {
        /* 10 */
        super(ModConfigLoader.ultimateFunnyFruitGeneratorCapacity, ModConfigLoader.ultimateFunnyFruitGeneratorTier, ModConfigLoader.ultimateFunnyFruitGeneratorTickEnergy, 1);
        this.defaultCanPutItems = new Item[]{ModItemLoader.FUNNY_FRUIT,ModItemLoader.GOLDEN_FUNNY_FRUIT,ModItemLoader.FUNNY_ESSENCE};
        /*    */
    }


    public void update() {
        /*  64 */
        this.energySource.update();
        /*  65 */
        if (isRun()||this.funnyFruit.getStack().getItem()==ModItemLoader.FUNNY_ESSENCE) {
            /*  66 */
            this.energySource.addEnergy(this.tickEnergy);
            /*  67 */
            markDirty();
            /*     */
        }
        /*  69 */
        World world = this.world;
        /*  70 */
        if (world != null && !world.isRemote) {
            /*  71 */
            if (this.funnyFruit.getHasStack() && this.burnTime <= 0 && this.energySource.getEnergyStored() < this.capacity) {
                /*  72 */
                if (this.funnyFruit.getStack().getItem() == ModItemLoader.FUNNY_FRUIT) {
                    this.burnTime = ModConfigLoader.normalFunnyFruitBurnTime;
                    this.maxBurnTime = ModConfigLoader.normalFunnyFruitBurnTime;
                    this.funnyFruit.getStack().shrink(1);
                } else if (this.funnyFruit.getStack().getItem() == ModItemLoader.GOLDEN_FUNNY_FRUIT) {
                    this.burnTime = ModConfigLoader.goldenFunnyFruitBurnTime;
                    this.maxBurnTime = ModConfigLoader.goldenFunnyFruitBurnTime;
                    this.funnyFruit.getStack().shrink(1);
                }

                /*  74 */
                markDirty();
                /*     */
            }
            /*  76 */
            if (this.burnTime > 0) {
                /*  77 */
                this.burnTime--;
                /*  78 */
                markDirty();
                /*     */
            }
            /*     */
        }
        /*     */
    }
    /*    */
}


/* Location:              E:\minecraft\客户端\.minecraft\mods\FunnyFruitGenerator.jar!\ink\mhxk\funnyfruit\tileentity\TileEntityUltimateFunnyFruitGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
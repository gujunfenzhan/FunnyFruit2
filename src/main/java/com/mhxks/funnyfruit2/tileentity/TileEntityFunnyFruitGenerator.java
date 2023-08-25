/*     */
package com.mhxks.funnyfruit2.tileentity;
/*     */
/*     */

import com.mhxks.funnyfruit2.init.ModConfigLoader;
import com.mhxks.funnyfruit2.init.ModItemLoader;
import ic2.api.energy.prefab.BasicSource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/*     */ public abstract class TileEntityFunnyFruitGenerator
        /*     */ extends TileEntity
        /*     */ implements ITickable
        /*     */ {
    /*     */   public BasicSource energySource;
    /*     */   public int tickEnergy;
    public int maxBurnTime;
    /*  35 */   public int burnTime = 0;
    /*     */   public double capacity;
    /*     */   public ItemStackHandler items;
    /*  38 */   public Item[] defaultCanPutItems = new Item[]{ModItemLoader.FUNNY_FRUIT, ModItemLoader.GOLDEN_FUNNY_FRUIT};
    /*     */   public SlotItemHandler funnyFruit;
    /*     */   private boolean state;

    /*     */
    /*     */
    public TileEntityFunnyFruitGenerator(double capacity, int tier, int tickEnergy, int size) {
        /*  41 */
        this.energySource = new BasicSource(this, capacity, tier);
        /*  42 */
        this.tickEnergy = tickEnergy;
        /*  43 */
        this.items = new ItemStackHandler(size)
                /*     */ {
            /*     */
            protected void onContentsChanged(int slot)
            /*     */ {
                /*  47 */
                super.onContentsChanged(slot);
                /*  48 */
                TileEntityFunnyFruitGenerator.this.markDirty();
                /*     */
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                for (Item defaultCanPutItem : defaultCanPutItems) {
                    if (stack.getItem() == defaultCanPutItem) {
                        return true;
                    }
                }
                return false;
            }
            /*     */
        };
        /*     */
        /*  52 */
        this.funnyFruit = new SlotItemHandler((IItemHandler) this.items, 0, 80, 57)
                /*     */ {
            /*     */
            public boolean isItemValid(ItemStack stack) {
                for (Item defaultCanPutItem : defaultCanPutItems) {
                    if (stack.getItem() == defaultCanPutItem) {
                        return true;
                    }
                }
                return false;
                /*     */
            }
            /*     */
        };
        /*     */
        /*  59 */
        this.capacity = capacity;
        /*     */
    }

    /*     */
    public void update() {
        /*  64 */
        this.energySource.update();
        /*  65 */
        if (isRun()) {
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
                } else if (this.funnyFruit.getStack().getItem() == ModItemLoader.GOLDEN_FUNNY_FRUIT) {
                    this.burnTime = ModConfigLoader.goldenFunnyFruitBurnTime;
                    this.maxBurnTime = ModConfigLoader.goldenFunnyFruitBurnTime;
                }
                this.funnyFruit.getStack().shrink(1);
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

    /*     */
    /*     */
    /*     */
    public void onChunkUnload() {
        /*  85 */
        this.energySource.onChunkUnload();
        /*     */
    }

    /*     */
    /*     */
    public void invalidate() {
        /*  89 */
        this.energySource.invalidate();
        /*  90 */
        super.invalidate();
        /*     */
    }

    /*     */
    /*     */
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        /*  94 */
        this.energySource.writeToNBT(compound);
        /*  95 */
        compound.setTag("items", (NBTBase) this.items.serializeNBT());
        /*  96 */
        compound.setInteger("burnTime", this.burnTime);
        compound.setInteger("maxBurnTime", this.maxBurnTime);
        /*  97 */
        return super.writeToNBT(compound);
        /*     */
    }

    /*     */
    /*     */
    public void readFromNBT(NBTTagCompound compound) {
        /* 101 */
        super.readFromNBT(compound);
        /* 102 */
        this.energySource.readFromNBT(compound);
        /* 103 */
        this.items.deserializeNBT(compound.getCompoundTag("items"));
        /* 104 */
        this.burnTime = compound.getInteger("burnTime");
        this.maxBurnTime = compound.getInteger("maxBurnTime");
        /*     */
    }

    /*     */
    public boolean isRun() {
        /* 107 */
        return (this.burnTime > 0);
        /*     */
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        if(capability== CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return true;
        }
        return super.hasCapability(capability,facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if(capability==CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(new IItemHandler() {
                @Override
                public int getSlots() {
                    return items.getSlots();
                }

                @Nonnull
                @Override
                public ItemStack getStackInSlot(int i) {
                    return items.getStackInSlot(i);
                }

                @Nonnull
                @Override
                public ItemStack insertItem(int i, @Nonnull ItemStack itemStack, boolean b) {
                    if(items.isItemValid(i,itemStack)){
                        return items.insertItem(i,itemStack,b);
                    }
                    return itemStack;
                }

                @Nonnull
                @Override
                public ItemStack extractItem(int i, int i1, boolean b) {
                    return ItemStack.EMPTY;
                }

                @Override
                public int getSlotLimit(int i) {
                    return items.getSlotLimit(i);
                }
            });
        }
        return super.getCapability(capability, facing);
    }

    /*     */
}


/* Location:              E:\minecraft\客户端\.minecraft\mods\FunnyFruitGenerator.jar!\ink\mhxk\funnyfruit\tileentity\TileEntityFunnyFruitGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
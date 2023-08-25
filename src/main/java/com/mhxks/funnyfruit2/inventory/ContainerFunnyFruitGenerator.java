/*     */ package com.mhxks.funnyfruit2.inventory;
/*     */ import com.mhxks.funnyfruit2.FunnyFruit2Main;
import com.mhxks.funnyfruit2.network.NetWorkFunnyFruitGeneratorMessage;
import com.mhxks.funnyfruit2.tileentity.TileEntityFunnyFruitGenerator;
import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.IContainerListener;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.inventory.Slot;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*     */ 
/*     */ public class ContainerFunnyFruitGenerator<T extends TileEntityFunnyFruitGenerator>
/*     */   extends Container
/*     */ {
/*     */   public T tileEntity;
/*     */   public EntityPlayer player;
/*     */   public int maxBurnTime;
/*     */   
/*     */   public ContainerFunnyFruitGenerator(EntityPlayer player, int AbenginX, int AbeginY, int BbeginX, int BbeginY, T tileEntity) {
/*  23 */     this.player = player;
/*  24 */     this.tileEntity = tileEntity;
/*  25 */     for (int i = 0; i < 3; i++) {
/*     */       
/*  27 */       for (int j = 0; j < 9; j++)
/*     */       {
/*     */         
/*  30 */         addSlotToContainer(new Slot((IInventory)player.inventory, j + i * 9 + 9, AbenginX + j * 18, AbeginY + i * 18));
/*     */       }
/*     */     } 
/*     */     
/*  34 */     for (int k = 0; k < 9; k++)
/*     */     {
/*  36 */       addSlotToContainer(new Slot((IInventory)player.inventory, k, BbeginX + k * 18, BbeginY)); } 
/*     */   }
/*     */   public int burnTime; public double energy; public double capacity; public int tickEnergy;
/*     */   public ContainerFunnyFruitGenerator(EntityPlayer player, T tileEntity) {
/*  40 */     this(player, 8, 89, 8, 147, tileEntity);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canInteractWith(EntityPlayer playerIn) {
/*  45 */     return (this.player.getDistanceSq(this.tileEntity.getPos()) < 64.0D);
/*     */   }
/*     */   public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
/*     */     boolean isMerged;
/*  49 */     Slot slot = this.inventorySlots.get(index);
/*  50 */     if (slot == null || !slot.getHasStack()) {
/*  51 */       return ItemStack.EMPTY;
/*     */     }
/*  53 */     ItemStack newStack = slot.getStack(), oldStack = newStack.copy();
/*     */     
/*  55 */     int length = this.inventorySlots.size() - 36;
/*  56 */     if (index < length) {
/*  57 */       isMerged = mergeItemStack(newStack, length, 36 + length, true);
/*  58 */     } else if (index < 27 + length) {
/*     */       
/*  60 */       isMerged = (mergeItemStack(newStack, 0, length, false) || mergeItemStack(newStack, 27 + length, 36 + length, false));
/*     */     } else {
/*     */       
/*  63 */       isMerged = (mergeItemStack(newStack, 0, length, false) || mergeItemStack(newStack, length, 27 + length, false));
/*     */     } 
/*  65 */     if (!isMerged) {
/*  66 */       return ItemStack.EMPTY;
/*     */     }
/*  68 */     if (newStack.isEmpty()) {
/*  69 */       slot.putStack(ItemStack.EMPTY);
/*     */     } else {
/*  71 */       slot.onSlotChanged();
/*     */     } 
/*  73 */     return oldStack;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean mergeItemStack(ItemStack stack, int startIndex, int endIndex, boolean reverseDirection) {
/*  78 */     boolean changed = false;
/*  79 */     int i = reverseDirection ? (endIndex - 1) : startIndex;
/*  80 */     if (stack.isStackable()) {
/*  81 */       while (!stack.isEmpty() && (
/*  82 */         !reverseDirection || i >= startIndex)) {
/*     */         
/*  84 */         if (i >= endIndex)
/*     */           break; 
/*  86 */         Slot slot = this.inventorySlots.get(i);
/*  87 */         ItemStack itemstack = slot.getStack();
/*  88 */         if (slot.isItemValid(itemstack) && !itemstack.isEmpty() && itemstack.getItem() == stack.getItem() && (
/*  89 */           !stack.getHasSubtypes() || stack.getMetadata() == itemstack.getMetadata()) && 
/*  90 */           ItemStack.areItemStackTagsEqual(stack, itemstack)) {
/*  91 */           int j = itemstack.getCount() + stack.getCount();
/*  92 */           int maxSize = Math.min(slot.getSlotStackLimit(), stack.getMaxStackSize());
/*  93 */           if (j <= maxSize) {
/*  94 */             stack.setCount(0);
/*  95 */             itemstack.setCount(j);
/*  96 */             slot.onSlotChanged();
/*  97 */             changed = true;
/*  98 */           } else if (itemstack.getCount() < maxSize) {
/*  99 */             stack.shrink(maxSize - itemstack.getCount());
/* 100 */             itemstack.setCount(maxSize);
/* 101 */             slot.onSlotChanged();
/* 102 */             changed = true;
/*     */           } 
/*     */         } 
/* 105 */         i += reverseDirection ? -1 : 1;
/*     */       } 
/*     */     }
/* 108 */     if (!stack.isEmpty()) {
/* 109 */       i = reverseDirection ? (endIndex - 1) : startIndex;
/*     */       
/* 111 */       while (!reverseDirection || i >= startIndex) {
/*     */         
/* 113 */         if (i >= endIndex)
/*     */           break; 
/* 115 */         Slot slot = this.inventorySlots.get(i);
/* 116 */         ItemStack itemstack = slot.getStack();
/* 117 */         if (itemstack.isEmpty() && slot.isItemValid(stack)) {
/* 118 */           if (stack.getCount() > slot.getSlotStackLimit()) {
/* 119 */             slot.putStack(stack.splitStack(slot.getItemStackLimit(stack)));
/*     */           } else {
/* 121 */             slot.putStack(stack.splitStack(stack.getCount()));
/* 122 */           }  slot.onSlotChanged();
/* 123 */           changed = true;
/*     */           break;
/*     */         } 
/* 126 */         i += reverseDirection ? -1 : 1;
/*     */       } 
/*     */     } 
/* 129 */     return changed;
/*     */   }
/*     */   
/*     */   public void detectAndSendChanges() {
/* 133 */     super.detectAndSendChanges();
/* 134 */     for (IContainerListener listener : this.listeners) {
/* 135 */       listener.sendWindowProperty(this, 0, ((TileEntityFunnyFruitGenerator)this.tileEntity).burnTime);
/* 136 */       listener.sendWindowProperty(this, 1, ((TileEntityFunnyFruitGenerator)this.tileEntity).maxBurnTime);
/* 137 */       listener.sendWindowProperty(this, 2, ((TileEntityFunnyFruitGenerator)this.tileEntity).tickEnergy);
/*     */     } 
/* 139 */     FunnyFruit2Main.getNetwork().sendTo((IMessage)new NetWorkFunnyFruitGeneratorMessage(((TileEntityFunnyFruitGenerator)this.tileEntity).energySource.getEnergyStored(), ((TileEntityFunnyFruitGenerator)this.tileEntity).capacity), (EntityPlayerMP)this.player);
/*     */   }
/*     */   
/*     */   public void updateProgressBar(int id, int data) {
/* 143 */     super.updateProgressBar(id, data);
/* 144 */     switch (id) {
/*     */       case 0:
/* 146 */         this.burnTime = data;
/*     */         break;
/*     */       case 1:
/* 149 */         this.maxBurnTime = data;
/*     */         break;
/*     */       case 2:
/* 152 */         this.tickEnergy = data;
/*     */         break;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              E:\minecraft\客户端\.minecraft\mods\FunnyFruitGenerator.jar!\ink\mhxk\funnyfruit\inventory\ContainerFunnyFruitGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
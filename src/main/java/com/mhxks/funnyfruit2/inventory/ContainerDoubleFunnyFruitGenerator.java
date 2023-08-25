/*    */ package com.mhxks.funnyfruit2.inventory;

/*    */ import com.mhxks.funnyfruit2.tileentity.TileEntityDoubleFunnyFruitGenerator;
import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ 
/*    */ public class ContainerDoubleFunnyFruitGenerator
/*    */   extends ContainerFunnyFruitGenerator<TileEntityDoubleFunnyFruitGenerator> {
/*    */   public ContainerDoubleFunnyFruitGenerator(EntityPlayer player, TileEntity tileEntity) {
/* 11 */     super(player, (TileEntityDoubleFunnyFruitGenerator)tileEntity);
/* 12 */     addSlotToContainer((Slot)this.tileEntity.funnyFruit);
/*    */   }
/*    */ }


/* Location:              E:\minecraft\客户端\.minecraft\mods\FunnyFruitGenerator.jar!\ink\mhxk\funnyfruit\inventory\ContainerDoubleFunnyFruitGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
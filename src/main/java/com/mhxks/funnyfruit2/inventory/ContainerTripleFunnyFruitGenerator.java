/*    */ package com.mhxks.funnyfruit2.inventory;

/*    */ import com.mhxks.funnyfruit2.tileentity.TileEntityTripleFunnyFruitGenerator;
import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ 
/*    */ public class ContainerTripleFunnyFruitGenerator
/*    */   extends ContainerFunnyFruitGenerator<TileEntityTripleFunnyFruitGenerator> {
/*    */   public ContainerTripleFunnyFruitGenerator(EntityPlayer player, TileEntity tileEntity) {
/* 11 */     super(player, (TileEntityTripleFunnyFruitGenerator)tileEntity);
/* 12 */     addSlotToContainer((Slot)this.tileEntity.funnyFruit);
/*    */   }
/*    */ }


/* Location:              E:\minecraft\客户端\.minecraft\mods\FunnyFruitGenerator.jar!\ink\mhxk\funnyfruit\inventory\ContainerTripleFunnyFruitGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
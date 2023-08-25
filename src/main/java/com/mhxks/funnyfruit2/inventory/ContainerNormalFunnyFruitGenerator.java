/*    */ package com.mhxks.funnyfruit2.inventory;

/*    */ import com.mhxks.funnyfruit2.tileentity.TileEntityNormalFunnyFruitGenerator;
import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.Slot;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ContainerNormalFunnyFruitGenerator
/*    */   extends ContainerFunnyFruitGenerator<TileEntityNormalFunnyFruitGenerator>
/*    */ {
/*    */   public ContainerNormalFunnyFruitGenerator(EntityPlayer player, TileEntity tileEntity) {
/* 14 */     super(player, (TileEntityNormalFunnyFruitGenerator)tileEntity);
/* 15 */     addSlotToContainer((Slot)this.tileEntity.funnyFruit);
/*    */   }
/*    */ }


/* Location:              E:\minecraft\客户端\.minecraft\mods\FunnyFruitGenerator.jar!\ink\mhxk\funnyfruit\inventory\ContainerNormalFunnyFruitGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
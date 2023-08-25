/*    */ package com.mhxks.funnyfruit2.init;

/*    */ import com.mhxks.funnyfruit2.FunnyFruit2Main;
import com.mhxks.funnyfruit2.client.gui.GuiDoubleFunnyFruitGenerator;
import com.mhxks.funnyfruit2.client.gui.GuiNormalFunnyFruitGenerator;
import com.mhxks.funnyfruit2.client.gui.GuiTripleFunnyFruitGenerator;
import com.mhxks.funnyfruit2.client.gui.GuiUltimateFunnyFruitGenerator;
import com.mhxks.funnyfruit2.inventory.ContainerDoubleFunnyFruitGenerator;
import com.mhxks.funnyfruit2.inventory.ContainerNormalFunnyFruitGenerator;
import com.mhxks.funnyfruit2.inventory.ContainerTripleFunnyFruitGenerator;
import com.mhxks.funnyfruit2.inventory.ContainerUltimateFunnyFruitGenerator;
import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraftforge.fml.common.network.IGuiHandler;
/*    */ import net.minecraftforge.fml.common.network.NetworkRegistry;
/*    */ 
/*    */ public class ModGuiLoader implements IGuiHandler {
/*    */   public static final int NORMAL_FUNNY_FRUIT_GENERATOR = 0;
/*    */   public static final int DOUBLE_FUNNY_FRUIT_GENERATOR = 1;
/*    */   public static final int TRIPLE_FUNNY_FRUIT_GENERATOR = 2;
/*    */   public static final int ULTIMATE_FUNNY_FRUIT_GENERATOR = 3;
/*    */   
/*    */   public ModGuiLoader() {
/* 27 */     NetworkRegistry.INSTANCE.registerGuiHandler(FunnyFruit2Main.INSTANCE, this);
/*    */   }
/*    */   
/*    */   public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
/* 31 */     switch (ID) {
/*    */       case 0:
/* 33 */         return new ContainerNormalFunnyFruitGenerator(player, getTileEntity(world, x, y, z));
/*    */       case 1:
/* 35 */         return new ContainerDoubleFunnyFruitGenerator(player, getTileEntity(world, x, y, z));
/*    */       case 2:
/* 37 */         return new ContainerTripleFunnyFruitGenerator(player, getTileEntity(world, x, y, z));
/*    */       case 3:
/* 39 */         return new ContainerUltimateFunnyFruitGenerator(player, getTileEntity(world, x, y, z));
/*    */     } 
/* 41 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
/* 47 */     switch (ID) {
/*    */       case 0:
/* 49 */         return new GuiNormalFunnyFruitGenerator((Container)new ContainerNormalFunnyFruitGenerator(player, getTileEntity(world, x, y, z)));
/*    */       case 1:
/* 51 */         return new GuiDoubleFunnyFruitGenerator((Container)new ContainerDoubleFunnyFruitGenerator(player, getTileEntity(world, x, y, z)));
/*    */       case 2:
/* 53 */         return new GuiTripleFunnyFruitGenerator((Container)new ContainerTripleFunnyFruitGenerator(player, getTileEntity(world, x, y, z)));
/*    */       case 3:
/* 55 */         return new GuiUltimateFunnyFruitGenerator((Container)new ContainerUltimateFunnyFruitGenerator(player, getTileEntity(world, x, y, z)));
/*    */     } 
/* 57 */     return null;
/*    */   }
/*    */   
/*    */   private TileEntity getTileEntity(World worldIn, int x, int y, int z) {
/* 61 */     return worldIn.getTileEntity(new BlockPos(x, y, z));
/*    */   }
/*    */ }


/* Location:              E:\minecraft\客户端\.minecraft\mods\FunnyFruitGenerator.jar!\ink\mhxk\funnyfruit\init\ModGuiLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
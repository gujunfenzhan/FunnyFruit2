/*    */ package com.mhxks.funnyfruit2.init;
/*    */ 
/*    */ import com.mhxks.funnyfruit2.block.BlockWithTileEntity;
import com.mhxks.funnyfruit2.tileentity.TileEntityDoubleFunnyFruitGenerator;
import com.mhxks.funnyfruit2.tileentity.TileEntityNormalFunnyFruitGenerator;

/*    */ import com.mhxks.funnyfruit2.tileentity.TileEntityTripleFunnyFruitGenerator;
import com.mhxks.funnyfruit2.tileentity.TileEntityUltimateFunnyFruitGenerator;
import ic2.core.block.TeBlockRegistry;
import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraftforge.fml.common.registry.GameRegistry;
/*    */ 
/*    */ public class ModTileEntityLoader
/*    */ {
/*    */   public ModTileEntityLoader() {
/* 14 */     registerTileEntity((Class) TileEntityNormalFunnyFruitGenerator.class, "normalFunnyFruitGenerator");
/* 15 */     registerTileEntity((Class) TileEntityDoubleFunnyFruitGenerator.class, "doubleFunnyFruitGenerator");
/* 16 */     registerTileEntity((Class) TileEntityTripleFunnyFruitGenerator.class, "tripleFunnyFruitGenerator");
/* 17 */     registerTileEntity((Class) TileEntityUltimateFunnyFruitGenerator.class, "ultimateFunnyFruitGenerator");
    //TeBlockRegistry.addAll(BlockWithTileEntity.class,BlockWithTileEntity.loc);
}
/*    */   public void registerTileEntity(Class<? extends TileEntity> clazz, String name) {
/* 20 */     GameRegistry.registerTileEntity(clazz, new ResourceLocation("funnyfruit", name));
/*    */   }
/*    */ }


/* Location:              E:\minecraft\客户端\.minecraft\mods\FunnyFruitGenerator.jar!\ink\mhxk\funnyfruit\init\ModTileEntityLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
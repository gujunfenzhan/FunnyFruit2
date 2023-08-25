/*   */ package com.mhxks.funnyfruit2.init;
/*   */ 
/*   */ import net.minecraft.item.ItemStack;
/*   */ import net.minecraftforge.fml.common.registry.GameRegistry;
/*   */ 
/*   */ public class ModSmeltingLoader {
/*   */   public ModSmeltingLoader() {
/* 8 */     GameRegistry.addSmelting(ModBlockLoader.LOG_FUNNY_FRUIT, new ItemStack(ModItemLoader.FUNNY_FRUIT), 0.5F);
/*   */   }
/*   */ }


/* Location:              E:\minecraft\客户端\.minecraft\mods\FunnyFruitGenerator.jar!\ink\mhxk\funnyfruit\init\ModSmeltingLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
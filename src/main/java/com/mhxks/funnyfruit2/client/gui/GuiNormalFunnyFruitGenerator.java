/*    */ package com.mhxks.funnyfruit2.client.gui;

/*    */ import com.mhxks.funnyfruit2.inventory.ContainerFunnyFruitGenerator;
import net.minecraft.client.resources.I18n;
/*    */ import net.minecraft.inventory.Container;
/*    */ 
/*    */ public class GuiNormalFunnyFruitGenerator
/*    */   extends GuiFunnyFruitGenerator
/*    */ {
/*    */   public GuiNormalFunnyFruitGenerator(Container inventorySlotsIn) {
/* 11 */     super(inventorySlotsIn);
/*    */   }
/*    */   
/*    */   protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
/* 15 */     ContainerFunnyFruitGenerator container = (ContainerFunnyFruitGenerator)this.inventorySlots;
/* 16 */     String lore = I18n.format("normalFunnyFruitGenerator.desc.1", new Object[0]);
/* 17 */     int width = this.fontRenderer.getStringWidth(lore);
/* 18 */     this.fontRenderer.drawString(lore, (this.xSize - width) / 2, 8, 4210752);
/* 19 */     this.fontRenderer.drawString(container.tickEnergy + "EU/t", 110, 25, 4210752);
/* 20 */     String EU = this.NF.format(container.energy) + "/" + this.NF.format(container.capacity) + " EU";
/* 21 */     this.fontRenderer.drawString(EU, (this.xSize - this.fontRenderer.getStringWidth(EU)) / 2, 40, 4210752);
/*    */   }
/*    */ }


/* Location:              E:\minecraft\客户端\.minecraft\mods\FunnyFruitGenerator.jar!\ink\mhxk\funnyfruit\client\gui\GuiNormalFunnyFruitGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
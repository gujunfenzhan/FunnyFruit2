/*    */ package com.mhxks.funnyfruit2.client.gui;

/*    */ import java.text.NumberFormat;
/*    */ import com.mhxks.funnyfruit2.inventory.ContainerFunnyFruitGenerator;
import net.minecraft.client.gui.inventory.GuiContainer;
/*    */ import net.minecraft.client.renderer.GlStateManager;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GuiFunnyFruitGenerator
/*    */   extends GuiContainer
/*    */ {
/* 15 */   public static final ResourceLocation TEXTURES = new ResourceLocation("funnyfruit2", "textures/gui/container/funny_fruit_generator.png");
/* 16 */   public NumberFormat NF = NumberFormat.getInstance();
/*    */   public GuiFunnyFruitGenerator(Container inventorySlotsIn) {
/* 18 */     super(inventorySlotsIn);
/* 19 */     this.NF.setGroupingUsed(false);
/* 20 */     this.xSize = 176;
/* 21 */     this.ySize = 171;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
/* 26 */     GlStateManager.color(1.0F, 1.0F, 1.0F);
/* 27 */     int offSetX = (this.width - this.xSize) / 2;
/* 28 */     int offSetY = (this.height - this.ySize) / 2;
/* 29 */     this.mc.getTextureManager().bindTexture(TEXTURES);
/* 30 */     drawTexturedModalRect(offSetX, offSetY, 0, 0, this.xSize, this.ySize);
/* 31 */     ContainerFunnyFruitGenerator container = (ContainerFunnyFruitGenerator)this.inventorySlots;
/* 32 */     int burnTime = container.burnTime;
/* 33 */     int maxBurnTime = container.maxBurnTime;
/* 34 */     double energy = container.energy;
/* 35 */     double capaciry = container.capacity;
/* 36 */     if (burnTime > 0) {
/* 37 */       int width = (int)(burnTime / (float)maxBurnTime * 100.0F);
/* 38 */       width = (width == 0) ? 1 : width;
/* 39 */       drawTexturedModalRect(offSetX + 38, offSetY + 81, 0, 171, width, 2);
/*    */     } 
/* 41 */     if (energy > 0.0D) {
/* 42 */       int width = (int)(energy / capaciry * 24.0D);
/* 43 */       width = (width == 0) ? 1 : width;
/* 44 */       drawTexturedModalRect(offSetX + 76, offSetY + 19, 176, 0, width, 17);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void drawScreen(int mouseX, int mouseY, float partialTicks) {
/* 52 */     drawDefaultBackground();
/* 53 */     super.drawScreen(mouseX, mouseY, partialTicks);
/* 54 */     renderHoveredToolTip(mouseX, mouseY);
/*    */   }
/*    */ }


/* Location:              E:\minecraft\客户端\.minecraft\mods\FunnyFruitGenerator.jar!\ink\mhxk\funnyfruit\client\gui\GuiFunnyFruitGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
/*    */ package com.mhxks.funnyfruit2.network;

/*    */ import com.mhxks.funnyfruit2.inventory.ContainerFunnyFruitGenerator;
import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.entity.EntityPlayerSP;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NetWorkFunnyFruitGeneratorMessageHandler
/*    */   implements IMessageHandler<NetWorkFunnyFruitGeneratorMessage, IMessage>
/*    */ {
/*    */   public IMessage onMessage(NetWorkFunnyFruitGeneratorMessage message, MessageContext ctx) {
/* 20 */     EntityPlayerSP player = (Minecraft.getMinecraft()).player;
/* 21 */     if (player != null && 
/* 22 */       player.openContainer instanceof ContainerFunnyFruitGenerator) {
/* 23 */       ContainerFunnyFruitGenerator inventory = (ContainerFunnyFruitGenerator)player.openContainer;
/* 24 */       inventory.energy = message.energy;
/* 25 */       inventory.capacity = message.capacity;
/*    */     } 
/*    */     
/* 28 */     return null;
/*    */   }
/*    */ }


/* Location:              E:\minecraft\客户端\.minecraft\mods\FunnyFruitGenerator.jar!\ink\mhxk\funnyfruit\network\NetWorkFunnyFruitGeneratorMessageHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
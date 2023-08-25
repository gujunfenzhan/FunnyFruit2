/*    */ package com.mhxks.funnyfruit2.network;
/*    */ 
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ 
/*    */ public class NetWorkFunnyFruitGeneratorMessage
/*    */   implements IMessage {
/*    */   double energy;
/*    */   double capacity;
/*    */   
/*    */   public NetWorkFunnyFruitGeneratorMessage() {}
/*    */   
/*    */   public NetWorkFunnyFruitGeneratorMessage(double energy, double capacity) {
/* 15 */     this.energy = energy;
/* 16 */     this.capacity = capacity;
/*    */   }
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 20 */     PacketBuffer pb = new PacketBuffer(buf);
/* 21 */     this.energy = pb.readDouble();
/* 22 */     this.capacity = pb.readDouble();
/*    */   }
/*    */ 
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 27 */     PacketBuffer pb = new PacketBuffer(buf);
/* 28 */     pb.writeDouble(this.energy);
/* 29 */     pb.writeDouble(this.capacity);
/*    */   }
/*    */ }


/* Location:              E:\minecraft\客户端\.minecraft\mods\FunnyFruitGenerator.jar!\ink\mhxk\funnyfruit\network\NetWorkFunnyFruitGeneratorMessage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
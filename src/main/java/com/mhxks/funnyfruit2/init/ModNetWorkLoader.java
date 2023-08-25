/*    */ package com.mhxks.funnyfruit2.init;
/*    */ 
/*    */ import com.mhxks.funnyfruit2.FunnyFruit2Main;
import com.mhxks.funnyfruit2.network.NetWorkFunnyFruitGeneratorMessage;
import com.mhxks.funnyfruit2.network.NetWorkFunnyFruitGeneratorMessageHandler;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
/*    */ import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import net.minecraftforge.fml.relauncher.Side;
/*    */ 
/*    */ public class ModNetWorkLoader {
/* 11 */   public static int NEXT = 0;
/*    */   public ModNetWorkLoader() {
/* 13 */     registerClientNetwork((IMessageHandler<NetWorkFunnyFruitGeneratorMessage, IMessage>)new NetWorkFunnyFruitGeneratorMessageHandler(), NetWorkFunnyFruitGeneratorMessage.class);
/*    */   }
/*    */   public <REQ extends IMessage, REPLY extends IMessage> void registerServerNetwork(IMessageHandler<REQ, REPLY> handler, Class<REQ> imessage) {
/* 16 */     FunnyFruit2Main.getNetwork().registerMessage(handler, imessage, NEXT, Side.SERVER);
/* 17 */     NEXT++;
/*    */   }
/*    */   public <REQ extends IMessage, REPLY extends IMessage> void registerClientNetwork(IMessageHandler<REQ, REPLY> handler, Class<REQ> imessage) {
/* 20 */     FunnyFruit2Main.getNetwork().registerMessage(handler, imessage, NEXT, Side.CLIENT);
/*    */   }
/*    */ }


/* Location:              E:\minecraft\客户端\.minecraft\mods\FunnyFruitGenerator.jar!\ink\mhxk\funnyfruit\init\ModNetWorkLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
package com.mhxks.funnyfruit2;

import com.mhxks.funnyfruit2.block.BlockWithTileEntity;
import com.mhxks.funnyfruit2.common.CommonProxy;
import com.mhxks.funnyfruit2.init.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(name = "FunnyFruit2", modid = "funnyfruit2", version = "1.0", dependencies = "required-before:ic2", acceptedMinecraftVersions = "[1.12.2]")
public class FunnyFruit2Main {
    @SidedProxy(serverSide = "com.mhxks.funnyfruit2.common.CommonProxy", clientSide = "com.mhxks.funnyfruit2.client.ClientProxy")
    public static CommonProxy proxy;
    public static final String MODNAME = "FunnyFruit2";
    public static final String MODID = "funnyfruit2";
    public static final String MODVERSION = "1.0";
    @Mod.Instance
    public static FunnyFruit2Main INSTANCE;
    private static SimpleNetworkWrapper NETWORK;

    @Mod.EventHandler
    public void pre(final FMLPreInitializationEvent event) {
        FunnyFruit2Main.INSTANCE = this;
        MinecraftForge.EVENT_BUS.register((Object)FunnyFruit2Main.proxy);
        FunnyFruit2Main.NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel("funnyfruit2");
        new ModConfigLoader(event);
        new ModOreDictionaryLoader();
        new ModGuiLoader();
        new ModTileEntityLoader();
        new ModGuiLoader();
        new ModNetWorkLoader();
    }

    @Mod.EventHandler
    public void init(final FMLInitializationEvent event) {
        new ModSmeltingLoader();
        //实例化每个TileEntity，IC2有一套成熟的自动注册
        BlockWithTileEntity.buildDummies();
        new ModRecipeLoader();
    }

    @Mod.EventHandler
    public void post(final FMLPostInitializationEvent event) {
    }

    public static SimpleNetworkWrapper getNetwork() {
        return FunnyFruit2Main.NETWORK;
    }
}

package com.mhxks.funnyfruit2.block;

import com.mhxks.funnyfruit2.FunnyFruit2Main;
import com.mhxks.funnyfruit2.tileentity.TileEntityChargepadDISU;
import com.mhxks.funnyfruit2.tileentity.TileEntityDISU;
import ic2.core.block.ITeBlock;
import ic2.core.block.TileEntityBlock;
import ic2.core.ref.IC2Material;
import ic2.core.ref.TeBlock;
import ic2.core.util.Util;
import net.minecraft.block.material.Material;
import net.minecraft.item.EnumRarity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;

import static ic2.core.ref.TeBlock.*;
import javax.annotation.Nullable;
import java.util.Set;

public enum BlockWithTileEntity
implements ITeBlock {
    /*
    IC2提供的系统,需要在TeBlockFinalCallEvent事件使用IC2的TeBlockRegistry#addAll进行注册，在Init阶段调用buildDummies注册TileEntity
     */
    disu(TileEntityDISU.class,0,true, Util.allFacings,true,HarvestTool.Wrench,DefaultDrop.Self,2.0f,10.0f,EnumRarity.EPIC, IC2Material.MACHINE,false),
    disu_charged(TileEntityChargepadDISU.class,1,true,Util.allFacings,true,HarvestTool.Wrench, DefaultDrop.Self,2.0f,10.0f,EnumRarity.EPIC, IC2Material.MACHINE,false);





    private Class<? extends TileEntityBlock> teClass;
    private final int itemMeta;
    private final boolean hasActive;
    private final Set<EnumFacing> supportedFacings;
    private final boolean allowWrenchRotating;
    private final TeBlock.HarvestTool harvestTool;
    private final TeBlock.DefaultDrop defaultDrop;
    private final float hardness;
    //使用IC2提供的注册系统的唯一标识
    public static final ResourceLocation loc = new ResourceLocation(FunnyFruit2Main.MODID, "te");
    /*
    teClass 写机器需要自己写TileEntityElectricBlock的子类
    itemMeta 特殊值，不能重复
    hasActive
    supportedFacings 支持的面
    harvestTool 被挖掘的工具等级(扳手)
    defaultDrop 掉落物
    hardness 硬度
    explosionResistance
    rarity 稀有度
    material 材质
    transparent
     */
    BlockWithTileEntity(Class<? extends TileEntityBlock> teClass, int itemMeta, boolean hasActive,
                            Set<EnumFacing> supportedFacings, boolean allowWrenchRotating, TeBlock.HarvestTool harvestTool,
                            DefaultDrop defaultDrop, float hardness, float explosionResistance, EnumRarity rarity, Material material,
                            boolean transparent) {
        this.teClass = teClass;
        this.itemMeta = itemMeta;
        this.hasActive = hasActive;
        this.supportedFacings = supportedFacings;
        this.allowWrenchRotating = allowWrenchRotating;
        this.harvestTool = harvestTool;
        this.defaultDrop = defaultDrop;
        this.hardness = hardness;
        this.explosionResistance = explosionResistance;
        this.rarity = rarity;
        this.material = material;
        this.transparent = transparent;
    }
    private static final BlockWithTileEntity[] VALUES;
    //自动注册TileEntity
    static {
        for (BlockWithTileEntity block : values()) {
            TileEntity.register(loc.getResourceDomain() + ':' + block.getName(), block.getTeClass());
        }
        VALUES = values();

    }




    private final float explosionResistance;private final EnumRarity rarity;private final Material material;private final boolean transparent;private TileEntityBlock dummyTe;private ITePlaceHandler placeHandler;



    public static void buildDummies() {
        ModContainer mc = Loader.instance().activeModContainer();
        if (mc != null && FunnyFruit2Main.MODID.equals(mc.getModId())) {
            BlockWithTileEntity[] tileEntities = VALUES;

            for(BlockWithTileEntity block : tileEntities) {
                if (block.teClass != null) {
                    try {
                        block.dummyTe = block.teClass.newInstance();
                    } catch (Exception expt) {
                        System.out.println("[METS]:Failed to init a tile entity.");
                        expt.printStackTrace();
                    }
                }
            }
        } else {
            throw new IllegalAccessError("Don't mess with this please.");
        }
    }

    @Override
    public int getId() {
        // TODO Auto-generated method stub
        return this.itemMeta;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return this.name();
    }

    @Override
    public boolean allowWrenchRotating() {
        // TODO Auto-generated method stub
        return this.allowWrenchRotating;
    }

    @Override
    public DefaultDrop getDefaultDrop() {
        // TODO Auto-generated method stub
        return this.defaultDrop;
    }

    @Override
    public TileEntityBlock getDummyTe() {
        // TODO Auto-generated method stub
        return this.dummyTe;
    }

    @Override
    public float getExplosionResistance() {
        // TODO Auto-generated method stub
        return this.explosionResistance;
    }

    @Override
    public float getHardness() {
        // TODO Auto-generated method stub
        return this.hardness;
    }

    @Override
    public HarvestTool getHarvestTool() {
        // TODO Auto-generated method stub
        return this.harvestTool;
    }

    @Override
    public ResourceLocation getIdentifier() {
        // TODO Auto-generated method stub
        return loc;
    }

    @Override
    public EnumRarity getRarity() {
        // TODO Auto-generated method stub
        return this.rarity;
    }

    @Override
    public Set<EnumFacing> getSupportedFacings() {
        // TODO Auto-generated method stub
        return this.supportedFacings;
    }

    @Override
    public Class<? extends TileEntityBlock> getTeClass() {
        // TODO Auto-generated method stub
        return this.teClass;
    }

    @Override
    public boolean hasActive() {
        // TODO Auto-generated method stub
        return this.hasActive;
    }

    @Override
    public boolean hasItem() {
        // TODO Auto-generated method stub
        return (this.teClass != null && this.itemMeta != -1);
    }
}

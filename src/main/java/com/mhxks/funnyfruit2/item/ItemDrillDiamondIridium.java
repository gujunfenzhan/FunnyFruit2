package com.mhxks.funnyfruit2.item;
/*     */ import com.mhxks.funnyfruit2.init.ModCreativeTabLoader;
import ic2.core.IC2;
/*     */ import ic2.core.item.tool.HarvestLevel;
/*     */ import ic2.core.item.tool.ItemDrill;
/*     */ import ic2.core.ref.ItemName;
import ic2.core.util.StackUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.block.state.IBlockState;
/*     */ import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.EnumRarity;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ActionResult;
/*     */ import net.minecraft.util.EnumActionResult;
/*     */ import net.minecraft.util.EnumFacing;
/*     */ import net.minecraft.util.EnumHand;
/*     */ import net.minecraft.util.math.BlockPos;
/*     */ import net.minecraft.util.math.RayTraceResult;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;

public class ItemDrillDiamondIridium
extends ItemDrill{

    /*     */
    /*  68 */   protected static final Material[] MATERIALS = new Material[] { Material.ROCK, Material.GRASS, Material.GROUND, Material.SAND, Material.CLAY };
    /*     */

    /*     */
    /*     */   public ItemDrillDiamondIridium() {
        /*  73 */     super(null, 2000, HarvestLevel.Iridium, 10000000, 5000, 4, 100.0F);
        /*     */   this.setCreativeTab(ModCreativeTabLoader.FUNNY_FRUIT);

    }


    /*     */   public EnumRarity getRarity(ItemStack stack) {
        /* 237 */     return EnumRarity.UNCOMMON;
        /*     */   }


}

/*    */ package com.mhxks.funnyfruit2.block;

/*    */ import com.mhxks.funnyfruit2.FunnyFruit2Main;
import com.mhxks.funnyfruit2.init.ModCreativeTabLoader;
import com.mhxks.funnyfruit2.tileentity.TileEntityNormalFunnyFruitGenerator;
import net.minecraft.block.BlockContainer;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
/*    */ import net.minecraft.util.EnumBlockRenderType;
/*    */ import net.minecraft.util.EnumFacing;
/*    */ import net.minecraft.util.EnumHand;
/*    */ import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
/*    */ import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;

/*    */
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockNormalFunnyFruitGenerator
/*    */   extends BlockContainer
/*    */ {
/*    */   public BlockNormalFunnyFruitGenerator() {
/* 28 */     super(Material.ROCK);
/* 29 */     setCreativeTab(ModCreativeTabLoader.FUNNY_FRUIT);
            this.setHardness(1.0f);
            this.setHarvestLevel("pickaxe",1);
/*    */   }
/*    */ 
/*    */   
/*    */   public EnumBlockRenderType getRenderType(IBlockState state) {
/* 34 */     return EnumBlockRenderType.MODEL;
/*    */   }
/*    */ 
/*    */   
/*    */   public TileEntity createNewTileEntity(World worldIn, int meta) {
/* 39 */     return (TileEntity)new TileEntityNormalFunnyFruitGenerator();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
/* 44 */     if (worldIn != null && !worldIn.isRemote) {
/* 45 */       TileEntity tileEntity = worldIn.getTileEntity(pos);
/* 46 */       if (tileEntity instanceof TileEntityNormalFunnyFruitGenerator) {
/* 47 */         TileEntityNormalFunnyFruitGenerator machine = (TileEntityNormalFunnyFruitGenerator)tileEntity;
/* 48 */         playerIn.openGui(FunnyFruit2Main.INSTANCE, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
/*    */       } 
/*    */     } 
/*    */     
/* 52 */     return true;
/*    */   }


    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntity te = worldIn.getTileEntity(pos);
        if(te instanceof TileEntityNormalFunnyFruitGenerator){
            worldIn.spawnEntity(new EntityItem(worldIn,pos.getX(),pos.getY(),pos.getZ(),((TileEntityNormalFunnyFruitGenerator) te).funnyFruit.getStack()));
        }
        super.breakBlock(worldIn, pos, state);
    }
    /*    */ }


/* Location:              E:\minecraft\客户端\.minecraft\mods\FunnyFruitGenerator.jar!\ink\mhxk\funnyfruit\block\BlockNormalFunnyFruitGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
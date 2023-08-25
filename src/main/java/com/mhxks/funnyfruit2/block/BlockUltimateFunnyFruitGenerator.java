/*    */ package com.mhxks.funnyfruit2.block;

/*    */ import com.mhxks.funnyfruit2.FunnyFruit2Main;
import com.mhxks.funnyfruit2.init.ModCreativeTabLoader;
import com.mhxks.funnyfruit2.tileentity.TileEntityNormalFunnyFruitGenerator;
import com.mhxks.funnyfruit2.tileentity.TileEntityTripleFunnyFruitGenerator;
import com.mhxks.funnyfruit2.tileentity.TileEntityUltimateFunnyFruitGenerator;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockUltimateFunnyFruitGenerator
/*    */   extends BlockContainer
/*    */ {
/*    */   public BlockUltimateFunnyFruitGenerator() {
/* 23 */     super(Material.ROCK);
/* 24 */     setCreativeTab(ModCreativeTabLoader.FUNNY_FRUIT);
    this.setHardness(1.0f);
    this.setHarvestLevel("pickaxe",1);
/*    */   }
/*    */ 
/*    */   
/*    */   public TileEntity createNewTileEntity(World worldIn, int meta) {
/* 29 */     return (TileEntity)new TileEntityUltimateFunnyFruitGenerator();
/*    */   }
/*    */   
/*    */   public EnumBlockRenderType getRenderType(IBlockState state) {
/* 33 */     return EnumBlockRenderType.MODEL;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
/* 38 */     if (worldIn != null && !worldIn.isRemote) {
/* 39 */       TileEntity tileEntity = worldIn.getTileEntity(pos);
/* 40 */       if (tileEntity instanceof TileEntityUltimateFunnyFruitGenerator) {
/* 41 */         TileEntityUltimateFunnyFruitGenerator machine = (TileEntityUltimateFunnyFruitGenerator)tileEntity;
/* 42 */         playerIn.openGui(FunnyFruit2Main.INSTANCE, 3, worldIn, pos.getX(), pos.getY(), pos.getZ());
/*    */       } 
/*    */     } 
/*    */     
/* 46 */     return true;
/*    */   }
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntity te = worldIn.getTileEntity(pos);
        if(te instanceof TileEntityUltimateFunnyFruitGenerator){
            worldIn.spawnEntity(new EntityItem(worldIn,pos.getX(),pos.getY(),pos.getZ(),((TileEntityUltimateFunnyFruitGenerator) te).funnyFruit.getStack()));
        }
        super.breakBlock(worldIn, pos, state);
    }

/*    */ }


/* Location:              E:\minecraft\客户端\.minecraft\mods\FunnyFruitGenerator.jar!\ink\mhxk\funnyfruit\block\BlockUltimateFunnyFruitGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
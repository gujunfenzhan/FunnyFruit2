/*    */ package com.mhxks.funnyfruit2.block;

/*    */ import com.mhxks.funnyfruit2.FunnyFruit2Main;
import com.mhxks.funnyfruit2.init.ModCreativeTabLoader;
import com.mhxks.funnyfruit2.tileentity.TileEntityDoubleFunnyFruitGenerator;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockDoubleFunnyFruitGenerator
/*    */   extends BlockContainer
/*    */ {
/*    */   public BlockDoubleFunnyFruitGenerator() {
/* 23 */     super(Material.ROCK);
/* 24 */     setCreativeTab(ModCreativeTabLoader.FUNNY_FRUIT);
    this.setHardness(1.0f);
    this.setHarvestLevel("pickaxe",1);
/*    */   }
/*    */ 
/*    */   
/*    */   public TileEntity createNewTileEntity(World worldIn, int meta) {
/* 29 */     return (TileEntity)new TileEntityDoubleFunnyFruitGenerator();
/*    */   }
/*    */ 
/*    */   
/*    */   public EnumBlockRenderType getRenderType(IBlockState state) {
/* 34 */     return EnumBlockRenderType.MODEL;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
/* 39 */     if (worldIn != null && !worldIn.isRemote) {
/* 40 */       TileEntity tileEntity = worldIn.getTileEntity(pos);
/* 41 */       if (tileEntity instanceof TileEntityDoubleFunnyFruitGenerator) {
/* 42 */         TileEntityDoubleFunnyFruitGenerator machine = (TileEntityDoubleFunnyFruitGenerator)tileEntity;
/* 43 */         playerIn.openGui(FunnyFruit2Main.INSTANCE, 1, worldIn, pos.getX(), pos.getY(), pos.getZ());
/*    */       } 
/*    */     } 
/*    */     
/* 47 */     return true;
/*    */   }
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntity te = worldIn.getTileEntity(pos);
        if(te instanceof TileEntityDoubleFunnyFruitGenerator){
            worldIn.spawnEntity(new EntityItem(worldIn,pos.getX(),pos.getY(),pos.getZ(),((TileEntityDoubleFunnyFruitGenerator) te).funnyFruit.getStack()));
        }
        super.breakBlock(worldIn, pos, state);
    }
/*    */ }


/* Location:              E:\minecraft\客户端\.minecraft\mods\FunnyFruitGenerator.jar!\ink\mhxk\funnyfruit\block\BlockDoubleFunnyFruitGenerator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
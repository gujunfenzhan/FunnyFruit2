/*    */ package com.mhxks.funnyfruit2.block;

/*    */ import com.mhxks.funnyfruit2.init.ModCreativeTabLoader;
import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockLog;
/*    */ import net.minecraft.block.properties.IProperty;
/*    */ import net.minecraft.block.state.BlockStateContainer;
/*    */ import net.minecraft.block.state.IBlockState;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockLogFunnyFruit
/*    */   extends BlockLog
/*    */ {
    public BlockLogFunnyFruit() {
        this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, EnumAxis.Y));
        this.setCreativeTab(ModCreativeTabLoader.FUNNY_FRUIT);
        this.setHardness(1.5F);
        this.setHarvestLevel("axe", 1);

    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, LOG_AXIS);
    }

    public IBlockState getStateFromMeta(int meta) {
        EnumAxis enumfacing$axis = EnumAxis.Y;
        int i = meta & 12;

        if (i == 4) {
            enumfacing$axis = EnumAxis.X;
        } else if (i == 8) {
            enumfacing$axis = EnumAxis.Z;
        }

        return this.getDefaultState().withProperty(LOG_AXIS, enumfacing$axis);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state) {
        int i = 0;
        EnumAxis enumfacing$axis = (EnumAxis) state.getValue(LOG_AXIS);

        if (enumfacing$axis == EnumAxis.X) {
            i |= 4;
        } else if (enumfacing$axis == EnumAxis.Z) {
            i |= 8;
        }

        return i;
    }
/*    */ }


/* Location:              E:\minecraft\客户端\.minecraft\mods\FunnyFruitGenerator.jar!\ink\mhxk\funnyfruit\block\BlockLogFunnyFruit.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */
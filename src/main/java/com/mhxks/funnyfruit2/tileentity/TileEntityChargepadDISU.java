package com.mhxks.funnyfruit2.tileentity;

import ic2.core.block.wiring.TileEntityChargepadBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class TileEntityChargepadDISU
extends TileEntityChargepadBlock {
    public TileEntityChargepadDISU() {
        super(5, 40960, 600000000);

    }
    //给玩家充电
    @Override
    protected void getItems(EntityPlayer entityPlayer) {
        if (entityPlayer != null) {
            for (ItemStack current : entityPlayer.inventory.armorInventory) {
                if (current == null)
                    continue;
                chargeItem(current, 40960);
            }

            for (ItemStack current : entityPlayer.inventory.mainInventory) {
                if (current == null)
                    continue;
                chargeItem(current, 40960);
            }
        }
    }
}

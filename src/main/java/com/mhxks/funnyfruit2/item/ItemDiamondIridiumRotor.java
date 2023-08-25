package com.mhxks.funnyfruit2.item;

import com.mhxks.funnyfruit2.FunnyFruit2Main;
import com.mhxks.funnyfruit2.init.ModConfigLoader;
import com.mhxks.funnyfruit2.init.ModCreativeTabLoader;
import ic2.api.item.IKineticRotor;
import ic2.core.block.kineticgenerator.gui.GuiWaterKineticGenerator;
import ic2.core.block.kineticgenerator.gui.GuiWindKineticGenerator;
import ic2.core.init.Localization;
import ic2.core.item.resources.ItemWindRotor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemDiamondIridiumRotor
    extends Item
implements IKineticRotor {
    //IKineticRotor不是很好，跟ic2原版转子不是很像，需要addInformation和showDurabilityBar

    public ItemDiamondIridiumRotor() {

        this.setMaxDamage(10000000);
        this.setNoRepair();
        this.setMaxStackSize(1);
        this.setCreativeTab(ModCreativeTabLoader.FUNNY_FRUIT);
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World world, List<String> tooltip, ITooltipFlag advanced) {
        tooltip.add(Localization.translate("ic2.itemrotor.wind.info", new Object[]{getMinWindStrength(stack), getMaxWindStrength(stack)}));
        GearboxType type = null;
        if (Minecraft.getMinecraft().currentScreen instanceof GuiWaterKineticGenerator) {
            type = GearboxType.WATER;
        } else if (Minecraft.getMinecraft().currentScreen instanceof GuiWindKineticGenerator) {
            type = GearboxType.WIND;
        }

        if (type != null) {
            tooltip.add(Localization.translate("ic2.itemrotor.fitsin." + this.isAcceptedType(stack, type)));
        }

    }
    protected static final ResourceLocation texture = new ResourceLocation(FunnyFruit2Main.MODID,"textures/rotor/diamond_iridium_rotor.png");
    //直径
    @Override
    public int getDiameter(ItemStack itemStack) {
        return 48;
    }

    @Override
    public ResourceLocation getRotorRenderTexture(ItemStack itemStack) {
        return texture;
    }
    //发电效率
    @Override
    public float getEfficiency(ItemStack itemStack) {
        return (float) ModConfigLoader.diamondIridiumRotorEfficiency;
    }
    //最低风强度要求
    @Override
    public int getMinWindStrength(ItemStack itemStack) {
        return 10;
    }
    //最高风强度
    @Override
    public int getMaxWindStrength(ItemStack itemStack) {
        return 200;
    }

    @Override
    public boolean isAcceptedType(ItemStack itemStack, GearboxType gearboxType) {
        return true;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.RARE;
    }
}

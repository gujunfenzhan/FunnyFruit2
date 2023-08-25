package com.mhxks.funnyfruit2.item;

import com.mhxks.funnyfruit2.FunnyFruit2Main;
import com.mhxks.funnyfruit2.init.ModConfigLoader;
import com.mhxks.funnyfruit2.init.ModCreativeTabLoader;
import ic2.api.item.*;
import ic2.core.IC2;
import ic2.core.IC2Potion;
import ic2.core.init.Localization;
import ic2.core.init.MainConfig;
import ic2.core.item.ElectricItemManager;
import ic2.core.item.IPseudoDamageItem;
import ic2.core.item.armor.jetpack.IJetpack;
import ic2.core.util.ConfigUtil;
import ic2.core.util.StackUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import scala.Int;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

public class ItemDiamondIridiumSuit
extends ItemArmor
implements ISpecialArmor,
        //伪损坏
        IPseudoDamageItem,
        IElectricItem ,
        IItemHudInfo,
        IHazmatLike,
        IJetpack {
    private static ArmorMaterial material = EnumHelper.addArmorMaterial("diamond_iridium_suit",
            FunnyFruit2Main.MODID+":diamond_iridium_suit",
            50,new int[] {8,24,20,8},40, SoundEvents.ITEM_ARMOR_EQUIP_IRON,2);
    protected static final Map<Potion, Integer> potionRemovalCost = new IdentityHashMap();
    private float jumpCharge;
    public ItemDiamondIridiumSuit( EntityEquipmentSlot equipmentSlotIn,int index) {

        super(material, index, equipmentSlotIn);
        potionRemovalCost.put(MobEffects.POISON, 10000);
        potionRemovalCost.put(IC2Potion.radiation, 10000);
        potionRemovalCost.put(MobEffects.WITHER, 25000);
        this.setNoRepair();
        this.setMaxDamage(27);
        this.setMaxStackSize(1);
        this.setCreativeTab(ModCreativeTabLoader.FUNNY_FRUIT);
        if (armorType == EntityEquipmentSlot.FEET) {
            MinecraftForge.EVENT_BUS.register(this);
        }
    }
    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
        if (this.isInCreativeTab(tab)) {
            ElectricItemManager.addChargeVariants(this, subItems);
        }
    }
    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean canProvideEnergy(ItemStack stack) {
        return false;
    }

    @Override
    public double getMaxCharge(ItemStack stack) {
        return 100000000;
    }

    @Override
    public int getTier(ItemStack stack) {
        return 5;
    }

    @Override
    public double getTransferLimit(ItemStack stack) {
        return 50000;
    }
    //物品是否有效，是否添加盔甲值
    @Override
    public boolean addsProtection(EntityLivingBase entity, EntityEquipmentSlot slot, ItemStack stack) {
        return ElectricItem.manager.getCharge(stack)>0.0D;
    }

    @Override
    public List<String> getHudInfo(ItemStack stack, boolean advanced) {
        List<String> info = new LinkedList();
        info.add(ElectricItem.manager.getToolTip(stack));
        info.add(Localization.translate("ic2.item.tooltip.PowerTier", new Object[]{3}));
        return info;
    }

    @Override
    public void setStackDamage(ItemStack itemStack, int i) {
        super.setDamage(itemStack,i);
    }

    @Override
    public ArmorProperties getProperties(EntityLivingBase player, @Nonnull ItemStack armor, DamageSource source, double damage, int slot) {
        int energyPerDamage = getEnergyPerDamage();
        int damageLimit = Integer.MAX_VALUE;
        if(energyPerDamage>0){
            //不懂
            damageLimit = (int)Math.min((double)damageLimit, 25.0D * ElectricItem.manager.getCharge(armor) / (double)energyPerDamage);
        }
        if(source==DamageSource.FALL){
            //priority越高伤害结算优先级越高
            if(this.armorType==EntityEquipmentSlot.FEET){
                return new ArmorProperties(10,1.0D,damageLimit);
            }
            if(this.armorType==EntityEquipmentSlot.LEGS){
                return new ArmorProperties(9,0.8D,damageLimit);
            }
        }
        double absorptionRatio = this.getBaseAbsorptionRatio() * this.getDamageAbsorptionRatio();
        //优先级、吸收比例、最大吸收伤害
        return new ArmorProperties(8, absorptionRatio, damageLimit);
    }
    public int getEnergyPerDamage() {
        return ModConfigLoader.diamondIridiumArmorEnergyPerDamage;
    }
    //稀有程度
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.EPIC;
    }
    @Override
    public int getArmorDisplay(EntityPlayer player, @Nonnull ItemStack armor, int slot) {
        return ElectricItem.manager.getCharge(armor) >= (double)this.getEnergyPerDamage() ? (int)Math.round(20.0D * this.getBaseAbsorptionRatio() * this.getDamageAbsorptionRatio()) : 0;
    }

    @Override
    public void damageArmor(EntityLivingBase entity, @Nonnull ItemStack stack, DamageSource source, int damage, int slot) {

        //荆棘效果，反伤20%
        if(source.getTrueSource()!=null&&source.getTrueSource() instanceof EntityLiving){
            EntityLiving trueSource = (EntityLiving) source.getTrueSource();

            float fanshang = 0.2f*damage;
            fanshang = Math.max(1.0f,fanshang);
            if(ElectricItem.manager.getCharge(stack)>fanshang*getEnergyPerDamage()) {
                trueSource.attackEntityFrom(DamageSource.MAGIC, fanshang);
                ElectricItem.manager.discharge(stack, fanshang*getEnergyPerDamage(), 2147483647, true, false, false);
            }
        }
        //强制放电
        ElectricItem.manager.discharge(stack, (double)(damage * this.getEnergyPerDamage()), 2147483647, true, false, false);
    }

    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        boolean ret = false;

        NBTTagCompound nbtData = StackUtil.getOrCreateNbtData(itemStack);
        byte toggleTimer = nbtData.getByte("toggleTimer");
        switch (this.armorType){
            case HEAD:
                IC2.platform.profilerStartSection("DiamondIridiumHelmet");

                int air = player.getAir();
                if (ElectricItem.manager.canUse(itemStack, 1000.0D) && air < 100) {
                    player.setAir(air + 200);
                    ElectricItem.manager.use(itemStack, 1000.0D, (EntityLivingBase)null);
                    ret = true;
                } else if (air <= 0) {
                    IC2.achievements.issueAchievement(player, "starveWithQHelmet");
                }
                //给史蒂夫喂食
                if(ElectricItem.manager.canUse(itemStack,10000.0D)&&player.getFoodStats().needFood()){
                    player.getFoodStats().addStats(1,1.0f);
                    ElectricItem.manager.use(itemStack,10000.0D,(EntityLivingBase)null);
                }
                //清除负面效果
                Iterator var13 = (new LinkedList(player.getActivePotionEffects())).iterator();

                while(var13.hasNext()) {
                    PotionEffect effect = (PotionEffect)var13.next();
                    Potion potion = effect.getPotion();
                    Integer cost = (Integer)potionRemovalCost.get(potion);
                    if (cost != null) {
                        cost = cost * (effect.getAmplifier() + 1);
                        if (ElectricItem.manager.canUse(itemStack, (double)cost)) {
                            ElectricItem.manager.use(itemStack, (double)cost, (EntityLivingBase)null);
                            IC2.platform.removePotion(player, potion);
                        }
                    }
                }
                //夜视
                boolean Nightvision = nbtData.getBoolean("Nightvision");
                short hubmode = nbtData.getShort("HudMode");
                //夜视
                if (IC2.keyboard.isAltKeyDown(player) && IC2.keyboard.isModeSwitchKeyDown(player) && toggleTimer == 0) {

                    toggleTimer = 10;
                    Nightvision = !Nightvision;
                    if (IC2.platform.isSimulating()) {
                        nbtData.setBoolean("Nightvision", Nightvision);
                        if (Nightvision) {
                            IC2.platform.messagePlayer(player, "Nightvision enabled.", new Object[0]);
                        } else {
                            IC2.platform.messagePlayer(player, "Nightvision disabled.", new Object[0]);
                        }
                    }
                }
                //hub上的装备数据显示
                //但是没效果，那还是删了吧
                /*
                if (IC2.keyboard.isAltKeyDown(player) && IC2.keyboard.isHudModeKeyDown(player) && toggleTimer == 0) {
                    toggleTimer = 10;
                    if (hubmode == HudMode.getMaxMode()) {
                        hubmode = 0;
                    } else {
                        ++hubmode;
                    }

                    if (IC2.platform.isSimulating()) {
                        nbtData.setShort("HudMode", hubmode);
                        IC2.platform.messagePlayer(player, Localization.translate(HudMode.getFromID(hubmode).getTranslationKey()), new Object[0]);
                    }
                }*/
                //防止连续被调用的
                if (IC2.platform.isSimulating() && toggleTimer > 0) {
                    --toggleTimer;
                    nbtData.setByte("toggleTimer", toggleTimer);
                }
                //isSimulating 是不是服务端
                if (Nightvision && IC2.platform.isSimulating() && ElectricItem.manager.use(itemStack, 1.0D, player)) {
                    BlockPos pos = new BlockPos((int)Math.floor(player.posX), (int)Math.floor(player.posY), (int)Math.floor(player.posZ));
                    int skylight = player.getEntityWorld().getLightFromNeighbors(pos);
                    IC2.platform.removePotion(player, MobEffects.BLINDNESS);
                    player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 300, 0, true, true));
                    ret = true;
                }
                IC2.platform.profilerEndSection();
                break;
            case CHEST:
                IC2.platform.profilerStartSection("DiamondIridiumChest");
                //熄灭火焰
                player.extinguish();
                float currentHealth = player.getHealth();
                if(currentHealth<player.getMaxHealth()*0.2f){
                    if(ElectricItem.manager.use(itemStack,10000,player)){
                        player.setHealth(currentHealth+1);
                    }
                }


                IC2.platform.profilerEndSection();
                break;
            case LEGS:
                IC2.platform.profilerStartSection("DiamondIridiumLeg");
                boolean enableQuantumSpeedOnSprint;
                //从客户端看有没有开启速跑
                if (IC2.platform.isRendering()) {
                    enableQuantumSpeedOnSprint = ConfigUtil.getBool(MainConfig.get(), "misc/quantumSpeedOnSprint");
                } else {
                    enableQuantumSpeedOnSprint = true;
                }
                if (ElectricItem.manager.canUse(itemStack, 1000.0D) && (player.onGround || player.isInWater()) && IC2.keyboard.isForwardKeyDown(player) && (enableQuantumSpeedOnSprint && player.isSprinting() || !enableQuantumSpeedOnSprint && IC2.keyboard.isBoostKeyDown(player))) {
                    byte speedTicker = nbtData.getByte("speedTicker");
                    ++speedTicker;
                    if (speedTicker >= 10) {
                        speedTicker = 0;
                        ElectricItem.manager.use(itemStack, 1000.0D, (EntityLivingBase)null);
                        ret = true;
                    }

                    nbtData.setByte("speedTicker", speedTicker);
                    float speed = 0.22F;
                    if (player.isInWater()) {
                        speed = 0.1F;
                        if (IC2.keyboard.isJumpKeyDown(player)) {
                            player.motionY += 0.10000000149011612D;
                        }
                    }

                    if (speed > 0.0F) {
                        player.moveRelative(0.0F, 0.0F, 1.0F, speed);
                    }
                }

                IC2.platform.profilerEndSection();
                break;
            case FEET:
                //完成靴子的高跳跃
                if (IC2.platform.isSimulating()) {
                    boolean wasOnGround = nbtData.hasKey("wasOnGround") ? nbtData.getBoolean("wasOnGround") : true;
                    if (wasOnGround && !player.onGround && IC2.keyboard.isJumpKeyDown(player) && IC2.keyboard.isBoostKeyDown(player)) {
                        ElectricItem.manager.use(itemStack, 4000.0D, (EntityLivingBase)null);
                        ret = true;
                    }

                    if (player.onGround != wasOnGround) {
                        nbtData.setBoolean("wasOnGround", player.onGround);
                    }
                } else {
                    if (ElectricItem.manager.canUse(itemStack, 4000.0D) && player.onGround) {
                        this.jumpCharge = 1.0F;
                    }

                    if (player.motionY >= 0.0D && this.jumpCharge > 0.0F && !player.isInWater()) {
                        if (IC2.keyboard.isJumpKeyDown(player) && IC2.keyboard.isBoostKeyDown(player)) {
                            if (this.jumpCharge == 1.0F) {
                                player.motionX *= 3.5D;
                                player.motionZ *= 3.5D;
                            }

                            player.motionY += (double)(this.jumpCharge * 0.3F);
                            this.jumpCharge = (float)((double)this.jumpCharge * 0.75D);
                        } else if (this.jumpCharge < 1.0F) {
                            this.jumpCharge = 0.0F;
                        }
                    }
                }
                IC2.platform.profilerEndSection();


        }
        if(ret){
            player.inventoryContainer.detectAndSendChanges();
        }



        super.onArmorTick(world, player, itemStack);
    }

    protected final double getBaseAbsorptionRatio() {
        switch(this.armorType) {
            case HEAD:
                return 0.30D;
            case CHEST:
                return 0.8D;
            case LEGS:
                return 0.6D;
            case FEET:
                return 0.30D;
            default:
                return 0.0D;
        }
    }
    public double getDamageAbsorptionRatio() {
        return this.armorType == EntityEquipmentSlot.CHEST ? 1.2D : 1.0D;
    }
    //是否有足够的能量起飞
    @Override
    public boolean drainEnergy(ItemStack itemStack, int i) {
        return ElectricItem.manager.discharge(itemStack, (double)(i + 6), 2147483647, true, false, false) > 0.0D;
    }


    //向上的推力
    @Override
    public float getPower(ItemStack itemStack) {
        return 1.0F;
    }
    //掉落百分比
    @Override
    public float getDropPercentage(ItemStack itemStack) {
        return 0.05F;
    }
    //能量剩余量百分比
    @Override
    public double getChargeLevel(ItemStack itemStack) {
        return ElectricItem.manager.getCharge(itemStack) / this.getMaxCharge(itemStack);
    }

    @Override
    public boolean isJetpackActive(ItemStack itemStack) {
        return true;
    }

    @Override
    public float getHoverMultiplier(ItemStack itemStack, boolean b) {
        return 0.2F;
    }

    @Override
    public float getWorldHeightDivisor(ItemStack itemStack) {
        return 0.9F;
    }
    @SubscribeEvent(
            priority = EventPriority.LOW
    )
    public void onEntityLivingFallEvent(LivingFallEvent event) {
        if (IC2.platform.isSimulating() && event.getEntity() instanceof EntityLivingBase) {
            EntityLivingBase entity = (EntityLivingBase)event.getEntity();
            ItemStack armor = entity.getItemStackFromSlot(EntityEquipmentSlot.FEET);
            if (armor != null && armor.getItem() == this) {
                int fallDamage = Math.max((int)event.getDistance() - 10, 0);
                double energyCost = (double)(this.getEnergyPerDamage() * fallDamage);
                if (energyCost <= ElectricItem.manager.getCharge(armor)) {
                    ElectricItem.manager.discharge(armor, energyCost, 2147483647, true, false, false);
                    event.setCanceled(true);
                }
            }
        }

    }
    @SubscribeEvent
    public void onLivingKnockBackEvent(LivingKnockBackEvent event){
        if(IC2.platform.isSimulating()&&event.getEntity() instanceof EntityLivingBase){
            EntityLivingBase entity = (EntityLivingBase)event.getEntity();
            ItemStack armor = entity.getItemStackFromSlot(EntityEquipmentSlot.FEET);
            if (armor != null && armor.getItem() == this) {
                if(ElectricItem.manager.getCharge(armor)>10000){
                    ElectricItem.manager.discharge(armor, 10000, 2147483647, true, false, false);
                    event.setCanceled(true);
                }

            }
        }

    }
    protected boolean hasOverlayTexture() {
        return true;
    }
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        char suffix1 = this.armorType == EntityEquipmentSlot.LEGS ? '2' : '1';
        String suffix2 = type != null && this.hasOverlayTexture() ? "_overlay" : "";
        return "funnyfruit2:textures/models/armor/" + "diamond_iridium_suit" + '_' + suffix1 + suffix2 + ".png";
    }
}

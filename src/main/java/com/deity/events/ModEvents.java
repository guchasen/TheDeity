package com.deity.events;

import com.deity.TheDeity;
import com.deity.items.ModItems;
import com.deity.utils.CuriosUtils;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingChangeTargetEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;


@EventBusSubscriber(modid = TheDeity.MOD_ID)
public class ModEvents {
    private static final Map<LivingEntity, Long> THORN_COOLDOWN = new ConcurrentHashMap<>();
    private static final long COOLDOWN_MS = 200;
    private static final Random random = new Random();

    @SubscribeEvent
    public static void onLivingChangeTarget(LivingChangeTargetEvent event) {
        LivingEntity entity = event.getNewAboutToBeSetTarget();
        if(!(entity instanceof Player)) return;
        if(!CuriosUtils.hasCurio(entity, ModItems.ROTTEN_HEART.get())) return;
        if(!(event.getEntity().getType().is(EntityTypeTags.UNDEAD))) return;
        event.setCanceled(true);
    }
    @SubscribeEvent
    public static void onLivingDamage(LivingDamageEvent.Pre event) {
        LivingEntity hurtEntity = event.getEntity();
        if(!(hurtEntity instanceof Player)) return;
        handleUndyingWill(event, hurtEntity);
    }
    @SubscribeEvent
    public static void onLivingIncomingDamage(LivingIncomingDamageEvent event) {
        LivingEntity hurtEntity = event.getEntity();
        if(!(hurtEntity instanceof Player)) return;

        if (CuriosUtils.hasCurio(hurtEntity, ModItems.THORN_SCALES.get()))
            handleThornScales(event,  hurtEntity);

        if (CuriosUtils.hasCurio(hurtEntity, ModItems.DIVINE_GUARDIAN.get())) {
            if (random.nextFloat() < 0.25f) {
                float originalDamage = event.getAmount();
                float reducedDamage = originalDamage * 0.25f;
                event.setAmount(reducedDamage);
                hurtEntity.level().playSound(null, hurtEntity.getX(), hurtEntity.getY(), hurtEntity.getZ(),
                        SoundEvents.SHIELD_BLOCK, SoundSource.PLAYERS, 0.7F, 1.2F);}
        }

    }

    private static void handleThornScales(LivingIncomingDamageEvent event, LivingEntity player) {
        Entity directEntity = event.getSource().getDirectEntity();
        Entity sourceEntity = event.getSource().getEntity();
        if (directEntity instanceof Projectile) {
            return;
        }
        if (sourceEntity instanceof LivingEntity attacker) {
            long currentTime = System.currentTimeMillis();
            long lastDamage = THORN_COOLDOWN.getOrDefault(player, 0L);
            if (currentTime - lastDamage < COOLDOWN_MS) {
                return;
            }
            THORN_COOLDOWN.put(player, currentTime);
            attacker.hurt(player.damageSources().thorns(player), 1.0f);
        }
    }

    private static void handleUndyingWill(LivingDamageEvent.Pre event, LivingEntity player){
        if(!(CuriosUtils.hasCurio(player, ModItems.UNDYING_WILL.get()))) return;
        if(event.getNewDamage() < player.getHealth()) return;
        event.setNewDamage(0.0f);
        player.setHealth(1.0f);
        player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.TOTEM_USE, SoundSource.PLAYERS, 0.6F, 1.2F);
        CuriosUtils.destroyCurio(player, ModItems.UNDYING_WILL.get());
        player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 70, 255, false, false, false));
        player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 70, 255, false, false, false));
        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 70, 255, false, false, false));
        player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 80, 255, false, false, true));
        player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 80, 255, false, false, true));
        player.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 60, 0, false, false, true));
    }
}
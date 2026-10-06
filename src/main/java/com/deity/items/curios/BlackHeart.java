package com.deity.items.curios;

import com.deity.items.BaseCurioItem;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import top.theillusivec4.curios.api.SlotContext;

import java.util.List;

public class BlackHeart extends BaseCurioItem {
    private static final ResourceLocation SPEED_MODIFIER = ResourceLocation.fromNamespaceAndPath("the_deity", "black_heart_speed");

    public BlackHeart() {
        super(new Item.Properties()
                .rarity(Rarity.UNCOMMON)
                .stacksTo(1)
        );
    }
    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        if(!slotContext.entity().hasEffect(MobEffects.WITHER)) return;
        slotContext.entity().removeEffectNoUpdate(MobEffects.WITHER);
    }
    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> modifiers = LinkedHashMultimap.create();
        modifiers.put(Attributes.MOVEMENT_SPEED, new AttributeModifier(SPEED_MODIFIER, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        return modifiers;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.literal(""));
        tooltipComponents.add(Component.translatable("item.the_deity.black_heart.description")
                .withStyle(ChatFormatting.DARK_GRAY)
                .withStyle(ChatFormatting.ITALIC));
        tooltipComponents.add(Component.literal(""));
        tooltipComponents.add(Component.literal("§8§l黑黯之心 §r§8吞噬一切光明"));
        tooltipComponents.add(Component.literal("  免疫凋零"));
        tooltipComponents.add(Component.literal("  移动速度提升 5%"));
        tooltipComponents.add(Component.literal(""));
        tooltipComponents.add(Component.literal("§7§o\"黑暗并非终结，而是力量的源泉...\"§r"));
    }
}

package com.deity.items.curios;

import com.deity.items.BaseCurioItem;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import top.theillusivec4.curios.api.SlotContext;

import java.util.List;

public class ThornScales extends BaseCurioItem {
    public ThornScales() {
        super(new Item.Properties()
                .rarity(Rarity.RARE)
                .stacksTo(1)
        );
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.literal(""));
        tooltipComponents.add(Component.translatable("item.the_deity.thorn_scales.description")
                .withStyle(ChatFormatting.DARK_GREEN)
                .withStyle(ChatFormatting.ITALIC));
        tooltipComponents.add(Component.literal(""));
        tooltipComponents.add(Component.literal("  任何伤害你的敌人都将付出代价"));
        tooltipComponents.add(Component.literal("  尖刺会撕裂攻击者的血肉"));
        tooltipComponents.add(Component.literal("  痛楚将如影随形"));
        tooltipComponents.add(Component.literal(""));
        tooltipComponents.add(Component.literal("§a§l荆棘护甲 §r§a提供 +5 护甲值"));
        tooltipComponents.add(Component.literal("§6§l反伤效果 §r§e对近战攻击者造成 1 点伤害"));
        tooltipComponents.add(Component.literal(""));
        tooltipComponents.add(Component.literal("§2§o\"触碰即是毁灭...\"§r"));
    }

    private static final ResourceLocation ARMOR_MODIFIER = ResourceLocation.fromNamespaceAndPath("the_deity", "thorn_scales_armor");
    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> modifiers = LinkedHashMultimap.create();
        modifiers.put(Attributes.ARMOR, new AttributeModifier(ARMOR_MODIFIER, 5.0, AttributeModifier.Operation.ADD_VALUE));
        return modifiers;
    }
}

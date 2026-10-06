package com.deity.items.curios;

import com.deity.items.BaseCurioItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class DivineGuardian extends BaseCurioItem {
    public DivineGuardian() {
        super(new Item.Properties()
                .rarity(Rarity.EPIC)
                .stacksTo(1)
        );
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.literal(""));
        tooltipComponents.add(Component.translatable("item.the_deity.divine_guardian.description")
                .withStyle(ChatFormatting.GOLD)
                .withStyle(ChatFormatting.ITALIC));
        tooltipComponents.add(Component.literal(""));
        tooltipComponents.add(Component.literal("§6§l承天之护 §r§6神的庇护"));
        tooltipComponents.add(Component.literal("  承受伤害时有 25% 概率"));
        tooltipComponents.add(Component.literal("  将伤害降低至 25%"));
        tooltipComponents.add(Component.literal(""));
        tooltipComponents.add(Component.literal("§6§o\"天眷之人，神亦护之...\"§r"));
    }
}

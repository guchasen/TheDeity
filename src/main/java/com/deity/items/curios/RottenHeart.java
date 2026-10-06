package com.deity.items.curios;

import com.deity.items.BaseCurioItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class RottenHeart extends BaseCurioItem {
    public RottenHeart() {
        super(new Item.Properties()
                .rarity(Rarity.EPIC)
                .stacksTo(1)
        );
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.literal(""));
        tooltipComponents.add(Component.translatable("item.the_deity.rotten_heart.description")
                .withStyle(ChatFormatting.DARK_PURPLE)
                .withStyle(ChatFormatting.ITALIC));
        tooltipComponents.add(Component.literal(""));
        tooltipComponents.add(Component.translatable("item.the_deity.rotten_heart.effect")
                .withStyle(ChatFormatting.GRAY)
                .withStyle(ChatFormatting.OBFUSCATED));
        tooltipComponents.add(Component.literal(" 亡灵生物将对你俯首称臣 ")
                .withStyle(ChatFormatting.DARK_PURPLE)
                .withStyle(ChatFormatting.BOLD));
        tooltipComponents.add(Component.literal("  它们在恐惧中颤抖"));
        tooltipComponents.add(Component.literal("  死亡的气息成为了你的保护伞"));
        tooltipComponents.add(Component.literal(""));
        tooltipComponents.add(Component.literal("§5§l腐化之力 §r§5在血脉中涌动..."));
    }
}

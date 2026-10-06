package com.deity.items.curios;

import com.deity.items.BaseCurioItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class UndyingWill extends BaseCurioItem  {
    public UndyingWill() {
        super(new Item.Properties()
                .rarity(Rarity.EPIC)
                .stacksTo(1)
        );
    }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.literal(""));
        tooltipComponents.add(Component.translatable("item.the_deity.undying_will.description")
                .withStyle(ChatFormatting.DARK_PURPLE)
                .withStyle(ChatFormatting.ITALIC));
        tooltipComponents.add(Component.literal(""));
        tooltipComponents.add(Component.literal("§5§l不死意志 §r§5在绝境中爆发"));
        tooltipComponents.add(Component.literal("  受到致命伤时抵消死亡"));
        tooltipComponents.add(Component.literal("  但饰品将损毁"));
        tooltipComponents.add(Component.literal(""));
        tooltipComponents.add(Component.literal("§d§o\"死亡不是终点，而是另一种开始...\"§r"));
    }
}

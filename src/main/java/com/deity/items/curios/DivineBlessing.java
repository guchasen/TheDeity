package com.deity.items.curios;

import com.deity.items.BaseCurioItem;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import top.theillusivec4.curios.api.SlotContext;

public class DivineBlessing extends BaseCurioItem {
    public DivineBlessing() {
        super(new Item.Properties()
                .stacksTo(1)
                .rarity(Rarity.UNCOMMON)
        );
    }

    private static final ResourceLocation ARMOR_MODIFIER = ResourceLocation.fromNamespaceAndPath("the_deity", "divine_blessing_armor");
    private static final ResourceLocation ARMOR_TOUGHNESS_MODIFIER = ResourceLocation.fromNamespaceAndPath("the_deity", "divine_blessing_armor_toughness");
    private static final ResourceLocation ATTACK_DAMAGE_MODIFIER = ResourceLocation.fromNamespaceAndPath("the_deity", "divine_blessing_attack_damage");
    private static final ResourceLocation LUCK = ResourceLocation.fromNamespaceAndPath("the_deity", "divine_blessing_luck");
    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> modifiers = LinkedHashMultimap.create();

        modifiers.put(Attributes.LUCK, new AttributeModifier(LUCK, 1.0, AttributeModifier.Operation.ADD_VALUE));
        modifiers.put(Attributes.ARMOR, new AttributeModifier(ARMOR_MODIFIER, 3.0, AttributeModifier.Operation.ADD_VALUE));
        modifiers.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(ARMOR_TOUGHNESS_MODIFIER, 2.0, AttributeModifier.Operation.ADD_VALUE));
        modifiers.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(ATTACK_DAMAGE_MODIFIER, 1.0, AttributeModifier.Operation.ADD_VALUE));
        return modifiers;
    }
}

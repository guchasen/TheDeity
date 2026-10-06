package com.deity.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class BaseCurioItem extends Item implements ICurioItem {

    public BaseCurioItem() {
        super(new Item.Properties());
    }
    public BaseCurioItem(Properties properties) {
        super(properties);
    }

    @Override
    public void onEquip(SlotContext slotContext, ItemStack prevStack, ItemStack stack) {

    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
    }

    @Override
    public void onUnequip(SlotContext slotContext, ItemStack newStack, ItemStack stack) {
    }

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        return CuriosApi.getCuriosInventory(slotContext.entity())
                .map(handler -> !handler.isEquipped(this))
                .orElse(true);
    }
}

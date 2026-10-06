package com.deity.utils;


import com.deity.items.BaseCurioItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;

public class CuriosUtils {
    private CuriosUtils() {}

    public static boolean hasCurio(LivingEntity entity, BaseCurioItem curioItem) {
        return CuriosApi.getCuriosInventory(entity).map(handler -> handler.isEquipped(curioItem)).orElse(false);
    }

    public static void destroyCurio(LivingEntity entity, Item item) {
        CuriosApi.getCuriosInventory(entity).map(handler -> handler.findFirstCurio(item).map(
                slotResult -> {
                        ItemStack stack = slotResult.stack();
                        stack.shrink(1);
                        return true;
                    }
                )
        );
    }
}

package com.deity;

import com.deity.items.ModItems;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheDeity.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> THE_DEITY_TAB = 
        CREATIVE_MODE_TABS.register("the_deity_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.the_deity"))
            .icon(() -> new ItemStack(ModItems.GREEN_KEY.get()))
            .displayItems((parameters, output) -> {
                output.accept(ModItems.GREEN_KEY.get());
                output.accept(ModItems.DIVINE_BLESSING.get());
                output.accept(ModItems.ROTTEN_HEART.get());
                output.accept(ModItems.THORN_SCALES.get());
                output.accept(ModItems.UNDYING_WILL.get());
                output.accept(ModItems.DIVINE_GUARDIAN.get());
            })
            .build());
}

package com.deity.items;

import com.deity.items.curios.*;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.deity.TheDeity.MOD_ID;

public class ModItems {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MOD_ID);

    public static final DeferredItem<Item> GREEN_KEY = ITEMS.register("green_key", () -> new Item(new Item.Properties()));

    public static final DeferredItem<DivineBlessing> DIVINE_BLESSING = ITEMS.register("divine_blessing", DivineBlessing::new);
    public static final DeferredItem<RottenHeart> ROTTEN_HEART = ITEMS.register("rotten_heart", RottenHeart::new);
    public static final DeferredItem<ThornScales> THORN_SCALES = ITEMS.register("thorn_scales", ThornScales::new);
    public static final DeferredItem<UndyingWill> UNDYING_WILL = ITEMS.register("undying_will", UndyingWill::new);
    public static final DeferredItem<DivineGuardian> DIVINE_GUARDIAN = ITEMS.register("divine_guardian", DivineGuardian::new);
    public static final DeferredItem<BlackHeart> BLACK_HEART = ITEMS.register("black_heart", BlackHeart::new);

}

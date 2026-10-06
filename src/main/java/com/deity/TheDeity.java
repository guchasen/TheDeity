package com.deity;

import com.deity.items.curios.DivineBlessing;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import com.deity.items.ModItems;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import top.theillusivec4.curios.api.CuriosApi;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(TheDeity.MOD_ID)
public class TheDeity {

    public static final String MOD_ID = "the_deity";
    public static final Logger LOGGER = LogUtils.getLogger();


    public TheDeity(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);

        ModTab.CREATIVE_MODE_TABS.register(modEventBus);

        ModItems.ITEMS.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        //LOGGER.info("THE DEITY COMMON SETUP");

    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("The Deity server starting");
    }
}

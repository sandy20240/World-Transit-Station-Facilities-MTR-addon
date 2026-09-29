package com.worldmtr.wtsf.forge;

import com.worldmtr.wtsf.Wtsf;
import com.worldmtr.wtsf.client.WtsfWelcomeScreen;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(Wtsf.MOD_ID)
public final class WtsfForge {
    public WtsfForge() {
        Wtsf.init();
    }

    @Mod.EventBusSubscriber(modid = Wtsf.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static final class ClientEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(WtsfWelcomeScreen::showIfFirstLaunch);
        }
    }
}

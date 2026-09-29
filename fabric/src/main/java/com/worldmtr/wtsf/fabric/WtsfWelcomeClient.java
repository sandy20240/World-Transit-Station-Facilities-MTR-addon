package com.worldmtr.wtsf.fabric;

import com.worldmtr.wtsf.client.WtsfWelcomeScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;

public final class WtsfWelcomeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientLifecycleEvents.CLIENT_STARTED.register(client ->
                WtsfWelcomeScreen.showIfFirstLaunch());
    }
}

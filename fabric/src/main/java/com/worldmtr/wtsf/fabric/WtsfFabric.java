package com.worldmtr.wtsf.fabric;

import com.worldmtr.wtsf.Wtsf;
import net.fabricmc.api.ModInitializer;

public final class WtsfFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        Wtsf.init();
    }
}

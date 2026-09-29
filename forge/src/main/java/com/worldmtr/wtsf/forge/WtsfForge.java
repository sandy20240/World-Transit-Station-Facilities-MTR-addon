package com.worldmtr.wtsf.forge;

import com.worldmtr.wtsf.Wtsf;
import net.minecraftforge.fml.common.Mod;

@Mod(Wtsf.MOD_ID)
public final class WtsfForge {
    public WtsfForge() {
        Wtsf.init();
    }
}

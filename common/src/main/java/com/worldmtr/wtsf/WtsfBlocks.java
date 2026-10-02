package com.worldmtr.wtsf;

import org.mtr.mapping.holder.Block;
import org.mtr.mapping.holder.Identifier;
import org.mtr.mapping.registry.BlockRegistryObject;
import org.mtr.mod.Blocks;
import org.mtr.mod.CreativeModeTabs;
import org.mtr.mod.Init;

public final class WtsfBlocks {
    public static final BlockRegistryObject WTM_VR = Init.REGISTRY.registerBlockWithBlockItem(
            new Identifier(Wtsf.MOD_ID, "wtm_vr"),
            () -> new Block(new WtsfTicketMachine(
                    Blocks.createDefaultBlockSettings(true, blockState -> 5)
            )),
            CreativeModeTabs.RAILWAY_FACILITIES
    );

    public static final BlockRegistryObject WTM_POLAND = Init.REGISTRY.registerBlockWithBlockItem(
            new Identifier(Wtsf.MOD_ID, "wtm_poland"),
            () -> new Block(new WtsfTicketMachine(
                    Blocks.createDefaultBlockSettings(true, blockState -> 5)
            )),
            CreativeModeTabs.RAILWAY_FACILITIES
    );

    private WtsfBlocks() {
    }
}

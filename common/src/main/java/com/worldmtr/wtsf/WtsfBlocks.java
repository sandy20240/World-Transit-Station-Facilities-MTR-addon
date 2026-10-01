package com.worldmtr.wtsf;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;

public final class WtsfBlocks {
    public static final FacilityBlock WTM_POLAND = register(
            "wtm_poland",
            new FacilityBlock(
                    "Warsaw Ticket Machine",
                    net.minecraft.world.level.block.state.BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                            .strength(3.0F)
            )
    );

    private WtsfBlocks() {
    }

    private static FacilityBlock register(String id, FacilityBlock block) {
        return Registry.register(
                BuiltInRegistries.BLOCK,
                new ResourceLocation(Wtsf.MOD_ID, id),
                block
        );
    }
}

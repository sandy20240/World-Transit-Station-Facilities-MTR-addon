package com.worldmtr.wtsf;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public final class WtsfItems {
    public static final String WTM_POLAND_ID = "wtm_poland";

    public static final Item WTM_POLAND = Registry.register(
            BuiltInRegistries.ITEM,
            new ResourceLocation(Wtsf.MOD_ID, WTM_POLAND_ID),
            new BlockItem(WtsfBlocks.WTM_POLAND, new Item.Properties())
    );

    private WtsfItems() {
    }

    public static void register() {
        // Static initialization registers the item before the platform entrypoint finishes.
    }
}

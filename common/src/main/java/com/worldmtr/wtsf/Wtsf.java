package com.worldmtr.wtsf;

public final class Wtsf {
    public static final String MOD_ID = "wtsf";
    public static final String MOD_NAME = "World Transit Station Facilities";

    private Wtsf() {
    }

    public static void init() {
        CountryRegistry.bootstrap();
        WtsfFacilities.WTM_POLAND.toString();
        WtsfBlocks.WTM_VR.toString();
        WtsfBlocks.WTM_POLAND.toString();
        WtsfItems.register();
    }
}

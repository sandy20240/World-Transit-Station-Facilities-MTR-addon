package com.worldmtr.wtsf;

public final class WtsfFacilities {
    public static final Facility WTM_POLAND;

    static {
        CountryRegistry.bootstrap();
        WTM_POLAND = FacilityRegistry.register(
                "wtm_poland",
                "Warsaw Ticket Machine",
                "poland"
        );
    }

    private WtsfFacilities() {
    }
}

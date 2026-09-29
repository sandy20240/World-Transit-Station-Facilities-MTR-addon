package com.worldmtr.wtsf;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class FacilityRegistry {
    private static final Map<String, Facility> FACILITIES = new LinkedHashMap<>();

    private FacilityRegistry() {
    }

    public static Facility register(String id, String displayName, String countryId) {
        Country country = CountryRegistry.get(countryId);
        if (country == null) {
            throw new IllegalArgumentException("Unknown country: " + countryId);
        }
        if (FACILITIES.containsKey(id)) {
            throw new IllegalStateException("Facility already registered: " + id);
        }

        Facility facility = new Facility(id, displayName, country);
        FACILITIES.put(id, facility);
        return facility;
    }

    public static Facility get(String id) {
        return FACILITIES.get(id);
    }

    public static Collection<Facility> all() {
        return Collections.unmodifiableCollection(FACILITIES.values());
    }
}

package com.worldmtr.wtsf;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class CountryRegistry {
    private static final Map<String, Country> COUNTRIES = new LinkedHashMap<>();

    private CountryRegistry() {
    }

    public static void bootstrap() {
        if (!COUNTRIES.isEmpty()) return;

        register("india", "India");
        register("japan", "Japan");
        register("china", "China");
        register("hong_kong", "Hong Kong");
        register("singapore", "Singapore");
        register("south_korea", "South Korea");
        register("poland", "Poland");
        register("united_kingdom", "United Kingdom");
        register("united_states", "United States");
    }

    public static Country register(String id, String displayName) {
        if (COUNTRIES.containsKey(id)) {
            throw new IllegalStateException("Country already registered: " + id);
        }
        Country country = new Country(id, displayName);
        COUNTRIES.put(id, country);
        return country;
    }

    public static Country get(String id) { return COUNTRIES.get(id); }

    public static Collection<Country> all() {
        return Collections.unmodifiableCollection(COUNTRIES.values());
    }
}

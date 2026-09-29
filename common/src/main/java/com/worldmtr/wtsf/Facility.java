package com.worldmtr.wtsf;

import java.util.Objects;

public record Facility(String id, String displayName, Country country) {
    public Facility {
        Objects.requireNonNull(id, "id");
        Objects.requireNonNull(displayName, "displayName");
        Objects.requireNonNull(country, "country");
        if (id.isBlank()) {
            throw new IllegalArgumentException("Facility id cannot be blank");
        }
    }
}

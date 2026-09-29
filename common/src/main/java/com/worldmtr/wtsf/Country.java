package com.worldmtr.wtsf;

import java.util.Objects;

public record Country(String id, String displayName) {
    public Country {
        Objects.requireNonNull(id, "id");
        Objects.requireNonNull(displayName, "displayName");
        if (id.isBlank()) {
            throw new IllegalArgumentException("Country id cannot be blank");
        }
        if (displayName.isBlank()) {
            throw new IllegalArgumentException("Country display name cannot be blank");
        }
    }
}

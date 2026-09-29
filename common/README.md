# WTSF Common

The common module contains loader-independent WTSF logic.

## Responsibilities

- Country definitions and country-based inventory grouping
- Facility definitions
- Shared registries
- Shared data/models
- Loader-neutral utilities

## Platform boundary

Fabric and Forge/NeoForge implementations belong in their own modules. Common code should not directly import Fabric, Forge, NeoForge, or loader-specific MTR APIs.

Architectury will be used as the multiloader boundary.

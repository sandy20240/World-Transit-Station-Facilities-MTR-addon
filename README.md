# World Transit Station Facilities

WTSF is a Minecraft Transit Railway (MTR) addon providing station facilities organized by country.

## Architecture

- Architectury API
- Common shared logic
- Fabric platform
- Forge platform
- MTR 4.0.5
- Java 17

Cubimised API is an optional project dependency planned for performance/integration features; it is not part of the WTSF common API.

## Status

Initial multi-loader architecture is being built. The current Gradle target is Minecraft 1.20.1 with MTR 4.0.5; additional Minecraft versions can be added as separate platform targets without moving loader-specific code into common.

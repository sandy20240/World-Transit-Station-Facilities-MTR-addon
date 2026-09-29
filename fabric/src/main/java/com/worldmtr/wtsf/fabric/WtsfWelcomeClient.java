package com.worldmtr.wtsf.fabric;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class WtsfWelcomeClient implements ClientModInitializer {
    private static final Path SEEN_FILE = Minecraft.getInstance().gameDirectory.toPath()
            .resolve("config").resolve("wtsf-welcome-seen");

    @Override
    public void onInitializeClient() {
        ClientLifecycleEvents.CLIENT_STARTED.register(client -> {
            if (!Files.exists(SEEN_FILE)) {
                client.setScreen(new WelcomeScreen());
            }
        });
    }

    private static final class WelcomeScreen extends Screen {
        private WelcomeScreen() {
            super(Component.literal("World Transit Station Facilities"));
        }

        @Override
        protected void init() {
            int buttonWidth = 150;
            int buttonHeight = 20;
            int x = (this.width - buttonWidth) / 2;
            int y = this.height - 42;
            this.addRenderableWidget(net.minecraft.client.gui.components.Button.builder(
                    Component.literal("CONTINUE"), button -> {
                        try {
                            Files.createDirectories(SEEN_FILE.getParent());
                            Files.writeString(SEEN_FILE, "seen");
                        } catch (IOException ignored) {
                            // If saving fails, the welcome screen may appear again next launch.
                        }
                        Minecraft.getInstance().setScreen(null);
                    }).bounds(x, y, buttonWidth, buttonHeight).build());
        }

        @Override
        public void render(GuiGraphics graphics, int mouseX, int mouseY, float delta) {
            this.renderBackground(graphics);
            int centerX = this.width / 2;
            graphics.drawCenteredString(this.font, "WORLD TRANSIT STATION FACILITIES",
                    centerX, this.height / 2 - 90, 0xFFFFFF);
            graphics.drawCenteredString(this.font, "WTSF",
                    centerX, this.height / 2 - 65, 0x55DDE0);
            graphics.drawCenteredString(this.font, "189 HOURS OF DEVELOPMENT",
                    centerX, this.height / 2 - 35, 0xFFFFFF);
            graphics.drawCenteredString(this.font, "Hope you enjoy this mod!",
                    centerX, this.height / 2 - 5, 0xD0D0D0);
            graphics.drawCenteredString(this.font, "Admins",
                    centerX, this.height / 2 + 28, 0x55DDE0);
            graphics.drawCenteredString(this.font, "Sandy · Curt · Renikh · Mathew · Waterberry",
                    centerX, this.height / 2 + 48, 0xFFFFFF);
            super.render(graphics, mouseX, mouseY, delta);
        }

        @Override
        public boolean shouldCloseOnEsc() {
            return false;
        }
    }
}

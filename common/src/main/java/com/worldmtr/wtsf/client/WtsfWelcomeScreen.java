package com.worldmtr.wtsf.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Shared WTSF first-launch welcome screen. Platform modules only call
 * {@link #showIfFirstLaunch()} from their client lifecycle hook.
 */
public final class WtsfWelcomeScreen extends Screen {
    private static final Path SEEN_FILE = Minecraft.getInstance().gameDirectory.toPath()
            .resolve("config").resolve("wtsf-welcome-seen");

    private WtsfWelcomeScreen() {
        super(Component.literal("World Transit Station Facilities"));
    }

    public static void showIfFirstLaunch() {
        Minecraft client = Minecraft.getInstance();
        if (!Files.exists(SEEN_FILE)) {
            client.setScreen(new WtsfWelcomeScreen());
        }
    }

    @Override
    protected void init() {
        int buttonWidth = 150;
        int x = (this.width - buttonWidth) / 2;
        int y = this.height - 42;
        this.addRenderableWidget(Button.builder(Component.literal("CONTINUE"), button -> {
            try {
                Files.createDirectories(SEEN_FILE.getParent());
                Files.writeString(SEEN_FILE, "seen");
            } catch (IOException ignored) {
                // The screen can appear again on next launch if the flag cannot be saved.
            }
            Minecraft.getInstance().setScreen(null);
        }).bounds(x, y, buttonWidth, 20).build());
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

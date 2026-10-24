package com.halloweenmenu.client;

import net.minecraft.client.gui.DrawContext;

/** Мелкие помощники для рисования (чтобы не зависеть от версии DrawContext). */
public final class Gfx {
    private Gfx() {
    }

    /** Рамка толщиной 1 пиксель. */
    public static void border(DrawContext ctx, int x, int y, int w, int h, int color) {
        ctx.fill(x, y, x + w, y + 1, color);
        ctx.fill(x, y + h - 1, x + w, y + h, color);
        ctx.fill(x, y + 1, x + 1, y + h - 1, color);
        ctx.fill(x + w - 1, y + 1, x + w, y + h - 1, color);
    }
}

package com.halloweenmenu.client.mixin;

import com.halloweenmenu.client.ThemedBackground;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Screen.class)
public abstract class ScreenMixin {

    /** Заменяет серый/земляной фон на хеллоуинскую сцену (Minecraft 1.20.1: renderBackground(DrawContext)). */
    @Inject(method = "renderBackground(Lnet/minecraft/client/gui/DrawContext;)V", at = @At("HEAD"), cancellable = true, require = 0)
    private void halloween$background(DrawContext context, CallbackInfo ci) {
        if (ThemedBackground.applies((Screen) (Object) this)) {
            MinecraftClient client = MinecraftClient.getInstance();
            int w = context.getScaledWindowWidth();
            int mouseX = (int) (client.mouse.getX() * w / (double) Math.max(1, client.getWindow().getWidth()));
            int mouseY = (int) (client.mouse.getY() * context.getScaledWindowHeight() / (double) Math.max(1, client.getWindow().getHeight()));
            ThemedBackground.render(context, mouseX, mouseY);
            ci.cancel();
        }
    }
}

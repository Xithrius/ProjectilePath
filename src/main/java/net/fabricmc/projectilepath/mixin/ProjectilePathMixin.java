package net.fabricmc.projectilepath.mixin;

import net.fabricmc.projectilepath.ProjectilePath;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class ProjectilePathMixin {
    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) {
        ProjectilePath.LOGGER.info("This line is printed by an projectile path mixin!");
    }
}

package theobald.bossbar.mixin;

import theobald.bossbar.TheobaldBossBar;
import net.minecraft.client.gui.hud.BossBarHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BossBarHud.class)
public class BossBarHudMixin
{
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    private void render(MatrixStack matrices, CallbackInfo ci)
    {
        if(TheobaldBossBar.enabled)
        {
            ci.cancel();
            return;
        }
    }
}

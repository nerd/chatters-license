package io.github.nerd.license.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// because the Minecraft version we are using is too high, these mixin targets will not resolve
@SuppressWarnings("UnresolvedMixinReference")
@Mixin(
        targets = "com.mojang.authlib.yggdrasil.YggdrasilSocialInteractionsService",
        remap = false
)
public class LegacyUserPropertiesSpoofer {
    @Inject(method = "serversAllowed", at = @At("HEAD"), cancellable = true)
    private void allowServers(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }

    @Inject(method = "realmsAllowed", at = @At("HEAD"), cancellable = true)
    private void allowRealms(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }

    @Inject(method = "chatAllowed", at = @At("HEAD"), cancellable = true)
    private void allowChat(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
}

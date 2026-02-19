package io.github.nerd.license.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@SuppressWarnings("OverwriteAuthorRequired")
@Mixin(targets = "com.mojang.authlib.yggdrasil.YggdrasilSocialInteractionsService", remap = false)
public class LegacyUserPropertiesSpoofer {
    @Overwrite
    public boolean serversAllowed() {
        return true;
    }

    @Overwrite
    public boolean realmsAllowed() {
        return true;
    }

    @Overwrite
    public boolean chatAllowed() {
        return true;
    }
}

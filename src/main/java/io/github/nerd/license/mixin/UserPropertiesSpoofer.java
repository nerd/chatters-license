package io.github.nerd.license.mixin;

import com.google.common.collect.ImmutableSet;
import com.mojang.authlib.minecraft.UserApiService;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import static com.mojang.authlib.minecraft.UserApiService.UserFlag.*;

@Mixin(targets = "com.mojang.authlib.yggdrasil.YggdrasilUserApiService", remap = false)
public class UserPropertiesSpoofer {
    @Unique
    private static final ImmutableSet<UserApiService.UserFlag> GOOD_FLAGS = ImmutableSet.of(
            CHAT_ALLOWED, SERVERS_ALLOWED, REALMS_ALLOWED
    );

    @Redirect(
            method = "fetchProperties",
            at = @At(
                    value = "INVOKE",
                    target = "Lcom/google/common/collect/ImmutableSet$Builder;build()Lcom/google/common/collect/ImmutableSet;"
            )
    )
    private ImmutableSet<UserApiService.UserFlag> redirectFlagSetBuild(ImmutableSet.Builder<UserApiService.UserFlag> instance) {
        return instance.addAll(GOOD_FLAGS).build();
    }
}

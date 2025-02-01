package io.github.candycalc.mixin;

import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import vazkii.botania.common.item.relic.RingOfOdinItem;

@Mixin(RingOfOdinItem.class)
public class RingOfOdinItemMixin {
    @Inject(at = @At("HEAD"), method="onValidPlayerWornTick", cancellable = true)
    private void onValidPlayerWornTick(PlayerEntity player, CallbackInfo ci) {
        ci.cancel();
    }

    @Inject(at = @At("HEAD"), method="onPlayerAttacked", cancellable = true)
    private static void onPlayerAttacked(PlayerEntity player, DamageSource src, CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(false);
    }
}

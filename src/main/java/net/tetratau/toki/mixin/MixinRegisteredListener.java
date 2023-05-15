package net.tetratau.toki.mixin;

import net.tetratau.toki.api.event.TokiHookBukkitEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.plugin.RegisteredListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = RegisteredListener.class, remap = false)
public abstract class MixinRegisteredListener {

    @Inject(method = "callEvent", at = @At(value = "INVOKE",
            target = "Lorg/bukkit/plugin/EventExecutor;execute(Lorg/bukkit/event/Listener;Lorg/bukkit/event/Event;)V",
            shift = At.Shift.BEFORE))
    private void toki$hookEvent(Event event, CallbackInfo ci) {
        if (Bukkit.getServer() != null) {
            TokiHookBukkitEvent.EVENT.invoker().hook(event);
        }
    }
}

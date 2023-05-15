package net.tetratau.toki.api.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

/**
 * @author wdog5
 * Made mod can hook Bukkit Event
 */
public interface TokiHookBukkitEvent {

    Event<TokiHookBukkitEvent> EVENT = EventFactory.createArrayBacked(TokiHookBukkitEvent.class,
            (listeners) -> (bukkitEvent) -> {
                for (TokiHookBukkitEvent listener : listeners) {
                    listener.hook(bukkitEvent);
                }
            });

    void hook(org.bukkit.event.Event bukkitEvent);
}

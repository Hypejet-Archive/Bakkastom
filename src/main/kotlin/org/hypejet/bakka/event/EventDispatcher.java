package org.hypejet.bakka.event;

import org.hypejet.bakka.event.trait.CancellableEvent;
import org.hypejet.bakka.AmogusServer;
import org.jetbrains.annotations.NotNull;

public final class EventDispatcher {

    public static void call(@NotNull Event event) {
        AmogusServer.INSTANCE.getGlobalEventHandler().call(event);
    }

    public static <E extends Event> ListenerHandle<E> getHandle(@NotNull Class<E> handleType) {
        return AmogusServer.INSTANCE.getGlobalEventHandler().getHandle(handleType);
    }

    public static void callCancellable(@NotNull CancellableEvent event, @NotNull Runnable successCallback) {
        AmogusServer.INSTANCE.getGlobalEventHandler().callCancellable(event, successCallback);
    }
}

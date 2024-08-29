package org.axein.seasons.events;

import org.axein.seasons.domain.Season;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class SeasonChangeEvent extends Event {

    private static final HandlerList _handlers = new HandlerList();
    private final Season _newSeason;

    public SeasonChangeEvent(Season newSeason) {
        _newSeason = newSeason;
    }

    public Season getewSeason() {
        return _newSeason;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return _handlers;
    }

    public static HandlerList getHandlerList() {
        return _handlers;
    }
}

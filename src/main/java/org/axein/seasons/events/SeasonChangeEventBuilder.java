package org.axein.seasons.events;

import org.axein.seasons.domain.Season;

public class SeasonChangeEventBuilder {
    private Season newSeason;

    public SeasonChangeEventBuilder setNewSeason(Season newSeason) {
        this.newSeason = newSeason;
        return this;
    }

    public SeasonChangeEvent createSeasonChangeEvent() {
        return new SeasonChangeEvent(newSeason);
    }
}
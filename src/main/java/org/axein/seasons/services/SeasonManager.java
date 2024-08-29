package org.axein.seasons.services;

import org.axein.seasons.domain.Season;
import org.axein.seasons.config.SeasonConfig;
import org.axein.seasons.localization.LocalizationManager;

public class SeasonManager {
    private Season currentSeason;
    private final ISeasonEffectApplier effectApplier;
    private final SeasonConfig seasonConfig;
    private final LocalizationManager localizationManager;

    public SeasonManager(
            Season initialSeason,
            ISeasonEffectApplier effectApplier,
            SeasonConfig seasonConfig,
            LocalizationManager localizationManager
    ) {
        this.currentSeason = initialSeason;
        this.effectApplier = effectApplier;
        this.seasonConfig = seasonConfig;
        this.localizationManager = localizationManager;
    }

    public void nextSeason() {
        currentSeason = currentSeason.next();
        applySeasonEffects();
    }

    public void applySeasonEffects() {
        effectApplier.applyEffects(currentSeason, seasonConfig);
    }

    public String getLocalizedSeasonName() {
        return localizationManager.getSeasonName(currentSeason);
    }

    public Season getCurrentSeason() {
        return currentSeason;
    }
}

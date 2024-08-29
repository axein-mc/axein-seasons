package org.axein.seasons.services;

import org.axein.seasons.domain.Season;
import org.axein.seasons.config.SeasonConfig;

public interface ISeasonEffectApplier {
    void applyEffects(Season season, SeasonConfig config);
}

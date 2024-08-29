package org.axein.seasons.services;

import org.axein.seasons.domain.Season;
import org.axein.seasons.config.SeasonConfig;

public class WeatherEffectApplier implements ISeasonEffectApplier {

    @Override
    public void applyEffects(Season season, SeasonConfig config) {
        // Применение погодных эффектов в зависимости от сезона и конфигурации
        switch (season) {
            case WINTER:
                // Применение зимних эффектов
                break;
            case SPRING:
                // Применение весенних эффектов
                break;
            case SUMMER:
                // Применение летних эффектов
                break;
            case AUTUMN:
                // Применение осенних эффектов
                break;
        }
    }
}


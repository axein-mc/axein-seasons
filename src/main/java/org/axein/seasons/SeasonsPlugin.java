package org.axein.seasons;

import org.axein.seasons.config.SeasonConfig;
import org.axein.seasons.domain.Season;
import org.axein.seasons.localization.LocalizationManager;
import org.axein.seasons.services.CommandRegistrar;
import org.axein.seasons.services.SeasonManager;
import org.axein.seasons.services.WeatherEffectApplier;
import org.bukkit.plugin.java.JavaPlugin;


public final class SeasonsPlugin extends JavaPlugin {

    private Season currentSeason;
    private int daysPerSeason;


    private LocalizationManager localizationManager;
    private SeasonManager seasonManager;

    /**
     * Один игровой день в Minecraft 24000 тиков
     */
    private static final short ticksPerDay = 24000;

    @Override
    public void onEnable() {
        saveDefaultConfig();
//        loadSeasonSettings();

        currentSeason = Season.SPRING;

        String defaultLocale = getConfig().getString("locale", "en"); // Чтение языка из конфигурации плагина
        localizationManager = new LocalizationManager(getDataFolder(), defaultLocale);

        SeasonConfig seasonConfig = new SeasonConfig(0, 0, 0);
        seasonManager = new SeasonManager(Season.SPRING, new WeatherEffectApplier(), seasonConfig, localizationManager);


        CommandRegistrar.RegisterCommands(this);

        // Запуск задачи, которая обновляет сезон каждые N дней
//        new BukkitRunnable() {
//            int dayCounter = 0;
//
//            @Override
//            public void run() {
//                dayCounter++;
//
//                // Проверяем, нужно ли сменить сезон
//                if (dayCounter >= daysPerSeason) {
//                    nextSeason();
//                    dayCounter = 0;
//                }
//
//                applySeasonEffects();
//            }
//        }.runTaskTimer(this, 0, ticksPerDay);
    }

    @Override
    public void onDisable() {
        // Сохранение состояния сезона
        getConfig().set("currentSeason", currentSeason.name());
        saveConfig();
    }

//    private void loadSeasonSettings() {
//        daysPerSeason = getConfig().getInt("seasons." + currentSeason.name().toLowerCase() + ".duration", 10);
//    }

//    public void nextSeason() {
//        // Переход к следующему сезону
//        currentSeason = currentSeason.next();
//        Bukkit.broadcastMessage("Наступил " + currentSeason.getName() + "!");
//
//        // Генерация ивента на смену сезона
//        Bukkit.getServer().getPluginManager().callEvent(new SeasonChangeEvent(currentSeason));
//
//        // Обновление продолжительности для следующего сезона
//        loadSeasonSettings();
//    }

//    public void applySeasonEffects() {
//        // Применение эффектов текущего сезона ко всем мирам
//        for (World world : Bukkit.getWorlds()) {
//            currentSeason.applyEffects(world, this.getConfig());
//        }
//    }

//    public Season getCurrentSeason() {
//        return currentSeason;
//    }
//
//    public void setCurrentSeason(Season season) {
//        this.currentSeason = season;
//        applySeasonEffects();
//        Bukkit.broadcastMessage("Сезон изменен на " + season.getName() + "!");
//    }
}

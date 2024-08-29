package org.axein.seasons.localization;

import org.axein.seasons.domain.Season;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class LocalizationManager {

    private final Map<String, FileConfiguration> localeConfigs = new HashMap<>();
    private FileConfiguration currentConfig;

    public LocalizationManager(File dataFolder, String defaultLocale) {
        loadLocale("en", dataFolder); // Загрузите основной язык по умолчанию
        if (!defaultLocale.equals("en")) {
            loadLocale(defaultLocale, dataFolder);
        }
        setLocale(defaultLocale); // Установите начальный язык
    }

    private void loadLocale(String locale, File dataFolder) {
        File file = new File(dataFolder, locale + ".yml");
        if (!file.exists()) {
            // Создайте файл и загрузите начальные значения, если файл не существует
            // Здесь можно добавить стандартные локализации
        }
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        localeConfigs.put(locale, config);
    }

    public void setLocale(String locale) {
        currentConfig = localeConfigs.get(locale);
        if (currentConfig == null) {
            throw new IllegalArgumentException("Locale not loaded: " + locale);
        }
    }

    public String getSeasonName(Season season) {
        String key = "season." + season.name().toLowerCase();
        return currentConfig.getString(key, season.name()); // Возвращает имя сезона по умолчанию, если ключ не найден
    }
}

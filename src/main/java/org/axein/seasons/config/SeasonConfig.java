package org.axein.seasons.config;

public class SeasonConfig {
    private final int rainChance;
    private final int stormChance;
    private final int snowChance;

    public SeasonConfig(int rainChance, int stormChance, int snowChance) {
        this.rainChance = rainChance;
        this.stormChance = stormChance;
        this.snowChance = snowChance;
    }

    public int getRainChance() {
        return rainChance;
    }

    public int getStormChance() {
        return stormChance;
    }

    public int getSnowChance() {
        return snowChance;
    }
}

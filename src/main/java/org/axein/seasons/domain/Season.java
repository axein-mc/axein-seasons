package org.axein.seasons.domain;

public enum Season {
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER;

    public Season next() {
        return values()[(ordinal() + 1) % values().length];
    }
}


//public enum Season {
//    SPRING("Весна"),
//    SUMMER("Лето"),
//    AUTUMN("Осень"),
//    WINTER("Зима");
//
//    private final String _name;
//    private final Random _random = new Random();
//
//    Season(String name) {
//        _name = name;
//    }
//
//    public String getName() {
//        return _name;
//    }
//
//    public Season next() {
//        return values()[(ordinal() + 1) % values().length];
//    }
//
//    public void applyEffects(World world, FileConfiguration config) {
//        String seasonName = this.name().toLowerCase();
//        int rainChance = config.getInt("seasons." + seasonName + ".weather.rain_chance", 0);
//        int stormChance = config.getInt("seasons." + seasonName + ".weather.storm_chance", 0);
//
//        if (this == WINTER) {
//            int snowChance = config.getInt("seasons." + seasonName + ".weather.snow_chance", 0);
//            if (_random.nextInt(100) < snowChance) {
//                world.setStorm(true);
//                world.setWeatherDuration(12000);
//            }
//        } else if (_random.nextInt(100) < rainChance) {
//            world.setStorm(true);
//            if (_random.nextInt(100) < stormChance) {
//                world.setThundering(true);
//            }
//            world.setWeatherDuration(12000);
//        } else {
//            world.setStorm(false);
//            world.setThundering(false);
//        }
//    }
//}


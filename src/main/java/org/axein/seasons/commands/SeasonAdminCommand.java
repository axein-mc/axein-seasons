package org.axein.seasons.commands;


import org.axein.seasons.SeasonsPlugin;
import org.axein.seasons.domain.Season;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SeasonAdminCommand implements CommandExecutor {

    private final SeasonsPlugin _plugin;

    public SeasonAdminCommand(SeasonsPlugin plugin) {
        _plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String[] args) {
        if (command.getName().equalsIgnoreCase("setseason")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Эту команду можно использовать только в игре.");
                return true;
            }

            Player player = (Player) sender;
            if (!player.hasPermission("seasonplugin.admin")) {
                player.sendMessage("У вас нет прав для использования этой команды.");
                return true;
            }

            if (args.length == 1) {
                try {
                    Season season = Season.valueOf(args[0].toUpperCase());
                    _plugin.setCurrentSeason(season);
                    player.sendMessage("Сезон установлен на " + season.getName() + ".");
                    return true;
                } catch (IllegalArgumentException e) {
                    player.sendMessage("Неверное название сезона.");
                }
            } else {
                player.sendMessage("Использование: /setseason <весна|лето|осень|зима>");
            }
        }
        return false;
    }
}

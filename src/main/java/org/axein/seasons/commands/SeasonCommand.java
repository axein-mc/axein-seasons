package org.axein.seasons.commands;

import org.axein.seasons.SeasonsPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SeasonCommand implements CommandExecutor {

    private final SeasonsPlugin plugin;

    public SeasonCommand(SeasonsPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(
            @NotNull CommandSender sender,
            Command command, @NotNull
            String label,
            String[] args
    ) {
        if (!command.getName().equalsIgnoreCase("season")) {
            return false;
        }

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Эту команду можно использовать только в игре.");
            return false;
        }

        player.sendMessage("Текущий сезон: " + plugin.getCurrentSeason().getName());
        return true;
    }
}


package org.axein.seasons.services;

import org.axein.seasons.SeasonsPlugin;
import org.axein.seasons.commands.SeasonAdminCommand;
import org.axein.seasons.commands.SeasonCommand;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;

public class CommandRegistrar {

    public static void RegisterCommands(SeasonsPlugin plugin){
        Register(plugin.getCommand("season"), new SeasonCommand(plugin));
        Register(plugin.getCommand("season:set"), new SeasonAdminCommand(plugin));
    }

    private static void Register(PluginCommand command, CommandExecutor executor) {
        if (command == null) {
            throw new NullPointerException();
        }

        command.setExecutor(executor);
    }
}

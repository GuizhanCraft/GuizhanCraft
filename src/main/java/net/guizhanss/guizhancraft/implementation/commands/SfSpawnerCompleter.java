package net.guizhanss.guizhancraft.implementation.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public final class SfSpawnerCompleter implements TabCompleter {
    @Override
    @ParametersAreNonnullByDefault
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            // Sub command
            String[] subcommands = {"broken", "repaired"};
            return Arrays.asList(subcommands);
        } else if (args.length == 2) {
            // Player name
            return Bukkit.getServer().getOnlinePlayers()
                .stream().map(Player::getName)
                .collect(Collectors.toList());
        } else if (args.length == 3) {
            // Entity type
            return Arrays.stream(EntityType.values())
                .map(EntityType::toString)
                .collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }
}

package net.guizhanss.guizhancraft.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SfSpawnerCompleter implements TabCompleter {
    @Override
    @ParametersAreNonnullByDefault
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            String[] subcommands = { "broken", "repaired" };
            return Arrays.asList(subcommands);
        } else if (args.length == 2) {
            return Bukkit.getServer().getOnlinePlayers()
                .stream().map(Player::getName)
                .collect(Collectors.toList());
        } else if (args.length == 3) {
            return Arrays.stream(EntityType.values())
                .map(EntityType::toString)
                .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}

package net.guizhanss.guizhancraft.implementation.commands;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.guizhanss.guizhancraft.implementation.GuizhanCraft;

public class UnloadChunkCommand implements CommandExecutor {

    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp() && !sender.hasPermission("guizhancraft.commands.unloadchunk")) {
            GuizhanCraft.getLocalization().sendMessage(sender, "no-permission");
            return true;
        }

        if (!(sender instanceof Player player)) {
            GuizhanCraft.getLocalization().sendMessage(sender, "no-console");
            return true;
        }

        if (args.length == 0) {
            Chunk chunk = player.getLocation().getChunk();
            if (chunk.isForceLoaded()) {
                chunk.setForceLoaded(false);
                GuizhanCraft.getLocalization().send(sender, "commands.unloadchunk.success");
            } else {
                GuizhanCraft.getLocalization().send(sender, "commands.unloadchunk.not-force-loaded");
            }
        } else {
            GuizhanCraft.getLocalization().sendMessage(sender, "usage", "/unloadchunk");
        }
        return true;
    }

}

package net.guizhanss.guizhancraft.implementation.commands;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Chunk;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;

import net.guizhanss.guizhancraft.GuizhanCraft;
import net.guizhanss.guizhanlib.minecraft.commands.BaseCommand;

/**
 * Command /unloadchunk
 *
 * @author ybw0014
 */
public final class UnloadChunkCommand extends BaseCommand {

    @ParametersAreNonnullByDefault
    public UnloadChunkCommand(PluginCommand command) {
        super(command, (cmd, sender) -> GuizhanCraft.getLocalization().getString("commands." + cmd + ".description"), "");
    }

    @Override
    @ParametersAreNonnullByDefault
    public void onExecute(CommandSender sender, String[] args) {
        if (!sender.hasPermission("guizhancraft.commands.unloadchunk")) {
            GuizhanCraft.getLocalization().sendMessage(sender, "no-permission");
            return;
        }

        if (!(sender instanceof Player player)) {
            GuizhanCraft.getLocalization().sendMessage(sender, "no-console");
            return;
        }

        Chunk chunk = player.getLocation().getChunk();
        if (chunk.isForceLoaded()) {
            chunk.setForceLoaded(false);
            GuizhanCraft.getLocalization().send(sender, "commands.unloadchunk.success");
        } else {
            GuizhanCraft.getLocalization().send(sender, "commands.unloadchunk.not-force-loaded");
        }
    }
}

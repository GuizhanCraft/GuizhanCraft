package net.guizhanss.guizhancraft.implementation.commands

import net.guizhanss.guizhancraft.GuizhanCraft
import net.guizhanss.guizhanlib.minecraft.commands.BaseCommand
import org.bukkit.command.CommandSender
import org.bukkit.command.PluginCommand
import org.bukkit.entity.Player

class UnloadChunkCommand(command: PluginCommand?) : BaseCommand(
    command,
    { cmd, _ -> GuizhanCraft.localization.getString("commands.${cmd.name}") },
    ""
) {

    override fun onExecute(sender: CommandSender, args: Array<String>) {
        if (!sender.hasPermission("guizhancraft.commands.unloadchunk")) {
            GuizhanCraft.localization.sendMessage(sender, "no-permission")
            return
        }

        if (sender !is Player) {
            GuizhanCraft.localization.sendMessage(sender, "no-console")
            return
        }

        val chunk = sender.location.chunk
        if (chunk.isForceLoaded) {
            chunk.isForceLoaded = false
            GuizhanCraft.localization.sendMessage(sender, "commands.unloadchunk.success")
        } else {
            GuizhanCraft.localization.sendMessage(sender, "commands.unloadchunk.not-force-loaded")
        }
    }
}

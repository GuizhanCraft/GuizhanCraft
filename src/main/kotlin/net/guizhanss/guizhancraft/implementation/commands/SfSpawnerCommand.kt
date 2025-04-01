package net.guizhanss.guizhancraft.implementation.commands

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.AbstractMonsterSpawner
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.ItemUtils
import net.guizhanss.guizhancraft.GuizhanCraft
import net.guizhanss.guizhanlib.kt.common.extensions.valueOfOrNull
import net.guizhanss.guizhanlib.kt.minecraft.items.edit
import net.guizhanss.guizhanlib.kt.slimefun.items.toItem
import net.guizhanss.guizhanlib.minecraft.commands.BaseCommand
import net.guizhanss.guizhanlib.minecraft.utils.InventoryUtil
import org.bukkit.Bukkit
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.PluginCommand
import org.bukkit.entity.EntityType

class SfSpawnerCommand(command: PluginCommand?) : BaseCommand(
    command,
    { cmd, _ -> GuizhanCraft.localization.getString("commands.${cmd.name}") },
    "<broken/repaired> <player> <mob_type> [amount]"
) {

    override fun onExecute(sender: CommandSender, args: Array<String>) {
        if (!sender.hasPermission("guizhancraft.commands.sfspawner")) {
            GuizhanCraft.localization.sendMessage(sender, "no-permission")
            return
        }

        if (args[0].equals("broken", ignoreCase = true)) {
            giveSpawner(sender, args, false)
        } else if (args[0].equals("repaired", ignoreCase = true)) {
            giveSpawner(sender, args, true)
        } else {
            sendHelp(sender, name)
        }
    }

    override fun onTabComplete(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<String>
    ): List<String>? = when (args.size) {
        1 -> listOf("broken", "repaired")
        2 -> null
        3 -> EntityType.entries.filter { it.name.startsWith(args[2], true) }.map { it.name }
        else -> listOf()
    }

    private fun giveSpawner(sender: CommandSender, args: Array<String>, isRepaired: Boolean) {
        val target = Bukkit.getPlayer(args[1]) ?: run {
            GuizhanCraft.localization.sendMessage(sender, "player-not-found", args[1])
            return
        }

        // limit amount
        val amount = args.getOrNull(3)?.toIntOrNull()?.coerceIn(1, 64) ?: 1

        // Get entity type
        val entityType = valueOfOrNull<EntityType>(args[2]) ?: run {
            GuizhanCraft.localization.sendMessage(sender, "commands.sfspawner.invalid-entity-type", args[2])
            return
        }

        // Get spawner
        val spawnerItem: SlimefunItemStack =
            if (isRepaired) SlimefunItems.REPAIRED_SPAWNER else SlimefunItems.BROKEN_SPAWNER
        val spawner = SlimefunItem.getByItem(spawnerItem.toItem()) as AbstractMonsterSpawner
        val item = spawner.getItemForEntityType(entityType).edit { amount(amount) }

        InventoryUtil.push(target, item)
        GuizhanCraft.localization.sendMessage(
            sender,
            "commands.sfspawner.sent",
            target.name,
            ItemUtils.getItemName(item)
        )
        GuizhanCraft.localization.sendMessage(
            target,
            "commands.sfspawner.received",
            sender.name,
            ItemUtils.getItemName(item)
        )
    }
}

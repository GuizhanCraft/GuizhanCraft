package net.guizhanss.guizhancraft.implementation.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.AbstractMonsterSpawner;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.ItemUtils;

import net.guizhanss.guizhancraft.GuizhanCraft;
import net.guizhanss.guizhancraft.utils.Utils;
import net.guizhanss.guizhanlib.minecraft.commands.BaseCommand;
import net.guizhanss.guizhanlib.minecraft.utils.InventoryUtil;

/**
 * Command /sfspawner
 *
 * @author ybw0014
 */
public final class SfSpanwerCommand extends BaseCommand {

    @ParametersAreNonnullByDefault
    public SfSpanwerCommand(PluginCommand command) {
        super(command, (cmd, sender) -> GuizhanCraft.getLocalization().getString("commands." + cmd + ".description"), "<broken/repaired> <player> <mob_type> [amount]");
    }

    @Override
    @ParametersAreNonnullByDefault
    public void onExecute(CommandSender sender, String[] args) {
        if (!sender.hasPermission("guizhancraft.commands.sfspawner")) {
            GuizhanCraft.getLocalization().sendMessage(sender, "no-permission");
            return;
        }

        if (args[0].equalsIgnoreCase("broken")) {
            giveSpawner(sender, args, false);
        } else if (args[0].equalsIgnoreCase("repaired")) {
            giveSpawner(sender, args, true);
        } else {
            sendHelp(sender, getName());
        }
    }

    @Nullable
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 1) {
            // Sub command
            String[] subcommands = { "broken", "repaired" };
            return Arrays.asList(subcommands);
        } else if (args.length == 2) {
            // Player
            return null;
        } else if (args.length == 3) {
            // Entity type
            return Arrays.stream(EntityType.values())
                .map(EntityType::toString)
                .filter(name -> name.startsWith(args[1]))
                .toList();
        }
        return new ArrayList<>();
    }

    private void giveSpawner(CommandSender sender, String[] args, boolean isRepaired) {
        Player target = Bukkit.getPlayer(args[1]);
        if (target == null) {
            GuizhanCraft.getLocalization().sendMessage(sender, "player-not-found", args[1]);
            return;
        }
        // limit amount
        int amount = Utils.parseIntAndClamp(args.length == 4 ? args[3] : null, 1, 64);

        // Get entity type
        EntityType entityType;
        try {
            entityType = EntityType.valueOf(args[2]);
        } catch (IllegalArgumentException ex) {
            GuizhanCraft.getLocalization().send(sender, "commands.sfspawner.invalid-entity-type", args[2]);
            return;
        }

        // Get spawner
        ItemStack sfItemStack = isRepaired ? SlimefunItems.REPAIRED_SPAWNER : SlimefunItems.BROKEN_SPAWNER;
        SlimefunItem sfItem = SlimefunItem.getByItem(sfItemStack);
        AbstractMonsterSpawner spawnerItem = (AbstractMonsterSpawner) sfItem;
        ItemStack spawner = new CustomItemStack(spawnerItem.getItemForEntityType(entityType), amount);

        InventoryUtil.push(target, spawner);
        GuizhanCraft.getLocalization().send(sender, "commands.sfspawner.sent", target.getName(), ItemUtils.getItemName(spawner));
        GuizhanCraft.getLocalization().send(target, "commands.sfspawner.received", sender.getName(), ItemUtils.getItemName(spawner));
    }
}

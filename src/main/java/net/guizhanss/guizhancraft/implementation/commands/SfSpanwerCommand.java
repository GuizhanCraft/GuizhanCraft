package net.guizhanss.guizhancraft.implementation.commands;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.AbstractMonsterSpawner;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

import net.guizhanss.guizhancraft.implementation.GuizhanCraft;
import net.guizhanss.guizhanlib.java.IntegerHelper;
import net.guizhanss.guizhanlib.minecraft.helper.inventory.ItemStackHelper;
import net.guizhanss.guizhanlib.utils.InventoryUtil;

/**
 * {@link CommandExecutor} for /sfspawner
 *
 * TODO: rewrite when AddonCommand is published
 * @author ybw0014
 */
public class SfSpanwerCommand implements CommandExecutor {

    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp() && !sender.hasPermission("guizhancraft.commands.sfspawner")) {
            GuizhanCraft.getLocalization().sendMessage(sender, "no-permission");
            return true;
        }
        if (args.length == 3 || args.length == 4) {
            if (args[0].equalsIgnoreCase("broken")) {
                giveSpawner(sender, args, false);
            } else if (args[0].equalsIgnoreCase("repaired")) {
                giveSpawner(sender, args, true);
            } else {
                GuizhanCraft.getLocalization().sendMessage(sender, "usage", "/sf <broken/repaired> <player> <mob_type> [amount]");
            }
        } else {
            GuizhanCraft.getLocalization().sendMessage(sender, "usage", "/sf <broken/repaired> <player> <mob_type> [amount]");
        }
        return true;
    }

    private void giveSpawner(CommandSender sender, String[] args, boolean isRepaired) {
        Player target = Bukkit.getPlayer(args[1]);
        if (target == null) {
            GuizhanCraft.getLocalization().sendMessage(sender, "player-not-found", args[1]);
            return;
        }
        // limit amount
        int amount = IntegerHelper.parseInt(args.length == 4 ? args[3] : null, 1, 64);

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
        GuizhanCraft.getLocalization().send(sender, "commands.sfspawner.sent", target.getName(), ItemStackHelper.getDisplayName(spawner));
        GuizhanCraft.getLocalization().send(target, "commands.sfspawner.received", sender.getName(), ItemStackHelper.getDisplayName(spawner));
    }

}

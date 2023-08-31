package net.guizhanss.guizhancraft.implementation.commands;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
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
import net.guizhanss.guizhanlib.minecraft.utils.InventoryUtil;

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

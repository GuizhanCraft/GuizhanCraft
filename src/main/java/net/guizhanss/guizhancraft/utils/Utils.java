package net.guizhanss.guizhancraft.utils;

import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerSkin;
import lombok.experimental.UtilityClass;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;

@UtilityClass
public class Utils {
    public static void send(CommandSender sender, String message) {
        sender.sendMessage(message);
    }

    public static String getItemId(String id) {
        return "GZ_" + id;
    }

    public static ItemStack getHeadItem(String hashCode) {
        return PlayerHead.getItemStack(PlayerSkin.fromHashCode(hashCode));
    }
}

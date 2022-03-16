package net.guizhanss.guizhancraft.utils;

import lombok.Getter;
import lombok.experimental.UtilityClass;
import net.guizhanss.guizhancraft.GuizhanCraft;
import org.bukkit.NamespacedKey;

@UtilityClass
public class Keys {

    @Getter
    private NamespacedKey mainItemGroup;

    public static void init() {
        GuizhanCraft plugin = GuizhanCraft.instance();

        mainItemGroup = new NamespacedKey(plugin, "main_item_group");
    }
}

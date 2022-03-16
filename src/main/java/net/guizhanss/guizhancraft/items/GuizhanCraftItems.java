package net.guizhanss.guizhancraft.items;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.experimental.UtilityClass;
import net.guizhanss.guizhancraft.utils.Utils;
import org.bukkit.Material;

@UtilityClass
public class GuizhanCraftItems {
    public static SlimefunItemStack ENHANCED_ANCIENT_ALTAR = new SlimefunItemStack(
        Utils.getItemId("ENHANCED_ANCIENT_ALTAR"),
        Material.ENCHANTING_TABLE,
        "增强古代祭坛"
    );
}

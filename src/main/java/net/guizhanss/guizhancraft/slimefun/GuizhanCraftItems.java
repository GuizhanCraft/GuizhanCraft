package net.guizhanss.guizhancraft.slimefun;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.experimental.UtilityClass;
import net.guizhanss.guizhancraft.slimefun.itemstack.GuizhanCraftItemStack;
import org.bukkit.Material;

/**
 * This class holds all GuizhanCraft's {@link SlimefunItemStack}
 *
 * @author ybw0014
 */
@UtilityClass
public final class GuizhanCraftItems {
    // region Materials
    public static final SlimefunItemStack BACKPACK_MATERIAL = new GuizhanCraftItemStack(
        "BACKPACK_MATERIAL",
        Material.LEATHER
    );
    // endregion Materials

    // region Machine
    public static final SlimefunItemStack BACKPACK_UPGRADER = new GuizhanCraftItemStack(
        "BACKPACK_UPGRADER",
        Material.DEEPSLATE
    );
    public static final SlimefunItemStack RECYCLER = new GuizhanCraftItemStack(
        "RECYCLER",
        Material.PRISMARINE
    );
    // endregion Machine

    // region Magic
    public static final SlimefunItemStack ENHANCED_ANCIENT_ALTAR = new GuizhanCraftItemStack(
        "ENHANCED_ANCIENT_ALTAR",
        Material.ENCHANTING_TABLE
    );
    // endregion Magic
}

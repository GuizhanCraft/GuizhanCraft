package net.guizhanss.guizhancraft.slimefun;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import lombok.experimental.UtilityClass;
import net.guizhanss.guizhancraft.GuizhanCraft;
import net.guizhanss.guizhancraft.utils.Utils;
import org.bukkit.Material;

/**
 * This class holds all GuizhanCraft's {@link SlimefunItemStack}
 *
 * @author ybw0014
 */
@UtilityClass
public final class GuizhanCraftItems {
    // region Materials
    public static final SlimefunItemStack BACKPACK_MATERIAL = new SlimefunItemStack(
        Utils.getItemId("BACKPACK_MATERIAL"),
        Material.LEATHER,
        GuizhanCraft.getLocalizationService().getItemName("BACKPACK_MATERIAL"),
        GuizhanCraft.getLocalizationService().getItemLore("BACKPACK_MATERIAL")
    );
    // endregion Materials

    // region Machine
    public static final SlimefunItemStack BACKPACK_UPGRADER = new SlimefunItemStack(
        Utils.getItemId("BACKPACK_UPGRADER"),
        Material.DEEPSLATE,
        GuizhanCraft.getLocalizationService().getItemName("BACKPACK_UPGRADER"),
        GuizhanCraft.getLocalizationService().getItemLore("BACKPACK_UPGRADER")
    );
    public static final SlimefunItemStack RECYCLER = new SlimefunItemStack(
        Utils.getItemId("RECYCLER"),
        Material.PRISMARINE,
        GuizhanCraft.getLocalizationService().getItemName("RECYCLER"),
        GuizhanCraft.getLocalizationService().getItemLore("RECYCLER")
    );
    // endregion Machine

    // region Magic
    public static final SlimefunItemStack ENHANCED_ANCIENT_ALTAR = new SlimefunItemStack(
        Utils.getItemId("ENHANCED_ANCIENT_ALTAR"),
        Material.ENCHANTING_TABLE,
        GuizhanCraft.getLocalizationService().getItemName("ENHANCED_ANCIENT_ALTAR"),
        GuizhanCraft.getLocalizationService().getItemLore("ENHANCED_ANCIENT_ALTAR")
    );
    // endregion Magic
}

package net.guizhanss.guizhancraft.utils;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.experimental.UtilityClass;
import net.guizhanss.guizhancraft.GuizhanCraft;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

@UtilityClass
public final class GuiItems {
    // region General
    public static final ItemStack PREVIEW = new CustomItemStack(
        Material.LIME_STAINED_GLASS_PANE,
        GuizhanCraft.getLocalization().getString("gui.preview")
    );
    public static final ItemStack CRAFT = new CustomItemStack(
        Material.CRAFTING_TABLE,
        GuizhanCraft.getLocalization().getString("gui.craft")
    );
    // endregion General

    // region BackpackUpgrader
    public static final ItemStack BACKPACK_MATERIAL_INDICATOR = new CustomItemStack(
        Material.LIME_STAINED_GLASS_PANE,
        GuizhanCraft.getLocalization().getString("gui.backpack_upgrader.material")
    );

    public static final ItemStack BACKPACK_INDICATOR = new CustomItemStack(
        Material.LIME_STAINED_GLASS_PANE,
        GuizhanCraft.getLocalization().getString("gui.backpack_upgrader.backpack")
    );

    public static final ItemStack BACKPACK_GOLD_INDICATOR = new CustomItemStack(
        Material.LIME_STAINED_GLASS_PANE,
        GuizhanCraft.getLocalization().getString("gui.backpack_upgrader.gold")
    );
    // endregion BackpackUpgrader
}

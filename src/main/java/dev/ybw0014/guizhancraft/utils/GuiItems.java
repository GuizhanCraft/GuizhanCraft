package dev.ybw0014.guizhancraft.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

import dev.ybw0014.guizhancraft.implementation.GuizhanCraft;

import lombok.experimental.UtilityClass;

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

}

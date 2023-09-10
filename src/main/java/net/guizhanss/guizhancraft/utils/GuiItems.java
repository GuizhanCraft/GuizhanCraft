package net.guizhanss.guizhancraft.utils;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

import net.guizhanss.guizhancraft.implementation.GuizhanCraft;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class GuiItems {

    //<editor-fold desc="General GUI items">
    public static final ItemStack CRAFT = new CustomItemStack(
        Material.CRAFTING_TABLE,
        GuizhanCraft.getLocalization().getString("gui.craft")
    );
    //</editor-fold>

    //<editor-fold desc="Electric Spawner Assembler GUI items">
    public static final ItemStack ELECTRIC_SPAWNER_ASSEMBLER_INFO = new CustomItemStack(
        Material.PAPER,
        GuizhanCraft.getLocalization().getString("gui.electric_spawner_assembler.info.name"),
        GuizhanCraft.getLocalization().getStringList("gui.electric_spawner_assembler.info.lore")
    );
    //</editor-fold>

    // Status items cache
    private static final Map<String, ItemStack> STATUS_ITEMS = new HashMap<>();

    @Nonnull
    public static ItemStack getStatus(@Nonnull String key, boolean success) {
        if (STATUS_ITEMS.containsKey(key)) {
            return STATUS_ITEMS.get(key);
        } else {
            ItemStack statusItem = new CustomItemStack(
                success ? Material.GREEN_STAINED_GLASS_PANE : Material.RED_STAINED_GLASS_PANE,
                GuizhanCraft.getLocalization().getString("gui." + key)
            );
            STATUS_ITEMS.put(key, statusItem);
            return statusItem;
        }
    }
}

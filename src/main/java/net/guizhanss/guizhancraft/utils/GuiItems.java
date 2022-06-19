package net.guizhanss.guizhancraft.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

import net.guizhanss.guizhancraft.implementation.GuizhanCraft;

import lombok.experimental.UtilityClass;

import javax.annotation.Nonnull;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public final class GuiItems {

    private static final Map<String, ItemStack> STATUS_ITEMS = new HashMap<>();

    // region General
    public static final ItemStack CRAFT = new CustomItemStack(
        Material.CRAFTING_TABLE,
        GuizhanCraft.getLocalization().getString("gui.craft")
    );
    // endregion General

    // region Electric Spawner Assembler
    public static final ItemStack ELECTRIC_SPAWNER_ASSEMBLER_INFO = new CustomItemStack(
        Material.CRAFTING_TABLE,
        GuizhanCraft.getLocalization().getString("gui.electric_spawner_assembler.info.name"),
        GuizhanCraft.getLocalization().getStringList("gui.electric_spawner_assembler.info.lore")
    );
    // endregion  Electric Spawner Assembler

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

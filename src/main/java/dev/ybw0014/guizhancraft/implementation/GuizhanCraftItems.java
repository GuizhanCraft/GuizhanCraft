package dev.ybw0014.guizhancraft.implementation;

import org.bukkit.Material;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

import dev.ybw0014.guizhancraft.core.items.LocalizedItemStack;

import lombok.experimental.UtilityClass;

/**
 * This class holds all GuizhanCraft's {@link SlimefunItemStack}
 *
 * @author ybw0014
 */
@UtilityClass
public final class GuizhanCraftItems {
    // region Materials
    public static final SlimefunItemStack ELECTRIC_SPAWNER_FRAMEWORK = new LocalizedItemStack(
        "ELECTRIC_SPAWNER_FRAMEWORK",
        Material.SPAWNER
    );
    // endregion Materials

    // region Machine
    public static final SlimefunItemStack ELECTRIC_SPAWNER_ASSEMBLER = new LocalizedItemStack(
        "ELECTRIC_SPAWNER_ASSEMBLER",
        Material.CRAFTING_TABLE
    );
    // endregion Machine

    // region Magic
    public static final SlimefunItemStack ENHANCED_ANCIENT_ALTAR = new LocalizedItemStack(
        "ENHANCED_ANCIENT_ALTAR",
        Material.ENCHANTING_TABLE
    );
    // endregion Magic
}

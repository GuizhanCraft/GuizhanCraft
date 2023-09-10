package net.guizhanss.guizhancraft.implementation;

import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;

import net.guizhanss.guizhancraft.utils.Constants;

import org.bukkit.Material;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

import net.guizhanss.guizhancraft.core.items.LocalizedItemStack;

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

    // region Generator
    public static final SlimefunItemStack CLASS_4_SINGULARITY = new LocalizedItemStack(
        "CLASS_4_SINGULARITY",
        Material.NETHERITE_BLOCK,
        "",
        GuizhanCraft.getLocalization().getLore("generator"),
        LoreBuilder.power(Constants.CLASS_4_SINGULARITY_GENERATION.getValue(),
            GuizhanCraft.getLocalization().getString("lores.per-tick"))
    );
    // endregion Generator

    // region Machine
    public static final SlimefunItemStack ELECTRIC_SPAWNER_ASSEMBLER = new LocalizedItemStack(
        "ELECTRIC_SPAWNER_ASSEMBLER",
        Material.CRAFTING_TABLE
    );
    // endregion Machine

    // region Magic
    // endregion Magic
}

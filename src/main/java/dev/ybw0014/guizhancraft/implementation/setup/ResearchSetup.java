package dev.ybw0014.guizhancraft.implementation.setup;

import dev.ybw0014.guizhancraft.utils.Keys;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;

import dev.ybw0014.guizhancraft.implementation.GuizhanCraft;

import lombok.experimental.UtilityClass;

/**
 * This class setup all {@link Research} for GuizhanCraft
 *
 * @author ybw0014
 */
@UtilityClass
public final class ResearchSetup {

    private static int researchId = 1919810;

    public static void setup() {

    }

    public static void setupElectricSpawners() {

    }

    private static void addResearch(String key, int cost, SlimefunItemStack... items) {
        new Research(
            Keys.getResearch(key),
            ++researchId,
            GuizhanCraft.getLocalization().getResearchName(key),
            cost
        ).addItems(items).register();
    }
}

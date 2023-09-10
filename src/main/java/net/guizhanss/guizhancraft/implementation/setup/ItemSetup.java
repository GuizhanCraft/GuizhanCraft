package net.guizhanss.guizhancraft.implementation.setup;

import net.guizhanss.guizhancraft.utils.Constants;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;

import net.guizhanss.guizhancraft.core.recipes.GuizhanCraftRecipeTypes;
import net.guizhanss.guizhancraft.implementation.GuizhanCraft;
import net.guizhanss.guizhancraft.implementation.GuizhanCraftItems;
import net.guizhanss.guizhancraft.implementation.items.generator.EternalGenerator;
import net.guizhanss.guizhancraft.implementation.items.machine.ElectricSpawnerAssembler;
import net.guizhanss.guizhancraft.implementation.items.material.SimpleMaterial;

import lombok.experimental.UtilityClass;

/**
 * This class setup all {@link SlimefunItem} for GuizhanCraft
 *
 * @author ybw0014
 */
@UtilityClass
public final class ItemSetup {
    public static void setup() {
        GuizhanCraft plugin = GuizhanCraft.getInstance();

        // region Generator
        new EternalGenerator(
            GuizhanCraftItemGroups.GENERATOR,
            GuizhanCraftItems.CLASS_4_SINGULARITY,
            GuizhanCraftRecipeTypes.FE_UNKNOWN,
            new ItemStack[9],
            Constants.CLASS_4_SINGULARITY_GENERATION.getValue()
        ).register(plugin);
        // endregion Generator
    }

    public static void setupElectricSpawners() {
        GuizhanCraft plugin = GuizhanCraft.getInstance();

        // region Materials
        new SimpleMaterial(
            GuizhanCraftItemGroups.MATERIAL,
            GuizhanCraftItems.ELECTRIC_SPAWNER_FRAMEWORK,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                null, SlimefunItems.PLUTONIUM, null,
                SlimefunItems.ELECTRIC_MOTOR, null, SlimefunItems.ELECTRIC_MOTOR,
                SlimefunItems.BLISTERING_INGOT_3, SlimefunItems.LARGE_CAPACITOR, SlimefunItems.BLISTERING_INGOT_3
            }
        ).register(plugin);
        // endregion Materials

        // region Machines
        new ElectricSpawnerAssembler(
            GuizhanCraftItemGroups.MACHINE,
            GuizhanCraftItems.ELECTRIC_SPAWNER_ASSEMBLER,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                null, GuizhanCraftItems.ELECTRIC_SPAWNER_FRAMEWORK, null,
                null, new ItemStack(Material.CRAFTING_TABLE), null,
                null, new ItemStack(Material.DISPENSER), null
            }
        ).register(plugin);
        // endregion Machines
    }
}

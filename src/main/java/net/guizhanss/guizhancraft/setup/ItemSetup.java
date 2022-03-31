package net.guizhanss.guizhancraft.setup;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import lombok.experimental.UtilityClass;
import net.guizhanss.guizhancraft.GuizhanCraft;
import net.guizhanss.guizhancraft.slimefun.GuizhanCraftItems;
import net.guizhanss.guizhancraft.slimefun.items.machine.BackpackUpgrader;
import net.guizhanss.guizhancraft.slimefun.items.material.SimpleMaterial;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * This class setup all {@link SlimefunItem} for GuizhanCraft
 *
 * @author ybw0014
 */
@UtilityClass
public final class ItemSetup {
    public static void setup() {
        GuizhanCraft plugin = GuizhanCraft.getInstance();

        // region Materials
        new SimpleMaterial(
            GuizhanCraftItems.BACKPACK_MATERIAL,
            RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[] {
                new ItemStack(Material.LEATHER), null, new ItemStack(Material.LEATHER),
                SlimefunItems.CLOTH, SlimefunItems.CLOTH, SlimefunItems.CLOTH,
                new ItemStack(Material.LEATHER), null, new ItemStack(Material.LEATHER)
            }
        ).register(plugin);
        // endregion Materials

        // region Machines
        new BackpackUpgrader().register(plugin);

//        new MachineBlock(
//            GuizhanCraftItemGroups.MACHINE,
//            GuizhanCraftItems.RECYCLER,
//            RecipeType.ENHANCED_CRAFTING_TABLE,
//            new ItemStack[] {
//                new ItemStack(Material.LEATHER), null, new ItemStack(Material.LEATHER),
//                SlimefunItems.CLOTH, SlimefunItems.CLOTH, SlimefunItems.CLOTH,
//                new ItemStack(Material.LEATHER), null, new ItemStack(Material.LEATHER)
//            }
//        )
//            .addRecipe(new ItemStack(Material.LEATHER, 4), GuizhanCraftItems.BACKPACK_MATERIAL)
//            .register(plugin);
        // endregion Machines

        // region Magic
//        new EnhancedAncientAltar().register(plugin);
        // endregion Magic

    }
}

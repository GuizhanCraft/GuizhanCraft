package net.guizhanss.guizhancraft.slimefun.items.material;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import net.guizhanss.guizhancraft.slimefun.GuizhanCraftItemGroups;
import org.bukkit.inventory.ItemStack;

/**
 * A simple unplaceable material
 *
 * @author ybw0014
 */
public class SimpleMaterial extends UnplaceableBlock {

    public SimpleMaterial(SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        this(GuizhanCraftItemGroups.MATERIAL, item, recipeType, recipe);
    }

    public SimpleMaterial(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }
}

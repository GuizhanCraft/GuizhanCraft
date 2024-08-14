package net.guizhanss.guizhancraft.implementation.items.generator;

import javax.annotation.Nonnull;

import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetProvider;

import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;

public class EternalGenerator extends SlimefunItem implements EnergyNetProvider {

    private final int generation;

    public EternalGenerator(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, int generation) {
        super(itemGroup, item, recipeType, recipe);
        this.generation = generation;
    }

    @Override
    public int getGeneratedOutput(@Nonnull Location location, @Nonnull Config config) {
        return generation;
    }

    @Override
    public int getCapacity() {
        return generation * 10;
    }
}

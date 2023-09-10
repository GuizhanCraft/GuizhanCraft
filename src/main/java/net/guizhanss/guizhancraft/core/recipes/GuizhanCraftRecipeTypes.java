package net.guizhanss.guizhancraft.core.recipes;

import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;

import net.guizhanss.guizhancraft.implementation.GuizhanCraft;
import net.guizhanss.guizhancraft.utils.HeadTextures;
import net.guizhanss.guizhancraft.utils.Keys;

import lombok.experimental.UtilityClass;

/**
 * This class holds all {@link RecipeType}s in {@link GuizhanCraft}
 *
 * @author ybw0014
 */
@UtilityClass
public final class GuizhanCraftRecipeTypes {
    public static final RecipeType FE_UNKNOWN = new RecipeType(
        Keys.get("fe_unknown"),
        new CustomItemStack(
            SlimefunUtils.getCustomHead(HeadTextures.RECIPE_FE_UNKNOWN),
            GuizhanCraft.getLocalization().getRecipeTypeName("fe_unknown"),
            GuizhanCraft.getLocalization().getRecipeTypeLore("fe_unknown")
        )
    );
}

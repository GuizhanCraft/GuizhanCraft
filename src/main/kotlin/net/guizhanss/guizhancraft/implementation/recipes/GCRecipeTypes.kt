package net.guizhanss.guizhancraft.implementation.recipes

import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType
import net.guizhanss.guizhancraft.GuizhanCraft
import net.guizhanss.guizhancraft.utils.constants.HeadTexture
import net.guizhanss.guizhancraft.utils.constants.gcKey

object GCRecipeTypes {

    val FE_UNKNOWN = RecipeType(
        gcKey("fe_unknown"),
        GuizhanCraft.localization.getRecipeTypeItem(
            "fe_unknown",
            HeadTexture.RECIPE_FE.materialType
        )
    )
}

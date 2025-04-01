package net.guizhanss.guizhancraft.implementation.items.generators

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetProvider
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config
import org.bukkit.Location
import org.bukkit.inventory.ItemStack

class EternalGenerator(
    itemGroup: ItemGroup,
    itemStack: SlimefunItemStack,
    recipeType: RecipeType,
    recipe: Array<out ItemStack?>,
    val generation: Int,
) : SlimefunItem(itemGroup, itemStack, recipeType, recipe), EnergyNetProvider {

    override fun getGeneratedOutput(l: Location, config: Config) = generation

    override fun getCapacity() = generation * 10
}

package net.guizhanss.guizhancraft.implementation.items.materials

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock
import net.guizhanss.guizhancraft.GuizhanCraft
import org.bukkit.inventory.ItemStack

class ElectricSpawnerFramework(
    itemGroup: ItemGroup,
    itemStack: SlimefunItemStack,
    recipeType: RecipeType,
    recipe: Array<out ItemStack?>,
) : UnplaceableBlock(itemGroup, itemStack, recipeType, recipe) {

    override fun register(addon: SlimefunAddon) {
        if (!GuizhanCraft.integrationService.electricSpawnersEnabled) {
            return
        }
        super.register(addon)
    }
}

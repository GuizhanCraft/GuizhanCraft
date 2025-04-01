package net.guizhanss.guizhancraft.implementation.items.machines

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset
import net.guizhanss.guizhanlib.kt.minecraft.extensions.isAir
import net.guizhanss.guizhanlib.kt.minecraft.items.edit
import net.guizhanss.guizhanlib.slimefun.machines.TickingMenuBlock
import org.bukkit.block.Block
import org.bukkit.inventory.ItemStack

class SimpleMaterialReplicator(
    itemGroup: ItemGroup,
    itemStack: SlimefunItemStack,
    recipeType: RecipeType,
    recipe: Array<out ItemStack?>,
) : TickingMenuBlock(itemGroup, itemStack, recipeType, recipe) {

    override fun setup(preset: BlockMenuPreset) {
        preset.drawBackground(ChestMenuUtils.getOutputSlotTexture(), OUTPUT_BORDER)
    }

    override fun getInputSlots() = INPUT_SLOTS

    override fun getOutputSlots() = OUTPUT_SLOTS

    override fun tick(b: Block, menu: BlockMenu) {
        val input = menu.getItemInSlot(INPUT_SLOTS[0])
        if (input.isAir()) {
            return
        }

        val output = input.edit {
            amount(input.maxStackSize)
        }

        repeat(OUTPUT_SLOTS.size) {
            menu.pushItem(output.clone(), *OUTPUT_SLOTS)
        }
    }

    companion object {

        val INPUT_SLOTS = intArrayOf(0)
        val OUTPUT_BORDER = intArrayOf(1)
        val OUTPUT_SLOTS = intArrayOf(2, 3, 4, 5, 6, 7, 8, 9)
    }
}

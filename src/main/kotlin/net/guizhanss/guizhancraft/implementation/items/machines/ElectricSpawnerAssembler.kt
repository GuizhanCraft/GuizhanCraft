package net.guizhanss.guizhancraft.implementation.items.machines

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.RepairedSpawner
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset
import net.guizhanss.guizhancraft.GuizhanCraft
import net.guizhanss.guizhancraft.implementation.items.materials.ElectricSpawnerFramework
import net.guizhanss.guizhancraft.utils.items.GuiItems
import net.guizhanss.guizhancraft.utils.toId
import net.guizhanss.guizhanlib.kt.slimefun.extensions.getSlimefunItem
import net.guizhanss.guizhanlib.kt.slimefun.extensions.isSlimefunItem
import net.guizhanss.guizhanlib.kt.slimefun.extensions.position
import net.guizhanss.guizhanlib.kt.slimefun.items.builder.asMaterialType
import net.guizhanss.guizhanlib.slimefun.machines.MenuBlock
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class ElectricSpawnerAssembler(
    itemGroup: ItemGroup,
    itemStack: SlimefunItemStack,
    recipeType: RecipeType,
    recipe: Array<out ItemStack?>,
) : MenuBlock(itemGroup, itemStack, recipeType, recipe) {

    override fun setup(preset: BlockMenuPreset) {
        preset.drawBackground(BACKGROUND)
        preset.drawBackground(ChestMenuUtils.getInputSlotTexture(), INPUT_BORDER)
        preset.drawBackground(ChestMenuUtils.getOutputSlotTexture(), OUTPUT_BORDER)

        preset.drawBackground(INFO_ITEM, intArrayOf(INFO_SLOT))
        preset.drawBackground(GuiItems.CRAFT, intArrayOf(CRAFT_SLOT))
    }

    override fun getInputSlots() = INPUT_SLOTS

    override fun getOutputSlots() = OUTPUT_SLOTS

    override fun onNewInstance(menu: BlockMenu, b: Block) {
        menu.addMenuClickHandler(CRAFT_SLOT) { p, _, _, _ ->
            craft(p, menu)
            false
        }
    }

    private fun craft(p: Player, menu: BlockMenu) {
        val framework = menu.getItemInSlot(INPUT_SLOTS[0])
        val spawner = menu.getItemInSlot(INPUT_SLOTS[1])

        GuizhanCraft.debug("crafting at ${menu.position} for player ${p.name}")
        if (!framework.isSlimefunItem<ElectricSpawnerFramework>() && !spawner.isSlimefunItem<RepairedSpawner>()) {
            GuizhanCraft.localization.sendMessage(p, "invalid-recipe")
            return
        }

        GuizhanCraft.debug("ingredients are valid SlimefunItem")

        val spawnerItem = spawner.getSlimefunItem<RepairedSpawner>()
        val type = spawnerItem.getEntityType(spawner)
        if (type.isEmpty) {
            GuizhanCraft.localization.sendMessage(p, "invalid-recipe")
            return
        }

        GuizhanCraft.debug("spawner item is valid")

        val output = getById("e${type.get().name.toId()}") ?: run {
            GuizhanCraft.localization.sendMessage(p, "invalid-recipe")
            return
        }

        if (menu.fits(output.item, *OUTPUT_SLOTS)) {
            menu.consumeItem(INPUT_SLOTS[0], 1)
            menu.consumeItem(INPUT_SLOTS[1], 1)
            menu.pushItem(output.item.clone(), OUTPUT_SLOTS[0])
        } else {
            GuizhanCraft.localization.sendMessage(p, "not-enough-space")
        }
    }

    override fun register(addon: SlimefunAddon) {
        if (!GuizhanCraft.integrationService.electricSpawnersEnabled) {
            return
        }
        super.register(addon)
    }

    companion object {

        private val BACKGROUND = intArrayOf(
            0, 4, 8,
            9, 17,
            18, 20, 26,
            27, 28, 29, 33, 34, 35,
            36, 37, 38, 42, 43, 44,
            45, 46, 47, 51, 52, 53,
        )
        private val INPUT_BORDER = intArrayOf(
            1, 2, 3, 5, 6, 7,
            10, 12, 14, 16,
            19, 20, 21, 23, 24, 25
        )
        private val INPUT_SLOTS = intArrayOf(11, 15) // framework - spawner
        private val OUTPUT_BORDER = intArrayOf(
            30, 31, 32,
            39, 41,
            48, 49, 50,
        )
        private val OUTPUT_SLOTS = intArrayOf(40)
        private const val INFO_SLOT = 13
        private const val CRAFT_SLOT = 22

        private val INFO_ITEM =
            GuizhanCraft.localization.getUIItem("ELECTRIC_SPAWNER_ASSEMBLER_INFO", Material.PAPER.asMaterialType())
    }
}

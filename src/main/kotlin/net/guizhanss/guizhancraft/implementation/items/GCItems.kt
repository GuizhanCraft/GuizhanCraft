@file:Suppress("unused")

package net.guizhanss.guizhancraft.implementation.items

import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder
import net.guizhanss.guizhancraft.GuizhanCraft
import net.guizhanss.guizhancraft.implementation.groups.GCItemGroups
import net.guizhanss.guizhancraft.implementation.items.generators.EternalGenerator
import net.guizhanss.guizhancraft.implementation.items.machines.ElectricSpawnerAssembler
import net.guizhanss.guizhancraft.implementation.items.machines.SimpleMaterialReplicator
import net.guizhanss.guizhancraft.implementation.items.materials.ElectricSpawnerFramework
import net.guizhanss.guizhancraft.implementation.recipes.GCRecipeTypes
import net.guizhanss.guizhancraft.utils.items.builder.buildSlimefunItem
import net.guizhanss.guizhanlib.kt.slimefun.items.builder.ItemRegistry
import net.guizhanss.guizhanlib.kt.slimefun.items.builder.asMaterialType
import net.guizhanss.guizhanlib.kt.slimefun.items.builder.buildRecipe
import org.bukkit.Material

object GCItems : ItemRegistry(GuizhanCraft.instance, GuizhanCraft.localization.idPrefix) {

    //<editor-fold desc="Materials" collapsed="true">
    val ELECTRIC_SPAWNER_FRAMEWORK by buildSlimefunItem<ElectricSpawnerFramework> {
        material = Material.SPAWNER.asMaterialType()
        itemGroup = GCItemGroups.MATERIALS
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = buildRecipe {
            +" P "
            +"M M"
            +"BIB"
            'P' means SlimefunItems.PLUTONIUM
            'M' means SlimefunItems.ELECTRIC_MOTOR
            'B' means SlimefunItems.BLISTERING_INGOT_3
            'I' means SlimefunItems.LARGE_CAPACITOR
        }
    }
    //</editor-fold>

    //<editor-fold desc="Generators" collapsed="true">
    val CLASS_4_SINGULARITY by buildSlimefunItem<EternalGenerator>(250_000) {
        material = Material.NETHERITE_BLOCK.asMaterialType()
        itemGroup = GCItemGroups.GENERATORS
        recipeType = GCRecipeTypes.FE_UNKNOWN
        recipe = emptyArray()

        +""
        +GuizhanCraft.localization.getString("lores.generator")
        +LoreBuilder.power(
            250_000,
            GuizhanCraft.localization.getString("lores.per-tick")
        )
    }
    //</editor-fold>

    //<editor-fold desc="Machines" collapsed="true">
    val ELECTRIC_SPAWNER_ASSEMBLER by buildSlimefunItem<ElectricSpawnerAssembler> {
        material = Material.CRAFTING_TABLE.asMaterialType()
        itemGroup = GCItemGroups.MACHINES
        recipeType = RecipeType.ENHANCED_CRAFTING_TABLE
        recipe = buildRecipe {
            +" F "
            +" C "
            +" D "
            'F' means ELECTRIC_SPAWNER_FRAMEWORK
            'C' means Material.CRAFTING_TABLE
            'D' means Material.DISPENSER
        }
    }

    val DIMENSIONAL_FABRICATOR by buildSlimefunItem<SimpleMaterialReplicator> {
        material = Material.BLAST_FURNACE.asMaterialType()
        itemGroup = GCItemGroups.MACHINES
        recipeType = GCRecipeTypes.FE_UNKNOWN
        recipe = emptyArray()
    }
    //</editor-fold>
}

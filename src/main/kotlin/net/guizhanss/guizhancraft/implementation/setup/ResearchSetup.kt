package net.guizhanss.guizhancraft.implementation.setup

import io.github.thebusybiscuit.slimefun4.api.researches.Research
import net.guizhanss.guizhancraft.GuizhanCraft
import net.guizhanss.guizhancraft.implementation.items.GCItems
import net.guizhanss.guizhancraft.utils.constants.gcKey
import net.guizhanss.guizhanlib.kt.slimefun.items.toItem

object ResearchSetup {

    val ELECTRIC_SPAWNER_ASSEMBLER = Research(
        gcKey("electric_spawner_assembler"),
        1919810,
        GuizhanCraft.localization.getString("researches.electric-spawner-assembler"),
        5
    )

    init {
        if (GuizhanCraft.integrationService.electricSpawnersEnabled) {
            ELECTRIC_SPAWNER_ASSEMBLER.addItems(
                GCItems.ELECTRIC_SPAWNER_FRAMEWORK.toItem(),
                GCItems.ELECTRIC_SPAWNER_ASSEMBLER.toItem()
            )
        }
        ELECTRIC_SPAWNER_ASSEMBLER.register()
    }
}

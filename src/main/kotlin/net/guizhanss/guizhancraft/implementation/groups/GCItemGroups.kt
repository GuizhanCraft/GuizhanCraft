package net.guizhanss.guizhancraft.implementation.groups

import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup
import net.guizhanss.guizhancraft.GuizhanCraft
import net.guizhanss.guizhancraft.utils.constants.HeadTexture
import net.guizhanss.guizhancraft.utils.constants.gcKey

object GCItemGroups {

    val MAIN = NestedItemGroup(
        gcKey("main"),
        GuizhanCraft.localization.getItemGroupItem(
            "main",
            HeadTexture.GROUP_MAIN.materialType
        )
    )

    val MATERIALS = SubItemGroup(
        gcKey("materials"),
        MAIN,
        GuizhanCraft.localization.getItemGroupItem(
            "materials",
            HeadTexture.GROUP_MATERIALS.materialType
        )
    )

    val GENERATORS = SubItemGroup(
        gcKey("generators"),
        MAIN,
        GuizhanCraft.localization.getItemGroupItem(
            "generators",
            HeadTexture.GROUP_GENERATORS.materialType
        )
    )

    val MACHINES = SubItemGroup(
        gcKey("machines"),
        MAIN,
        GuizhanCraft.localization.getItemGroupItem(
            "machines",
            HeadTexture.GROUP_MACHINES.materialType
        )
    )
}

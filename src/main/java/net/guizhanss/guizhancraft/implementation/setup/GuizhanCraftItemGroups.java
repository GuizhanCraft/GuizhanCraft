package net.guizhanss.guizhancraft.implementation.setup;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;

import net.guizhanss.guizhancraft.GuizhanCraft;
import net.guizhanss.guizhancraft.utils.HeadTextures;
import net.guizhanss.guizhancraft.utils.Keys;

import lombok.experimental.UtilityClass;

/**
 * This class holds all {@link ItemGroup} for GuizhanCraft.
 *
 * @author ybw0014
 */
@UtilityClass
final class GuizhanCraftItemGroups {
    public static final NestedItemGroup MAIN = new NestedItemGroup(
        Keys.getCategory("main"),
        new CustomItemStack(
            SlimefunUtils.getCustomHead(HeadTextures.GROUP_MAIN),
            GuizhanCraft.getLocalization().getCategoryName("main")
        ),
        1
    );

    public static final SubItemGroup MATERIAL = new SubItemGroup(
        Keys.getCategory("material"),
        MAIN,
        new CustomItemStack(
            SlimefunUtils.getCustomHead(HeadTextures.GROUP_MATERIAL),
            GuizhanCraft.getLocalization().getCategoryName("material")
        )
    );

//    public static final SubItemGroup MAGIC = new SubItemGroup(
//        Keys.getCategory("magic"),
//        MAIN,
//        new CustomItemStack(
//            Utils.getHeadItem(HeadTextures.MAIN_ITEM_GROUP),
//            GuizhanCraft.getLocalizationService().getCategoryName("magic")
//        )
//    );

    public static final SubItemGroup GENERATOR = new SubItemGroup(
        Keys.getCategory("generator"),
        MAIN,
        new CustomItemStack(
            SlimefunUtils.getCustomHead(HeadTextures.GROUP_GENERATOR),
            GuizhanCraft.getLocalization().getCategoryName("generator")
        )
    );

    public static final SubItemGroup MACHINE = new SubItemGroup(
        Keys.getCategory("machine"),
        MAIN,
        new CustomItemStack(
            SlimefunUtils.getCustomHead(HeadTextures.GROUP_MACHINE),
            GuizhanCraft.getLocalization().getCategoryName("machine")
        )
    );
}

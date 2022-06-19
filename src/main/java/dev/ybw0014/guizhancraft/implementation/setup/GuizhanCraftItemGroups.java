package dev.ybw0014.guizhancraft.implementation.setup;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

import dev.ybw0014.guizhancraft.implementation.GuizhanCraft;
import dev.ybw0014.guizhancraft.utils.HeadTextures;
import dev.ybw0014.guizhancraft.utils.Keys;
import dev.ybw0014.guizhancraft.utils.Utils;

import lombok.experimental.UtilityClass;

import net.guizhanss.guizhanlib.utils.PlayerHeadUtil;

/**
 * This class holds all {@link ItemGroup} for GuizhanCraft
 *
 * @author ybw0014
 */
@UtilityClass
public final class GuizhanCraftItemGroups {
    public static final NestedItemGroup MAIN = new NestedItemGroup(
        Keys.getCategory("main"),
        new CustomItemStack(
            PlayerHeadUtil.getFromBase64(HeadTextures.MAIN_ITEM_GROUP),
            GuizhanCraft.getLocalization().getCategoryName("main")
        ),
        1
    );

    public static final SubItemGroup MATERIAL = new SubItemGroup(
        Keys.getCategory("material"),
        MAIN,
        new CustomItemStack(
            PlayerHeadUtil.getFromBase64(HeadTextures.MATERIAL_ITEM_GROUP),
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

    public static final SubItemGroup MACHINE = new SubItemGroup(
        Keys.getCategory("machine"),
        MAIN,
        new CustomItemStack(
            PlayerHeadUtil.getFromBase64(HeadTextures.MACHINE_ITEM_GROUP),
            GuizhanCraft.getLocalization().getCategoryName("machine")
        )
    );
}

package net.guizhanss.guizhancraft.items;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import lombok.experimental.UtilityClass;
import net.guizhanss.guizhancraft.utils.HeadTextures;
import net.guizhanss.guizhancraft.utils.Keys;
import net.guizhanss.guizhancraft.utils.Utils;

@UtilityClass
public class ItemGroups {
    public static ItemGroup MAIN = new ItemGroup(
        Keys.getMainItemGroup(),
        new CustomItemStack(Utils.getHeadItem(HeadTextures.MAIN_ITEM_GROUP), ""),
        1
    );
}

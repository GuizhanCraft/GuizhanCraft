package net.guizhanss.guizhancraft.utils;

import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerSkin;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang.Validate;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

@UtilityClass
public final class Utils {

    public static @Nonnull String getItemId(@Nonnull String id) {
        Validate.notNull(id, "id should not be null");
        return "GZ_" + id;
    }

    public static @Nonnull ItemStack getHeadItem(@Nonnull String hashCode) {
        Validate.notNull(hashCode, "head hashcode should not be null");
        return PlayerHead.getItemStack(PlayerSkin.fromHashCode(hashCode));
    }
}

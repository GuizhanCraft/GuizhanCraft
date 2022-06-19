package dev.ybw0014.guizhancraft.utils;

import javax.annotation.Nonnull;

import com.google.common.base.Preconditions;

import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerSkin;

import lombok.experimental.UtilityClass;

@UtilityClass
public final class Utils {

    public static @Nonnull String getItemId(@Nonnull String id) {
        Preconditions.checkArgument(id != null, "id should not be null");
        return "GZ_" + id;
    }

    public static @Nonnull ItemStack getHeadItem(@Nonnull String hashCode) {
        Preconditions.checkArgument(hashCode != null, "head hashcode should not be null");
        return PlayerHead.getItemStack(PlayerSkin.fromHashCode(hashCode));
    }
}

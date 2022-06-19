package net.guizhanss.guizhancraft.utils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.base.Preconditions;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import lombok.experimental.UtilityClass;

@SuppressWarnings("ConstantConditions")
@UtilityClass
public final class Utils {

    @Nonnull
    public static String getItemId(@Nonnull String id) {
        Preconditions.checkArgument(id != null, "id should not be null");
        return "GZ_" + id;
    }

    public static boolean checkItemStack(@Nullable ItemStack item) {
        return item != null && item.getType() != Material.AIR;
    }
}

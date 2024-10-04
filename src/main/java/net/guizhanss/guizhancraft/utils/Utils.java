package net.guizhanss.guizhancraft.utils;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.base.Preconditions;

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
        return item != null && !item.getType().isAir();
    }

    /**
     * Parse the {@link String} to int and clamp it. Default to min if the {@link String} cannot be parsed.
     *
     * @param str The {@link String} to parse.
     * @param min The minimum value.
     * @param max The maximum value.
     * @return Result
     */
    public static int parseIntAndClamp(@Nullable String str, int min, int max) {
        int result;
        try {
            result = Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            result = min;
        }
        if (result < min) result = min;
        if (result > max) result = max;
        return result;
    }
}

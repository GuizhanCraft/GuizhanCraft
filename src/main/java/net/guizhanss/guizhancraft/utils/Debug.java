package net.guizhanss.guizhancraft.utils;

import net.guizhanss.guizhancraft.GuizhanCraft;

import lombok.experimental.UtilityClass;

/**
 * This utility class is useful for debugging.
 *
 * @author ybw0014
 */
@UtilityClass
public final class Debug {
    /**
     * Debug wrapper
     */
    public static void log(String message, Object... args) {
        GuizhanCraft.debug(message, args);
    }
}

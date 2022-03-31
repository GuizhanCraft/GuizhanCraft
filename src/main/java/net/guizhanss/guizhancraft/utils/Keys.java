package net.guizhanss.guizhancraft.utils;

import lombok.experimental.UtilityClass;
import net.guizhanss.guizhancraft.GuizhanCraft;
import org.apache.commons.lang.Validate;
import org.bukkit.NamespacedKey;

import javax.annotation.Nonnull;

@UtilityClass
public final class Keys {

    @Nonnull
    public static NamespacedKey get(@Nonnull String key) {
        return GuizhanCraft.createKey(key);
    }

    @Nonnull
    public static NamespacedKey getCategory(@Nonnull String key) {
        Validate.notNull(key, "key should not be null");
        return get("ig_" + key);
    }

    @Nonnull
    public static NamespacedKey getResearch(@Nonnull String key) {
        Validate.notNull(key, "key should not be null");
        return get("research_" + key);
    }
}

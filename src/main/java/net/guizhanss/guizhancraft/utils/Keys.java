package net.guizhanss.guizhancraft.utils;

import javax.annotation.Nonnull;

import com.google.common.base.Preconditions;

import org.bukkit.NamespacedKey;

import net.guizhanss.guizhancraft.GuizhanCraft;

import lombok.experimental.UtilityClass;

@SuppressWarnings("ConstantConditions")
@UtilityClass
public final class Keys {

    @Nonnull
    public static NamespacedKey get(@Nonnull String key) {
        return GuizhanCraft.createKey(key);
    }

    @Nonnull
    public static NamespacedKey getCategory(@Nonnull String key) {
        Preconditions.checkArgument(key != null, "key should not be null");
        return get("ig_" + key);
    }

    @Nonnull
    public static NamespacedKey getResearch(@Nonnull String key) {
        Preconditions.checkArgument(key != null, "key should not be null");
        return get("research_" + key);
    }
}

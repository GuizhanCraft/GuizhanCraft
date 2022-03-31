package net.guizhanss.guizhancraft.utils;

import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerHead;
import io.github.thebusybiscuit.slimefun4.libraries.dough.skins.PlayerSkin;
import lombok.experimental.UtilityClass;
import net.guizhanss.guizhancraft.GuizhanCraft;
import net.guizhanss.guizhanlib.utils.ChatUtil;
import org.apache.commons.lang.Validate;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.util.logging.Level;

@UtilityClass
public final class Utils {

    @ParametersAreNonnullByDefault
    public static void log(Level level, String message) {
        GuizhanCraft.getInstance().getLogger().log(level, ChatUtil.color(message));
    }

    public static @Nonnull String getItemId(@Nonnull String id) {
        Validate.notNull(id, "id should not be null");
        return "GZ_" + id;
    }

    public static @Nonnull ItemStack getHeadItem(@Nonnull String hashCode) {
        Validate.notNull(hashCode, "head hashcode should not be null");
        return PlayerHead.getItemStack(PlayerSkin.fromHashCode(hashCode));
    }
}

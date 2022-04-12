package net.guizhanss.guizhancraft;

import net.guizhanss.guizhanlib.localization.Localization;
import net.guizhanss.guizhanlib.utils.ChatUtil;
import net.guizhanss.guizhanlib.utils.StringUtil;
import org.apache.commons.lang.Validate;
import org.bukkit.command.CommandSender;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;
import java.text.MessageFormat;
import java.util.Locale;

/**
 * This is an extended {@link Localization} class.
 *
 * @author ybw0014
 */
public final class GuizhanCraftLocalization extends Localization {
    public GuizhanCraftLocalization(GuizhanCraft plugin) {
        super(plugin);
    }

    public @Nonnull String getCategoryName(@Nonnull String categoryId) {
        Validate.notNull(categoryId, "Category Id cannot be null");

        return getString("categories." + StringUtil.dehumanize(categoryId).toLowerCase(Locale.ROOT));
    }

    public @Nonnull String getItemName(@Nonnull String itemId) {
        Validate.notNull(itemId, "Item Id cannot be null");

        return getString("items." + StringUtil.dehumanize(itemId).toLowerCase(Locale.ROOT) + ".name");
    }

    public @Nonnull String[] getItemLore(@Nonnull String itemId) {
        Validate.notNull(itemId, "Item Id cannot be null");

        return getStringArray("items." + StringUtil.dehumanize(itemId).toLowerCase(Locale.ROOT) + ".lore");
    }

    public @Nonnull String getResearchName(@Nonnull String researchId) {
        Validate.notNull(researchId, "Research Id cannot be null");

        return getString("searches." + StringUtil.dehumanize(researchId).toLowerCase(Locale.ROOT));
    }

    @ParametersAreNonnullByDefault
    public void send(CommandSender sender, String key, Object... args) {
        Validate.notNull(sender, "CommandSender cannot be null");
        Validate.notNull(key, "Message key cannot be null");

        ChatUtil.send(sender, MessageFormat.format(getString(key), args));
    }

    @ParametersAreNonnullByDefault
    public void sendMessage(CommandSender sender, String messageKey, Object... args) {
        send(sender, "messages." + messageKey, args);
    }
}

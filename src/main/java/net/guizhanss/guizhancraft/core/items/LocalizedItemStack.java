package net.guizhanss.guizhancraft.core.items;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Material;
import org.bukkit.inventory.meta.ItemMeta;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

import net.guizhanss.guizhancraft.core.services.LocalizationService;
import net.guizhanss.guizhancraft.GuizhanCraft;
import net.guizhanss.guizhancraft.utils.Utils;
import net.guizhanss.guizhanlib.minecraft.utils.ChatUtil;

/**
 * An extended {@link SlimefunItemStack} that integrates
 * {@link LocalizationService}.
 *
 * @author ybw0014
 */
@ParametersAreNonnullByDefault
public class LocalizedItemStack extends SlimefunItemStack {

    @ParametersAreNonnullByDefault
    public LocalizedItemStack(String id, Material material) {
        super(
            Utils.getItemId(id),
            material,
            GuizhanCraft.getLocalization().getItemName(id),
            GuizhanCraft.getLocalization().getItemLore(id)
        );
    }

    @ParametersAreNonnullByDefault
    public LocalizedItemStack(String id, Material material, String... appendLore) {
        super(
            id,
            material,
            GuizhanCraft.getLocalization().getItemName(id),
            GuizhanCraft.getLocalization().getItemLore(id)
        );

        appendLore(appendLore);
    }

    @ParametersAreNonnullByDefault
    public LocalizedItemStack(String id, String headTexture) {
        super(
            Utils.getItemId(id),
            headTexture,
            GuizhanCraft.getLocalization().getItemName(id),
            GuizhanCraft.getLocalization().getItemLore(id)
        );
    }

    @ParametersAreNonnullByDefault
    public LocalizedItemStack(String id, String texture, String... appendLore) {
        super(
            id,
            texture,
            GuizhanCraft.getLocalization().getItemName(id),
            GuizhanCraft.getLocalization().getItemLore(id)
        );

        appendLore(appendLore);
    }

    @ParametersAreNonnullByDefault
    private void appendLore(String... lores) {
        ItemMeta im = getItemMeta();
        List<String> lore;
        if (im.hasLore()) {
            lore = im.getLore();
        } else {
            lore = new ArrayList<>();
        }
        for (String line : lores) {
            lore.add(ChatUtil.color(line));
        }
        im.setLore(lore);
        setItemMeta(im);
    }
}

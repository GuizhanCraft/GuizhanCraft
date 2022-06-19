package dev.ybw0014.guizhancraft.core.items;

import org.bukkit.Material;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

import dev.ybw0014.guizhancraft.implementation.GuizhanCraft;
import dev.ybw0014.guizhancraft.utils.Utils;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * An extended {@link SlimefunItemStack} that integrates
 * {@link dev.ybw0014.guizhancraft.core.services.LocalizationService}.
 *
 * @author ybw0014
 */
@ParametersAreNonnullByDefault
public class LocalizedItemStack extends SlimefunItemStack {
    public LocalizedItemStack(String id, Material material) {
        super(
            Utils.getItemId(id),
            material,
            GuizhanCraft.getLocalization().getItemName(id),
            GuizhanCraft.getLocalization().getItemLore(id)
        );
    }

    public LocalizedItemStack(String id, String headTexture) {
        super(
            Utils.getItemId(id),
            headTexture,
            GuizhanCraft.getLocalization().getItemName(id),
            GuizhanCraft.getLocalization().getItemLore(id)
        );
    }
}

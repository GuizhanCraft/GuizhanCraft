package net.guizhanss.guizhancraft.core.items;

import net.guizhanss.guizhancraft.core.services.LocalizationService;
import org.bukkit.Material;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

import net.guizhanss.guizhancraft.implementation.GuizhanCraft;
import net.guizhanss.guizhancraft.utils.Utils;

import javax.annotation.ParametersAreNonnullByDefault;

/**
 * An extended {@link SlimefunItemStack} that integrates
 * {@link LocalizationService}.
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

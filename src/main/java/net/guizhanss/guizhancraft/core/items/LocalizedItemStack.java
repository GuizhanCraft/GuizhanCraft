package net.guizhanss.guizhancraft.core.items;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.Material;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

import net.guizhanss.guizhancraft.GuizhanCraft;
import net.guizhanss.guizhancraft.core.services.LocalizationService;
import net.guizhanss.guizhancraft.utils.Utils;
import net.guizhanss.guizhanlib.minecraft.utils.ItemUtil;

/**
 * An extended {@link SlimefunItemStack} that integrates
 * {@link LocalizationService}.
 *
 * TODO: refactor this class to a util class for 1.21
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

        ItemUtil.appendLore(this, appendLore);
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

        ItemUtil.appendLore(this, appendLore);
    }
}

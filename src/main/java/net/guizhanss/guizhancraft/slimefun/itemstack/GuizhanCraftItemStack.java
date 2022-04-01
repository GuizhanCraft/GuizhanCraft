package net.guizhanss.guizhancraft.slimefun.itemstack;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import net.guizhanss.guizhancraft.GuizhanCraft;
import net.guizhanss.guizhancraft.utils.Utils;
import org.bukkit.Material;

/**
 * An extended {@link SlimefunItemStack} that integrates localization service
 */
public class GuizhanCraftItemStack extends SlimefunItemStack {
    public GuizhanCraftItemStack(String id, Material material) {
        super(
            Utils.getItemId(id),
            material,
            GuizhanCraft.getLocalization().getItemName(id),
            GuizhanCraft.getLocalization().getItemLore(id)
        );
    }

    public GuizhanCraftItemStack(String id, String headTexture) {
        super(
            Utils.getItemId(id),
            headTexture,
            GuizhanCraft.getLocalization().getItemName(id),
            GuizhanCraft.getLocalization().getItemLore(id)
        );
    }
}

package net.guizhanss.guizhancraft.slimefun.items.machine;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.player.PlayerBackpack;
import io.github.thebusybiscuit.slimefun4.api.player.PlayerProfile;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.backpacks.RestoredBackpack;
import io.github.thebusybiscuit.slimefun4.implementation.items.backpacks.SlimefunBackpack;
import io.github.thebusybiscuit.slimefun4.implementation.items.backpacks.SoulboundBackpack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.common.CommonPatterns;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import net.guizhanss.guizhancraft.GuizhanCraft;
import net.guizhanss.guizhancraft.slimefun.GuizhanCraftItemGroups;
import net.guizhanss.guizhancraft.slimefun.GuizhanCraftItems;
import net.guizhanss.guizhancraft.utils.GuiItems;
import net.guizhanss.guizhanlib.slimefun.machines.MenuBlock;
import net.guizhanss.guizhanlib.utils.ChatUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

/**
 * This is a machine which can upgrade {@link SlimefunBackpack}.
 * This is added for a special "feature" in cargo dupe fix branch of Slimefun Chinese version,
 * which is related to the DistinctiveItem PR.
 *
 * May be removed when the branch is merged into master.
 *
 * This machines does not support cargo, as it is a temporary manual machine.
 *
 * @author ybw0014
 */
public class BackpackUpgrader extends MenuBlock {

    private static final int[] BACKGROUND = {
        0, 8, 9, 17, 18, 26, 27, 28, 29, 30, 32, 33, 34, 35, 36, 37, 38, 42, 43, 44, 45, 46, 47, 48, 50, 51, 52, 53
    };
    private static final int[] INPUT_BACKGROUND = {
        1, 3, 5, 7, 10, 12, 14, 16, 19, 20, 21, 22, 23, 24, 25
    };
    private static final int[] OUTPUT_BACKGROUND = {
        39, 40, 41, 48, 50
    };
    private static final int MATERIAL_INDICATOR = 2;
    private static final int INPUT_MATERIAL = 11;
    private static final int BACKPACK_INDICATOR = 4;
    private static final int INPUT_BACKPACK = 13;
    private static final int GOLD_INDICATOR = 6;
    private static final int INPUT_GOLD = 15;
    private static final int CRAFT_BUTTON = 31;
    private static final int OUTPUT_SLOT = 49;

    private static final Map<Integer, SlimefunItemStack> BACKPACK_MAP = new HashMap<>();
    static {
        BACKPACK_MAP.put(9, SlimefunItems.BACKPACK_MEDIUM);
        BACKPACK_MAP.put(18, SlimefunItems.BACKPACK_LARGE);
        BACKPACK_MAP.put(27, SlimefunItems.WOVEN_BACKPACK);
        BACKPACK_MAP.put(36, SlimefunItems.GILDED_BACKPACK);
        BACKPACK_MAP.put(45, SlimefunItems.RADIANT_BACKPACK);
    }

    public BackpackUpgrader() {
        super(GuizhanCraftItemGroups.MACHINE, GuizhanCraftItems.BACKPACK_UPGRADER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {
            GuizhanCraftItems.BACKPACK_MATERIAL, GuizhanCraftItems.BACKPACK_MATERIAL, GuizhanCraftItems.BACKPACK_MATERIAL,
            SlimefunItems.GOLD_20K, new ItemStack(Material.CHEST), SlimefunItems.GOLD_20K,
            SlimefunItems.GOLD_20K, GuizhanCraftItems.BACKPACK_MATERIAL, SlimefunItems.GOLD_20K
        });
    }

    @Override
    protected void setup(BlockMenuPreset blockMenuPreset) {
        blockMenuPreset.drawBackground(ChestMenuUtils.getBackground(), BACKGROUND);
        blockMenuPreset.drawBackground(ChestMenuUtils.getInputSlotTexture(), INPUT_BACKGROUND);
        blockMenuPreset.drawBackground(ChestMenuUtils.getOutputSlotTexture(), OUTPUT_BACKGROUND);

        blockMenuPreset.addItem(MATERIAL_INDICATOR, GuiItems.BACKPACK_MATERIAL_INDICATOR);
        blockMenuPreset.addItem(BACKPACK_INDICATOR, GuiItems.BACKPACK_INDICATOR);
        blockMenuPreset.addItem(GOLD_INDICATOR, GuiItems.BACKPACK_GOLD_INDICATOR);
        blockMenuPreset.addItem(CRAFT_BUTTON, GuiItems.CRAFT);

        blockMenuPreset.addMenuClickHandler(MATERIAL_INDICATOR, ChestMenuUtils.getEmptyClickHandler());
        blockMenuPreset.addMenuClickHandler(BACKPACK_INDICATOR, ChestMenuUtils.getEmptyClickHandler());
        blockMenuPreset.addMenuClickHandler(GOLD_INDICATOR, ChestMenuUtils.getEmptyClickHandler());
        blockMenuPreset.addMenuClickHandler(CRAFT_BUTTON, ChestMenuUtils.getEmptyClickHandler());
    }

    @Override
    protected int[] getInputSlots() {
        return new int[0];
    }

    @Override
    protected int[] getOutputSlots() {
        return new int[0];
    }

    @Override
    protected void onBreak(@Nonnull BlockBreakEvent e, @Nonnull BlockMenu menu) {
        super.onBreak(e, menu);
        Location location = menu.getLocation();
        menu.dropItems(location, INPUT_MATERIAL);
        menu.dropItems(location, INPUT_BACKPACK);
        menu.dropItems(location, INPUT_GOLD);
        menu.dropItems(location, OUTPUT_SLOT);
    }

    @Override
    protected void onNewInstance(@Nonnull BlockMenu blockMenu, @Nonnull Block b) {
        super.onNewInstance(blockMenu, b);
        blockMenu.addMenuClickHandler(CRAFT_BUTTON, (player, i, itemStack, clickAction) -> {
            craft(blockMenu, player);
            return false;
        });
    }

    private void craft(@Nonnull BlockMenu blockMenu, @Nonnull Player p) {
        ItemStack material = blockMenu.getItemInSlot(INPUT_MATERIAL);
        ItemStack backpackItem = blockMenu.getItemInSlot(INPUT_BACKPACK);
        ItemStack gold = blockMenu.getItemInSlot(INPUT_GOLD);

        // null check
        if (material == null || backpackItem == null || gold == null) {
            GuizhanCraft.getLocalizationService().sendMessage(p, "input_all");
            return;
        }

        // check output slot
        if (blockMenu.getItemInSlot(OUTPUT_SLOT) != null) {
            GuizhanCraft.getLocalizationService().sendMessage(p, "output_no_space");
            return;
        }

        // validate input slots
        if (!validateMaterial(material)) {
            GuizhanCraft.getLocalizationService().sendMessage(p, "backpack_upgrader.invalid_material");
            return;
        }
        if (!validateGold(gold)) {
            GuizhanCraft.getLocalizationService().sendMessage(p, "backpack_upgrader.invalid_gold");
            return;
        }
        if (!validateBackpack(backpackItem)) {
            GuizhanCraft.getLocalizationService().sendMessage(p, "backpack_upgrader.invalid_backpack");
            return;
        }

        // validate backpack
        SlimefunBackpack backpack = (SlimefunBackpack) SlimefunItem.getByItem(backpackItem);

        if (backpackItem.getAmount() > 1) {
            GuizhanCraft.getLocalizationService().sendMessage(p, "backpack_upgrader.stacked");
            return;
        }

        int size = backpack.getSize(); // input backpack size
        if (size == 54) {
            return;
        }
        Optional<String> id = retriveId(backpackItem, size); // the id
        SlimefunItemStack output = (SlimefunItemStack) BACKPACK_MAP.get(size).clone();

        ItemMeta im = output.getItemMeta();
        List<String> lore = im.getLore();

        if (id.isPresent()) {
            for (int line = 0; line < lore.size(); line++) {
                if (lore.get(line).equals(ChatUtil.color("&7ID: <ID>"))) {
                    lore.set(line, lore.get(line).replace("<ID>", id.get()));
                    im.setLore(lore);
                    output.setItemMeta(im);
                    break;
                }
            }
        } else {
            for (int line = 0; line < lore.size(); line++) {
                if (lore.get(line).equals(ChatUtil.color("&7ID: <ID>"))) {
                    int target = line;

                    PlayerProfile.get(p, profile -> {
                        int backpackId = profile.createBackpack(size + 9).getId();
                        Slimefun.getBackpackListener().setBackpackId(p, output, target, backpackId);
                    });

                    break;
                }
            }
        }

        blockMenu.consumeItem(INPUT_MATERIAL, 1);
        blockMenu.replaceExistingItem(INPUT_BACKPACK, null);
        blockMenu.consumeItem(INPUT_GOLD, 1);
        blockMenu.pushItem(output.clone(), OUTPUT_SLOT);

        GuizhanCraft.getLocalizationService().sendMessage(p, "crafted", output.getDisplayName());
    }

    private boolean validateMaterial(@Nullable ItemStack itemStack) {
        if (itemStack == null || !itemStack.hasItemMeta()) {
            return false;
        }
        return SlimefunUtils.isItemSimilar(itemStack, GuizhanCraftItems.BACKPACK_MATERIAL, false, false);
    }

    private boolean validateBackpack(@Nullable ItemStack itemStack) {
        if (itemStack == null || !itemStack.hasItemMeta()) {
            return false;
        }
        SlimefunItem sfItem = SlimefunItem.getByItem(itemStack);
        return sfItem instanceof SlimefunBackpack &&
            !(sfItem instanceof SoulboundBackpack || sfItem instanceof RestoredBackpack);
    }

    private boolean validateGold(@Nullable ItemStack itemStack) {
        if (itemStack == null || !itemStack.hasItemMeta()) {
            return false;
        }
        return SlimefunUtils.isItemSimilar(itemStack, SlimefunItems.GOLD_14K, false, false);
    }

    private Optional<String> retriveId(ItemStack backpack, int size) {
        for (String loreLine : backpack.getItemMeta().getLore()) {
            if (loreLine.startsWith(ChatUtil.color("&7ID: ")) && loreLine.contains("#")) {
                String id = loreLine.replace(ChatUtil.color("&7ID: "), "");
                String[] idSplit = CommonPatterns.HASH.split(id);

                PlayerProfile.fromUUID(UUID.fromString(idSplit[0]), profile -> {
                    Optional<PlayerBackpack> optional = profile.getBackpack(Integer.parseInt(idSplit[1]));
                    optional.ifPresent(playerBackpack -> playerBackpack.setSize(size + 9));
                });

                return Optional.of(id);
            }
        }
        return Optional.empty();
    }
}

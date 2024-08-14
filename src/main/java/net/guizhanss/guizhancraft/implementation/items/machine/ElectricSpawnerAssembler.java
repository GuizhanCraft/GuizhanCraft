package net.guizhanss.guizhancraft.implementation.items.machine;

import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNullableByDefault;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.RepairedSpawner;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;

import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

import net.guizhanss.guizhancraft.GuizhanCraft;
import net.guizhanss.guizhancraft.implementation.GuizhanCraftItems;
import net.guizhanss.guizhancraft.utils.Debug;
import net.guizhanss.guizhancraft.utils.GuiItems;
import net.guizhanss.guizhancraft.utils.Utils;
import net.guizhanss.guizhanlib.minecraft.helper.inventory.ItemStackHelper;
import net.guizhanss.guizhanlib.slimefun.machines.MenuBlock;

/**
 * This machine can assemble electric spawners with
 * electric spawner frameworks and reinforced spawners.
 * <p>
 * This is to solve electric spawners are not craftable while using texture packs.
 *
 * @author ybw0014
 */
public class ElectricSpawnerAssembler extends MenuBlock {

    // gui
    private static final int[] BACKGROUND = {0, 4, 8, 9, 17, 18, 20, 26, 27, 28, 29, 33, 34, 35, 36, 37, 38, 42, 43, 44, 45, 46, 47, 51, 52, 53};
    private static final int[] INPUT_BACKGROUND = {1, 2, 3, 5, 6, 7, 10, 12, 14, 16, 19, 20, 21, 23, 24, 25};
    private static final int[] OUTPUT_BACKGROUND = {30, 31, 32, 39, 41, 48, 49, 50};
    private static final int INPUT_FRAMEWORK_SLOT = 11;
    private static final int INPUT_SPAWNER_SLOT = 15;
    private static final int OUTPUT_SLOT = 40;
    private static final int INFO_SLOT = 13;
    private static final int CRAFT_BUTTON = 22;

    public ElectricSpawnerAssembler(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    protected void setup(BlockMenuPreset blockMenuPreset) {
        blockMenuPreset.drawBackground(ChestMenuUtils.getBackground(), BACKGROUND);
        blockMenuPreset.drawBackground(ChestMenuUtils.getInputSlotTexture(), INPUT_BACKGROUND);
        blockMenuPreset.drawBackground(ChestMenuUtils.getOutputSlotTexture(), OUTPUT_BACKGROUND);

        blockMenuPreset.addItem(INFO_SLOT, GuiItems.ELECTRIC_SPAWNER_ASSEMBLER_INFO);
        blockMenuPreset.addItem(CRAFT_BUTTON, GuiItems.CRAFT);

        blockMenuPreset.addMenuClickHandler(INFO_SLOT, ChestMenuUtils.getEmptyClickHandler());
        blockMenuPreset.addMenuClickHandler(CRAFT_BUTTON, ChestMenuUtils.getEmptyClickHandler());
    }

    @Override
    protected int[] getInputSlots() {
        return new int[] {INPUT_FRAMEWORK_SLOT, INPUT_SPAWNER_SLOT};
    }

    @Override
    protected int[] getOutputSlots() {
        return new int[] {OUTPUT_SLOT};
    }

    @Override
    protected void onBreak(@Nonnull BlockBreakEvent e, @Nonnull BlockMenu menu) {
        super.onBreak(e, menu);
        Location location = menu.getLocation();
        menu.dropItems(location, getInputSlots());
        menu.dropItems(location, getOutputSlots());
    }

    @Override
    protected void onNewInstance(@Nonnull BlockMenu blockMenu, @Nonnull Block b) {
        super.onNewInstance(blockMenu, b);
        blockMenu.addMenuClickHandler(CRAFT_BUTTON, (player, i, itemStack, clickAction) -> {
            manualCraft(blockMenu, player);
            return false;
        });
    }

    private void manualCraft(@Nonnull BlockMenu blockMenu, @Nonnull Player p) {
        if (craft(blockMenu)) {
            String itemName = ItemStackHelper.getDisplayName(blockMenu.getItemInSlot(OUTPUT_SLOT));
            GuizhanCraft.getLocalization().sendMessage(p, "crafted", itemName);
        } else {
            GuizhanCraft.getLocalization().sendMessage(p, "not-crafted");
        }
    }

    private boolean craft(@Nonnull BlockMenu blockMenu) {
        ItemStack framework = blockMenu.getItemInSlot(INPUT_FRAMEWORK_SLOT);
        ItemStack spawner = blockMenu.getItemInSlot(INPUT_SPAWNER_SLOT);
        ItemStack output = blockMenu.getItemInSlot(OUTPUT_SLOT);

        // null check
        if (!validateInput(framework, spawner)) {
            return false;
        }

        RepairedSpawner repairedSpawner = (RepairedSpawner) SlimefunItem.getByItem(spawner);
        Optional<EntityType> entityType = repairedSpawner.getEntityType(spawner);

        if (entityType.isEmpty()) {
            return false;
        }

        Debug.log("Got entity type");

        EntityType type = entityType.get();

        SlimefunItem electricSpawner = SlimefunItem.getById("ELECTRIC_SPAWNER_" + type);
        if (electricSpawner == null) {
            return false;
        }

        Debug.log("Got electric spawner");

        if (Utils.checkItemStack(output) && !SlimefunUtils.isItemSimilar(output, electricSpawner.getItem(), false, false)) {
            return false;
        }

        Debug.log("Output slot is available");

        blockMenu.consumeItem(INPUT_FRAMEWORK_SLOT, 1);
        blockMenu.consumeItem(INPUT_SPAWNER_SLOT, 1);
        blockMenu.pushItem(electricSpawner.getItem().clone(), OUTPUT_SLOT);

        return true;
    }

    @ParametersAreNullableByDefault
    private boolean validateInput(ItemStack framework, ItemStack spawner) {
        Debug.log("Start input validation!");
        // Check framework
        if (!Utils.checkItemStack(framework)) {
            return false;
        }
        if (!SlimefunUtils.isItemSimilar(framework, GuizhanCraftItems.ELECTRIC_SPAWNER_FRAMEWORK, true, false)) {
            return false;
        }

        Debug.log("Checked framework!");

        // Check spawner
        if (!Utils.checkItemStack(spawner)) {
            return false;
        }

        SlimefunItem repairedSpawner = SlimefunItem.getByItem(spawner);
        Debug.log("Is RepairedSpawner? " + (repairedSpawner instanceof RepairedSpawner));
        return repairedSpawner instanceof RepairedSpawner;
    }
}

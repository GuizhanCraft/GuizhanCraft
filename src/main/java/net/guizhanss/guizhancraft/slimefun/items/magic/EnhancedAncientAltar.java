//package net.guizhanss.guizhancraft.slimefun.items.magic;
//
//import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
//import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
//import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
//import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
//import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
//import net.guizhanss.guizhancraft.slimefun.GuizhanCraftItems;
//import net.guizhanss.guizhancraft.slimefun.GuizhanCraftItemGroups;
//import net.guizhanss.guizhancraft.utils.GuiItems;
//import org.bukkit.Location;
//import org.bukkit.block.Block;
//import org.bukkit.event.block.BlockBreakEvent;
//import org.bukkit.inventory.ItemStack;
//
//import javax.annotation.Nonnull;
//
///**
// * Enhanced Ancient Altar, a single block that accepts ancient altar recipes and craft them.
// * Craft once per click only, with animation.
// *
// * @author ybw0014
// */
//public class EnhancedAncientAltar extends TickingMenuBlock {
//
//    private static final int[] BACKGROUND = {
//        5, 6, 8, 14, 15, 17, 32, 41
//    };
//    private static final int[] INPUT_SLOTS = {
//        10, 11, 12, 19, 20, 21, 28, 29, 30
//    };
//    private static final int[] INPUT_BACKGROUND = {
//        0, 1, 2, 3, 4, 9, 13, 18, 22, 27, 31, 36, 37, 38, 39, 40
//    };
//    private static final int[] OUTPUT_BACKGROUND = {
//        24, 25, 26, 33, 35, 42, 43, 44
//    };
//    private static final int[] PREVIEW_BACKGROUND = {
//        7
//    };
//    private static final int CRAFT_BUTTON = 23;
//    private static final int PREVIEW_SLOT = 16;
//    private static final int OUTPUT_SLOT = 34;
//
//    public EnhancedAncientAltar() {
//        super(GuizhanCraftItemGroups.MAGIC, GuizhanCraftItems.ENHANCED_ANCIENT_ALTAR, RecipeType.MAGIC_WORKBENCH, new ItemStack[] {
//            SlimefunItems.ANCIENT_PEDESTAL, SlimefunItems.ANCIENT_PEDESTAL, SlimefunItems.ANCIENT_PEDESTAL,
//            SlimefunItems.ANCIENT_PEDESTAL, SlimefunItems.ANCIENT_ALTAR, SlimefunItems.ANCIENT_PEDESTAL,
//            SlimefunItems.ANCIENT_PEDESTAL, SlimefunItems.ANCIENT_PEDESTAL, SlimefunItems.ANCIENT_PEDESTAL
//        });
//    }
//
//    @Override
//    protected void setup(BlockMenuPreset blockMenuPreset) {
//        blockMenuPreset.drawBackground(ChestMenuUtils.getBackground(), BACKGROUND);
//        blockMenuPreset.drawBackground(ChestMenuUtils.getInputSlotTexture(), INPUT_BACKGROUND);
//        blockMenuPreset.drawBackground(ChestMenuUtils.getOutputSlotTexture(), OUTPUT_BACKGROUND);
//        blockMenuPreset.drawBackground(GuiItems.PREVIEW, PREVIEW_BACKGROUND);
//
//        blockMenuPreset.addItem(PREVIEW_SLOT, GuiItems.PREVIEW);
//        blockMenuPreset.addItem(CRAFT_BUTTON, GuiItems.CRAFT);
//
//        blockMenuPreset.addMenuClickHandler(PREVIEW_SLOT, ChestMenuUtils.getEmptyClickHandler());
//        blockMenuPreset.addMenuClickHandler(CRAFT_BUTTON, ChestMenuUtils.getEmptyClickHandler());
//    }
//
//    @Override
//    protected void tick(@Nonnull Block block, @Nonnull BlockMenu blockMenu) {
//
//    }
//
//    @Override
//    protected int[] getInputSlots() {
//        return new int[0];
//    }
//
//    @Override
//    protected int[] getOutputSlots() {
//        return new int[0];
//    }
//
//    @Override
//    protected void onBreak(@Nonnull BlockBreakEvent e, @Nonnull BlockMenu menu) {
//        super.onBreak(e, menu);
//        Location location = menu.getLocation();
//        menu.dropItems(location, INPUT_SLOTS);
//        menu.dropItems(location, OUTPUT_SLOT);
//    }
//
//    @Override
//    protected void onNewInstance(@Nonnull BlockMenu blockMenu, @Nonnull Block b) {
//        super.onNewInstance(blockMenu, b);
//        blockMenu.addMenuClickHandler(CRAFT_BUTTON, (player, i, itemStack, clickAction) -> {
//            // craft(blockMenu, player);
//            return false;
//        });
//    }
//}

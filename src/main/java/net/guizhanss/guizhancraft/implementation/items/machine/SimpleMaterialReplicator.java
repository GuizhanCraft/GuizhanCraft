package net.guizhanss.guizhancraft.implementation.items.machine;

import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;

import net.guizhanss.guizhancraft.utils.Utils;

import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;

import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;

import net.guizhanss.guizhanlib.slimefun.machines.TickingMenuBlock;

public class SimpleMaterialReplicator extends TickingMenuBlock {

    private static final int INPUT_SLOT = 0;
    private static final int[] OUTPUT_BORDER = {1};
    private static final int[] OUTPUT_SLOTS = {2, 3, 4, 5, 6, 7, 8};

    public SimpleMaterialReplicator(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }


    @Override
    protected void setup(BlockMenuPreset preset) {
        preset.drawBackground(ChestMenuUtils.getOutputSlotTexture(), OUTPUT_BORDER);
    }

    @Override
    protected int[] getInputSlots() {
        return new int[] {INPUT_SLOT};
    }

    @Override
    protected int[] getOutputSlots() {
        return OUTPUT_SLOTS;
    }

    @Override
    protected void tick(Block block, BlockMenu menu) {
        final ItemStack input = menu.getItemInSlot(INPUT_SLOT);
        if (!Utils.checkItemStack(input)) {
            return;
        }

        final ItemStack output = input.clone();
        output.setAmount(output.getMaxStackSize());

        for (int i = 0; i < OUTPUT_SLOTS.length; i++) {
            menu.pushItem(output.clone(), OUTPUT_SLOTS);
        }
    }
}

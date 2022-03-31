package net.guizhanss.guizhancraft.setup;

import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import lombok.experimental.UtilityClass;
import net.guizhanss.guizhancraft.GuizhanCraft;
import net.guizhanss.guizhancraft.slimefun.GuizhanCraftItems;
import net.guizhanss.guizhancraft.utils.Keys;

/**
 * This class setup all {@link Research} for GuizhanCraft
 *
 * @author ybw0014
 */
@UtilityClass
public final class ResearchSetup {
    public static void setup() {
        int researchId = 114514;

//        new Research(
//            Keys.get("enhanced_ancient_altar"),
//            ++researchId,
//            GuizhanCraft.getLocalizationService().getResearchName("enhanced_ancient_altar"),
//            15
//        )
//            .addItems(GuizhanCraftItems.ENHANCED_ANCIENT_ALTAR)
//            .register();

        new Research(
            Keys.get("backpack_upgrader"),
            ++researchId,
            GuizhanCraft.getLocalizationService().getResearchName("backpack_upgrader"),
            10
        )
            .addItems(GuizhanCraftItems.BACKPACK_MATERIAL, GuizhanCraftItems.BACKPACK_UPGRADER)
            .register();
    }
}

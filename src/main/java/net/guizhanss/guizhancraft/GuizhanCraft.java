package net.guizhanss.guizhancraft;

import net.guizhanss.guizhancraft.setup.ItemSetup;
import net.guizhanss.guizhancraft.setup.ResearchSetup;
import net.guizhanss.guizhancraft.utils.Utils;
import net.guizhanss.guizhanlib.slimefun.addon.AbstractAddon;

import java.text.MessageFormat;
import java.util.logging.Level;

public final class GuizhanCraft extends AbstractAddon {

    private GuizhanCraftLocalization localization;

    public GuizhanCraft() {
        super("ybw0014", "GuizhanCraft", "master", "auto-update");
        setupMetrics(14629);
    }

    @Override
    protected void enable() {
        Utils.log(Level.INFO, "&a==================");
        Utils.log(Level.INFO, "&a   GuizhanCraft   ");
        Utils.log(Level.INFO, "&a      ybw0014     ");
        Utils.log(Level.INFO, "&a==================");

        Utils.log(Level.INFO, "&eLoading localization service");
        String lang = getConfig().getString("lang", "zh-CN");
        localization = new GuizhanCraftLocalization(this);
        localization.addLanguage(lang);
        Utils.log(Level.INFO, MessageFormat.format("&eLoaded language {0}", lang));

        Utils.log(Level.INFO, "&eSetting up items");
        ItemSetup.setup();

        if (getConfig().getBoolean("enable-research", true)) {
            Utils.log(Level.INFO, "&eSetting up researches");
            ResearchSetup.setup();
        }
    }

    @Override
    protected void disable() {
    }

    public static GuizhanCraftLocalization getLocalization() {
        return ((GuizhanCraft) getInstance()).localization;
    }
}

package net.guizhanss.guizhancraft;

import net.guizhanss.guizhancraft.setup.CommandSetup;
import net.guizhanss.guizhancraft.setup.ItemSetup;
import net.guizhanss.guizhancraft.setup.ResearchSetup;
import net.guizhanss.guizhanlib.slimefun.addon.AbstractAddon;

import java.text.MessageFormat;

public final class GuizhanCraft extends AbstractAddon {

    private GuizhanCraftLocalization localization;

    public GuizhanCraft() {
        super("ybw0014", "GuizhanCraft", "master", "auto-update");
        setupMetrics(14629);
    }

    @Override
    protected void enable() {
        sendConsole("&a==================");
        sendConsole("&a   GuizhanCraft   ");
        sendConsole("&a      ybw0014     ");
        sendConsole("&a==================");

        sendConsole("&eLoading localization service");
        String lang = getConfig().getString("lang", "zh-CN");
        localization = new GuizhanCraftLocalization(this);
        localization.addLanguage(lang);
        sendConsole(MessageFormat.format("&eLoaded language {0}", lang));

        sendConsole("&eSetting up items");
        ItemSetup.setup();

        sendConsole("&eSetting up commands");
        CommandSetup.setup();

        if (getConfig().getBoolean("enable-research", true)) {
            sendConsole("&eSetting up researches");
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

package dev.ybw0014.guizhancraft.implementation;

import dev.ybw0014.guizhancraft.integrations.IntegrationsManager;

import org.bukkit.configuration.Configuration;

import net.guizhanss.guizhanlib.slimefun.addon.AbstractAddon;
import net.guizhanss.guizhanlib.slimefun.addon.AddonConfig;

import dev.ybw0014.guizhancraft.core.services.LocalizationService;
import dev.ybw0014.guizhancraft.implementation.setup.CommandSetup;
import dev.ybw0014.guizhancraft.implementation.setup.ItemSetup;
import dev.ybw0014.guizhancraft.implementation.setup.ResearchSetup;

import javax.annotation.Nonnull;

public final class GuizhanCraft extends AbstractAddon {

    private static final String DEFAULT_LANG = "zh-CN";

    private LocalizationService localization;
    private IntegrationsManager integrations;

    public GuizhanCraft() {
        super("ybw0014", "GuizhanCraft", "master", "auto-update", "lang");
        enableMetrics(14629);
    }

    @Override
    protected void enable() {
        sendConsole("&a==================");
        sendConsole("&a   GuizhanCraft   ");
        sendConsole("&a      ybw0014     ");
        sendConsole("&a==================");

        // Config
        AddonConfig config = getAddonConfig();
        if (config.getInt("version", 1) < 2) {
            Configuration defaultConfig = config.getDefaults();
            for (String key : defaultConfig.getKeys(true)) {
                if (!config.contains(key)) {
                    config.set(key, defaultConfig.get(key));
                }
            }
            config.set("version", 2);
            config.save();
        }

        // Localization
        String lang = config.getString("options.lang", DEFAULT_LANG);
        localization = new LocalizationService(this);
        localization.addLanguage(lang);
        if (!lang.equals(DEFAULT_LANG)) {
            localization.addLanguage(DEFAULT_LANG);
        }
        localization.sendConsole("loaded_lang", lang);

        // Items
        localization.sendConsole("loading_items");
        ItemSetup.setup();

        // Commands
        localization.sendConsole("loading_commands");
        CommandSetup.setup();

        // Researches
        if (getConfig().getBoolean("enable-researches", true)) {
            localization.sendConsole("loading_researches");
            ResearchSetup.setup();
        }

        // Integrations
        localization.sendConsole("loading_integrations");
        integrations = new IntegrationsManager(this);
    }

    @Override
    protected void disable() {
        // Nothing to do yet
    }

    @Nonnull
    private static GuizhanCraft inst() {
        return getInstance();
    }

    @Nonnull
    public static LocalizationService getLocalization() {
        return inst().localization;
    }

    @Nonnull
    public IntegrationsManager getIntegrationManager() {
        return integrations;
    }
}

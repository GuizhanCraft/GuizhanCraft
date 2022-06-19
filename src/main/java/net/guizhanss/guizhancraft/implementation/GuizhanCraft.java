package net.guizhanss.guizhancraft.implementation;

import java.util.logging.Level;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.configuration.Configuration;

import net.guizhanss.guizhancraft.core.services.LocalizationService;
import net.guizhanss.guizhancraft.implementation.setup.CommandSetup;
import net.guizhanss.guizhancraft.implementation.setup.ItemSetup;
import net.guizhanss.guizhancraft.implementation.setup.ResearchSetup;
import net.guizhanss.guizhancraft.integrations.IntegrationsManager;
import net.guizhanss.guizhanlib.slimefun.addon.AbstractAddon;
import net.guizhanss.guizhanlib.slimefun.addon.AddonConfig;

public final class GuizhanCraft extends AbstractAddon {

    private static final String DEFAULT_LANG = "zh-CN";

    private boolean isDebugEnabled = false;

    // Services
    private LocalizationService localization;

    // Managers
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

        // Debug
        if (config.getBoolean("debug")) {
            isDebugEnabled = true;
        }

        // Localization
        String lang = config.getString("options.lang", DEFAULT_LANG);
        localization = new LocalizationService(this);
        localization.addLanguage(lang);
        if (!lang.equals(DEFAULT_LANG)) {
            localization.addLanguage(DEFAULT_LANG);
        }
        localization.sendConsole("loaded_language", lang);

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
        integrations.start();
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

    @ParametersAreNonnullByDefault
    public static void debug(String message, Object... args) {
        if (inst().isDebugEnabled) {
            GuizhanCraft.log(Level.WARNING, "[DEBUG] " + message, args);
        }
    }
}

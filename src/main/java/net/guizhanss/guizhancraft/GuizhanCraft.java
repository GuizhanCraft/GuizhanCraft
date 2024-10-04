package net.guizhanss.guizhancraft;

import java.io.File;
import java.lang.reflect.Method;
import java.util.logging.Level;

import javax.annotation.Nonnull;
import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.Plugin;

import io.github.thebusybiscuit.slimefun4.libraries.dough.updater.BlobBuildUpdater;

import net.guizhanss.guizhancraft.core.services.LocalizationService;
import net.guizhanss.guizhancraft.implementation.setup.CommandSetup;
import net.guizhanss.guizhancraft.implementation.setup.ItemSetup;
import net.guizhanss.guizhancraft.implementation.setup.ResearchSetup;
import net.guizhanss.guizhancraft.integrations.IntegrationsManager;
import net.guizhanss.guizhanlib.slimefun.addon.AbstractAddon;
import net.guizhanss.guizhanlib.slimefun.addon.AddonConfig;
import net.guizhanss.guizhanlib.updater.GuizhanBuildsUpdater;

public final class GuizhanCraft extends AbstractAddon {

    private static final String DEFAULT_LANG = "en-US";
    private static final int CONFIG_VERSION = 2;

    private boolean isDebugEnabled = false;

    // Services
    private LocalizationService localization;

    // Managers
    private IntegrationsManager integrations;

    public GuizhanCraft() {
        super("ybw0014", "GuizhanCraft", "master", "auto-update");
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
    public static IntegrationsManager getIntegrationManager() {
        return inst().integrations;
    }

    @ParametersAreNonnullByDefault
    public static void debug(String message, Object... args) {
        if (inst().isDebugEnabled) {
            GuizhanCraft.log(Level.WARNING, "[DEBUG] " + message, args);
        }
    }

    @Override
    protected void enable() {
        sendConsole("&a==================");
        sendConsole("&a   GuizhanCraft   ");
        sendConsole("&a    by ybw0014    ");
        sendConsole("&a==================");

        // Config
        AddonConfig config = getAddonConfig();
        if (config.getInt("version", 1) < CONFIG_VERSION) {
            Configuration defaultConfig = config.getDefaults();
            for (String key : defaultConfig.getKeys(true)) {
                if (!config.contains(key)) {
                    config.set(key, defaultConfig.get(key));
                }
            }
            config.set("version", CONFIG_VERSION);
            config.save();
        }

        // Debug
        if (config.getBoolean("debug")) {
            isDebugEnabled = true;
        }

        // Localization
        String lang = config.getString("lang", DEFAULT_LANG);
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

    @Override
    protected void autoUpdate() {
        if (getPluginVersion().startsWith("Dev")) {
            new BlobBuildUpdater(this, getFile(), getGithubRepo()).start();
        } else if (getPluginVersion().startsWith("Build")) {
            try {
                // use updater in lib plugin

                // this little trick because maven shade plugin will change strings
                char[] pluginPackage = {
                    'n', 'e', 't', '.', 'g', 'u', 'i', 'z', 'h', 'a', 'n', 's', 's', '.',
                    'g', 'u', 'i', 'z', 'h', 'a', 'n', 'l', 'i', 'b', 'p', 'l', 'u', 'g', 'i', 'n'
                };
                Class<?> clazz = Class.forName(new String(pluginPackage) + ".updater.GuizhanUpdater");
                Method updaterStart = clazz.getDeclaredMethod("start", Plugin.class, File.class, String.class, String.class, String.class);
                updaterStart.invoke(null, this, getFile(), getGithubUser(), getGithubRepo(), getGithubBranch());
            } catch (Exception ignored) {
                // use updater in lib
                GuizhanBuildsUpdater.start(this, getFile(), getGithubUser(), getGithubRepo(), getGithubBranch());
            }
        }
    }
}

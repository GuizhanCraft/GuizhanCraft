package net.guizhanss.guizhancraft.integrations;

import java.util.function.Consumer;
import java.util.logging.Level;

import javax.annotation.ParametersAreNonnullByDefault;

import org.bukkit.plugin.Plugin;

import net.guizhanss.guizhancraft.GuizhanCraft;
import net.guizhanss.guizhancraft.implementation.setup.ItemSetup;
import net.guizhanss.guizhancraft.implementation.setup.ResearchSetup;

import lombok.Getter;

public final class IntegrationsManager {
    private final GuizhanCraft plugin;

    @Getter
    private boolean isEnabled = false;

    // Soft dependencies
    @Getter
    private boolean isElectricSpawnersEnabled = false;

    public IntegrationsManager(GuizhanCraft plugin) {
        this.plugin = plugin;
    }

    public void start() {
        if (isEnabled) {
            throw new UnsupportedOperationException("Integrations has been loaded.");
        } else {
            isEnabled = true;
        }
        onPluginStart();
        postIntegration();
    }

    private void onPluginStart() {
        load("ElectricSpawners", (plugin) -> {
            isElectricSpawnersEnabled = true;
        });
    }

    private void postIntegration() {
        if (isElectricSpawnersEnabled) {
            ItemSetup.setupElectricSpawners();
            ResearchSetup.setupElectricSpawners();
        }
    }

    @ParametersAreNonnullByDefault
    private void load(String pluginName, Consumer<Plugin> consumer) {
        Plugin integration = this.plugin.getServer().getPluginManager().getPlugin(pluginName);

        if (integration != null && integration.isEnabled()) {
            String version = integration.getDescription().getVersion();
            GuizhanCraft.getLocalization().sendConsole("loaded_integration", pluginName, version);
            try {
                // Run our callback
                consumer.accept(integration);
            } catch (Exception | LinkageError x) {
                GuizhanCraft.log(Level.WARNING, "Maybe you need to update {0} or GuizhanCraft?", pluginName);
                GuizhanCraft.log(Level.WARNING, x, "Failed to setup integration of plugin {0}", pluginName);
            }
        }
    }
}

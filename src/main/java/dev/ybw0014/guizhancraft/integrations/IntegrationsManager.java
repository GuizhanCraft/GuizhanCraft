package dev.ybw0014.guizhancraft.integrations;

import dev.ybw0014.guizhancraft.implementation.GuizhanCraft;

import dev.ybw0014.guizhancraft.implementation.setup.ItemSetup;

import dev.ybw0014.guizhancraft.implementation.setup.ResearchSetup;

import lombok.Getter;

import org.bukkit.plugin.Plugin;

import javax.annotation.ParametersAreNonnullByDefault;

import java.util.function.Consumer;
import java.util.logging.Level;

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


            try {
                // Run our callback
                consumer.accept(integration);
            } catch (Exception | LinkageError x) {
                GuizhanCraft.log(Level.WARNING, "Maybe you need to update {0} or GuizhanCraft?", pluginName);
                x.printStackTrace();
            }
        }
    }
}

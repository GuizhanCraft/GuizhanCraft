package net.guizhanss.guizhancraft;

import io.github.mooy1.infinitylib.core.AbstractAddon;
import lombok.Getter;
import net.guizhanss.guizhancraft.localization.Localization;
import net.guizhanss.guizhancraft.setup.ItemSetup;
import net.guizhanss.guizhancraft.setup.ResearchSetup;
import net.guizhanss.guizhanlib.updater.GuizhanBuildsUpdater;
import org.bstats.bukkit.Metrics;

public final class GuizhanCraft extends AbstractAddon {

    @Getter
    private Localization localization;

    public GuizhanCraft() {
        super("ybw0014", "GuizhanCraft", "master", "auto-update");
    }

    @Override
    protected void enable() {
        setupMetrics();

        localization = new Localization();

        ItemSetup.setup();
        ResearchSetup.setup();
    }

    @Override
    protected void disable() {
    }

    private void setupMetrics() {
        new Metrics(this, 14629);
    }
}

package dev.ybw0014.guizhancraft.implementation.setup;

import dev.ybw0014.guizhancraft.implementation.GuizhanCraft;
import dev.ybw0014.guizhancraft.implementation.commands.SfSpanwerCommand;
import dev.ybw0014.guizhancraft.implementation.commands.SfSpawnerCompleter;

import lombok.experimental.UtilityClass;

/**
 * This class sets up all commands
 *
 * @author ybw0014
 */
@UtilityClass
public final class CommandSetup {
    public static void setup() {
        GuizhanCraft.getPluginCommand("sfspawner").setExecutor(new SfSpanwerCommand());
        GuizhanCraft.getPluginCommand("sfspawner").setTabCompleter(new SfSpawnerCompleter());
    }
}

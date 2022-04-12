package net.guizhanss.guizhancraft.setup;

import lombok.experimental.UtilityClass;
import net.guizhanss.guizhancraft.GuizhanCraft;
import net.guizhanss.guizhancraft.commands.SfSpanwerCommand;
import net.guizhanss.guizhancraft.commands.SfSpawnerCompleter;

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

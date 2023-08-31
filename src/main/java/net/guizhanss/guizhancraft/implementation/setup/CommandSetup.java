package net.guizhanss.guizhancraft.implementation.setup;

import net.guizhanss.guizhancraft.implementation.GuizhanCraft;
import net.guizhanss.guizhancraft.implementation.commands.SfSpanwerCommand;
import net.guizhanss.guizhancraft.implementation.commands.SfSpawnerCompleter;
import net.guizhanss.guizhancraft.implementation.commands.UnloadChunkCommand;

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
        GuizhanCraft.getPluginCommand("unloadchunk").setExecutor(new UnloadChunkCommand());
    }
}

package net.guizhanss.guizhancraft.implementation.setup;

import net.guizhanss.guizhancraft.GuizhanCraft;
import net.guizhanss.guizhancraft.implementation.commands.SfSpanwerCommand;
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
        new SfSpanwerCommand(GuizhanCraft.getPluginCommand("sfspawner")).register();
        new UnloadChunkCommand(GuizhanCraft.getPluginCommand("unloadchunk")).register();
    }
}

package net.guizhanss.guizhancraft

import io.github.thebusybiscuit.slimefun4.libraries.dough.updater.BlobBuildUpdater
import net.byteflux.libby.Library
import net.guizhanss.guizhancraft.core.services.ConfigService
import net.guizhanss.guizhancraft.core.services.IntegrationService
import net.guizhanss.guizhancraft.core.services.LocalizationService
import net.guizhanss.guizhancraft.implementation.commands.SfSpawnerCommand
import net.guizhanss.guizhancraft.implementation.commands.UnloadChunkCommand
import net.guizhanss.guizhancraft.implementation.groups.GCItemGroups
import net.guizhanss.guizhancraft.implementation.items.GCItems
import net.guizhanss.guizhancraft.implementation.setup.ResearchSetup
import net.guizhanss.guizhanlib.libraries.BukkitLibraryManager
import net.guizhanss.guizhanlib.slimefun.addon.AbstractAddon
import net.guizhanss.guizhanlib.updater.GuizhanBuildsUpdater
import org.bstats.bukkit.Metrics
import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin
import java.io.File
import java.util.logging.Level

class GuizhanCraft : AbstractAddon(
    GITHUB_USER, GITHUB_REPO, GITHUB_BRANCH, AUTO_UPDATE_KEY
) {

    override fun load() {
        // check if there is central repo prop defined
        val centralRepo = System.getProperty("centralRepository") ?: "https://repo1.maven.org/maven2/"

        logger.info("Loading libraries, please wait...")
        logger.info("If you stuck here for a long time, try to specify a mirror repository:")
        logger.info("Add -DcentralRepository=<url> to the JVM arguments.")

        // download libs
        val manager = BukkitLibraryManager(this)
        manager.addRepository(centralRepo)
        manager.loadLibrary(
            Library.builder().groupId("org.jetbrains.kotlin").artifactId("kotlin-stdlib").version("2.1.20").build()
        )
        manager.loadLibrary(
            Library.builder().groupId("org.jetbrains.kotlin").artifactId("kotlin-reflect").version("2.1.20").build()
        )

        logger.info("Loaded all required libraries.")
    }

    override fun enable() {
        instance = this

        // config
        configService = ConfigService(this)
        debug("Debug mode is enabled.")

        // localization
        log(Level.INFO, "Loading language...")
        val lang = configService.lang
        localization = LocalizationService(this, file)
        localization.idPrefix = "GZ_"
        localization.addLanguage(lang)
        if (lang != DEFAULT_LANG) {
            localization.addLanguage(DEFAULT_LANG)
        }
        log(Level.INFO, "Loaded language {0}.", lang)

        // integrations
        integrationService = IntegrationService(this)

        // item groups setup
        GCItemGroups

        // item setup
        GCItems

        // researches setup
        if (configService.enableResearches) {
            ResearchSetup
        }

        // commands setup
        setupCommands()

        // Metrics setup
        setupMetrics()
    }

    override fun disable() {
        Bukkit.getScheduler().cancelTasks(this)
    }

    override fun autoUpdate() {
        if (pluginVersion.startsWith("Dev")) {
            BlobBuildUpdater(this, file, githubRepo).start()
        } else if (pluginVersion.startsWith("Build")) {
            try {
                // use updater in lib plugin
                val clazz = Class.forName("net.guizhanss.minecraft.guizhanlib.updater.GuizhanUpdater")
                val updaterStart = clazz.getDeclaredMethod(
                    "start",
                    Plugin::class.java,
                    File::class.java,
                    String::class.java,
                    String::class.java,
                    String::class.java
                )
                updaterStart.invoke(null, this, file, githubUser, githubRepo, githubBranch)
            } catch (_: Exception) {
                // use updater in lib
                GuizhanBuildsUpdater.start(this, file, githubUser, githubRepo, githubBranch)
            }
        }
    }

    private fun setupCommands() {
        SfSpawnerCommand(getPluginCommand("sfspawner")).register()
        UnloadChunkCommand(getPluginCommand("unloadchunk")).register()
    }

    private fun setupMetrics() {
        Metrics(this, 14629)
    }

    companion object {

        private const val GITHUB_USER = "ybw0014"
        private const val GITHUB_REPO = "GuizhanCraft"
        private const val GITHUB_BRANCH = "master"
        private const val AUTO_UPDATE_KEY = "auto-update"
        const val DEFAULT_LANG = "en-US"

        lateinit var instance: GuizhanCraft
            private set
        lateinit var configService: ConfigService
            private set
        lateinit var localization: LocalizationService
            private set
        lateinit var integrationService: IntegrationService
            private set

        fun scheduler() = getScheduler()

        fun log(level: Level, message: String) {
            instance.logger.log(level, message)
        }

        fun log(level: Level, ex: Throwable, message: String) {
            instance.logger.log(level, ex) { message }
        }

        fun debug(message: String) {
            if (!Companion::configService.isInitialized || !configService.debug) return
            log(Level.INFO, "[DEBUG] $message")
        }
    }
}

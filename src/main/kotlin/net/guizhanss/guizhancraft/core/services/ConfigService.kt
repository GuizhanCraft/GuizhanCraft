package net.guizhanss.guizhancraft.core.services

import net.guizhanss.guizhancraft.GuizhanCraft
import net.guizhanss.guizhanlib.slimefun.addon.AddonConfig

class ConfigService(plugin: GuizhanCraft) {

    var autoUpdate = true
        private set
    var debug = false
        private set
    var lang = "en"
        private set
    var enableResearches = true
        private set

    private val config = AddonConfig(plugin, "config.yml")

    init {
        reload()
    }

    fun reload() {
        config.reload()

        autoUpdate = config.getBoolean("auto-update", true)
        debug = config.getBoolean("debug", false)
        lang = config.getString("lang") ?: "en"
        enableResearches = config.getBoolean("enable-researches", true)

        config.save()
    }
}

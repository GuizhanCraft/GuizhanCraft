package net.guizhanss.guizhancraft.implementation.listeners

import net.guizhanss.guizhancraft.GuizhanCraft
import net.guizhanss.slimefuntranslation.api.events.TranslationsLoadEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class TranslationListener(plugin: GuizhanCraft) : Listener {

    init {
        plugin.server.pluginManager.registerEvents(this, plugin)
    }

    @EventHandler
    fun onTranslationsLoad(e: TranslationsLoadEvent) {
        GuizhanCraft.scheduler().runAsync { GuizhanCraft.integrationService.loadTranslations() }
    }
}

package net.guizhanss.guizhancraft.core.services

import net.guizhanss.guizhancraft.GuizhanCraft
import net.guizhanss.guizhancraft.utils.listYmlFilesInJar
import net.guizhanss.guizhancraft.utils.toId
import net.guizhanss.guizhanlib.kt.slimefun.items.builder.MaterialType
import net.guizhanss.guizhanlib.kt.slimefun.items.toItem
import net.guizhanss.guizhanlib.minecraft.utils.ChatUtil
import net.guizhanss.guizhanlib.slimefun.addon.SlimefunLocalization
import org.bukkit.command.CommandSender
import org.bukkit.inventory.ItemStack
import java.io.File
import java.text.MessageFormat

class LocalizationService(
    private val plugin: GuizhanCraft,
    private val jarFile: File
) : SlimefunLocalization(plugin) {

    init {
        extractTranslations()
    }

    private fun extractTranslations() {
        val translationsFolder = File(plugin.dataFolder, FOLDER_NAME)
        if (!translationsFolder.exists()) {
            translationsFolder.mkdirs()
        }
        val translationFiles = listYmlFilesInJar(jarFile, FOLDER_NAME)
        for (translationFile in translationFiles) {
            val filePath = FOLDER_NAME + File.separator + translationFile
            plugin.saveResource(filePath, true)
        }
    }

    fun getString(key: String, vararg args: Any?): String = MessageFormat.format(getString(key), *args)

    // categories
    fun getItemGroupItem(key: String, materialType: MaterialType): ItemStack =
        getItem("GROUP_${key.toId()}", materialType.convert()).toItem()

    // recipe
    fun getRecipeTypeItem(key: String, materialType: MaterialType): ItemStack =
        getItem("RECIPE_${key.toId()}", materialType.convert()).toItem()

    // ui
    fun getUIItem(key: String, materialType: MaterialType): ItemStack =
        getItem("UI_${key.toId()}", materialType.convert()).toItem()

    // items
    fun getItemName(itemId: String, vararg args: Any?) = getString("items.${itemId.toId()}.name", *args)
    fun getItemLore(itemId: String): List<String> = getStringList("items.${itemId.toId()}.lore")

    fun sendMessage(sender: CommandSender, key: String, vararg args: Any) {
        if (GuizhanCraft.integrationService.slimefunTranslationEnabled) {
            GuizhanCraft.integrationService.sendMessage(sender, key, *args)
        } else {
            ChatUtil.send(sender, MessageFormat.format(getString("messages.$key"), *args))
        }
    }

    companion object {

        const val FOLDER_NAME = "lang"
    }
}

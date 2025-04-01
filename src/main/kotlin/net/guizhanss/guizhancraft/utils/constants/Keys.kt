package net.guizhanss.guizhancraft.utils.constants

import net.guizhanss.guizhancraft.GuizhanCraft
import org.bukkit.NamespacedKey

object Keys {

    val DISPLAY_ITEM = gcKey("display_item")
}

fun gcKey(key: String) = NamespacedKey(GuizhanCraft.instance, key)

package net.guizhanss.guizhancraft.utils

import net.guizhanss.guizhanlib.common.utils.FileUtil
import java.io.File
import java.io.IOException
import java.util.jar.JarEntry

fun listYmlFilesInJar(jarFile: File, folderName: String): List<String> {
    return try {
        FileUtil.listJarEntries(
            jarFile,
            { entryName: String, entry: JarEntry ->
                entryName.startsWith("$folderName/") && !entry.isDirectory && entryName.endsWith(".yml")
            },
            { entryName: String, _: JarEntry ->
                entryName.replace("$folderName/", "")
            }
        )
    } catch (e: IOException) {
        emptyList()
    }
}

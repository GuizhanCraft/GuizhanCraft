import net.minecrell.pluginyml.bukkit.BukkitPluginDescription
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm") version "2.1.20"
    id("com.gradleup.shadow") version "8.3.5"
    id("de.eldoria.plugin-yml.bukkit") version "0.7.1"
    id("xyz.jpenilla.run-paper") version "2.3.1"
}

repositories {
    mavenLocal()
    mavenCentral()
    maven("https://s01.oss.sonatype.org/content/groups/public/")
    maven("https://repo.papermc.io/repository/maven-public/")
    maven("https://repo.alessiodp.com/releases/")
    maven("https://jitpack.io")
}

dependencies {
    compileOnly(kotlin("stdlib")) // loaded through library loader
    compileOnly(kotlin("reflect")) // loaded through library loader
    compileOnly("io.papermc.paper:paper-api:1.21.1-R0.1-SNAPSHOT")
    compileOnly("com.github.Slimefun:Slimefun4:3ea21da4fe")
    compileOnly("net.guizhanss:SlimefunTranslation:e03b01a7b7")
    implementation("org.bstats:bstats-bukkit:3.1.0")
    implementation("net.guizhanss:guizhanlib-all:2.3.0")
    implementation("net.guizhanss:guizhanlib-kt-all:0.1.0")
}

group = "net.guizhanss"
description = "GuizhanCraft"

val timestamp = System.currentTimeMillis()
val mainPackage = "net.guizhanss.guizhancraft"

version = "UNOFFICIAL-${timestamp}"

java {
    disableAutoTargetJvm()
    sourceCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        javaParameters = true
        jvmTarget = JvmTarget.JVM_17
    }
}

tasks.shadowJar {
    fun doRelocate(from: String, to: String? = null) {
        val last = to ?: from.split(".").last()
        relocate(from, "$mainPackage.libs.$last")
    }

    doRelocate("net.byteflux.libby")
    doRelocate("net.guizhanss.guizhanlib")
    doRelocate("org.bstats")
    doRelocate("io.papermc.lib", "paperlib")
    minimize()
    archiveClassifier = ""
}

bukkit {
    main = "$mainPackage.GuizhanCraft"
    apiVersion = "1.18"
    authors = listOf("ybw0014")
    description = "A Slimefun addon with some useful items for testing"
    depend = listOf("Slimefun")
    softDepend = listOf(
        "GuizhanLibPlugin",
        "SlimefunTranslation",
        "ElectricSpawners",
    )

    commands {
        register("sfspawner") {
            aliases = listOf("sfs", "slimefunspawner")
        }

        register("unloadchunk") {
            aliases = listOf("uc", "unloadforcedchunk")
        }
    }

    permissions {
        register("guizhancraft.commands.sfspawner") {
            description = "permission to run /sfspawner command"
            default = BukkitPluginDescription.Permission.Default.OP
        }
        register("guizhancraft.commands.unloadchunk") {
            description = "permission to run /unloadchunk command"
            default = BukkitPluginDescription.Permission.Default.OP
        }
    }
}

tasks.runServer {
    downloadPlugins {
        // Slimefun
        url("https://blob.build/dl/Slimefun4/Dev/latest")
        // SlimeHUD
        url("https://blob.build/dl/SlimeHUD/Dev/latest")
        // ElectricSpawners
        url("https://thebusybiscuit.github.io/builds/TheBusyBiscuit/ElectricSpawners/master/ElectricSpawners-23.jar")
    }
    jvmArgs("-Dcom.mojang.eula.agree=true")
    minecraftVersion("1.20.6")
}

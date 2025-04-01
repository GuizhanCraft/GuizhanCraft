# GuizhanCraft

[简体中文](./README.zh-CN.md)

A Slimefun addon made by ybw0014.

It provides a solution for those servers that installed Slimefun texture pack and cannot craft electric spawners.  
It also adds some new items that are useful for testers (only obtainable through cheat menu or command).

## Download

Download from:

- [Blob builds](https://blob.build/project/GuizhanCraft)
- [Guizhan Builds ![Build Status](https://builds.guizhanss.com/ybw0014/GuizhanCraft/master/badge.svg)](https://builds.guizhanss.com/ybw0014/GuizhanCraft/master)

## Supported language / 支持语言

You can change the language in `config.yml`. Supported languages:

- `en-US` English (United States)
- `zh-CN` 简体中文
- `zh-TW` 繁體中文

## Content

### Energy Generators

- Class-4 Singularity: A generator that can produce a large amount of energy. (Obtainable by cheat menu / command only)

### Machines

- Electric Spawner Assembler：You can assemble electric spawner with electric spawner framework and a reinforced
  spawner. (Only when ElectricSpawner is installed)
- Dimensional Fabricator: Infinitely replicate the specified item. (Obtainable by cheat menu / command only)

### Commands

Parameters: `<>` is required, `[]` is optional

| Command                                            | Description                                                                                | Required permission                 |
|----------------------------------------------------|--------------------------------------------------------------------------------------------|-------------------------------------|
| /sfspawner broken <player> <entityType> [amount]   | Give player a broken spawner with specified entity type.                                   | `guizhancraft.commands.sfspawner`   |
| /sfspawner repaired <player> <entityType> [amount] | Give player a reinforced spawner with specified entity type.                               | `guizhancraft.commands.sfspawner`   |
| /unloadchunk                                       | Disable the force load of the chunk you are standing on (not really unload current chunk). | `guizhancraft.commands.unloadchunk` |


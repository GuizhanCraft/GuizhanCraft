# GuizhanCraft

[English](./README.md)

由鬼斩制作的 Slimefun 附属插件。

它为安装了 Slimefun 资源包而无法制作电力刷怪笼的服务器提供了解决方案。  
它还添加了一些对测试人员有用的新物品（只能通过作弊菜单或指令获得）。

## 下载

[![构建状态](https://builds.guizhanss.com/ybw0014/GuizhanCraft/master/badge.svg)](https://builds.guizhanss.com/ybw0014/GuizhanCraft/master)

## 支持语言

你可以在 `config.yml` 中更改语言。支持的语言：

- `en-US` English (United States)
- `zh-CN` 简体中文
- `zh-TW` 繁體中文

## 内容

### 发电机

- 四级奇点：一种可以产生大量能量的发电机。（只能通过作弊菜单/指令获得）

### 机器

- 电力刷怪笼组装器：您可以使用电力刷怪笼框架和修复的刷怪笼来合成电力刷怪笼。（仅在安装电动产生器时可用）
- 维度制造机：无限复制指定物品。（只能通过作弊菜单/指令获得）

### 命令

参数：`<>` 为必填项， `[]` 为可选项

| 命令                                                 | 描述                     | 所需权限                                |
|----------------------------------------------------|------------------------|-------------------------------------|
| /sfspawner broken <player> <entityType> [amount]   | 给玩家提供指定实体类型的破损的刷怪笼。    | `guizhancraft.commands.sfspawner`   |
| /sfspawner repaired <player> <entityType> [amount] | 给玩家提供指定实体类型的修复的刷怪笼。    | `guizhancraft.commands.sfspawner`   |
| /unloadchunk                                       | 禁用当前区块的强制加载（并不会卸载该区块）。 | `guizhancraft.commands.unloadchunk` |

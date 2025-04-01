package net.guizhanss.guizhancraft.utils

import net.guizhanss.guizhanlib.common.utils.StringUtil

fun String.toId() = StringUtil.dehumanize(this)

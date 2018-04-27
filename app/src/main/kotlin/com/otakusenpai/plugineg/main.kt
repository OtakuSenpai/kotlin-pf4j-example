package com.otakusenpai.plugineg

import org.pf4j.DefaultPluginManager

fun main(args: Array<String>) {
    val p: PluginManager = PluginMaanger()
    p.loadPlugins
    p.startOrStopPlugins(true)
    p.callPlugins()
}

package com.otakusenpai.plugineg

import com.otakusenpai.plugineg.TestPluginManager

fun main(args: Array<String>) {
    val p: TestPluginManager = TestPluginManager()
    p.loadORUnloadPlugins(true)
    p.startOrStopPlugins(true)
    p.callPlugins()
}

package com.otakusenpai.plugineg.api

import org.pf4j.ExtensionPoint

interface PluginInterface : ExtensionPoint {
    fun retString(): String
}
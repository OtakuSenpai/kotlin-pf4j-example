package com.otakusenpai.plugineg

import com.otakusenpai.plugineg.api.PluginInterface
import org.pf4j.Extension

@Extension
public class WazzupHello : PluginInterface {
    override fun retString(): String {
        return "Wazzup, Hello"
    }
}
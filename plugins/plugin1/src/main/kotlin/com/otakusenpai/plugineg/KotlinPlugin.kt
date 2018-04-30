package com.otakusenpai.plugineg.plugins.KotlinHello

import org.slf4j.LoggerFactory
import org.pf4j.Extension
import org.pf4j.Plugin
import org.pf4j.PluginWrapper
import com.otakusenpai.plugineg.api.PluginInterface

class KotlinPlugin(wrapper: PluginWrapper) : Plugin(wrapper) {
    private val logger = LoggerFactory.getLogger(KotlinPlugin::class.java)

    override fun start() {
        logger.info("KotlinPlugin.start()")
        logger.info("KotlinPlugin")
    }

    override fun stop() {
        logger.info("KotlinPlugin.stop()")
    }
}

@Extension
class KotlinGreeting : PluginInterface {
    override fun retString(): String {
        return "KotlinGreetings"
    }
}
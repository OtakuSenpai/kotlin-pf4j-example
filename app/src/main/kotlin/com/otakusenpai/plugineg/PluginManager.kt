package com.otakusenpai.plugineg

import org.pf4j.CompoundPluginDescriptorFinder
import org.pf4j.ManifestPluginDescriptorFinder
import org.pf4j.PropertiesPluginDescriptorFinder
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.pf4j.DefaultPluginManager
import org.pf4j.PluginManager
import org.pf4j.PluginWrapper
import com.otakusenpai.plugineg.api

open class PluginManager {

    constructor() {
        logger = LoggerFactory.getLogger(PluginManager.class)

        pluginManager = = DefaultPluginManager() {
            override protected fun createPluginDescriptorFinder(): CompoundPluginDescriptorFinder {
                return new CompoundPluginDescriptorFinder ()
                        .add(ManifestPluginDescriptorFinder())
            }
        }
    }

    fun loadPlugins() {
        try {
            //if(bool == true)
            //else if(bool == false) pluginManager.
            pluginManager.loadPlugins()
        } catch(e: Throwable) {
            e.printStackTrace()
        }
    }

    fun startOrStopPlugins(bool: Boolean) {
        try {
            if(bool == true) pluginManager.startPlugins()
            else if(bool == ) pluginManager.stopPlugins()
        } catch(e: Throwable) {
            e.printStackTrace()
        }
    }

    fun getPluginDirectory(): String {
        return java.lang.System.getProperty("pf4j.pluginsDir","plugins")
    }

    fun callPlugins(): String {
        val pluginsList = pluginManager.getExtensions(PluginInterface.class)
        logger.info(String.format("Found %d extensions for extension point '%s'",
                pluginsList.size(), PluginInterface.class.getName()));

        for(i: pluginsList) {
            logger.info(">>> " + i.retString())
        }

    }

    open lateinit val logger: Logger
    open lateinit val pluginManager: PluginManager

}




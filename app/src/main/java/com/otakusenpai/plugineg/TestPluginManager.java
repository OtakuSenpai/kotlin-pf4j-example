package com.otakusenpai.plugineg;

import org.pf4j.CompoundPluginDescriptorFinder;
import org.pf4j.DefaultPluginManager;
import org.pf4j.ManifestPluginDescriptorFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.pf4j.CompoundPluginDescriptorFinder;
import org.pf4j.ManifestPluginDescriptorFinder;
import org.pf4j.PropertiesPluginDescriptorFinder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.pf4j.DefaultPluginManager;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import com.otakusenpai.plugineg.api.*;

import java.nio.file.Path;
import java.util.List;

public class TestPluginManager {
    private static Logger logger = null;

    PluginManager pluginManager = null;

    public TestPluginManager() {
        logger = LoggerFactory.getLogger(TestPluginManager.class);
        pluginManager = new DefaultPluginManager() {
            @Override
            protected CompoundPluginDescriptorFinder createPluginDescriptorFinder() {
                return new CompoundPluginDescriptorFinder()
                        // Demo is using the Manifest file
                        // PropertiesPluginDescriptorFinder is commented out just to avoid error log
                        //.add(new PropertiesPluginDescriptorFinder())
                        .add(new ManifestPluginDescriptorFinder());
            }
        };
    }

    public TestPluginManager(Path path) {
        logger = LoggerFactory.getLogger(TestPluginManager.class);
        pluginManager = new DefaultPluginManager(path) {
            @Override
            protected CompoundPluginDescriptorFinder createPluginDescriptorFinder() {
                return new CompoundPluginDescriptorFinder()
                        // Demo is using the Manifest file
                        // PropertiesPluginDescriptorFinder is commented out just to avoid error log
                        //.add(new PropertiesPluginDescriptorFinder())
                        .add(new ManifestPluginDescriptorFinder());
            }
        };
    }

    public void loadORUnloadPlugins(Boolean load) {
        try {
            if(load == true)
                pluginManager.loadPlugins();
            else
                pluginManager.loadPlugins();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void callPlugins() {
        List<PluginInterface> p = pluginManager.getExtensions(PluginInterface.class);
        for(PluginInterface plugin : p) {
            logger.info(">>> " + plugin.retString());
        }
    }

    public void startOrStopPlugins(Boolean start) {
        try {
            if(start == true)
                pluginManager.startPlugins();
            else if(start == false)
                pluginManager.stopPlugins();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

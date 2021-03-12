/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.commandprices.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    protected static FileConfiguration config;
    protected static File configFile = new File("plugins/CommandPrices/config.yml");

    public static void reloadConfig(Boolean save){
        if(!configFile.exists()){
            if(!configFile.getParentFile().isDirectory()){
                configFile.getParentFile().mkdirs();
            }
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(save){
            try {
                config.save(configFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public static FileConfiguration getConfig(){
        return null;
    }
}

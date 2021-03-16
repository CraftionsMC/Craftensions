/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.activationkeys.util;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Config {

    public static String system_prefix = "[§eActivation§cKeys§r] ";

    public static String mysql_host = "localhost";
    public static String mysql_port = "3306";
    public static String mysql_username = "minecraft";
    public static String mysql_password = "minecraft";
    public static String mysql_database = "activationkeys";

    public static File configFile = new File("plugins/ActivationKeys/config.yml");
    public static FileConfiguration config = null;

    private static String defaultConfigURL = "https://cdn.craftions.net/extensions/activationkeys/defaults/config.yml";

    public static void doDefaults(){
        if(!configFile.exists()){
            if(!configFile.getParentFile().exists()){
                configFile.getParentFile().mkdirs();
            }
            NetUtils.download(defaultConfigURL, null);
        }
    }

    public static void applyValues(){
        config = YamlConfiguration.loadConfiguration(configFile);
        system_prefix = config.getString("system.prefix");
        mysql_host = config.getString("mysql.host");
        mysql_port = config.getString("mysql.port");
        mysql_username = config.getString("mysql.username");
        mysql_password = config.getString("mysql.password");
        mysql_database = config.getString("mysql.database");
    }

    public static void saveValues(){
        try {
            config.save(configFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

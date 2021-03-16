package net.craftions.activationkeys;

import net.craftions.activationkeys.util.Config;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class ActivationKeys extends JavaPlugin {

    public static final Logger logger = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        // Plugin startup logic
        Config.doDefaults();
        Config.applyValues();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static void log(String msg, String level){
        switch (level){
            case "i":
                logger.info(Config.system_prefix + msg);
            case "w":
                logger.warning(Config.system_prefix + msg);
            case "e":
                logger.severe(Config.system_prefix + msg);
            default:
                logger.info(Config.system_prefix + msg);
        }
    }
}

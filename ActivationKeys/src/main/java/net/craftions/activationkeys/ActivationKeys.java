package net.craftions.activationkeys;

import net.craftions.activationkeys.util.Config;
import net.craftions.activationkeys.util.MySQL;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class ActivationKeys extends JavaPlugin {

    public static final Logger logger = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        getCommand("key").setExecutor(new CommandKey());
        getCommand("keycreate").setExecutor(new CommandKeyCreate());
        Config.doDefaults();
        Config.applyValues();
        // Init database
        // new MySQL("CRATE ").executeUpdate();
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

package net.craftions.craftensions;

import net.craftions.craftensions.commands.CommandExtension;
import net.craftions.craftensions.tabcompleter.CommandExtensionTabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class Craftensions extends JavaPlugin {

    @Override
    public void onEnable() {
        // Init bStats
        Metrics metrics = new Metrics(this, 10647);

        getCommand("extension").setExecutor(new CommandExtension());
        getCommand("extension").setTabCompleter(new CommandExtensionTabCompleter());
        if(!new File("plugins/Craftensions").isDirectory()){
            new File("plugins/Craftensions").mkdirs();
        }
        File exConfig = new File("plugins/Craftensions/extensions.yml");
        if(!exConfig.exists()){
            try {
                exConfig.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDisable() {

    }
}

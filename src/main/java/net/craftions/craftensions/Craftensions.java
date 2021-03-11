package net.craftions.craftensions;

import net.craftions.craftensions.commands.CommandExtension;
import net.craftions.craftensions.tabcompleter.CommandExtensionTabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Craftensions extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("extension").setExecutor(new CommandExtension());
        getCommand("extension").setTabCompleter(new CommandExtensionTabCompleter());
    }

    @Override
    public void onDisable() {

    }
}

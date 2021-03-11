package net.craftions.craftensions;

import net.craftions.craftensions.commands.CommandExtension;
import org.bukkit.plugin.java.JavaPlugin;

public final class Craftensions extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("extension").setExecutor(new CommandExtension());
    }

    @Override
    public void onDisable() {

    }
}

package net.craftions.fancycommands;

import net.craftions.fancycommands.commands.CommandGameMode;
import net.craftions.fancycommands.commands.CommandHeal;
import org.bukkit.plugin.java.JavaPlugin;

public final class FancyCommands extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("gamemode").setExecutor(new CommandGameMode());
        getCommand("heal").setExecutor(new CommandHeal());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

package net.craftions.fancycommands;

import net.craftions.fancycommands.commands.CommandClear;
import net.craftions.fancycommands.commands.CommandGameMode;
import net.craftions.fancycommands.commands.CommandHeal;
import net.craftions.fancycommands.commands.CommandRepair;
import org.bukkit.plugin.java.JavaPlugin;

public final class FancyCommands extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("gamemode").setExecutor(new CommandGameMode());
        getCommand("heal").setExecutor(new CommandHeal());
        getCommand("Repair").setExecutor(new CommandRepair());
        getCommand("Clear").setExecutor(new CommandClear());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

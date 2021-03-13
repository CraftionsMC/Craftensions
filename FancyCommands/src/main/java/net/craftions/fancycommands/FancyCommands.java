package net.craftions.fancycommands;

import net.craftions.fancycommands.commands.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class FancyCommands extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("gamemode").setExecutor(new CommandGameMode());
        getCommand("heal").setExecutor(new CommandHeal());
        getCommand("repair").setExecutor(new CommandRepair());
        getCommand("clear").setExecutor(new CommandClear());
        getCommand("killall").setExecutor(new CommandKillAll());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

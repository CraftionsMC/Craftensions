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
        getCommand("gmc").setExecutor(new CommandGameMode());
        getCommand("gms").setExecutor(new CommandGameMode());
        getCommand("gmsp").setExecutor(new CommandGameMode());
        getCommand("gma").setExecutor(new CommandGameMode());
        getCommand("heal").setExecutor(new CommandHeal());
        getCommand("repair").setExecutor(new CommandRepair());
        getCommand("clear").setExecutor(new CommandClear());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

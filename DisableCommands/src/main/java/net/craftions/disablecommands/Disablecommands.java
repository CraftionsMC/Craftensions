package net.craftions.disablecommands;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public final class Disablecommands extends JavaPlugin implements Listener {

    public FileConfiguration config = null;

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);
        File cfgFile = new File("plugins/DisableCommands/commands.yml");
        if(!cfgFile.exists()){
            if(!cfgFile.getParentFile().isDirectory()){ cfgFile.getParentFile().mkdirs(); }
            try {
                cfgFile.createNewFile();
                FileWriter w = new FileWriter(cfgFile); w.write("commands:\n"); w.write("  - adisabledcommand"); w.close();
            } catch (IOException e) { e.printStackTrace(); }
        }
        reloadConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void reloadConfig(Boolean save){
        if(save){ try { config.save(new File("plugins/DisableCommands/commands.yml")); } catch (IOException e) { e.printStackTrace(); } } config = YamlConfiguration.loadConfiguration(new File("plugins/DisableCommands/commands.yml"));
    }

    @EventHandler
    public void onExecute(PlayerCommandPreprocessEvent e){
        if(!e.getPlayer().hasPermission("disabledcommands.bypass")){
            if(e.getMessage().contains(":")){
                e.getPlayer().sendMessage("§cYou cant use commands with :");
                e.setCancelled(true);
                return;
            }
            String[] _split = e.getMessage().split(" ");
            String cmd = _split[0].split("/")[1];
            if(config.getStringList("commands").contains(cmd)){
                e.getPlayer().sendMessage("§cThis command is disabled.");
                e.setCancelled(true);
                return;
            }
        }
    }
}

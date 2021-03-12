package net.craftions.commandprices;

import net.craftions.commandprices.config.Config;
import net.craftions.commandprices.events.EventPlayerChat;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class CommandPrices extends JavaPlugin {

    public static Economy econ = null;

    @Override
    public void onEnable() {
        if(!setupEconomy()){
            System.out.println("§cVault not found!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        Bukkit.getPluginManager().registerEvents(new EventPlayerChat(), this);
        Config.reloadConfig(false);
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
}

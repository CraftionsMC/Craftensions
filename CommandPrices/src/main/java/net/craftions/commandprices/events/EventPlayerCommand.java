/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.commandprices.events;

import net.craftions.commandprices.CommandPrices;
import net.craftions.commandprices.config.Config;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class EventPlayerCommand implements Listener {

    @EventHandler
    public void onExecute(PlayerCommandPreprocessEvent e){
        if(e.getMessage().contains(":") && !e.getPlayer().hasPermission("commandprices.bypass")){
            String[] _split = e.getMessage().split(" ");
            String cmd = _split[0].split("/")[1];
            if(Config.getConfig().contains(cmd)){
                int cost = Config.getConfig().getInt(cmd);
                if(CommandPrices.econ.getBalance(e.getPlayer()) >= cost){
                    CommandPrices.econ.withdrawPlayer(e.getPlayer(), cost);
                    e.getPlayer().sendMessage("§b"+ cost + " §awere taken from your balance.");
                }else {
                    e.getPlayer().sendMessage("§cYou do not have enough money! You need §b" + cost);
                    e.setCancelled(true);
                }
            }
        }
    }
}

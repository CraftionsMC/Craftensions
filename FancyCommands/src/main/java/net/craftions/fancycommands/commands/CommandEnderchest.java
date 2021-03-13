/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.fancycommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandEnderchest implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(args.length == 0){
                ((Player) sender).openInventory(((Player) sender).getEnderChest());
            }else {
                Player p = Bukkit.getPlayer(args[0]);
                if(p.isOnline()){
                    ((Player) sender).openInventory(p.getEnderChest());
                }else {
                    sender.sendMessage("§cThe entered player is not online.");
                }
            }
        }else {
            sender.sendMessage("§cYou need to be a player.");
        }
        return true;
    }
}

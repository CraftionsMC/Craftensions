/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.fancycommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHeal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(args.length == 0){
                ((Player) sender).setHealth(20.0d);
                ((Player) sender).setFoodLevel(20);
                ((Player) sender).setFireTicks(0);
                sender.sendMessage("§bYou got healed.");
            }else {
                if(Bukkit.getPlayer(args[0]).isOnline()){
                    Player p0 = Bukkit.getPlayer(args[0]);
                    p0.setHealth(20.0d);
                    p0.setFoodLevel(20);
                    p0.setFireTicks(0);
                    p0.sendMessage("§bYou got healed by §e" + sender.getName());
                    sender.sendMessage("§bThe player got healed.");
                }else {
                    sender.sendMessage("§cThe entered player is not online!");
                }
            }
        }else {
            sender.sendMessage("§cYou need to be a player.");
        }
        return true;
    }
}

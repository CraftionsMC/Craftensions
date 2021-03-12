/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.fancycommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHeal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            ((Player) sender).setHealth(20.0d);
            ((Player) sender).setFoodLevel(20);
            ((Player) sender).setFireTicks(0);
            sender.sendMessage("§bYou got healed.");
        }else {
            sender.sendMessage("§cYou need to be a player.");
        }
        return true;
    }
}

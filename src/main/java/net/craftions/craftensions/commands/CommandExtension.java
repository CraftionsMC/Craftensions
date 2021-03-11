/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.craftensions.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandExtension implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0){
            sender.sendMessage("§cPlease use §b" + command.getUsage());
        }else {
            if(args.length == 1){

            }
        }
        return true;
    }
}

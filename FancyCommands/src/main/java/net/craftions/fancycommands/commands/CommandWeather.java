/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.fancycommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandWeather implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length >= 1){
            if(command.getName().equals("weather")){
                World world = Bukkit.getWorld("world");
                if(args.length != 1){
                    world = Bukkit.getWorld(args[1]);
                }
                if(args[0].startsWith("s")){
                    world.setStorm(false);
                    sender.sendMessage("§bThe weather has been set to §esun");
                }else if(args[0].startsWith("r")){
                    world.setStorm(true);
                    sender.sendMessage("§bThe weather has been set to §erain");
                }else {
                    sender.sendMessage("§cPlease use §b" + command.getUsage());
                }
            }else if(command.getName().equals("sun")){
                World world = Bukkit.getWorld("world");
                if(args.length != 1){
                    world = Bukkit.getWorld(args[1]);
                }
                world.setStorm(false);
            }else if(command.getName().equals("rain")){
                World world = Bukkit.getWorld("world");
                if(args.length != 1){
                    world = Bukkit.getWorld(args[1]);
                }
                world.setStorm(true);
            }
        }else {
            sender.sendMessage("§cPlease use §b" + command.getUsage());
        }
        return true;
    }
}

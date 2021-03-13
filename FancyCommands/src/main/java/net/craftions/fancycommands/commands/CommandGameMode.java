/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.fancycommands.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGameMode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(command.getName().equals("gamemode") || command.getName().equals("gm")){
                if(args.length == 1){
                    if(args[0].equals("0") || args[0].startsWith("su")) {
                        ((Player) sender).setGameMode(GameMode.SURVIVAL);
                        sender.sendMessage("§bYour gamemode has been updated to §esurvival");
                    }else if(args[0].equals("1") || args[0].startsWith("c")) {
                        ((Player) sender).setGameMode(GameMode.CREATIVE);
                        sender.sendMessage("§bYour gamemode has been updated to §ecreative");
                    }else if(args[0].equals("2") || args[0].startsWith("a")) {
                        ((Player) sender).setGameMode(GameMode.ADVENTURE);
                        sender.sendMessage("§bYour gamemode has been updated to §eadventure");

                    }else if (args[0].equals("3") || args[0].startsWith("sp")) {
                        ((Player) sender).setGameMode(GameMode.SPECTATOR);
                        sender.sendMessage("§bYour gamemode has been updated to §espectator");
                    }else {
                        sender.sendMessage("§cPlease use §b/gamemode <0|1|2|3|survival|creative|adventure|spectator>");
                    }
                }else {
                    sender.sendMessage("§cPlease use §b/gamemode <0|1|2|3|survival|creative|adventure|spectator>");
                }
            }else {
                if(command.getName().equals("gmc")){
                    ((Player) sender).setGameMode(GameMode.CREATIVE);
                    sender.sendMessage("§bYour gamemode has been updated to §ecreative");
                }else if(command.getName().equals("gms")){
                    ((Player) sender).setGameMode(GameMode.SURVIVAL);
                    sender.sendMessage("§bYour gamemode has been updated to §esurvival");
                }else if(command.getName().equals("gma")){
                    ((Player) sender).setGameMode(GameMode.ADVENTURE);
                    sender.sendMessage("§bYour gamemode has been updated to §eadventure");
                }else if(command.getName().equals("gmsp")){
                    ((Player) sender).setGameMode(GameMode.SPECTATOR);
                    sender.sendMessage("§bYour gamemode has been updated to §espectator");
                }
            }
        }else {
            sender.sendMessage("§cYou need to be a player.");
        }
        return true;
    }
}

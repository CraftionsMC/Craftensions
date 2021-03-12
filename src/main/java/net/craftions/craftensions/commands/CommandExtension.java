/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.craftensions.commands;

import net.craftions.craftensions.api.NetUtils;
import net.craftions.craftensions.extensions.Extension;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitTask;

import java.io.File;

public class CommandExtension implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0){
            sender.sendMessage(getWrongUsageResponse(command));
        }else {
            if(args.length == 1){
                if(args[0].equals("list")){
                    sender.sendMessage("§bInstalled Extensions:");
                    for(Extension ex : Extension.installedExtensions){
                        sender.sendMessage("- " + ex.getName());
                    }
                }else {
                    sender.sendMessage(getWrongUsageResponse(command));
                }
            }else if(args.length == 2){
                if(args[0].equals("install")){
                    String extension = args[1];
                    if(NetUtils.urlExists("https://cdn.craftions.net/extensions/" + extension + "/latest/" + extension + "-latest.jar")){
                        sender.sendMessage("§aDownloading Extension....");
                        NetUtils.download("https://cdn.craftions.net/extensions/" + extension + "/latest/" + extension + "-latest.jar", new File("plugins/" + extension + "-latest.jar"));
                        sender.sendMessage("§aDownloaded! To use this extension you need to reload the server!");
                    }else {
                        sender.sendMessage("§cThis extension does not exists.");
                    }
                }else if(args[0].equals("remove")){
                    String extension = args[1];
                    File exFile = new File("plugins/" + extension + "-latest.jar");
                    if(exFile.exists()){

                    }else {
                        sender.sendMessage("§cThis extension is not installed.");
                    }
                }else {
                    sender.sendMessage(getWrongUsageResponse(command));
                }
            }
        }
        return true;
    }

    public static String getWrongUsageResponse(Command command){
        return "§cPlease use §b" + command.getUsage();
    }

}

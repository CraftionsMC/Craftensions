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
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;

import java.io.File;
import java.net.URLClassLoader;

public class CommandExtension implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0){
            sender.sendMessage(getWrongUsageResponse(command));
        }else {
            if(args.length == 1){
                sender.sendMessage(getWrongUsageResponse(command));
            }else if(args.length == 2){
                if(args[0].equals("install")){
                    String extension = args[1];
                    installExtension(extension, sender, true);
                }else if(args[0].equals("remove")){
                    String extension = args[1];
                    File exFile = new File("plugins/" + extension + "-latest.jar");
                    if(exFile.exists()){
                        try {
                            Plugin plugin = Bukkit.getPluginManager().getPlugin(extension);
                            ClassLoader loader = plugin.getClass().getClassLoader();
                            if(loader instanceof URLClassLoader){
                                ((URLClassLoader) loader).close();
                                exFile.delete();
                                sender.sendMessage("§aSuccessfully removed extension §b" + extension + ".§a Reloading the server...");
                                Bukkit.reload();
                            }
                            System.gc();
                        }catch (Exception ex){
                            sender.sendMessage("§cAn error occurred. See the console log for details.");
                            ex.printStackTrace();
                        }
                    }else {
                        sender.sendMessage("§cThis extension is not installed.");
                    }
                }else if(args[0].equals("reinstall")) {
                    String extension = args[1];
                    File exFile = new File(extension);
                    if(exFile.exists()){
                        // remove plugin
                        try {
                            Plugin plugin = Bukkit.getPluginManager().getPlugin(extension);
                            Bukkit.getPluginManager().disablePlugin(plugin);
                        }catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }
                    installExtension(extension, sender, false);
                    sender.sendMessage("§aFinished. Reloading...");
                    Bukkit.reload();
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

    public static void installExtension(String extension, CommandSender sender, Boolean load){
        if(NetUtils.urlExists("https://cdn.craftions.net/extensions/" + extension + "/latest/" + extension + "-latest.jar")){
            sender.sendMessage("§aDownloading Extension....");
            NetUtils.download("https://cdn.craftions.net/extensions/" + extension + "/latest/" + extension + "-latest.jar", new File("plugins/" + extension + "-latest.jar"));
            sender.sendMessage("§aDownloaded.");
            if(load){
                sender.sendMessage("§aEnabling Extension...");
                try {
                    Plugin p = Bukkit.getPluginManager().loadPlugin(new File("plugins/" + extension + "-latest.jar"));
                    Bukkit.getPluginManager().enablePlugin(p);
                    sender.sendMessage("§aSuccessfully enabled §b" + extension);
                } catch (InvalidPluginException e) {
                    sender.sendMessage("§cAn error occurred. See the console log for details.");
                    e.printStackTrace();
                } catch (InvalidDescriptionException e) {
                    sender.sendMessage("§cAn error occurred. See the console log for details.");
                    e.printStackTrace();
                }
            }
        }else {
            sender.sendMessage("§cThis extension does not exists.");
        }
    }

}

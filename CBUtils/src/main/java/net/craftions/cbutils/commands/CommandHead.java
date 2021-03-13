package net.craftions.cbutils.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHead implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            if (args.length == 1) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "minecraft:give " + sender.getName() + " minecraft:player_head{SkullOwner:" + args[0] + "}");
            }else{

                sender.sendMessage("§c Please use /head <playername>.");
            }
            }else{
            sender.sendMessage("§cYou need to be a player.");
        }
        return false;
    }
}

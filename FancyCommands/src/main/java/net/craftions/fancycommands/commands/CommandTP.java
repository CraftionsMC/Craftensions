package net.craftions.fancycommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTP implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            Player p0 = (Player) sender;
            if(args.length == 1){
                Player p1 = Bukkit.getPlayer(args[0]);
                if(!p1.isOnline()){
                    sender.sendMessage("§cThe player is not online.");
                    return true;
                }else {
                    p0.teleport(p1.getLocation());
                    sender.sendMessage("§bYou were teleported.");
                }
            }else if(args.length == 2){

            }else {
                sender.sendMessage("§cPlease use §b/tp <player> [player]");
            }
        }else {
            if(args.length == 2){
                Player p0 = Bukkit.getPlayer(args[0]);
                Player p1 = Bukkit.getPlayer(args[1]);
                if(!p0.isOnline() || !p1.isOnline()){
                    sender.sendMessage("§cAt least one of the players is not online.");
                    return true;
                }else {
                    p0.teleport(p1.getLocation());
                    sender.sendMessage("§bThe player has been teleported.");
                }
            }else {
                sender.sendMessage("§cPlease use §b/tp <player> <player>");
            }
        }
        return true;
    }
}

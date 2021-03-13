package net.craftions.fancycommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class CommandTPA implements CommandExecutor {

    public static HashMap<Player, Player> tpas = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(sender instanceof Player){
            if(command.getName().equals("tpa")){
                if(args.length == 1){
                    Player p0 = (Player) sender;
                    Player p1 = Bukkit.getPlayer(args[0]);
                    tpas.put(p1, p0);
                    p0.sendMessage("§bRequest was sent.");
                    p1.sendMessage("§e" + p0.getName() + "§b sent a tpa request to you. Use §e/tpaccept §bto acccept.");
                }else {
                    sender.sendMessage("§cPlease use §b/tpa <player>");
                }
            }else if(command.getName().equals("tpaccept")){
                Player p0 = (Player) sender;
                if(tpas.containsKey(p0)){
                    p0.teleport(tpas.get(p0));
                    p0.sendMessage("§bYou have been teleported.");
                    tpas.remove(p0);
                }else {
                    sender.sendMessage("§cYou dont have an open request.");
                }
            }
        }
        return true;
    }
}

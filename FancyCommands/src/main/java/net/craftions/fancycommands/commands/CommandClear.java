package net.craftions.fancycommands.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandClear implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length != 0) {
            if (sender instanceof Player) {
                ((Player) sender).getInventory().clear();
                sender.sendMessage("$bYour Inventory was successful cleared.");
            } else {
                sender.sendMessage("§cYou need to be a player.");
            }
            return true;
        } else {
            if (sender instanceof Player) {
                Bukkit.getPlayer(args[0]).getInventory().clear();
                sender.sendMessage("§b The Player §e" + args[0] + "§b was successful cleared.");
            }
        }

        return true;
    }
}
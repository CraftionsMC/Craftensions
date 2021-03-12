package net.craftions.fancycommands.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandClear implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player){
            ((Player) sender).getInventory().clear();
            sender.sendMessage("$bYour Inventory was successful cleared.");
        }else{
            sender.sendMessage("§cYou need to be a player.");
        }
        return false;
    }

}

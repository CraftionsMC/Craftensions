package net.craftions.fancycommands.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Repairable;

public class CommandRepair implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        ItemStack Item = ((Player) sender).getItemInHand();
        if (args.length == 0) {
            if (Item.getType() != Material.AIR || Item.getDurability() != (short) 0) {
                if (sender instanceof Player) {
                    ((Player) sender).getItemInHand().setDurability(((Player) sender).getItemInHand().getType().getMaxDurability());
                    sender.sendMessage("§bYour " + ((Player) sender).getItemInHand().getType() + "§b got repaired.");
                } else {
                    sender.sendMessage("§cYou need to be a player.");
                }
            } else {
                sender.sendMessage("§cYou can't repair this Item.");

            }
        }
        if (args[0].toLowerCase() == "inventory") {
            if (sender instanceof Player) {
                for (ItemStack items : ((Player) sender).getInventory().getContents()) {
                    if (items instanceof Repairable) {
                        items.setDurability((short) items.getType().getMaxDurability());
                    }
                }
            }
        }
        if (args[0].toLowerCase() == "hand") {
            if (sender instanceof Player) {
                ((Player) sender).getItemInHand().setDurability(((Player) sender).getItemInHand().getType().getMaxDurability());
                sender.sendMessage("§bYour " + ((Player) sender).getItemInHand().getType() + "§b got repaired.");
            }
        }
        if (args[0].toLowerCase() == "all")
            if (sender instanceof Player) {
                for (ItemStack items : ((Player) sender).getInventory().getContents()) {
                    if (items instanceof Repairable) {
                        items.setDurability((short) items.getType().getMaxDurability());
                    }
                }
                for (ItemStack armor : ((Player) sender).getInventory().getContents()){
                    if (armor instanceof Repairable){
                        armor.setDurability(armor.getType().getMaxDurability());
                    }

                }
            }
        sender.sendMessage("§b All your Items have been repaired.");
        return true;
    }
}
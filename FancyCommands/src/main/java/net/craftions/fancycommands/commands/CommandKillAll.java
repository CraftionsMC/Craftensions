package net.craftions.fancycommands.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class CommandKillAll implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            for (Entity e : player.getWorld().getEntities()) {
                if (e.getType() == EntityType.valueOf(args[0])){
                    e.remove();
                    sender.sendMessage("§b All Entitys from the type §e" + args[0] + "§b.");
                }
            }
        } else {
            sender.sendMessage("§cYou need to be a player.");
        }
        return true;
    }
}
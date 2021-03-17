/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.activationkeys;

import net.craftions.activationkeys.util.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommandKey implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){

            if(args.length == 1){
                String key = args[0];
                MySQL l0 = new MySQL("select * from `keys` where `key` = '" + key + "';");
                ResultSet rs0 = l0.executeQuery();
                try {
                    if(rs0.next()){
                        // l0.close();
                        // l0 = new MySQL("select `command` from `keys` where `key` = '" + key + "'");
                        ResultSet rs1 = l0.executeQuery();
                        rs1.next();
                        String cmd = rs1.getString("command");
                        l0.close();
                        cmd = cmd.replaceAll("%player%", sender.getName());
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd);
                        MySQL l1 = new MySQL("delete from `keys` where `key` = '" + key + "'");
                        l1.executeUpdate();
                        l1.close();
                        sender.sendMessage("§aThe key was used.");
                    }else {
                        sender.sendMessage("§cThe key is not valid.");
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                    sender.sendMessage("§cAn error occurred. See the console log for details.");
                }
            }else {
                sender.sendMessage("§cPlease use §b" + command.getUsage());
            }
        }else {
            sender.sendMessage("§cYou need to be a player");
        }
        return true;
    }
}

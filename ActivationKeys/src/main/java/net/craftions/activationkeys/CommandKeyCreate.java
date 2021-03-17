/*
 * Copyright (c) 2021 Ben Siebert. All rights reserved.
 */
package net.craftions.activationkeys;

import net.craftions.activationkeys.util.MySQL;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Random;

public class CommandKeyCreate implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0){
            sender.sendMessage("§cPlease use §b" + command.getUsage());
        }else {
            String cmd = "";
            for(int i = 0; i < args.length; i++){
                cmd+=args[i];
                if((i + 1) != args.length){
                       cmd+=" ";
                }
            }
            String key = getRandomString(30);
            MySQL l = new MySQL("insert into `keys`(`key`, `command`) values ('" + key + "', '" + cmd + "')");
            l.executeUpdate();
            l.close();
            TextComponent c = new TextComponent("§aYour key: §b" + key);
            c.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Copy Key to clipboard").create()));
            c.setClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, key));
            sender.spigot().sendMessage(c);
            // sender.sendMessage("§aYour key: §b" + key);
        }
        return true;
    }

    private String getRandomString(int length){
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);
            sb.append(randomChar);
        }
        return sb.toString();
    }
}

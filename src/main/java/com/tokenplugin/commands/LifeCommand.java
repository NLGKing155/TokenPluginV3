package com.tokenplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LifeCommand implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cOnly players can use this command!");
            return true;
        }
        
        Player player = (Player) sender;
        
        if (args.length == 0) {
            player.sendMessage("§a❤️ Your lives: §e10§a/§e50");
            return true;
        }
        
        if (args[0].equalsIgnoreCase("add") && args.length >= 2) {
            if (!player.isOp()) {
                player.sendMessage("§cYou don't have permission!");
                return true;
            }
            int amount = Integer.parseInt(args[1]);
            player.sendMessage("§aYou added §e" + amount + " §alife!");
            return true;
        }
        
        if (args[0].equalsIgnoreCase("give") && args.length >= 3) {
            if (!player.isOp()) {
                player.sendMessage("§cYou don't have permission!");
                return true;
            }
            Player target = player.getServer().getPlayer(args[1]);
            if (target == null) {
                player.sendMessage("§cPlayer not found!");
                return true;
            }
            int amount = Integer.parseInt(args[2]);
            player.sendMessage("§aYou gave §e" + amount + " §alife to §6" + target.getName());
            target.sendMessage("§aYou received §e" + amount + " §alife!");
            return true;
        }
        
        player.sendMessage("§6§l=== Life Commands ===§r");
        player.sendMessage("§e/life §7- Check your lives");
        player.sendMessage("§e/life add <amount> §7- Add lives (OP)");
        player.sendMessage("§e/life give <player> <amount> §7- Give lives (OP)");
        return true;
    }
    }

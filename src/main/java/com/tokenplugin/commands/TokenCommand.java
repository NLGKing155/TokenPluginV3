package com.tokenplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TokenCommand implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cOnly players can use this command!");
            return true;
        }
        
        Player player = (Player) sender;
        player.sendMessage("§6§l=== Your Tokens ===§r");
        player.sendMessage(" §e✦ You have tokens!");
        player.sendMessage("§7━━━━━━━━━━━━━━━━━━━━");
        
        return true;
    }
}

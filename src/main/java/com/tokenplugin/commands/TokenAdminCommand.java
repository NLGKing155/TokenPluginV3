package com.tokenplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TokenAdminCommand implements CommandExecutor {
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        
        if (!sender.isOp()) {
            sender.sendMessage("§cYou don't have permission!");
            return true;
        }
        
        if (args.length == 0) {
            sender.sendMessage("§6§l=== Token Admin Commands ===§r");
            sender.sendMessage("§e/tokenadmin give <player> <token> [amount] §7- Give token");
            sender.sendMessage("§e/tokenadmin remove <player> <token> [amount] §7- Remove token");
            sender.sendMessage("§e/tokenadmin reload §7- Reload config");
            sender.sendMessage("§e/tokenadmin list <player> §7- List player tokens");
            return true;
        }
        
        if (args[0].equalsIgnoreCase("reload")) {
            if (sender instanceof Player) {
                ((Player) sender).getServer().getPluginManager().getPlugin("TokenPlugin").reloadConfig();
            }
            sender.sendMessage("§aConfig reloaded!");
            return true;
        }
        
        if (args[0].equalsIgnoreCase("give") && args.length >= 3) {
            Player target = sender.getServer().getPlayer(args[1]);
            if (target == null) {
                sender.sendMessage("§cPlayer not found!");
                return true;
            }
            String token = args[2];
            int amount = args.length >= 4 ? Integer.parseInt(args[3]) : 1;
            sender.sendMessage("§aGave §e" + amount + " §a" + token + " token to §6" + target.getName());
            return true;
        }
        
        sender.sendMessage("§cUnknown command! Use /tokenadmin for help");
        return true;
    }
}

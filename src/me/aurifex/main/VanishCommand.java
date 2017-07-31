package me.aurifex.main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class VanishCommand implements CommandExecutor {
	main main;
	
	
    private ArrayList<Player> vanished = new ArrayList<Player>();
    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
           
            if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "BUILDTOOLS " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "» " + ChatColor.GRAY +  "You cannot do that!"); 
                    return true;
            }
           
            Player p = (Player) sender;
                              
                    if (!vanished.contains(p)) {
                            for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
                                    pl.hidePlayer(p);
                            }
                            vanished.add(p);
                            p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "BUILDTOOLS " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "» " + ChatColor.GRAY +  "" + me.aurifex.main.main.main.getConfig().getString("vanish"));
                            return true;
                    }
                    else {
                            for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
                                    pl.showPlayer(p);
                            }
                            vanished.remove(p);
                            p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "BUILDTOOLS " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "» " + ChatColor.GRAY +  "" + me.aurifex.main.main.main.getConfig().getString("unvanish"));
                            return true;
                    }
    }
   
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
            for (Player p : vanished) {
                    e.getPlayer().hidePlayer(p);
            }
    }
}

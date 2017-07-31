package me.aurifex.main;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
	
    List<String> fly = new ArrayList<String>();


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] arg) {
            Player player = (Player) sender;
            if(player.hasPermission("fly.use")) {
                            fly.add(player.getName());
                    player.setAllowFlight(true);
                    player.setFlying(true);
                    player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "BUILDTOOLS " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "» " + ChatColor.GRAY +  "" + me.aurifex.main.main.main.getConfig().getString("flymessage"));
                    return true;
            }
                    if(fly.contains(player.getName())) {
                            fly.remove(player.getName());
                            player.setAllowFlight(false);
                            player.setFlying(false);
                            player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "BUILDTOOLS " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "» " + ChatColor.GRAY +  "" + me.aurifex.main.main.main.getConfig().getString("flymessage"));
                           
                            return true;
                           
                    }
		return true;
	}

}

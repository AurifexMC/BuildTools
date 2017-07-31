package me.aurifex.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
	    Player p = (Player) sender;
	 	me.aurifex.main.main.main.getConfig().set("spawn.world", p.getLocation().getWorld().getName());
    	me.aurifex.main.main.main.getConfig().set("spawn.x", p.getLocation().getX());
    	me.aurifex.main.main.main.getConfig().set("spawn.y", p.getLocation().getY());
    	me.aurifex.main.main.main.getConfig().set("spawn.z", p.getLocation().getZ());
    	me.aurifex.main.main.main.saveConfig();
            p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "BUILDTOOLS " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "» " + ChatColor.GRAY +  "Spawn has been set!");
            return true;
	}

}

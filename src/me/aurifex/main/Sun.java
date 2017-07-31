package me.aurifex.main;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Sun implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] arg) {
		Player player = (Player) sender;
        player.getLocation().getWorld().setTime(1000);
        player.getLocation().getWorld().setThundering(false);
        player.getLocation().getWorld().setStorm(false);
		player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "BUILDTOOLS " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "» " + ChatColor.GRAY +  "" + me.aurifex.main.main.main.getConfig().getString("sun"));
		return false;
	}

}

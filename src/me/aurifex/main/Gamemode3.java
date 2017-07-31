package me.aurifex.main;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode3 implements CommandExecutor {
	main main;
	
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		Player player = (Player) sender;
		      player.setGameMode(GameMode.SPECTATOR);
		      player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "BUILDTOOLS " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "» " + ChatColor.GRAY +  "" + "Gamemode has been updated!");
		      return true;

  }
}

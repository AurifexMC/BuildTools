package me.aurifex.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "BUILDTOOLS " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "» " + ChatColor.GRAY +  "" + me.aurifex.main.main.main.getConfig().getString("tpmessage"));
            return true;
    }
   
    Player p = (Player) sender;
   
            if (args.length == 0) {
                    p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "BUILDTOOLS " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "» " + ChatColor.GRAY +  "" + me.aurifex.main.main.main.getConfig().getString("specifyplayer"));
                    return true;
            }
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {
                    p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "BUILDTOOLS " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "» " + ChatColor.GRAY +  "" + me.aurifex.main.main.main.getConfig().getString("couldnotfind"));
                    return true;
            }
            p.teleport(target.getLocation());
            return true;
}
}
package me.aurifex.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Spawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
	    Player p = (Player) sender;
        if (me.aurifex.main.main.main.getConfig().getConfigurationSection("spawn") == null) {
            p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "BUILDTOOLS " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "» " + ChatColor.GRAY +  "" + me.aurifex.main.main.main.getConfig().getString("nospawn"));
            return true;
    }
    World w = Bukkit.getServer().getWorld(me.aurifex.main.main.main.getConfig().getString("spawn.world"));
    double x = me.aurifex.main.main.main.getConfig().getDouble("spawn.x");
    double y = me.aurifex.main.main.main.getConfig().getDouble("spawn.y");
    double z = me.aurifex.main.main.main.getConfig().getDouble("spawn.z");
    p.teleport(new Location(w, x, y, z));
    p.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "BUILDTOOLS " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "» " + ChatColor.GRAY +  "" + me.aurifex.main.main.main.getConfig().getString("spawnwelcome"));
return true;
	}

}

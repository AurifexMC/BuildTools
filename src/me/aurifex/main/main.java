package me.aurifex.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {

    public static main main;

    public void onEnable() {
    main = this;
        getConfig().options().copyDefaults(true);
        saveConfig();
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getCommand("vanish").setExecutor(new VanishCommand());
        getCommand("gmc").setExecutor(new Gamemode1());
        getCommand("gms").setExecutor(new Gamemode0());
        getCommand("gma").setExecutor(new Gamemode2());
        getCommand("gmspec").setExecutor(new Gamemode3());
        getCommand("pl").setExecutor(new Plugins());
        getCommand("fly").setExecutor(new Fly());
        getCommand("sun").setExecutor(new Sun());
        getCommand("tp").setExecutor(new Teleport());
        getCommand("spawn").setExecutor(new Spawn());
        getCommand("setspawn").setExecutor(new SetSpawn());
        }
	@EventHandler
	public void blockBreak(BlockBreakEvent e){
		Player p = e.getPlayer();
		p.sendMessage("Hello World");
	 }

public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
       
        if (!(sender instanceof Player)) {
                sender.sendMessage(ChatColor.RED + "The console cannot use Medic!");
                return true;
        }
       
        Player player = (Player) sender;
       
        if (cmd.getName().equalsIgnoreCase("heal")) {
                if (args.length == 0) {
                        player.setHealth(20);
                        sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "BUILDTOOLS " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "» " + ChatColor.GRAY + getConfig().getString("healmessage"));
                        return true;
                }
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target == null) {
                        player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "BUILDTOOLS " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "» " + ChatColor.GRAY + getConfig().getString("couldnotfind"));
                        return true;
                }
                target.setHealth(20);
                target.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "BUILDTOOLS " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "» " + ChatColor.GRAY + getConfig().getString("healmessage"));
                player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "BUILDTOOLS " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "» " + ChatColor.GRAY + target.getName() + ChatColor.GRAY + " has been healed!");     
                }
       
        if (cmd.getName().equalsIgnoreCase("feed")) {
                if (args.length == 0) {
                        player.setFoodLevel(20);
                        sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "BUILDTOOLS " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "» " + ChatColor.GRAY + getConfig().getString("feedmessage"));
                        return true;
                }
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target == null) {
                    sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "BUILDTOOLS " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "» " + ChatColor.GRAY + getConfig().getString("couldnotfind"));
                        return true;
                }
                target.setFoodLevel(20);
                target.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "BUILDTOOLS " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "» " + ChatColor.GRAY + getConfig().getString("feedmessage"));
                player.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "BUILDTOOLS " + ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "» " + ChatColor.GRAY + target.getName() + ChatColor.GRAY + " has been fed!");
        }
        
        return true;

}

}
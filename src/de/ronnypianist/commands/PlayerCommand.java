package de.ronnypianist.commands;

import de.ronnypianist.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("molecraft.player")) {
                if (args.length == 0) {
                    p.sendMessage(Main.Prefix + "§7Players: §a" + Bukkit.getOnlinePlayers().size() + "§7/§a" + Bukkit.getMaxPlayers());
                } else
                    p.sendMessage(Main.Prefix + ("§7Gebe §c/player §7ein!"));
            } else
                p.sendMessage(Main.Prefix + ("§cDazu hast du keine Rechte!"));
        } else
            sender.sendMessage(Main.Prefix + "§7You must go in Minecraft to use this Command!");
        return false;
    }
}

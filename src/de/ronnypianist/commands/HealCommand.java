package de.ronnypianist.commands;

import de.ronnypianist.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("molecraft.heal")) {
                if (args.length == 0) {
                    p.setHealth(20);
                    p.setFoodLevel(20);
                    p.sendMessage(Main.Prefix + "§7Du wurdest geheilt");
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        target.setHealth(20);
                        target.setFoodLevel(20);
                        target.sendMessage(Main.Prefix + "§7Du wurdest geheilt");
                        p.sendMessage(Main.Prefix + "§7Du hast den Spieler §a" + target.getName() + " §7geheilt.");
                    } else
                        p.sendMessage(Main.Prefix + ("§7Der Spieler §c" + args[0] + " §7ist nicht auf dem Server."));
                } else
                    p.sendMessage(Main.Prefix + ("§7Bitte benutze §c/heal <Name>§7!"));
            } else
                p.sendMessage(Main.Prefix + ("§cDazu hast du keine Rechte!"));
        }else
            sender.sendMessage(Main.Prefix + "§7You must go in Minecraft to use this Command!");
                    return false;
    }
}
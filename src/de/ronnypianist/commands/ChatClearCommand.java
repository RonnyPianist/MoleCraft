package de.ronnypianist.commands;

import de.ronnypianist.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatClearCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("molecraft.cc")) {
                if (args.length == 0) {
                    for(int i = 0; i <= 200; i ++)
                        Bukkit.broadcastMessage(" ");
                    Bukkit.broadcastMessage(Main.Prefix + "§7Der Chat wurde von §a" + p.getName() +  " §7geleert.");
                } else
                    p.sendMessage(Main.Prefix + "§7Bitte benutze §c/cc§7!");
            } else
                p.sendMessage(Main.Prefix + "$cDazu hast du keine Rechte!");
        }
        return false;
    }
}

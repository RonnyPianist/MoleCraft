package de.ronnypianist.commands;

import de.ronnypianist.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("molecraft.setspawn")) {
                if (args.length == 0) {
                    FileConfiguration cfg = Main.getPlugin().getConfig();
                    cfg.set("Spawn.World", p.getWorld().getName());
                    cfg.set("Spawn.X", p.getLocation().getX());
                    cfg.set("Spawn.Y", p.getLocation().getY());
                    cfg.set("Spawn.Z", p.getLocation().getZ());
                    cfg.set("Spawn.Yaw", p.getLocation().getYaw());
                    cfg.set("Spawn.Pitch", p.getLocation().getPitch());
                    Main.getPlugin().saveConfig();
                    p.sendMessage(Main.Prefix + "§7Du hast den Spawn gesetzt!");
                } else
                    p.sendMessage(Main.Prefix + "§7Bitte benutze §c/setspawn§7!");
            } else
                p.sendMessage(Main.Prefix + "§7Dazu hast du §ckeine Rechte!");
        }
        return false;
    }
}

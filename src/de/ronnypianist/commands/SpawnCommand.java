package de.ronnypianist.commands;

import de.ronnypianist.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("molecraft.spawn")) {
                if (args.length == 0) {
                    FileConfiguration cfg = Main.getPlugin().getConfig();
                    World world = Bukkit.getWorld(cfg.getString("Spawn.World"));
                    double x = cfg.getDouble("Spawn.X");
                    double y = cfg.getDouble("Spawn.Y");
                    double z = cfg.getDouble("Spawn.Z");
                    float yaw = (float) cfg.getDouble("Spawn.Yaw");
                    float pitch = (float) cfg.getDouble("Spawn.Pitch");
                    Location location = new Location(world, x, y, z, yaw, pitch);
                    p.teleport(location);
                } else
                    p.sendMessage(Main.Prefix + "§7Bitte benutze §c/spawn§7!");
            } else
                p.sendMessage(Main.Prefix + "§7Dazu hast du keine Rechte!");
        }
        return false;
    }
}

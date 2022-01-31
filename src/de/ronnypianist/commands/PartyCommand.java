package de.ronnypianist.commands;

import de.ronnypianist.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PartyCommand implements CommandExecutor {
    private int taskID;

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
                int countdown = 10;
                @Override
                public void run() {
                    if (countdown <= 0) {
                        Bukkit.broadcastMessage(Main.Prefix + "§a§lDIE PARTY BEGINNT!");
                        Bukkit.getScheduler().cancelTask(taskID);
                        return;
                    }
                    Bukkit.broadcastMessage(Main.Prefix +  "§7Die Party startet in §a" + countdown +  " §6Sekunden.");
                    countdown--;
                }
            }, 0,20);
        }
        return false;
    }
}
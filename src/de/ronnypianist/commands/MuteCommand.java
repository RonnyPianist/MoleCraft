package de.ronnypianist.commands;

import de.ronnypianist.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class MuteCommand implements CommandExecutor {

    private ArrayList<String> mutedPlayers = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("molecraft.mute")) {
                if(args.length == 1){



                } else
                    p.sendMessage(Main.Prefix +  "$7Bitte benutze §c/mute <Spieler>§7!");
            } else
                p.sendMessage(Main.Prefix +  "$cDazu hast du keine Rechte!");
        }
        return false;
    }
}

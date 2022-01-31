package de.ronnypianist.listener;

import de.ronnypianist.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(Main.Prefix + "§a" + event.getPlayer().getName() + " §7joined the Game!");
    }

}

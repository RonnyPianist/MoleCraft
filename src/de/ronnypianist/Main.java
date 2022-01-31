package de.ronnypianist;

import de.ronnypianist.commands.*;
import de.ronnypianist.listener.JoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main plugin;

    public static String Prefix = "§8[§6MoleCraft§8] §f";

    public void onEnable(){
        plugin = this;

        System.out.println("Plugins wurde aktiviert!");

        getCommand("heal").setExecutor(new HealCommand());
        getCommand("kit").setExecutor(new KitCommand());
        getCommand("setspawn").setExecutor(new SetSpawnCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("party").setExecutor(new PartyCommand());
        getCommand("cc").setExecutor(new ChatClearCommand());
        getCommand("player").setExecutor(new PlayerCommand());

        getServer().getPluginManager().registerEvents(new JoinListener(), this);
    }

    public static Main getPlugin() {
        return plugin;
    }
}

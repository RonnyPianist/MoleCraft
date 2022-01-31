package de.ronnypianist;

import de.ronnypianist.commands.*;
import de.ronnypianist.listener.JoinListener;
import de.ronnypianist.sql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public class Main extends JavaPlugin {

    private static Main plugin;
    public MySQL SQL;
    public static String Prefix = "§8[§6MoleCraft§8] §f";

    public void onEnable(){
        plugin = this;

        this.SQL = new MySQL();
        try {
            SQL.connect();
        } catch (ClassNotFoundException | SQLException e) {
            Bukkit.getLogger().info("Database not connected");
        }
        if (SQL.isConnected()) {
            Bukkit.getLogger().info("Database is connected");
        }

        System.out.println("Plugins wurde aktiviert!");

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

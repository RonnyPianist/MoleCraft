package de.ronnypianist.sql;

import de.ronnypianist.Main;
import org.bukkit.configuration.file.FileConfiguration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    private String host = "localhost";
    private String port = "3306";
    private String database = "molecraft";
    private String username = "molecraft";
    private String password = "Ronny331";

    private Connection connection;

    public boolean isConnected(){
        FileConfiguration cfg = Main.getPlugin().getConfig();
        cfg.set("MySQL.host",host);
        cfg.set("MySQL.host",port);
        cfg.set("MySQL.host",database);
        cfg.set("MySQL.host",username);
        cfg.set("MySQL.host",password);
        return (connection == null ? false : true);
    }

    public void connect() throws ClassNotFoundException, SQLException {
        if (!isConnected()) {
            connection = DriverManager.getConnection("jdbc:mysql://" +
                            host + ":" + port + "/" + database + "?useSSL=false",
                    username, password);
        }
    }

    public void disconnect(){
        if (isConnected()) {
            try {
                connection.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection(){
        return connection;
    }

}
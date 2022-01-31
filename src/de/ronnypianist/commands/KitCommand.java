package de.ronnypianist.commands;

import de.ronnypianist.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
                Player p = (Player) sender;
                if (p.hasPermission("molecraft.kit")) {
                    if (args.length == 0) {
                        Inventory inv = Bukkit.createInventory(null, 9*6, Main.Prefix + "Kit-Inventar");

                        ItemStack item = new ItemStack(Material.DIAMOND);
                        ItemMeta itemMeta = item .getItemMeta();
                        itemMeta.setDisplayName("§6Spawn");
                        itemMeta.addEnchant(Enchantment.LUCK, 5,false);
                        item.setItemMeta(itemMeta);

                        inv.addItem(item);
                        item.setAmount(64);
                        inv.setItem(10, item);
                        p.openInventory(inv);
                    } else
                        p.sendMessage(Main.Prefix + "§7Bitte benutze §c/kit§7!");
                } else
                    p.sendMessage(Main.Prefix + "$cDazu hast du keine Rechte!");
            }
        return false;
    }
}

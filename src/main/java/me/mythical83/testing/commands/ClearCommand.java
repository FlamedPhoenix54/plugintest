package me.mythical83.testing.commands;

import me.mythical83.testing.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ClearCommand implements CommandExecutor {
    private final Main main;

    public  ClearCommand(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.isOp() || player.hasPermission("test.clear")) {
                Inventory inv = player.getInventory();
                inv.clear();
                player.sendMessage(ChatColor.GREEN + "Your inventory has been cleared");
            } else {
                player.sendMessage(ChatColor.RED + "You don't have the permissions to use this command");
            }
        }
        else {
            main.getLogger().info(ChatColor.RED + "You have to be a player to clear your inventory");
        }
        return true;
    }
}

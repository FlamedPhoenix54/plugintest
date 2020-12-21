package me.mythical83.testing.commands;

import me.mythical83.testing.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static me.mythical83.testing.ItemStacks.GodStack.*;

public class God implements CommandExecutor {
    private final Main main;

    public God(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (cmd.getName().equalsIgnoreCase("god")) {
            if(sender instanceof  Player) {
                Player player = (Player) sender;
                Inventory inv = player.getInventory();
                Location loc = player.getLocation();
                World world = player.getWorld();

                if (inv.firstEmpty() == -1) {
                    world.dropItemNaturally(loc, godSword());
                } else {
                    inv.addItem(godSword());
                }
            } else {
                main.getLogger().info("You have to be a player to use this!");
            }
        }
        return true;
    }
}

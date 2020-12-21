package me.mythical83.testing.commands;

import me.mythical83.testing.Main;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.jar.Attributes;

import static me.mythical83.testing.ItemStacks.EnhancedStack.*;

public class EnhancedGear implements CommandExecutor, Listener {
    private final Main main;

    public EnhancedGear(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.isOp() || player.hasPermission("test.movement")) {
                Inventory inv = player.getInventory();
                Location loc = player.getLocation();
                World world = player.getWorld();
                if (inv.firstEmpty() == -1) {
                    world.dropItemNaturally(loc, Helmet());
                } else {
                    inv.addItem(Helmet());
                }
                if (inv.firstEmpty() == -1) {
                    world.dropItemNaturally(loc, Chestplate());
                } else {
                    inv.addItem(Chestplate());
                }
                if (inv.firstEmpty() == -1) {
                    world.dropItemNaturally(loc, Leggings());
                } else {
                    inv.addItem(Leggings());
                }
                if (inv.firstEmpty() == -1) {
                    world.dropItemNaturally(loc, Boots());
                } else {
                    inv.addItem(Boots());
                }
                if (inv.firstEmpty() == -1) {
                    world.dropItemNaturally(loc, Stacked());
                } else {
                    inv.addItem(Stacked());
                }
                if (inv.firstEmpty() == -1) {
                    world.dropItemNaturally(loc, Sword());
                } else {
                    inv.addItem(Sword());
                }
            } else {
                player.sendMessage(ChatColor.RED + "You don't have the permissions to use this command");
            }
        }
        else {
            main.getLogger().info("You have to be a player to use this command");
        }
        return true;
    }
}

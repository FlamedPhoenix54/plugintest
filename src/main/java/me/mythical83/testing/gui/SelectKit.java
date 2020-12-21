package me.mythical83.testing.gui;

import me.mythical83.testing.Main;
import me.mythical83.testing.commands.EnhancedGear;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static me.mythical83.testing.ItemStacks.EnhancedStack.*;
import static me.mythical83.testing.ItemStacks.GodStack.*;

public class SelectKit implements CommandExecutor, Listener{
    private final Main main;

    public SelectKit(Main main) {
        this.main = main;
    }

    public static Inventory inv;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.isOp() || player.hasPermission("test.kits")) {
                if (args.length == 0) {
                    player.openInventory(inv);
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[1]);
                    target.openInventory(inv);
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
    public static void createInv() {
        inv = Bukkit.createInventory(null, 9, "Kit Selector");

        ItemStack slot1 = new ItemStack(Material.BEACON);
        ItemMeta slot1m = slot1.getItemMeta();
        slot1m.setDisplayName(ChatColor.DARK_PURPLE + "Enhanced Kit");
        List<String> lore = new ArrayList<>();
        lore.add("Click to select this kit!");
        slot1m.setLore(lore);
        slot1.setItemMeta(slot1m);
        inv.setItem(0, slot1);

        ItemStack slot2 = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta slot2m = slot2.getItemMeta();
        List<String> lore2 = new ArrayList<>();
        lore2.add("Click to select this kit!");
        slot2m.setLore(lore2);
        slot2m.setDisplayName(ChatColor.GOLD + "God Kit");
        slot2.setItemMeta(slot2m);
        inv.setItem(1, slot2);
    }
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (!e.getInventory().equals(inv)) return;
        if (e.getCurrentItem() == null) return;
        if (e.getCurrentItem().getItemMeta() == null) return;
        if (e.getCurrentItem().getItemMeta().getDisplayName() == null) return;

        e.setCancelled(true);
        Player player = (Player) e.getWhoClicked();

        if (e.getSlot() == 0) {
            Inventory inv = player.getInventory();
            Location loc = player.getLocation();
            World world = player.getWorld();
            inv.clear();

            player.getInventory().setHelmet(Helmet());
            player.getInventory().setChestplate(Chestplate());
            player.getInventory().setLeggings(Leggings());
            player.getInventory().setBoots(Boots());
            inv.addItem(Sword());
            inv.addItem(Stacked());

            player.closeInventory();
        } else if (e.getSlot() == 1) {
            Inventory inv = player.getInventory();
            Location loc = player.getLocation();
            World world = player.getWorld();
            inv.clear();

            inv.addItem(godSword());
            player.getInventory().setHelmet(godHelmet());

            player.closeInventory();
        }
    }
}

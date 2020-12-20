package me.mythical83.testing;

import me.mythical83.testing.commands.GodMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Events implements Listener{

    public List<String> ancient_trident = new ArrayList<>();
    public List<String> ancient_bow = new ArrayList<>();

    @EventHandler
    public void onPlayerBreakBlock(BlockBreakEvent e) {
        Block blockBroken = e.getBlock();

        if(blockBroken.getType() == Material.DIAMOND_ORE) {
            Player player = e.getPlayer();
            e.setCancelled(true);
            blockBroken.setType(Material.AIR);
            ItemStack diamonds = new ItemStack(Material.DIAMOND, 2);
            blockBroken.getWorld().dropItemNaturally(blockBroken.getLocation(), diamonds);
        }
        if(blockBroken.getType() == Material.GOLD_ORE) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void onFall(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            if (e.getCause() == EntityDamageEvent.DamageCause.FALL) {
                if(player.getInventory().getBoots() != null)
                    if (player.getInventory().getBoots().getItemMeta().getDisplayName().contains("Boots of jumping")) {
                        if (player.getInventory().getBoots().getItemMeta().getLore().contains("Boots made to increase your jump height")) {
                            e.setCancelled(true);
                        }
                    }
            }
        }
    }
    @EventHandler
    public void onJump(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        if(player.getInventory().getBoots() != null)
            if (player.getInventory().getBoots().getItemMeta().getDisplayName().contains("Boots of jumping")) {
                if(player.getInventory().getBoots().getItemMeta().getLore().contains("Boots made to increase your jump height"))
                    if(e.getFrom().getY() < e.getTo().getY() &&
                            player.getLocation().subtract(0, 1, 0).getBlock().getType() != Material.AIR) {
                        player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));
                    }
            }
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        player.sendMessage("Welcome to the server");
        player.sendMessage("for a list of commands type /help");
        player.sendMessage("Have fun!");
    }
}

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
    public static ItemStack Helmet() {
        ItemStack helmet = new ItemStack(Material.NETHERITE_HELMET);
        ItemMeta helmetm = helmet.getItemMeta();
        helmetm.setUnbreakable(true);
        helmetm.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Helmet of vision");
        helmetm.addEnchant(Enchantment.PROTECTION_FALL, 0, true);
        helmetm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        helmetm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        helmetm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List <String> lore = new ArrayList<>();
        lore.add("A helmet made to increase your vision at night");
        helmetm.setLore(lore);
        helmet.setItemMeta(helmetm);

        return helmet;
    }

    public static ItemStack Chestplate() {
        ItemStack chestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemMeta chestplatem = chestplate.getItemMeta();
        chestplatem.setUnbreakable(true);
        chestplatem.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Chestplate of resistance");
        chestplatem.addEnchant(Enchantment.PROTECTION_FALL, 0, true);
        chestplatem.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        chestplatem.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.Armor", 100.0, AttributeModifier.Operation.ADD_NUMBER);
        chestplatem.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
        chestplate.setItemMeta(chestplatem);
        List <String> lore = new ArrayList<>();
        lore.add("A chestplate made to increase your resistance to damage");
        chestplatem.setLore(lore);
        return chestplate;
    }
    public static ItemStack Leggings() {
        ItemStack leggings = new ItemStack(Material.NETHERITE_LEGGINGS);
        ItemMeta leggingsm = leggings.getItemMeta();
        leggingsm.setUnbreakable(true);
        leggingsm.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Leggings of speed");
        leggingsm.addEnchant(Enchantment.PROTECTION_FALL, 0, true);
        leggingsm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        leggingsm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.Speed", 0.5, AttributeModifier.Operation.ADD_NUMBER);
        leggingsm.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier);
        List <String> lore = new ArrayList<>();
        lore.add("leggings made to increase your movement speed");
        leggingsm.setLore(lore);
        leggings.setItemMeta(leggingsm);
        return leggings;
    }
    public static ItemStack Boots() {

        ItemStack boots = new ItemStack(Material.NETHERITE_BOOTS);
        ItemMeta bootsm = boots.getItemMeta();
        bootsm.setUnbreakable(true);
        bootsm.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Boots of jumping");
        bootsm.addEnchant(Enchantment.PROTECTION_FALL, 0, true);
        bootsm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        bootsm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List <String> lore = new ArrayList<>();
        lore.add("Boots made to increase your jump height");
        bootsm.setLore(lore);
        boots.setItemMeta(bootsm);

        return boots;
    }
    public static ItemStack Sword() {
        ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta swordm = sword.getItemMeta();
        swordm.setUnbreakable(true);
        swordm.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Sword of strength");
        swordm.addEnchant(Enchantment.PROTECTION_FALL, 0, true);
        swordm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        swordm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.AttackDamage", 100.0, AttributeModifier.Operation.ADD_NUMBER);
        swordm.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
        List <String> lore = new ArrayList<>();
        lore.add("A sword made to increase your strength");
        swordm.setLore(lore);
        sword.setItemMeta(swordm);
        return sword;
    }

    public static ItemStack Stacked() {
        ItemStack stacked = new ItemStack(Material.NETHERITE_PICKAXE, 64);
        ItemMeta stackedm = stacked.getItemMeta();
        stackedm.setUnbreakable(true);
        stackedm.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Stacked Picks");
        stackedm.addEnchant(Enchantment.DIG_SPEED, 32767, true);
        stackedm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        stacked.setItemMeta(stackedm);
        return stacked;
    }
}

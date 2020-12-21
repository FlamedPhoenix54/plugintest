package me.mythical83.testing.ItemStacks;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EnhancedStack {
    public static ItemStack Helmet() {
        ItemStack helmet = new ItemStack(Material.NETHERITE_HELMET);
        ItemMeta helmetm = helmet.getItemMeta();
        helmetm.setUnbreakable(true);
        helmetm.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Helmet of vision");
        helmetm.addEnchant(Enchantment.PROTECTION_FALL, 0, true);
        helmetm.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        helmetm.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        helmetm.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        List<String> lore = new ArrayList<>();
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

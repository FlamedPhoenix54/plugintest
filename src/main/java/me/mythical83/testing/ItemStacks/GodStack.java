package me.mythical83.testing.ItemStacks;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GodStack {
    public static ItemStack godSword() {
        ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = item.getItemMeta();

        item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 32767);
        item.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, 32767);
        item.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 32767);
        item.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 32767);
        item.addUnsafeEnchantment(Enchantment.SWEEPING_EDGE, 32767);

        meta.setUnbreakable(true);
        item.setItemMeta(meta);

        return item;
    }
    public static ItemStack godHelmet() {
        ItemStack item = new ItemStack(Material.NETHERITE_HELMET);
        ItemMeta meta = item.getItemMeta();

        item.addUnsafeEnchantment(Enchantment.OXYGEN, 32767);
        item.addUnsafeEnchantment(Enchantment.THORNS, 32767);
        item.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 32767);
        item.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 32767);
        item.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 32767);
        item.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 32767);
        item.addUnsafeEnchantment(Enchantment.WATER_WORKER, 32767);

        return item;
    }
}

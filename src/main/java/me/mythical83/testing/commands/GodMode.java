package me.mythical83.testing.commands;

import me.mythical83.testing.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;

public class GodMode implements CommandExecutor, Listener {
    private final Main main;

    public GodMode(Main main) {
        this.main = main;
    }

    public static ArrayList godmode_players = new ArrayList();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.isOp() || player.hasPermission("test.godmode")) {
                if (godmode_players.contains(player)) {
                    godmode_players.remove(player);
                } else if (!godmode_players.contains(player)) {
                    godmode_players.remove(player);
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

package me.mythical83.testing.commands;

import me.mythical83.testing.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Fly implements CommandExecutor {
    private final Main main;

    public Fly(Main main) {
        this.main = main;
    }

    private ArrayList <Player> flying_players = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.isOp() || player.hasPermission("test.fly")) {
                if (flying_players.contains(player.getPlayer())) {
                    player.setAllowFlight(false);
                    flying_players.remove(player.getPlayer());
                } else if (!flying_players.contains(player.getPlayer())) {
                    player.setAllowFlight(true);
                    flying_players.add(player.getPlayer());
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

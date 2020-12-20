package me.mythical83.testing.commands;

import me.mythical83.testing.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Launch implements CommandExecutor {
    private final Main main;

    public Launch(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.isOp() || player.hasPermission("test.launch")) {
                if  (args.length == 0) {
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Woooooosh");
                    player.setVelocity(player.getLocation().getDirection().multiply(2).setY(2));
                } else if (args.length == 1) {
                    if (isNum(args[0])) {
                        player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Woooooosh");
                        player.setVelocity(player.getLocation().getDirection().multiply(Integer.parseInt(args[0])).setY(2));
                    } else {
                        player.sendMessage(ChatColor.RED + "Usage: /launch (number value)");
                    }
                } else if (args.length == 2) {
                        if (isNum(args[0])) {
                            player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Woooooosh");
                            Player target = Bukkit.getPlayer(args[1]);
                            target.setVelocity(player.getLocation().getDirection().multiply(Integer.parseInt(args[0])).setY(2));
                        } else {
                            player.sendMessage(ChatColor.RED + "Usage: /launch (number-value)");
                        }
                    } else {
                    player.sendMessage(ChatColor.RED + "Only two arguments are allowed");
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
    public boolean isNum(String num) {
        try {
            Integer.parseInt(num);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}

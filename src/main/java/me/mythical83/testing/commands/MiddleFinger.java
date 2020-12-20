package me.mythical83.testing.commands;

import me.mythical83.testing.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MiddleFinger implements CommandExecutor {
    private final Main main;

    public MiddleFinger(Main main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.isOp() || player.hasPermission("test.middle")) {
                player.sendMessage("(凸 ͡° ͜ʖ ͡°)凸");
            } else {
                player.sendMessage(ChatColor.RED + "You don't have the permissions to use this command");
            }
        }
        else {
            main.getLogger().info("(凸 ͡° ͜ʖ ͡°)凸");
        }
        return true;
    }
}

package me.mythical83.testing;

import me.mythical83.testing.commands.*;
import me.mythical83.testing.gui.SelectKit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public final class Main extends JavaPlugin implements Listener {

    public final Logger logger = Logger.getLogger("Minecraft");
    public Main plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        logger.info("Hello There!");

        getServer().getPluginManager().registerEvents(new Events(), this);
        getServer().getPluginManager().registerEvents(new SelectKit(this), this);

        getCommand("c").setExecutor(new ClearCommand(this));
        getCommand("god").setExecutor(new God(this));
        getCommand("fly").setExecutor(new Fly(this));
        getCommand("middle").setExecutor(new MiddleFinger(this));
        getCommand("gmc").setExecutor(new GMC(this));
        getCommand("gms").setExecutor(new GMS(this));
        getCommand("gma").setExecutor(new GMA(this));
        getCommand("gmsp").setExecutor(new GMSP(this));
        getCommand("launch").setExecutor(new Launch(this));
        getCommand("heal").setExecutor(new Heal(this));
        getCommand("enhancement").setExecutor(new EnhancedGear(this));
        getCommand("kits").setExecutor(new SelectKit(this));

        SelectKit.createInv();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        logger.info("Goodbye!");
    }
}

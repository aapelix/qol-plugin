package aapelix.aapelix;

import aapelix.aapelix.commands.*;
import aapelix.aapelix.handlers.PlayerHandler;
import aapelix.aapelix.handlers.PvPHandler;
import aapelix.aapelix.handlers.RightClick;
import aapelix.aapelix.handlers.TorchHandler;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Aapelix extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("Aapelix's plugin: Started!");


        getCommand("gms").setExecutor(new Survival());
        getCommand("gmc").setExecutor(new Creative());
        getCommand("gmsp").setExecutor(new Spectator());
        getCommand("gma").setExecutor(new Adventure());
        getCommand("fly").setExecutor(new Fly());
        getCommand("menu").setExecutor(new Menu(this));
        getCommand("duel").setExecutor(new Duel());
        getCommand("title").setExecutor(new Title());

        new TorchHandler(this);
        new PlayerHandler(this);
        new PvPHandler(this);
        new RightClick(this);

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Aapelix's' plugin: Stopped!");
    }
}

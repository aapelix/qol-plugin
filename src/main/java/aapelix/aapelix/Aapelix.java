package aapelix.aapelix;

import aapelix.aapelix.commands.*;
import aapelix.aapelix.handlers.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Aapelix extends JavaPlugin {

    @Override
    public void onEnable() {
        Bukkit.getLogger().info("                            .__  .__        \n" +
                "_____  _____  ______   ____ |  | |__|__  ___\n" +
                "\\__  \\ \\__  \\ \\____ \\_/ __ \\|  | |  \\  \\/  / \n" +
                " / __ \\_/ __ \\|  |_> >  ___/|  |_|  |>    <  \n" +
                "(____  (____  /   __/ \\___  >____/__/__/\\_ \\ \n" +
                "     \\/     \\/|__|        \\/              \\/");


        getCommand("gms").setExecutor(new Survival());
        getCommand("gmc").setExecutor(new Creative());
        getCommand("gmsp").setExecutor(new Spectator());
        getCommand("gma").setExecutor(new Adventure());
        getCommand("fly").setExecutor(new Fly());
        getCommand("pvp").setExecutor(new PvP());
        getCommand("duel").setExecutor(new Duel());
        getCommand("title").setExecutor(new Title());
        getCommand("msg").setExecutor(new Msg());
        getCommand("food").setExecutor(new Food());


        new PlayerHandler(this);
        new PvPHandler(this);
        //new Gyrowand(this);

    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Aapelix's' plugin: Stopped!");
    }
}

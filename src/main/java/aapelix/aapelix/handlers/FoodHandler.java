package aapelix.aapelix.handlers;

import aapelix.aapelix.Aapelix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class FoodHandler implements Listener {

    public static boolean isInfiniteFoodEnabled;
    public FoodHandler(Aapelix plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerEvent(PlayerEvent event) {
        Player player = event.getPlayer();

        if (isInfiniteFoodEnabled)
        {
            player.setAbsorptionAmount(1000000);
        }

    }
}

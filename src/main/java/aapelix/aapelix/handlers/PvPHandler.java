package aapelix.aapelix.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;;
import org.bukkit.event.Listener;
import aapelix.aapelix.Aapelix;
import org.bukkit.event.entity.EntityDamageByEntityEvent;



public class PvPHandler implements Listener {
    public static boolean isPvPEnabled;

    public PvPHandler(Aapelix plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }


    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {

        if (event.getDamager() instanceof Player && event.getEntity() instanceof Player && isPvPEnabled) {

            event.setCancelled(true);

        }

    }

}

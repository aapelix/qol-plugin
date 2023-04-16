package aapelix.aapelix.handlers;

import aapelix.aapelix.Aapelix;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import java.util.List;

public class RightClick implements Listener {

    public RightClick(Aapelix plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event){
        Player player = event.getPlayer();

        if (player.getInventory().getItemInMainHand().getType() == Material.IRON_SWORD) {

            Location playerLocation = player.getLocation();
            Vector playerDirection = player.getLocation().getDirection();
            playerDirection.multiply(10);
            Location targetLocation = playerLocation.add(playerDirection);
            player.teleport(targetLocation);

            List<Entity> nearby =  player.getNearbyEntities(5,5,5);

            for (Entity tmp: nearby)
                if (tmp instanceof Damageable)
                    ((Damageable) tmp).damage(100);




        }

    }
}

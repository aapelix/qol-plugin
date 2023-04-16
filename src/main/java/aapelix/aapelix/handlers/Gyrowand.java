package aapelix.aapelix.handlers;

import aapelix.aapelix.Aapelix;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.List;

public class Gyrowand implements Listener {
    public Gyrowand(Aapelix plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event){
        Player player = event.getPlayer();

        if (player.getInventory().getItemInMainHand().getType() == Material.BLAZE_ROD) {

            Block block = player.getTargetBlock(null, 30);
            Location loc = block.getLocation();

            World world = player.getWorld();

            Entity armorstand = world.spawnEntity(loc, EntityType.ARMOR_STAND);

            List<Entity> nearby =  armorstand.getNearbyEntities(5,5,5);

            for (Entity tmp: nearby) {
                if (!(tmp instanceof Player)) {
                    if(tmp instanceof Damageable) {
                        tmp.teleport(loc);
                    }
                }
            }
            armorstand.remove();

        }

    }
}

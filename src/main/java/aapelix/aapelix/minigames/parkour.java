package aapelix.aapelix.minigames;

import aapelix.aapelix.Aapelix;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.Timer;
import java.util.TimerTask;

public class parkour implements Listener {
    public parkour(Aapelix plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.PHYSICAL)) {
            if (event.getClickedBlock().getType().equals(Material.LIGHT_WEIGHTED_PRESSURE_PLATE)) {
                Location location = event.getClickedBlock().getLocation();
                location.setY(location.getY()-1);
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("Task ran");
                    }
                }, 0, 1000);
            }
        }

    }
}

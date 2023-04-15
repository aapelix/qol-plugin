package aapelix.aapelix.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import aapelix.aapelix.Aapelix;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class PlayerHandler implements Listener {
    public PlayerHandler(Aapelix plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        ItemStack item = new ItemStack(Material.BELL, 1);
        Inventory inv = player.getInventory();

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Kello?");
        item.setItemMeta(meta);

        inv.setItem(4, item);

        player.setAllowFlight(true);
        player.sendMessage("Lento otettu automaattisesti käyttöön!");
        player.setMaxHealth(1);
        player.setInvulnerable(true);
        player.setSaturation(1000000);
        player.setAbsorptionAmount(0);


    }

}

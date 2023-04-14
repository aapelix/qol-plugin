package aapelix.aapelix.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;;
import org.bukkit.event.Listener;
import aapelix.aapelix.Aapelix;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class TorchHandler implements Listener {
    public TorchHandler(Aapelix plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onTorchPlace(BlockPlaceEvent event) {
        Block block = event.getBlock();

        if (block.getType() != Material.TORCH) {
            return;
        }

        Bukkit.getLogger().info("Torch placed!");

    }

    @EventHandler
    public void onSnowBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();

        if (block.getType() != Material.SNOW_BLOCK) {
            return;
        }

        ItemStack item = new ItemStack(Material.SNOWBALL, 2);
        Inventory inv = player.getInventory();

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Lumipullo");
        item.setItemMeta(meta);

        inv.addItem(item);
    }



}

package aapelix.aapelix.commands;

import aapelix.aapelix.Aapelix;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class Menu implements Listener, CommandExecutor {
    private String invName = "Pelimuoto valitsin";

    public Menu(Aapelix plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(invName)) {
            return;
        }

        Player player = (Player) event.getWhoClicked();
        int slot = event.getSlot();
        HumanEntity Pelaaja = event.getWhoClicked();

        if (slot != 1) {
            Bukkit.getLogger().info(Pelaaja + " klikkasi valikkoa kohdasta " + slot + "!");
            Pelaaja.addPotionEffect(PotionEffectType.LEVITATION.createEffect(300, 0));
        }

        event.setCancelled(true);
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {
        event.setCancelled(true);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Miks yrität tehdä tätä consolessa?");
            return true;
        }

        Player player = (Player) sender;

        Inventory inv = Bukkit.createInventory(player, 9 * 3, invName);

        inv.setItem(11, getItem(new ItemStack(Material.DIAMOND_SHOVEL), "&9&lSpleef", "&bKlikkaa liittyäksesi", "&bTiputa muut hakkaamalla palikat heidän altaan!"));
        inv.setItem(13, getItem(new ItemStack(Material.BELL), "&e&lKukkulan kuningas", "&bKlikkaa liittyäksesi", "&bOle kukkulan kuningas!"));
        inv.setItem(15, getItem(new ItemStack(Material.GRASS_BLOCK), "&c&lSkyblock", "&bKlikkaa liittyäksesi", "&bKauanko selviät menettämättä hermojasi?"));

        player.openInventory(inv);


        return true;
    }

    private ItemStack getItem(ItemStack item, String name, String ... lore) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));

        List<String> lores = new ArrayList<>();
        for (String s : lore) {
            lores.add(ChatColor.translateAlternateColorCodes('&', s));
        }
        meta.setLore(lores);
        item.setItemMeta(meta);
        return item;
    }
}

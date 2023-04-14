package aapelix.aapelix.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.concurrent.TimeUnit;

public class Duel implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Miks yrität tehdä tätä consolessa?");
            return true;
        }

        Player player = (Player) sender;

        if (args.length >= 1) {
            String potentialPlayer = args[0];

            if (Bukkit.getPlayerExact(potentialPlayer) == player) {
                player.sendMessage(ChatColor.RED+("Et voi haastaa itseäsi"));
                return true;
            }

            if (Bukkit.getPlayerExact(potentialPlayer) == null) {
                return true;
            }

            Player targetPlayer = Bukkit.getServer().getPlayer(potentialPlayer);

            targetPlayer.sendMessage(ChatColor.GOLD +(player + " haastoi sinut kaksin taisteluun!"));

            player.teleport(new Location(Bukkit.getWorld("overworld"), 145, 95, 263));
            targetPlayer.teleport(new Location(Bukkit.getWorld("overworld"), 145, 95, 263));

        } else {
            player.sendMessage(ChatColor.RED+("Käyttö: /duel <nimi>"));
        }

        return true;
    }

}
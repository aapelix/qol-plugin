package aapelix.aapelix.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;


public class Duel implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Why are you trying to do this in console?");
            return true;
        }

        Player player = (Player) sender;

        if (args.length >= 1) {

            String potentialPlayer = args[0];
            String acceptPlayer = args[1];

            if (Bukkit.getPlayerExact(potentialPlayer) == player) {
                player.sendMessage(ChatColor.RED+("You cannot duel yourself"));
                return true;
            }

            if (Bukkit.getPlayerExact(potentialPlayer) == null) {
                player.sendMessage(ChatColor.RED+("Player not found!"));
                return true;
            }

            Player targetPlayer = Bukkit.getServer().getPlayer(potentialPlayer);

            targetPlayer.sendMessage(ChatColor.GOLD +(player + " dueled you!"));

            if (potentialPlayer.equals("accept")) {

                if (Bukkit.getPlayerExact(acceptPlayer) == null) {
                    player.sendMessage(ChatColor.RED+("Player now found!"));
                    return true;
                }

                if (Bukkit.getPlayerExact(acceptPlayer) == player) {

                    player.teleport(new Location(Bukkit.getWorld("overworld"), 145, 95, 263));
                    targetPlayer.teleport(new Location(Bukkit.getWorld("overworld"), 145, 95, 263));

                }
            }

        } else {
            player.sendMessage(ChatColor.RED+("Käyttö: /duel <nimi>"));
        }

        return true;
    }

}

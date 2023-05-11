package aapelix.aapelix.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Title implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {

        Player player = (Player) sender;

        if (args.length >= 1) {

            String titlePlayer = args[0];
            String title = args[1];
            String subtitle = args[2];

            if (Objects.equals(titlePlayer, "all")) {
                for (Player pelaajat : Bukkit.getOnlinePlayers()) {
                    pelaajat.sendTitle(title, subtitle);
                }
            }

            if (Bukkit.getPlayerExact(titlePlayer) == null) {
                player.sendMessage(ChatColor.RED + "Pelaajaa ei löydetty!");
                return true;
            }


            Player targetPlayer = Bukkit.getServer().getPlayer(titlePlayer);

            targetPlayer.sendTitle(title, subtitle);
        }

        return true;

    }

}

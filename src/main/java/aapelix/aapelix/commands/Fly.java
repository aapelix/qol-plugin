package aapelix.aapelix.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Miks yrität tehdä tätä consolessa?");
            return true;
        }

        Player player = (Player) sender;

        if (player.getAllowFlight()) {
            player.setAllowFlight(false);
            player.sendMessage("Lento poistettu käytöstä!");
            player.sendMessage(Bukkit.getOnlinePlayers().toString());
        } else {
            player.setAllowFlight(true);
            player.sendMessage("Lento otettu käyttöön!");
        }

        return true;
    }
}

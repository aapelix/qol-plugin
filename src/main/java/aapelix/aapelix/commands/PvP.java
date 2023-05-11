package aapelix.aapelix.commands;

import aapelix.aapelix.handlers.PvPHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class PvP implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {

        Player player = (Player) sender;
        if (PvPHandler.isPvPEnabled) {
            player.sendMessage(ChatColor.RED + ("PvP is now disabled"));
            PvPHandler.isPvPEnabled = false;
        }
        else {
            player.sendMessage(ChatColor.GREEN + ("PvP is now enabled"));
            PvPHandler.isPvPEnabled = true;
        }

        return true;
    }
}

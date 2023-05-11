package aapelix.aapelix.commands;

import aapelix.aapelix.handlers.FoodHandler;
import aapelix.aapelix.handlers.PvPHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Food implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        Player player = (Player) sender;
        if (FoodHandler.isInfiniteFoodEnabled) {
            player.sendMessage(ChatColor.RED + ("Infinite Food is now disabled"));
            FoodHandler.isInfiniteFoodEnabled = false;
        }
        else {
            player.sendMessage(ChatColor.GREEN + ("Infinite Food is now enabled"));
            FoodHandler.isInfiniteFoodEnabled = true;
        }
        return true;
    }
}

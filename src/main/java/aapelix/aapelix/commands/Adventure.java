package aapelix.aapelix.commands;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Adventure implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Why are you trying to do this in console?");
            return true;
        }

        Player player = (Player) sender;

        player.setGameMode(GameMode.ADVENTURE);
        player.sendMessage(ChatColor.RED+"Game mode set to " + player.getGameMode());

        return true;
    }
}

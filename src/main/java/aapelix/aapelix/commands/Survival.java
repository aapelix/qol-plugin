package aapelix.aapelix.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Survival implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String [] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Miks yrität tehdä tätä consolessa?");
            return true;
        }

        Player player = (Player) sender;

        player.setGameMode(GameMode.SURVIVAL);

        return true;
    }
}

package aapelix.aapelix.commands;


import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Msg implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            return false;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target != null) {

            StringBuilder message = new StringBuilder();

            for (int i = 1; i != args.length; i++)

                message.append(args[1]).append(" ");

            target.sendMessage("§6§l" + sender.getName() + " §e§l>>> §6§l" + target.getName() + " §7§l" + message);

            sender.sendMessage("§6§l" + sender.getName() + " §e§l>>> §6§l" + target.getName() + " §7§l" + message);

        } else if (!(target != null)) {

            sender.sendMessage("§4That player is not currently online!");

        }


        return true;
    }
}

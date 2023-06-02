package com.hideplayer;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

public class HidePlayerCommand implements CommandExecutor {
    private final Set<Player> hiddenPlayers = new HashSet<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by a player.");
            return true;
        }

        if(args.length != 1) {
            sender.sendMessage("Incorrect usage. Use /hideplayer <playername>.");
            return true;
        }

        Player playerToHide = Bukkit.getPlayer(args[0]);

        if(playerToHide == null) {
            sender.sendMessage("The player " + args[0] + " does not exist or is not online.");
            return true;
        }

        Player player = (Player) sender;
        if(hiddenPlayers.contains(playerToHide)) {
            player.showPlayer(playerToHide);
            hiddenPlayers.remove(playerToHide);
            sender.sendMessage("You have successfully unhidden " + playerToHide.getName() + ".");
        } else {
            player.hidePlayer(playerToHide);
            hiddenPlayers.add(playerToHide);
            sender.sendMessage("You have successfully hidden " + playerToHide.getName() + ".");
        }

        return true;
    }
}

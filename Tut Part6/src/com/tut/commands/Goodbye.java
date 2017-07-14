package com.tut.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Goodbye implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command!");
			return false;

		}

		Player player = (Player) sender;

		Location l = new Location(player.getWorld(), 0, 64, 0);
		player.sendMessage(ChatColor.AQUA + "Goodbye! ");
		player.teleport(l);

		return false;
	}
}

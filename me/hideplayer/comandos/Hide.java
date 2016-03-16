package me.hideplayer.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Hide implements CommandExecutor, Listener {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		
		Player p = (Player)sender;
		
		if(cmd.getName().equalsIgnoreCase("hide")) {
			
			for(Player p1 : Bukkit.getOnlinePlayers()) {
				p.hidePlayer(p1);
			}
			
		}
		
		return false;
	}

	
	
}

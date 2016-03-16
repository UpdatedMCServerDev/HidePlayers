package me.hideplayer.comandos;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Show implements CommandExecutor, Listener {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		
		Player p = (Player)sender;
		
		if(cmd.getName().equalsIgnoreCase("show")) {
			
			p.sendMessage("§aTodos os Players estão vísiveis.");
			
			for(Player p1 : Bukkit.getOnlinePlayers()) {
				
				p.showPlayer(p1);
				
			}
			
		}
		
		return false;
	}

	
	
}

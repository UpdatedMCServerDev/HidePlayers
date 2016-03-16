package me.hideplayer.comandos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerInventoryEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Hide implements CommandExecutor, Listener {

	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) {
		
		Player p = (Player)sender;
		
		if(cmd.getName().equalsIgnoreCase("hide")) {
			
			p.sendMessage("§aTodos os Players foram escondidos.");
			
			for(Player p1 : Bukkit.getOnlinePlayers()) {
				p.hidePlayer(p1);
			}
			
			
			
			
		}
		
		return false;
	}
	
	@EventHandler
	public void join(PlayerJoinEvent e) {
		
		ItemStack clock = new ItemStack(Material.WATCH);
		
		
		e.getPlayer().getInventory().setItem(1, clock);
	}
	
	@EventHandler
	public void hide(PlayerInteractEvent e) {
		
		ItemStack oclock = new ItemStack(Material.COMPASS);
		
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
			if(e.getPlayer().getInventory().getItemInHand().getType().equals(Material.WATCH)) {
					e.getPlayer().chat("/hide");
					e.getPlayer().getInventory().remove(Material.WATCH);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Bukkit.getServer().getPluginManager().getPlugin("HidePlayer"), new Runnable() {
		                 @Override
		                 public void run() {
		                     e.getPlayer().getInventory().setItem(1, oclock);
		                 }
		             }, 1L * 3);
					
		                 
			}
		}
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
			if(e.getPlayer().getInventory().getItemInHand().getType().equals(Material.COMPASS)) {
				e.getPlayer().chat("/show");
				e.getPlayer().getInventory().remove(oclock);
				ItemStack clock = new ItemStack(Material.WATCH);
				e.getPlayer().getInventory().setItem(1, clock);
			}
		}
		
		
	}

	
	
}

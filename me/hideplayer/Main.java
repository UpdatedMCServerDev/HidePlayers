
package me.hideplayer;

import me.hideplayer.comandos.Hide;
import me.hideplayer.comandos.Show;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public void onEnable() {
		
		registrarEventos();
		registrarComandos();
		
	}
	
	public void registrarEventos() {
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new Hide(), this);
		pm.registerEvents(new Show(), this);
		
		
	}
	
	public void registrarComandos() {
		
		getCommand("hide").setExecutor(new Hide());
		getCommand("show").setExecutor(new Show());
		
		
	}
	
	
}

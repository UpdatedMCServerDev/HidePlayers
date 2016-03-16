package me.hideplayer;

import me.hideplayer.comandos.Hide;

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
		
		
	}
	
	public void registrarComandos() {
		
		getCommand("hide").setExecutor(new Hide());
		
		
	}
	
	
}

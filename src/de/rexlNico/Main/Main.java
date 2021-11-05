package de.rexlNico.Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.rexlNico.Commands.Map;
import de.rexlNico.Commands.Stats;
import de.rexlNico.Listeners.Build;
import de.rexlNico.Listeners.Damage;
import de.rexlNico.Listeners.Enterhaken;
import de.rexlNico.Listeners.Food;
import de.rexlNico.Listeners.Interackt;
import de.rexlNico.Listeners.Inventory;
import de.rexlNico.Listeners.Join;
import de.rexlNico.Listeners.Move;
import de.rexlNico.Methodes.KitManager;
import de.rexlNico.Methodes.MapAPI;

public class Main extends JavaPlugin{

	public static Main plugin;
	private PluginManager pm = Bukkit.getPluginManager();
//	private TwarixAPI api;
	
	@Override
	public void onEnable() {
//		api = new TwarixAPI();
		plugin = this;
		
		getCommand("stats").setExecutor(new Stats());
		getCommand("map").setExecutor(new Map());
		
		pm.registerEvents(new Build(), this);
		pm.registerEvents(new Damage(), this);
		pm.registerEvents(new Enterhaken(), this);
		pm.registerEvents(new Food(), this);
		pm.registerEvents(new Interackt(), this);
		pm.registerEvents(new Inventory(), this);
		pm.registerEvents(new Join(), this);
		pm.registerEvents(new Move(), this);
		
		MapAPI.setMap(0);
		MapAPI.startTimer();
		KitManager.updateList();
		
		for(Player a:Bukkit.getOnlinePlayers()){
			a.getInventory().clear();
			KitManager.giveKitSelect(a);
		}
		
	}
	
	public static Main getInstance() {
		return plugin;
	}
	
}

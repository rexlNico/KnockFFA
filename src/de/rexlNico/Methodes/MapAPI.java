package de.rexlNico.Methodes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.rexlNico.Main.Main;

public class MapAPI {

	public static File file = new File("plugins/knocki", "maps.yml");
	public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public static int TaskID;
	public static int Map = 0;
	public static int seconds = 600;
	public static String Mapname = "";
	public static List<String> mapnamen = cfg.getStringList("Maps");
	
	@SuppressWarnings("deprecation")
	public static void startTimer() {
		TaskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getInstance(), new Runnable() {
			
			@Override
			public void run() {
				switch (seconds) {
				case 600: case 300: case 240: case 180: case 120:
					Bukkit.broadcastMessage("§4Die Map wechselt in §6"+(seconds/60)+" §4Minuten!");
					break;
				 case 60:
					 Bukkit.broadcastMessage("§4Die Map wechselt in §6einer §4Minute!");
					 break;
				case 0:
					seconds = 600;
					for(Player a:Bukkit.getOnlinePlayers()){
						KitManager.giveKitSelect(a);
					}
					setNextMap();
					break;
					
				}
				Factory.getConfigLocation("Map."+Mapname, cfg).getWorld().setFullTime(1000);
				seconds--;
			}
		}, 0, 20*1);
	}
	public static void stopTimer(){
		Bukkit.getScheduler().cancelTask(TaskID);
	}
	public static void setMap(int i){
		if(i > mapnamen.size() || mapnamen.isEmpty()){
			return;
		}
		Mapname = mapnamen.get(i);
		for(Player a: Bukkit.getOnlinePlayers()){
			teleport(a);
			a.sendMessage("§4Jetzige Map§8: §e"+Mapname);
		}
		seconds = 600;
	}
	public static String getMap(){
		return Mapname;
	}
	public static void setNextMap(){
		
		if(Map > mapnamen.size()){
			Map = 0;
		}else{
			Map++;
		}
		Mapname = mapnamen.get(Map);
		for(Player a: Bukkit.getOnlinePlayers()){
			teleport(a);
			a.sendMessage("§4Jetzige Map§8: §e"+Mapname);
		}
	}

	public static void addMap(String MAP, Player p){
		for(int i=0; i<mapnamen.size(); i++){
			if(mapnamen.get(i).equalsIgnoreCase(MAP)){
				p.sendMessage("§4Diese Map Existiert bereits");
				return;
			}
		}
		mapnamen.add(MAP);
		updateConfig();
		p.sendMessage("§4Du hast die Map §6"+MAP+" §4hinzugefügt!");
		Factory.CreateConfigLocation(p.getLocation(), cfg, file, "Map."+MAP);
	}
	public static void removeMap(String MAP, Player p){
		for(int i=0; i<mapnamen.size(); i++){
			if(mapnamen.get(i).equalsIgnoreCase(MAP)){
				p.sendMessage("§4Die Map §6"+MAP+" §4wurde entfernt!");
				mapnamen.remove(i);
				updateConfig();
				
				if(Mapname.equalsIgnoreCase(MAP)){
					setNextMap();
				}
				return;
			}
		}
	}
	public static void teleport(Player p){
		try {
			Location loc = Factory.getConfigLocation("Map."+Mapname, cfg);
			p.teleport(loc);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	public static void updateConfig(){
		cfg.set("Maps", mapnamen);
		try {
			cfg.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

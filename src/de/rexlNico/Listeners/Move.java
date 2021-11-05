package de.rexlNico.Listeners;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerMoveEvent;

import de.rexlNico.Methodes.Factory;
import de.rexlNico.Methodes.KitManager;
import de.rexlNico.Methodes.MapAPI;

import org.bukkit.event.Listener;

public class Move implements Listener{

	public static ArrayList<Player> hasKiste = new ArrayList<>();
	public static ArrayList<Player> wasSpawn = new ArrayList<>();
	
	@EventHandler
	public void on(PlayerMoveEvent e){
		Player p = e.getPlayer();
		Location loc = Factory.getConfigLocation("Map."+MapAPI.getMap(), MapAPI.cfg);
		
		if(p.getLocation().getY()+3 < loc.getY()){
			if(!Damage.canatack.contains(p)){
				Damage.canatack.add(p);
			}
			if(!Inventory.canMove.contains(p)){
				Inventory.canMove.add(p);
			}
			if(!p.getInventory().contains(Material.STICK)){
				KitManager.giveKit(p);
			}
			if(hasKiste.contains(p)){
				hasKiste.remove(p);
			}
			wasSpawn.add(p);
		}else{
			if(!wasSpawn.contains(p) || p.getGameMode().equals(GameMode.CREATIVE)){
				if(Damage.canatack.contains(p)){
					Damage.canatack.remove(p);
				}
				if(Inventory.canMove.contains(p)){
					Inventory.canMove.remove(p);
				}
				if(!hasKiste.contains(p)){
					p.getInventory().clear();
					KitManager.giveKitSelect(p);
					hasKiste.add(p);
				}
			}
		}
		if(p.getLocation().getY() <= 15){
			
			Player lh = null;
			
			if(Damage.lastHit.containsKey(p)){
				lh = Damage.lastHit.get(p);
				Damage.lastHit.remove(p);
			}
			MapAPI.teleport(p);
//			if(lh == null){
//				StatsAPI api = new StatsAPI(p.getUniqueId().toString(), "knockiStats");
//				api.set("Tode", api.getTode()+1);
//			}else{
//			StatsAPI api = new StatsAPI(p.getUniqueId().toString(), "knockiStats");
//			StatsAPI api2 = new StatsAPI(lh.getUniqueId().toString(), "knockiStats");
//			api2.set("Kills", api2.getKills()+1);
//			api2.set("LastKill", p.getName());
//			api.set("Tode", api.getTode()+1);
//			}
			if(Damage.canatack.contains(p)){
				Damage.canatack.remove(p);
			}
			if(Inventory.canMove.contains(p)){
				Inventory.canMove.remove(p);
			}
			if(!hasKiste.contains(p)){
				p.getInventory().clear();
				KitManager.giveKitSelect(p);
				hasKiste.add(p);
			}
			if(wasSpawn.contains(p)){
				wasSpawn.remove(p);
			}
		}else{
			if(Damage.canatack.contains(p)){
				Damage.canatack.remove(p);
			}
			if(Inventory.canMove.contains(p)){
				Inventory.canMove.remove(p);
			}
		}
		
	}
	
}

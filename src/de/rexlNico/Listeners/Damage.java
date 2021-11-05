package de.rexlNico.Listeners;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class Damage implements Listener{

	public static ArrayList<Player> canatack = new ArrayList<>();
	public static HashMap<Player, Player> lastHit = new HashMap<>();
	
	
	@EventHandler
	public void on(EntityDamageByEntityEvent e){
		
		Player p = (Player) e.getEntity();
		Player t  = (Player) e.getDamager();
		
		if(canatack.contains(p) && canatack.contains(t)){
			p.setHealth(10);
			t.setHealth(10);
			if(lastHit.containsKey(p)){
				lastHit.remove(p);
			}
				lastHit.put(p, t);
		}else{
			e.setCancelled(true);
		}
		
	}
	@EventHandler
	public void on(EntityDamageEvent e){
		if(e.getCause() == DamageCause.FALL){
			e.setCancelled(true);
		}
	}
	
}

package de.rexlNico.Listeners;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import de.rexlNico.Methodes.KitManager;

public class Inventory implements Listener{

	public static ArrayList<Player> canMove = new ArrayList<>();
	
	@EventHandler
	public void on(InventoryClickEvent e){
		Player p = (Player) e.getWhoClicked();
			if(e.getInventory().getName().equals(KitManager.setSelection().getName())){
				e.setCancelled(true);
				if(e.getCurrentItem().getType().equals(KitManager.setSelection().getItem(0).getType())){
					KitManager.setKit(p, KitManager.standart);
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
					p.closeInventory();
				}else if(e.getCurrentItem().getType().equals(KitManager.setSelection().getItem(1).getType())){
					KitManager.setKit(p, KitManager.bogen);
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
					p.closeInventory();
				}else if(e.getCurrentItem().getType().equals(KitManager.setSelection().getItem(3).getType())){
					KitManager.setKit(p, KitManager.schneemann);
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
					p.closeInventory();
				}else if(e.getCurrentItem().getType().equals(KitManager.setSelection().getItem(4).getType())){
					KitManager.setKit(p, KitManager.enderman);
					p.playSound(p.getLocation(), Sound.LEVEL_UP, 1, 1);
					p.closeInventory();
				}
			}else if(canMove.contains((Player) e.getWhoClicked()) || p.getGameMode().equals(GameMode.CREATIVE)){
				
		}else{
			e.setCancelled(true);
		}
		
	}
	
	@EventHandler
	public void on(PlayerDropItemEvent e){
		e.setCancelled(true);
	}
	
}

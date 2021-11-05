package de.rexlNico.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;

import de.rexlNico.Methodes.KitManager;

import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;

public class Interackt implements Listener{

	@EventHandler
	public void on(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(p.getItemInHand().getType().equals(Material.CHEST) && p.getItemInHand().getItemMeta().getDisplayName().equals("§bKit auswahl")){
				p.openInventory(KitManager.setSelection());
			}
		}
	}
	
}

package de.rexlNico.Listeners;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class Build implements Listener{

	@EventHandler
	public void on(BlockBreakEvent e){
		if(e.getPlayer().getGameMode().equals(GameMode.CREATIVE)){
			
		}else{
			e.setCancelled(true);
		}
	}
	@EventHandler
	public void on(BlockPlaceEvent e){
		if(e.getPlayer().getGameMode().equals(GameMode.CREATIVE)){
			
		}else{
			e.setCancelled(true);
		}
	}
	
}

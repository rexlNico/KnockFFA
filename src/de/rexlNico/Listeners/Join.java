package de.rexlNico.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.rexlNico.Methodes.MapAPI;

public class Join implements Listener{

	@EventHandler
	public void on(PlayerJoinEvent e){
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		MapAPI.teleport(p);
		p.setFoodLevel(20);
//		ScoreboardAPI ScoreboardAPI = new ScoreboardAPI(e.getPlayer(), "");
//		
//		StatsAPI api  = new StatsAPI(p.getUniqueId().toString(), "knockiStats");
//		
//		api.set("LastKill", null);
//		
//		ScoreboardAPI.addLine("§r");
//		ScoreboardAPI.addLine("§8  ⬛ §fRang");
//		ScoreboardAPI.addLine("§7    » §9"+api.getRank());
//		ScoreboardAPI.addLine("§r§r");
//		ScoreboardAPI.addLine("§8  ⬛ §fKills");
//		ScoreboardAPI.addLine("§7    » §4"+api.getKills());
//		ScoreboardAPI.addLine("§r§r§r");
//		ScoreboardAPI.addLine("§8  ⬛ §fTode");
//		ScoreboardAPI.addLine("§7    » §9"+api.getTode());
//		ScoreboardAPI.addLine("§r§r§r§r");
//		ScoreboardAPI.addLine("§8  ⬛ §fTeamspeak");
//		ScoreboardAPI.addLine("§7    » §9ts.Twarix.DE");
//		ScoreboardAPI.addLine("§r§r§r§r§r");
	}
	
}

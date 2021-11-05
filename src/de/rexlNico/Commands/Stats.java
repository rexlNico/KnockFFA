package de.rexlNico.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import de.rexlNico.Main.Main;

public class Stats implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(sender instanceof Player){
			Player p = (Player)sender;
//			if(args.length == 0){
//		                StatsAPI api  = new StatsAPI(UUIDFetcher.getUUID(p.getName()).toString(), "knockiStats");
//		                p.sendMessage(" ");
//		                p.sendMessage("§8------§4Stats§8------");
//		                p.sendMessage("§7Rang§8➤ §c"+api.getRank());
//		                p.sendMessage("§7Kills§8➤ §c"+api.getKills());
//		                p.sendMessage("§7Tode§8➤ §c"+api.getTode());
//		                p.sendMessage("§7Kd§8➤ §c"+api.getKd());
//		                p.sendMessage("§7letzte Tötung§8➤ §c"+api.getLastKill());
//		                p.sendMessage("§8---------------------");
//		                p.sendMessage(" ");  
//			}else if(args.length == 1){
//	                try {
//	                	StatsAPI api  = new StatsAPI(UUIDFetcher.getUUID(args[0]).toString(), "knockiStats");
//		                p.sendMessage(" ");
//		                p.sendMessage("§8----§4Stats von "+UUIDFetcher.getName(UUIDFetcher.getUUID(args[0]))+"§8----");
//		                p.sendMessage("§7Rang§8➤ §c"+api.getRank());
//		                p.sendMessage("§7Kills§8➤ §c"+api.getKills());
//		                p.sendMessage("§7Tode§8➤ §c"+api.getTode());
//		                p.sendMessage("§7Kd§8➤ §c"+api.getKd());
//		                p.sendMessage("§7letzte Tötung§8➤ §c"+api.getLastKill());
//		                p.sendMessage("§8---------------------");
//		                p.sendMessage(" ");    
//					} catch (Exception e) {
//		                p.sendMessage(" ");
//		                p.sendMessage("§8----§4Stats von "+args[0]+"§8----");
//		                p.sendMessage("§7Rang§8➤  §c✖");
//		                p.sendMessage("§7Kills§8➤ §c0");
//		                p.sendMessage("§7Tode§8➤ §c0");
//		                p.sendMessage("§7Kd§8➤ §c0");
//		                p.sendMessage("§7letzte Tötung§8➤ §c✖");
//		                p.sendMessage("§8---------------------");
//		                p.sendMessage(" "); 
//					}
//			}else{
//				
//			}
		}else{
			
		}
		return false;
	}	

}

package de.rexlNico.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.rexlNico.Methodes.MapAPI;

public class Map implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lable, String[] args) {
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(p.hasPermission("knocki.map")){
				if(args.length == 1){
					if(args[0].equalsIgnoreCase("list")){
						p.sendMessage("§8---§eMaps§8---");
						for(int i=0; i<MapAPI.mapnamen.size(); i++){
							p.sendMessage("§b"+MapAPI.mapnamen.get(i));
						}
						p.sendMessage("§8----------");
					}else{
						p.sendMessage("§8---§eHilfe§8---");
						p.sendMessage("§c/Map list");
						p.sendMessage("§c/Map set <NAME>");
						p.sendMessage("§c/Map add <NAME>");
						p.sendMessage("§c/Map remove <NAME>");
						p.sendMessage("§8-----------");
					}
				}else if(args.length == 2){
					if(args[0].equalsIgnoreCase("add")){
						MapAPI.addMap(args[1], p);
					}else if(args[0].equalsIgnoreCase("remove")){
						MapAPI.removeMap(args[1], p);
					}else if(args[0].equalsIgnoreCase("set")){
						if(MapAPI.mapnamen.contains(args[1])){
							for(int i=0; i<MapAPI.mapnamen.size(); i++){
								if(MapAPI.mapnamen.get(i).equalsIgnoreCase(args[1])){
									MapAPI.setMap(i);
									p.sendMessage("§4Du hast die Map zu §6"+args[1]+"§4 gesetzt!");
									return false;
								}
							}
							p.sendMessage("§4Die Map §6"+args[1]+" §4existiert nicht!");
						}else{
							p.sendMessage("§4Die Map §6"+args[1]+" §4existiert nicht!");
						}
					}else{
						p.sendMessage("§8---§eHilfe§8---");
						p.sendMessage("§c/Map list");
						p.sendMessage("§c/Map set <NAME>");
						p.sendMessage("§c/Map add <NAME>");
						p.sendMessage("§c/Map remove <NAME>");
						p.sendMessage("§8-----------");
					}
				}else{
					p.sendMessage("§8---§eHilfe§8---");
					p.sendMessage("§c/Map list");
					p.sendMessage("§c/Map set <NAME>");
					p.sendMessage("§c/Map add <NAME>");
					p.sendMessage("§c/Map remove <NAME>");
					p.sendMessage("§8-----------");
				}
			}else{
				p.sendMessage("");
			}
		}
		return false;
	}

}

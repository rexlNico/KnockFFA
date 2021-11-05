package de.rexlNico.Methodes;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class KitManager {

	public static ArrayList<ItemStack> standart = new ArrayList<>();
	public static ArrayList<ItemStack> bogen = new ArrayList<>();
	public static ArrayList<ItemStack> schneemann = new ArrayList<>();
	public static ArrayList<ItemStack> enderman = new ArrayList<>();
	public static HashMap<Player, ArrayList<ItemStack>> kits = new HashMap<>();
	
	public static void giveKit(Player p){
		
		p.getInventory().clear();
		if(!kits.containsKey(p)){
			for(int i=0; i<standart.size(); i++){
				p.getInventory().addItem(standart.get(i));
			}
		}else{
			for(int i=0; i<kits.get(p).size(); i++){
				p.getInventory().addItem(kits.get(p).get(i));
			}
		}
		
	}
	public static void giveKitSelect(Player p){
		
		p.getInventory().setItem(4, new ItemBuilder(Material.CHEST, 1).setName("§bKit auswahl").build());
		
	}
	public static void setKit(Player p, ArrayList<ItemStack> kit){
		
		if(kits.containsKey(p)){
			kits.remove(p);
		}
		kits.put(p, kit);
		
	}
	public static ArrayList<ItemStack> getKit(Player p){
		if(!kits.containsKey(p)){
			return standart;
		}
		return kits.get(p);
	}
	public static void updateList(){
		standart.add(new ItemBuilder(Material.STICK, 1).addEnchant(Enchantment.KNOCKBACK, 2).build());
		standart.add(new ItemBuilder(Material.FISHING_ROD, 1).setUnbreakable().build());
		
		bogen.add(new ItemBuilder(Material.STICK, 1).addEnchant(Enchantment.KNOCKBACK, 2).build());
		bogen.add(new ItemBuilder(Material.BOW, 1).setUnbreakable().build());
		bogen.add(new ItemBuilder(Material.ARROW, 2).build());
		
		schneemann.add(new ItemBuilder(Material.STICK, 1).addEnchant(Enchantment.KNOCKBACK, 2).build());
		schneemann.add(new ItemBuilder(Material.SNOW_BALL, 6).build());
		
		enderman.add(new ItemBuilder(Material.STICK, 1).addEnchant(Enchantment.KNOCKBACK, 2).build());
		enderman.add(new ItemBuilder(Material.ENDER_PEARL, 1).build());
	}
	public static Inventory setSelection(){
		Inventory inv = Bukkit.createInventory(null, InventoryType.HOPPER, "§bKit Auswahl");
		
		inv.addItem(new ItemBuilder(Material.FISHING_ROD, 1).setName("§cAngel").build());
		inv.addItem(new ItemBuilder(Material.BOW, 1).setName("§cBogen").build());
		inv.addItem(new ItemBuilder(Material.STAINED_GLASS_PANE, 1, 15).setName("§r").build());
		inv.addItem(new ItemBuilder(Material.SNOW_BALL, 1).setName("§cSchneemann").build());
		inv.addItem(new ItemBuilder(Material.ENDER_PEARL, 1).setName("§cEnderman").build());
		
		return inv;
	}
	
}

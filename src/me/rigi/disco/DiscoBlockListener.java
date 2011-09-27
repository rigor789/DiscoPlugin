package me.rigi.disco;


import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;

import me.rigi.disco.DiscoMain;

public class DiscoBlockListener extends BlockListener {
	@SuppressWarnings("unused")
	private DiscoMain plugin;

	public DiscoBlockListener(DiscoMain plugin) {
		this.plugin = plugin;
	}
	private HashMap<Player, String> using = DiscoMain.using;
	private HashMap<String, ArrayList<Block>> discos = DiscoMain.discos;
	
	public void onBlockPlace(BlockPlaceEvent event) {;
	Player player = event.getPlayer();
	Block block = event.getBlock();
	if(block.getType()== Material.WOOL){
	if(using.containsKey(player)){
		if(discos.containsKey(using.get(player))){
			if(discos.get(using.get(player)).contains(block)){
			}else{
			discos.get(using.get(player)).add(block);
			System.out.println("Array have: " + discos.get(using.get(player)).size()+" blocks after adding");
			player.sendMessage("Block added to the disco!");
			}
		}else{
			discos.put(using.get(player), new ArrayList<Block>());
			if(discos.get(using.get(player)).contains(block)){
			}else{
			discos.get(using.get(player)).add(block);
			System.out.println("Array have: " + discos.get(using.get(player)).size()+" blocks after adding");
			player.sendMessage("Block added to the disco!");
			}
		}	
	}
	}
	
	
	}
	
	
	public void onBlockBreak(BlockBreakEvent event){
		Player player = event.getPlayer();
		Block block = event.getBlock();
		if(block.getType()== Material.WOOL){
		if(using.containsKey(player)){
			if(discos.containsKey(using.get(player))){
				if(discos.get(using.get(player)).contains(block)){
				discos.get(using.get(player)).remove(block);
				block.setType(Material.WOOL);
				player.sendMessage("Block removed from the disco!");
				}
			}
	}
		}
}
}
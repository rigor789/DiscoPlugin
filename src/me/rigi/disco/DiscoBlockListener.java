package me.rigi.disco;


import java.util.ArrayList;

import org.bukkit.block.Block;
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

	public void onBlockPlace(BlockPlaceEvent event) {;
	if(DiscoMain.blocks.containsKey("Test")){
		DiscoMain.blocks.get("Test").add(event.getBlock());
	}else{
		DiscoMain.blocks.put("Test", new ArrayList<Block>());
		DiscoMain.blocks.get("Test").add(event.getBlock());
	}
	
	
	}
	
	
	public void onBlockBreak(BlockBreakEvent event){
	
	}
}
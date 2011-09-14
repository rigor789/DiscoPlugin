package me.rigi.disco;

import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
import java.util.Random;
import java.util.logging.Logger;

import org.bukkit.block.Block;
import org.bukkit.event.Event.Type;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;

import me.rigi.disco.discoBlockListener;

public class discoMain extends JavaPlugin {
	private discoBlockListener bListener = new discoBlockListener(this);
	static Logger Log = Logger.getLogger("Minecraft");
	public static ArrayList<Player> players = new ArrayList<Player>();
	public static ArrayList<Player> using = new ArrayList<Player>();
	//public static Map<String, Block> blocks = new HashMap<String, Block>();
	public static ArrayList<Block> blocks = new ArrayList<Block>();
	private static byte[] allowed = {1,2,3,4,5,6,9,10,11,14};
	private static Random random;


	//@Override
	public void onDisable() {
		Log.info("[DiscoPlugin] Disco plugin disabled!");
	}
	//@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Type.BLOCK_PLACE, bListener, Priority.Normal, this);
		pm.registerEvent(Type.BLOCK_BREAK, bListener, Priority.Normal, this);
		getCommand("disco").setExecutor(new discoCmdExecutor(this));
		discoPreferences discopreferences = new discoPreferences();
		discopreferences.createDir();
		coordinateReader reader = new coordinateReader(this);
		reader.readAll();
		random = new Random();
		Log.info("[DiscoPlugin] Disco plugin enabled!");
	}
	public static void blockChanger() {
        //Block block = blocks.get(random.nextInt(blocks.size()));
		//block.setData(randomColor);
		//byte randomColor = allowed[random.nextInt(allowed.length)];
		
		//Prepare random colors...
		byte[] colors = new byte[blocks.size()];
		for (int n=0; n<colors.length; n++) {
			colors[n] = allowed[random.nextInt(allowed.length)];
		}
		
		//Set the blocks
		for (int n=0; n<colors.length; n++) {
			blocks.get(n).setData(colors[n]);
		}
	}
}


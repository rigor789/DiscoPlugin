package me.rigi.disco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

import org.bukkit.block.Block;
import org.bukkit.event.Event.Type;
import org.bukkit.event.Event.Priority;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;


public class DiscoMain extends JavaPlugin {
	private DiscoBlockListener bListener = new DiscoBlockListener(this);
	Logger Log = Logger.getLogger("Minecraft");
	public static HashMap<Player, String> using = new HashMap<Player, String>();
	public static HashMap<String, ArrayList<Block>> discos = new HashMap<String, ArrayList<Block>>();

	//@Override
	public void onDisable() {
		Log.info("Disco plugin disabled!");
	}
	//@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Type.BLOCK_PLACE, bListener, Priority.Normal, this);
		pm.registerEvent(Type.BLOCK_BREAK, bListener, Priority.Normal, this);
		getCommand("disco").setExecutor(new DiscoCmdExecutor(this));
		DiscoReaderWriter.createDir();
		DiscoReaderWriter.ReadAll();
		Log.info("Disco plugin enabled!");
	}

	public static void blockChanger() {
		
	}
}

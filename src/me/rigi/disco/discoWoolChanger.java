package me.rigi.disco;

import org.bukkit.block.Block;

public class discoWoolChanger implements Runnable {
	public static Block block;

	public void run() {
		discoMain.blockChanger();
	}
}

package me.rigi.disco;

import org.bukkit.block.Block;

public class DiscoRunnable implements Runnable {
	public static Block block;

	public void run() {
		DiscoMain.blockChanger();
	}
}

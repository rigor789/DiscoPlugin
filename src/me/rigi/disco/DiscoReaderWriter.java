package me.rigi.disco;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;

public class DiscoReaderWriter {
	static String mainDirectory = "plugins/DiscoPlugin";
	static File blocks = new File(mainDirectory + File.separator + "blocks.dat");
	
	public void createDir() {
		new File(mainDirectory).mkdir();	
			if (!blocks.exists()) {				
			try {
				blocks.createNewFile();					
				} catch (IOException ex) {
				ex.printStackTrace();
			}
			}
		}
	
	public void ReadAll() {
		 try{
			 FileReader fstream = new FileReader(blocks);			
				BufferedReader in = new BufferedReader(fstream);
				String input=in.readLine();
				String[] items = input.split(";");
				 for(String block : items){
					 String[] item = block.split(",");
					 int x = Integer.parseInt(item[2]);
					 int y = Integer.parseInt(item[3]);
					 int z = Integer.parseInt(item[4]);
				World world = Bukkit.getServer().getWorld(item[1]);
				Block blockAt = world.getBlockAt(x,y,z);
				if(DiscoMain.blocks.containsKey(item[0])){
					DiscoMain.blocks.get(item[0]).add(blockAt);
					System.out.println("Allready existing disconame: "+item[0]+" and block added: "+ blockAt);
				}else{
				DiscoMain.blocks.put(item[0],new ArrayList<Block>());
				DiscoMain.blocks.get(item[0]).add(blockAt);
				System.out.println("Disconame: "+item[0]+" and block added: "+ blockAt);
				 }
				 }
			 }catch (Exception e){//Catch exception if any
				  System.err.println("Error: " + e.getMessage());
				  }
		
	}
	
public static void WriteAll() {
		
		Set<String> discos = DiscoMain.blocks.keySet();
		ArrayList<String> towrite =new ArrayList<String>();
		
for(String disco : discos){
	ArrayList<Block> blocks = DiscoMain.blocks.get(disco);
		
	for(Block block : blocks){
		String world = block.getWorld().getName();
		int x= block.getX();
		int y= block.getY();
		int z= block.getZ();
		towrite.add(disco+","+world+","+x+","+y+","+z+";");
	}
}
			
		boolean append = false;
		try{
			  FileWriter fstream = new FileWriter(blocks, append);
			  PrintWriter out = new PrintWriter(fstream, true); 
			  for(String coordinate : towrite){
				  out.write(coordinate);		 
			  }
						  
			  out.close(); //Close the output stream
			  }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
}
}

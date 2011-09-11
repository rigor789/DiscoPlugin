package me.rigi.disco;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;


public class coordinateReader {

	/*private static discoMain plugin;

	public coordinateReader(discoMain plugin) {
		coordinateReader.plugin = plugin;
	}
	*/
	
	private static discoMain main;

	public coordinateReader(discoMain plugin)
	{
		main = plugin;
	}
	
	//public static ArrayList<String> discosToLoadList = new ArrayList<String>();
	static String mainDirectory = "plugins/Disco";	
	//public static String discoName;
//	static File Disco = new File(mainDirectory + File.separator + discoName);
	
	
	
	public void readAll(){
		
	
		File dir = new File("plugins/Disco/");

	String[] children = dir.list();
	if (children == null) {
	    // Either dir does not exist or is not a directory
	} else {
	    for (int i=0; i<children.length; i++) {
	        // Get filename of file or directory
	    	//discoName = children[i];
	    	
	    	try{
				  // Create file 
				FileReader fstream = new FileReader("plugins/Disco/" +children[i]);
				
				BufferedReader in = new BufferedReader(fstream);
				String input=in.readLine();
			//	System.out.println("After buffered reader:"+ input);
				
				String[] items = input.split(";");
				
			//	System.out.println("split:"+ items);
			
				
				 for(String worldName : items){
					 String[] item = worldName.split(",");
					 int x = Integer.parseInt(item[1]);
					 int y = Integer.parseInt(item[2]);
					 int z = Integer.parseInt(item[3]);
					 
					
					
					// System.out.println("Before getworld after for...world: "+item[0]+ "x: "+x+" y: "+y+" z: "+z);
					 World world = Bukkit.getServer().getWorld(item[0]);
					// System.out.println("Before getblock after getworld"+world);
					Block blockAt = world.getBlockAt(x,y,z);
					
						discoMain.blocks.add(blockAt);
					 }
				
					Runnable discowoolchanger = new discoWoolChanger();
					
					Bukkit.getServer()
					.getScheduler()
					.scheduleSyncRepeatingTask(main, discowoolchanger, 100,	20);
				
	
				in.close(); //Close the input stream
				
			}catch (Exception e){//Catch exception if any
				  System.err.println("Error: " + e.getMessage());
				  }
		}
	    	
	    }
	}
	
}
	
	
	
	
	
	/* public static void reader() {
			// TODO Auto-generated method stub
		
				
			try{
				  // Create file 
				FileReader fstream = new FileReader(Disco);
				BufferedReader in = new BufferedReader(fstream);
				String input=in.readLine();
				
				
				String[] items = input.split(";");
				
				
				
				
				 for(String worldName : items){
					 String[] item = worldName.split(",");
					 int x = Integer.parseInt(item[1]);
					 int y = Integer.parseInt(item[2]);
					 int z = Integer.parseInt(item[3]);
				
					 World world = plugin.getServer().getWorld(item[0]);
						Block blockAt = world.getBlockAt(x,y,z);
					 	discoMain.blocks.put(item[1], blockAt);
					 }
				
				
	
				in.close(); //Close the input stream
				
			}catch (Exception e){//Catch exception if any
				  System.err.println("Error: " + e.getMessage());
				  }
		}
	
	 
	
}*/

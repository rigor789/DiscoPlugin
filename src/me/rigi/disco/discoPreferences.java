package me.rigi.disco;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.ChatColor;



public class discoPreferences{

	static String mainDirectory = "plugins/Disco";
	

	
	public void createDir() {

		new File(mainDirectory).mkdir();
		
}
	
	public static void removeDisco(String name){
		File Disco = new File(mainDirectory + File.separator + name + ".dat");
		File f1 = Disco;
		// boolean success = f1.delete();
		 
		  if (f1.delete()==false){
		  //System.out.println("Deletion failed.");
		  discoCmdExecutor.removeResponse=ChatColor.AQUA + "Disco " + name + " can't be removed/or dosen't exsist's.";
		  }else{
		  //System.out.println("File deleted.");
		  discoCmdExecutor.removeResponse=ChatColor.AQUA + "Disco " +name + " removed.";
		  discoList.remove(discoCmdExecutor.discoToRemove);
		    }
	}
	
	
	public static ArrayList<String> discoList = new ArrayList<String>();
	public static void listDiscos(){
		discoList.clear();
		File dir = new File("plugins/Disco/");

	String[] children = dir.list();
	if (children == null) {
	    // Either dir does not exist or is not a directory
	} else {
	    for (int i=0; i<children.length; i++) {
	        // Get filename of file or directory
	    	String filename = children[i];
	    	if (!(discoList.contains(filename.substring(0, filename.lastIndexOf('.'))))){
	    		discoList.add(filename.substring(0, filename.lastIndexOf('.')));
	    	}
	    	
	    }
	}
	
}
}
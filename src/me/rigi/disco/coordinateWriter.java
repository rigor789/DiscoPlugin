package me.rigi.disco;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class coordinateWriter {

	public boolean discoExists=false;

	static String mainDirectory = "plugins/Disco";
	static File Disco = new File(mainDirectory + File.separator + discoCmdExecutor.disconame + ".dat");
	
		 public static void coordinateWrite(String args){
			 

				if (!Disco.exists()) {
					
					
					try {
						Disco.createNewFile();
						writer(args);	
						
						} catch (IOException ex) {
						ex.printStackTrace();
					}
				}else{	
					
					writer(args);
				}
				}
			 
			 
		 private static void writer(String arg) {
				// TODO Auto-generated method stub
			 boolean append = true;
				try{
					  FileWriter fstream = new FileWriter(Disco, append);
					  PrintWriter out = new PrintWriter(fstream, true); 
					  out.write(arg);					  
					  out.close(); //Close the output stream
					  }catch (Exception e){//Catch exception if any
					  System.err.println("Error: " + e.getMessage());
					  }
			}		
		 
		
		 public static void coordinateRemove(String args){
			 if (!Disco.exists()){
				 //removecoordinate failed
			 }else{
				 //removecoordinate from file
			 }
		 }
		 
		  }

		
		
	

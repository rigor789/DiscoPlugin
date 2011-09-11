package me.rigi.disco;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class discoCmdExecutor implements CommandExecutor {
	private discoMain plugin;

	public discoCmdExecutor(discoMain plugin) {
		this.plugin = plugin;
	}
	
	
	public static String disconame = "name";
	public static String discoToRemove = "name";
	public static String removeResponse;
	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		
		Player playr = (Player) sender;
		
		
		if (commandLabel.equalsIgnoreCase("disco")) {
			if (sender instanceof Player){
			
			if ((args.length == 0)) {

				sender.sendMessage(ChatColor.RED + "Wrong args. Try one of these:");
				sender.sendMessage(ChatColor.GREEN +"/disco create " + ChatColor.GRAY +"<name>");
				sender.sendMessage(ChatColor.GREEN +"/disco finish");
				sender.sendMessage(ChatColor.GREEN +"/disco reset");
				sender.sendMessage(ChatColor.GREEN +"/disco remove " + ChatColor.GRAY +"<name>");
				sender.sendMessage(ChatColor.GREEN +"/disco list");
				return true;
			}else{
									
			if (args[0].equalsIgnoreCase("create")) {
				if (discoMain.using.contains(playr)) {
						sender.sendMessage("You already created a disco. use /disco finish to finish it!");
				}else{
					if (args.length >= 2){
						
						if (!sender.isOp()) {
							sender.sendMessage("You must be an OP!");
							return true;
							
						}else {
							disconame=args[1];
							coordinateWriter.coordinateWrite("");
							
							
							
					      
					        sender.sendMessage("Disco "+disconame+" created.");
							sender.sendMessage("Place wool to the ground, then /disco finish");
							Player p = (Player) sender;
							discoMain.players.add(p);
							discoMain.using.add(p);
							
					        
						
							return true;
						}
				
						}else{
					
						sender.sendMessage("Argument needed /disco create <name>");
						return true;
					}}
			
					
			}else if (args[0].equalsIgnoreCase("finish")) {
					
					if (!sender.isOp()) {
						sender.sendMessage("You must be an OP!");
						return true;
					} else {
						
						sender.sendMessage("Disco finished!");
						Player p = (Player) sender;
						discoMain.players.remove(p);
						discoMain.using.remove(p);
						
						
						Runnable discowoolchanger = new discoWoolChanger();
						
						Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, discowoolchanger, 100,20);
						
						return true;
					}

				}else if(args[0].equalsIgnoreCase("reset")){
					if(!sender.isOp()){
						sender.sendMessage("You must be an OP!");
						return true;
					}
					
					else{
						sender.sendMessage("Disco's reset.");
						discoMain.players.clear();
						discoMain.blocks.clear();
					}
				}else if(args[0].equalsIgnoreCase("remove")){
					if (discoMain.using.contains(playr)) {
						sender.sendMessage("You are already editing a disco. use /disco finish to finish it,");
						sender.sendMessage("and then try again!");
						return true;
					}else{
						if (args.length >= 2){
						
						
								
						if (!sender.isOp()) {
							sender.sendMessage("You must be an OP!");
							return true;
							
						}else {
							discoToRemove=args[1];
							discoPreferences.removeDisco(discoToRemove);
							
							 try {
				             Thread.sleep(1000);
				         }catch (Throwable t){
				                }
							
								sender.sendMessage(removeResponse);
						
							return true;
						}
						
						}else{
					sender.sendMessage("Argument needed /disco remove <name>");
					return true;
				}
					
					}
		}else if (args[0].equalsIgnoreCase("list")){
			if (discoMain.using.contains(playr)) {
				sender.sendMessage("You are already editing a disco. use /disco finish to finish it,");
				sender.sendMessage("and then try again!");
				return true;
			}else{
				if(!sender.isOp()){
					sender.sendMessage("You must be an OP!");
					return true;
				}else{
					discoPreferences.listDiscos();
					sender.sendMessage(ChatColor.AQUA+"Avaiable disco's: " +ChatColor.GREEN+ discoPreferences.discoList.toString());
					return true;
					}	
				}
			}	
			}
			}else{
				sender.sendMessage("This command can't be used from the console!");
				return true;
			}
			
			}//end of if commandlabel..disco
		
		return false;
}//end of onCommand
	}//end of the constructor
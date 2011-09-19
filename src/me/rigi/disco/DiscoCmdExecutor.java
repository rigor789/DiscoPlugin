package me.rigi.disco;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscoCmdExecutor implements CommandExecutor {
	private DiscoMain plugin;

	public DiscoCmdExecutor(DiscoMain plugin) {
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel,
			String[] args) {
		// TODO Auto-generated method stub
		if (sender instanceof Player){
		if (CommandLabel.equalsIgnoreCase("disco")){
			if(args.length==0){
				
			}else if(args[0].equalsIgnoreCase("create")){
				if(sender.isOp()||sender.hasPermission("discoplugin.create")){
					
				}else{
					sender.sendMessage("You dont have acces to that command");
				}
			
			}else if(args[0].equalsIgnoreCase("finish")){
				if(sender.isOp()||sender.hasPermission("discoplugin.create")){
					
				}else{
					sender.sendMessage("You dont have acces to that command");
				}
			}else if(args[0].equalsIgnoreCase("remove")){
				if(sender.isOp()||sender.hasPermission("discoplugin.remove")){
					
				}else{
					sender.sendMessage("You dont have acces to that command");
				}
			}else if(args[0].equalsIgnoreCase("list")){
				if(sender.isOp()||sender.hasPermission("discoplugin.list")){
					
				}else{
					sender.sendMessage("You dont have acces to that command");
				}
			}
		}
		
	}else{
		sender.sendMessage("Ingame command only!");
	}
		return false;
	}

}

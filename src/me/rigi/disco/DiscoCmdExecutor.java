package me.rigi.disco;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class DiscoCmdExecutor implements CommandExecutor {
	@SuppressWarnings("unused")
	private DiscoMain plugin;
	public DiscoCmdExecutor(DiscoMain plugin) {
		this.plugin = plugin;
	}	
	private HashMap<Player, String> using = DiscoMain.using;
	private HashMap<String, ArrayList<Block>> discos = DiscoMain.discos;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel,
			String[] args) {
		// TODO Auto-generated method stub
		Player player = (Player) sender;
		if (sender instanceof Player){
		if (CommandLabel.equalsIgnoreCase("disco")){
			if(args.length==0){
				
			}else if(args[0].equalsIgnoreCase("create")){ //CREATE
				if(sender.isOp()||sender.hasPermission("discoplugin.create")){
					if(args.length >= 2){
					if(using.containsKey(player)){
						sender.sendMessage("You have allready created a disco!");
					}else{
						using.put(player, args[1]);
						sender.sendMessage("Disco created!");
					}
				}else{
					sender.sendMessage("You must specify a name for the disco!");
				}
				}else{
					sender.sendMessage("You dont have acces to that command");
				}
				
			}else if(args[0].equalsIgnoreCase("edit")){ //EDIT
				if(sender.isOp()||sender.hasPermission("discoplugin.create")){
					if(args.length >= 2){
						if(using.containsKey(player)){
							sender.sendMessage("You are ellready editing a disco!");
						}else{
							if(discos.containsKey(args[1])){
							using.put(player, args[1]);
							}else{
								sender.sendMessage("You are trying to edit a disco that dosent exists");
							}
						}
					}else{
						sender.sendMessage("You must specify a name for the disco!");
					}
					}else{
						sender.sendMessage("You dont have acces to that command");
					}
				
			}else if(args[0].equalsIgnoreCase("finish")){ //FINISH
				if(sender.isOp()||sender.hasPermission("discoplugin.create")){
					if(using.containsKey(player)){
						using.remove(player);
						DiscoReaderWriter.WriteAll();
						DiscoReaderWriter.ReadAll();
						sender.sendMessage("Succesfully finished editing disco!");
					}else{
						sender.sendMessage("You must create/edit a disco in order to finish it!");
					}
				}else{
					sender.sendMessage("You dont have acces to that command");
				}
				
			}else if(args[0].equalsIgnoreCase("remove")){ //REMOVE
				if(sender.isOp()||sender.hasPermission("discoplugin.remove")){
					if(args.length >= 2){
						if(!(using.containsKey(sender))){
						if(discos.containsKey(args[1])){
						for(Block block : discos.get(args[1])){
							block.setType(Material.AIR);
							
						}
						player.getInventory().addItem(new ItemStack(Material.WOOL, discos.get(args[1]).size()));
						System.out.println("Integer of blocks in: "+discos.get(args[1])+" omfg: "+discos.get(args[1]).size());
						
						discos.remove(args[1]);
						DiscoReaderWriter.WriteAll();
						DiscoReaderWriter.ReadAll();
						sender.sendMessage("Disco removed!");
						}else{
						sender.sendMessage("That disco dosent exists");
						}	
						}else{
							sender.sendMessage("You are editing a disco! Type /disco finish and try again!");
						}
					}
				}else{
					sender.sendMessage("You dont have acces to that command");
				}
				
			}else if(args[0].equalsIgnoreCase("list")){ //LIST
				if(sender.isOp()||sender.hasPermission("discoplugin.list")){
					Set<String> alldiscos = DiscoMain.discos.keySet();	
					ArrayList<String> list = new ArrayList<String>();
					for(String disco : alldiscos){
						list.add(disco);
					}
					sender.sendMessage(list.toString());
				}else{
					sender.sendMessage("You dont have acces to that command");
				}
			}
		}
		
	}else{
		sender.sendMessage("Ingame command only!");
	}
		return true;
	}

}

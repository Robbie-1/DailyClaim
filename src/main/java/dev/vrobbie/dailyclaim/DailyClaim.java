package dev.vrobbie.dailyclaim;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author vRobbie <dev.bukkit.org>
 * ~ 11-06-16
 */

public class DailyClaim extends JavaPlugin {
	
    public void onEnable() {
    	init(); //generates default plugin files
        this.getLogger().info("DailyClaim has been enabled.");
        //check to see if program files are in directory => generate if not found.
    }

    public void onDisable() {
        this.getLogger().info("DailyClaim has bn disabled.");
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("claim") && sender instanceof Player) { //command sender must be player. --> TODO: add server giving claims maybe?
        	createPlayerFile(sender);
        	DailyClaimHandler dch = new DailyClaimHandler(sender, new Timestamp(System.currentTimeMillis()));
        	dch.handleClaim((Player) sender);
            return true;
        }
        return false;
    }
    
    public void init() {
    	FileConfiguration config = null;
    	
    	File file = new File("plugins" + File.separator + "DailyClaim" + File.separator + "world_setup.yml"); //world setup YAML
    	
    	if (!file.exists()) {
    		try {
    			file.createNewFile();
    		} catch (IOException e) {}

    		config = YamlConfiguration.loadConfiguration(file);
    		
    		config.set("allowMultiWorldSetup", false);
    		config.set("allowClaimIndependence", false);
    		
    		//scan worlds... etc{}

    		try {
    			config.save(file);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    public void createPlayerFile(CommandSender sender) {
    	Player pl = (Player) sender;
    	FileConfiguration config = null;
    	
    	/** plugins/DailyClaim/data/vRobbie.yml **/
    	
    	File file = new File("plugins" + File.separator + "DailyClaim" + File.separator + "data" + File.separator + pl.getPlayer().getName() + ".yml");
    	if (!file.exists()) {
    		//this.getLogger().info("Player Data File Created: " + pl.getPlayer().getName() + ".yml");
    		try {
    			file.createNewFile();
    		} catch (IOException e) {}

    		config = YamlConfiguration.loadConfiguration(file);
    		
    		config.set("PlayerData.name", pl.getPlayer().getName());
    		config.set("PlayerData.lastClaimTime", "null"); //New player, so hasn't done cmd "/claim"

    		try {
    			config.save(file);
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
    	}
    }

}

package com.tut;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.tut.commands.Goodbye;
import com.tut.commands.Hello;
import com.tut.event.block.BlockBreak;
import com.tut.event.player.PlayerChat;

public class Tut2 extends JavaPlugin {

	public void onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		
		registerCommands();
		registerEvents();
		registerConfig();
		
		
		logger.info(pdfFile.getName() + " Has Been Enabled (V." + pdfFile.getVersion() + ")");
	}

	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();

		logger.info(pdfFile.getName() + " Has Been Disabled (V." + pdfFile.getVersion() + ")");
	}

   public void  registerCommands() {
	   getCommand("hello").setExecutor(new Hello());
	   getCommand("goodbye").setExecutor(new Goodbye());
	   
   }
   
   public void registerEvents() {
	   PluginManager pm = getServer().getPluginManager();
	   
	   pm.registerEvents(new BlockBreak(), this);
	   pm.registerEvents(new PlayerChat(), this);
	   
    }

	private void registerConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
		
	}
}

	
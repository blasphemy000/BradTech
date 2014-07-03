package net.BradTech.mod;

import java.io.File;

import org.apache.logging.log4j.Level;

import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CfgHelper {

	// Enumeration for the configuration categories.
	private enum Categories {
		NetherOres("Nether Ores"),
		MiscConfig("Misc Config");
		
		private final String output;
		
		private Categories(final String str) {
			this.output = str;
		}
		
		@Override
		public String toString() {
			return output;
		}
	}
	
	
	// Instance of the Configuration class that handles the configuration file.
	File configFile;
	Configuration config;
	
	// All of the private variables and get functions to hold and retrieve the loaded configuration info.
	private Property netherMiningAngersPigmen;
	
	public boolean getNetherMiningAngersPigmen() {
		return netherMiningAngersPigmen.getBoolean(true);
	}
	
	
	private Property silkTouchDisablesPigmen;
	
	public boolean getSilkTouchDisablesPigmen() {
		return silkTouchDisablesPigmen.getBoolean(true);
	}
	
	
	private Property dummy;
	
	public int getDummy() {
		return dummy.getInt(-1);
	}
	
	
	public CfgHelper(FMLPreInitializationEvent preEvent) {
		//configFile = new File(preEvent.getModConfigurationDirectory().getAbsolutePath() + "/BradTech.cfg");
		configFile = preEvent.getSuggestedConfigurationFile();
		config = new Configuration(configFile);
		
		try {
			config.load();
			
			// Load all of the configuration properties.
			netherMiningAngersPigmen = config.get(Categories.NetherOres.toString(), "miningAngersPigmen", true);
			netherMiningAngersPigmen.comment = "This sets whether or not nearby pigmen will become angered when you mine the nether ores.";
			
			silkTouchDisablesPigmen = config.get(Categories.NetherOres.toString(), "silkTouchDisablesPigmen", true);
			silkTouchDisablesPigmen.comment = "If true the pigmen will NOT become angry when mining nether ores with a silk-touch tool.";
			
			dummy = config.get(Categories.MiscConfig.toString(), "dummyInteger", -1);
			dummy.comment = "This is just a dummy value for testing purposes.";
			
		} catch (Exception exc) {
			FMLLog.log(Level.FATAL, exc, BradTech.modid + " has had a problem loading the configuration file(%s).", configFile.getAbsolutePath());
		} finally {
			config.save();
		}
	}
	
}

package nl.LumiaAntiInvis;

import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin
{
	public static Main plugin;

	public static Main get() {
		return plugin;
	}

	public void onEnable() {
		plugin = this;
		log("===[Plugin version " + getDescription().getVersion()
				+ " Enabling]===");
		// EventHandlers/Listeners
		registerEvent();
		// Config load and safe
		//getConfig();
		//saveConfig();

		log("===[Plugin version " + getDescription().getVersion()
				+ "  Enabled]===");
	}

	public void onDisable() {
		log("===[Plugin version " + getDescription().getVersion()
				+ " Disabling]===");

		log("===[Plugin version " + getDescription().getVersion()
				+ "  Disabled]===");
	}

	public void log(String msg) {
		getLogger().info(msg);
	}
	
	private void registerEvent() {
		getServer().getPluginManager().registerEvents(new PotionListener(),
				this);
	}
}

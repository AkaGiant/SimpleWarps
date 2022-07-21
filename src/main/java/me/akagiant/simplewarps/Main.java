package me.akagiant.simplewarps;

import me.akagiant.simplewarps.commands.commands_simplewarps;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    static Main plugin;
    public static Config config, warps;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        config = new Config("config");
        warps = new Config("warps");

        getCommand("simplewarps").setExecutor(new commands_simplewarps());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getPlugin() {
        return plugin;
    }
}

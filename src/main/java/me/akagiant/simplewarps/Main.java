package me.akagiant.simplewarps;

import me.akagiant.giantapi.util.Config;
import me.akagiant.simplewarps.commands.commands_simplewarps;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin {

    static Main plugin;
    public static Config config, warps, test, test2;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        config = new Config(this, "config");
        warps = new Config(this, "warps");
        test = new Config(this, "test", "test");
        test2 = new Config(this, "test2", "test/test2");

        for (File file : Config.getAllConfigurationFiles(this)) {
            Bukkit.getLogger().info(file.getName());
        }

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

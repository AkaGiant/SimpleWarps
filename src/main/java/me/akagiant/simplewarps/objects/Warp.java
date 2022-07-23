package me.akagiant.simplewarps.objects;

import me.akagiant.giantapi.util.ColorManager;
import me.akagiant.simplewarps.Main;
import me.akagiant.simplewarps.Util;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;

import javax.security.auth.login.Configuration;
import javax.security.auth.login.ConfigurationSpi;
import java.util.ArrayList;
import java.util.List;

public class Warp {


    public Warp (String warpName, Location location) {

        // Convert values to 2 decimal places.
        Main.warps.getConfig().set("warps." + warpName + ".worldName", location.getWorld().getName());
        Main.warps.getConfig().set("warps." + warpName + ".x", Util.convertTo2DecimalPlaces(location.getX()));
        Main.warps.getConfig().set("warps." + warpName + ".y", Util.convertTo2DecimalPlaces(location.getY()));
        Main.warps.getConfig().set("warps." + warpName + ".z", Util.convertTo2DecimalPlaces(location.getZ()));
        Main.warps.getConfig().set("warps." + warpName + ".yaw", Util.convertTo2DecimalPlaces((double) location.getYaw()));
        Main.warps.getConfig().set("warps." + warpName + ".pitch", Util.convertTo2DecimalPlaces((double) location.getPitch()));
        Main.warps.saveConfig();

    }

    private static ConfigurationSection getSection(String warpName) {
       return Main.warps.getConfig().getConfigurationSection("warps." + warpName);
    }

    public static String getWorldName(String warpName) { return getSection(warpName).getString("worldName"); }
    public static Double getX(String warpName) { return getSection(warpName).getDouble("x"); }
    public static Double getY(String warpName) { return getSection(warpName).getDouble("y"); }
    public static Double getZ(String warpName) { return getSection(warpName).getDouble("z"); }
    public static Float getPitch(String warpName) { return (float) getSection(warpName).getDouble("pitch"); }
    public static Float getYaw(String warpName) { return (float) getSection(warpName).getDouble("yaw"); }


    public static boolean warpExists(String name) {
        for (String key : Main.warps.getConfig().getConfigurationSection("warps").getKeys(false)) {
            if (key.equals(name)) return true;
        }
        return false;
    }
}

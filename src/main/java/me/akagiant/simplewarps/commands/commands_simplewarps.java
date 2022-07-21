package me.akagiant.simplewarps.commands;

import me.akagiant.simplewarps.Main;
import me.akagiant.simplewarps.Warp;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class commands_simplewarps implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String cmdName, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("You cannot run this command");
            return false;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage("");
            return false;
        }

        switch (args[0]) {
            case "create": {
                new Warp(args[1], player.getLocation());
                break;
            }
            case "list": {
                Main.warps.getConfig().getConfigurationSection("warps").getKeys(false).forEach(key -> {
                    player.sendMessage("Warp: " + key);
                    player.sendMessage("World Name: " + Warp.getWorldName(key));
                    player.sendMessage("X: " + Warp.getX(key));
                    player.sendMessage("Y: " + Warp.getY(key));
                    player.sendMessage("Z: " + Warp.getZ(key));
                    player.sendMessage("Pitch: " + Warp.getPitch(key));
                    player.sendMessage("Yaw: " + Warp.getYaw(key));
                });
                break;

            }
        }


        return false;
    }
}

package com.katnissali.lureafk.Core;

import com.katnissali.lureafk.LureAfk;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Util {

    private static LureAfk main;
    private static PlayerManager playerManager;

    public static void setup(LureAfk m){
        main = m;
        playerManager = new PlayerManager();
    }

    //  CLASS GETTERS
    public static LureAfk getMain(){ return main; }
    public static PlayerManager getPlayerManager(){ return playerManager; }

    //  GETTERS
    public static String format(String str){
        return ChatColor.translateAlternateColorCodes('&', str);
    }
    public static String getPrefix(){ return ChatColor.RESET + "[" + ChatColor.GREEN + "LureAfk" + ChatColor.RESET + "] "; }
    public static void noPermission(Player player){ player.sendMessage(ChatColor.RED + "You do not have permission to do this."); }
    public static void onlyPlayers(){ print(ChatColor.RED + "Only players can do this."); }
    public static void print(String str){ Bukkit.getServer().getConsoleSender().sendMessage(str); }
    public static void debug(String str){
        print(ChatColor.DARK_RED + "DEBUG" + ChatColor.DARK_RED + " >> " + ChatColor.RED + str);
    }
    public static boolean isAir(ItemStack item){
        return item == null || item.getType().equals(Material.AIR);
    }
    public static void log(String msg){
        print(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "LOG >> " + ChatColor.BLUE + msg);
    }
}

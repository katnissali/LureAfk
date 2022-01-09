package com.katnissali.lureafk.Core;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class PlayerManager {

    private final ArrayList<AfkPlayer> players = new ArrayList<>();

    public PlayerManager(){
        Bukkit.getOnlinePlayers().forEach(this::register);
    }

    //  GETTERS
    public AfkPlayer getPlayer(Player player){
        for(AfkPlayer aPlayer : players){
            if(aPlayer.getPlayer().getName().equals(player.getName())) return aPlayer;
        }
        return null;
    }

    //  SETTERS
    public AfkPlayer register(Player player){
        AfkPlayer aPlayer = new AfkPlayer(player);
        players.add(aPlayer);
        return aPlayer;
    }
    public AfkPlayer unregister(Player player){
        AfkPlayer aPlayer = getPlayer(player);
        players.remove(aPlayer);
        return aPlayer;
    }
}

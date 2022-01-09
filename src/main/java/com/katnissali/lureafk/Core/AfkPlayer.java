package com.katnissali.lureafk.Core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class AfkPlayer {

    private static final double AFK_SECONDS = Util.getMain().getConfig().getDouble("afk-time") * 60;

    private final Player player;
    private boolean isAfk = false;
    private final Timer timer = new Timer((int)AFK_SECONDS){
        @Override
        public void onFinished() {
            if(!isAfk()) setAfk(true);
        }
    };

    public AfkPlayer(Player player){
        this.player = player;
    }

    //  GETTERS
    public Timer getTimer(){ return timer; }
    public boolean isAfk(){ return isAfk; }
    public Player getPlayer(){ return player; }

    //  SETTERS
    public void setAfk(boolean isAfk){
        this.isAfk = isAfk;
        if(!isAfk){
            timer.reset();
        } else {
            timer.setTimeLeft(-1);
        }
    }
}

package com.katnissali.lureafk.Events;

import com.katnissali.lureafk.Core.Util;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class AfkEvents implements Listener {

    //  DETECT MOVEMENT - RESET TIMER
    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Location to = e.getTo();
        Location from = e.getFrom();

        if(to.getX() == from.getX()
                && to.getY() == from.getY()
                && to.getZ() == from.getZ()
                && !Util.getMain().getConfig().getBoolean("reset-on-rotation"))
            return;
        Util.getPlayerManager().getPlayer(e.getPlayer()).setAfk(false);
    }

    //  REGISTER PLAYER
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Util.getPlayerManager().register(e.getPlayer());
    }

    //  UNREGISTER PLAYER
    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Util.getPlayerManager().unregister(e.getPlayer());
    }

}

package com.katnissali.lureafk.Commands;

import com.katnissali.lureafk.Core.AfkPlayer;
import com.katnissali.lureafk.Core.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AfkCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)){
            Util.onlyPlayers();
            return false;
        }

        AfkPlayer player = Util.getPlayerManager().getPlayer((Player) sender);
        if(!player.getPlayer().hasPermission("LureAfk.modify")){
            Util.noPermission(player.getPlayer());
            return false;
        }
        player.setAfk(!player.isAfk());

        return false;
    }
}

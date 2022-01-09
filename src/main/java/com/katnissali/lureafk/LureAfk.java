package com.katnissali.lureafk;

import com.katnissali.lureafk.Commands.AfkCmd;
import com.katnissali.lureafk.Core.Util;
import com.katnissali.lureafk.Events.AfkEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LureAfk extends JavaPlugin {

    @Override
    public void onEnable() {
        Util.print(Util.getPrefix() + "Enabling " + this.getName());
        if(!loadCore()){
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        loadConfig();

        Util.log("Loading commands and events.");
        registerCommands();
        registerEvents();
        Util.log("Loaded commands and events.");

        Util.print(Util.getPrefix() + "Enabled " + this.getName());
    }

    @Override
    public void onDisable() {
        Util.print(Util.getPrefix() + "Disabling plugin.");
    }
    public boolean loadCore(){
        Util.log("Loading core.");
        Util.setup(this);
        Util.log("Loaded core.");
        return true;
    }
    private void loadConfig(){
        Util.log("Loading config.");
        this.getConfig().options().copyDefaults();
        saveDefaultConfig();
        reloadConfig();
        Util.log("Config loaded.");
    }
    private void registerEvents(){
        Bukkit.getPluginManager().registerEvents(new AfkEvents(), this);
    }
    private void registerCommands(){
        getCommand("afk").setExecutor(new AfkCmd());
    }

}

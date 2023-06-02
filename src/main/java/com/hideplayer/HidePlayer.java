package com.hideplayer;

import org.bukkit.plugin.java.JavaPlugin;

public class HidePlayer extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getCommand("hideplayer").setExecutor(new HidePlayerCommand());
    }
}

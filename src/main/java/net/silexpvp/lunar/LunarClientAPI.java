package net.silexpvp.lunar;

import lombok.Getter;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class LunarClientAPI implements PluginMessageListener {

    @Getter private static JavaPlugin plugin;

    public LunarClientAPI(JavaPlugin plugin) {
        this.plugin = plugin;

        plugin.getServer().getMessenger().registerOutgoingPluginChannel(plugin, "Lunar-Client");
        plugin.getServer().getMessenger().registerIncomingPluginChannel(plugin, "Lunar-Client", this);
    }

    // We must register an incoming channel, otherwise, it won't work.
    @Override
    public void onPluginMessageReceived(String s, Player player, byte[] bytes) {

    }
}

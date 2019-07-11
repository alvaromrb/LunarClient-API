package net.silexpvp.lunar.packet;

import net.silexpvp.lunar.LunarClientAPI;
import net.silexpvp.lunar.packet.util.BufferUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public interface LCPacket extends BufferUtil {

    default void send(Player player) {
        try {
            player.sendPluginMessage(LunarClientAPI.getPlugin(), "Lunar-Client", getData().toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    default void send() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            try {
                player.sendPluginMessage(LunarClientAPI.getPlugin(), "Lunar-Client", getData().toByteArray());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    ByteArrayOutputStream getData() throws IOException;
}

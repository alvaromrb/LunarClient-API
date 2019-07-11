package net.silexpvp.lunar.packet.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.silexpvp.lunar.packet.LCPacket;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
public class LCPacketEmoteBroadcast implements LCPacket {

    private final Player player;
    private final Emote emote;

    @Override
    public ByteArrayOutputStream getData() throws IOException {
        ByteArrayOutputStream data = new ByteArrayOutputStream();

        data.write(26);

        data.write(getBytesFromUUID(player.getUniqueId()));
        data.write(writeInt(emote.getId()));

        data.close();

        return data;
    }

    @RequiredArgsConstructor
    @Getter
    public enum Emote {
        WAVE(0),
        HANDS_UP(1),
        FLOSS(2),
        DAB(3),
        T_POSE(4),
        SHRUG(5),
        FACEPALM(6);

        private final int id;
    }
}

package net.silexpvp.lunar.packet.impl;

import lombok.RequiredArgsConstructor;
import net.silexpvp.lunar.packet.LCPacket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
public class LCPacketTeammates implements LCPacket {

    private final long lastMillis;
    private final UUID[] players;

    @Override
    public ByteArrayOutputStream getData() throws IOException {
        ByteArrayOutputStream data = new ByteArrayOutputStream();

        data.write(13);

        data.write(writeLong(lastMillis));

        data.write(writeVarInt(players.length));
        for (UUID uniqueId : players) {
            data.write(getBytesFromUUID(uniqueId));
        }

        data.close();

        return data;
    }
}

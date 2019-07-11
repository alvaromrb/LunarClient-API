package net.silexpvp.lunar.packet.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.silexpvp.lunar.packet.LCPacket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
public class LCPacketServerRule implements LCPacket {

    private final Rule rule;
    private final int i;
    private final float f;
    private final boolean b;
    private final String message;

    @Override
    public ByteArrayOutputStream getData() throws IOException {
        ByteArrayOutputStream data = new ByteArrayOutputStream();

        data.write(10);

        data.write(writeString(rule.getName()));
        data.write(writeInt(i));
        data.write(writeFloat(f));
        data.write(writeBoolean(b));
        data.write(writeString(message));

        data.close();

        return data;
    }

    @RequiredArgsConstructor
    @Getter
    public enum Rule {
        MINIMAP_STATUS("minimapStatus"),
        SERVER_HANDLES_WAYPOINTS("serverHandlesWaypoints"),
        COMPETITIVE_GAMEMODE("competitiveGame");

        private final String name;
    }
}

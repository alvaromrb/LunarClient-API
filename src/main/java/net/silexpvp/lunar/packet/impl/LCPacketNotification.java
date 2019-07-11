package net.silexpvp.lunar.packet.impl;

import lombok.RequiredArgsConstructor;
import net.silexpvp.lunar.packet.LCPacket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
public class LCPacketNotification implements LCPacket {

    private final String message;
    private final long durationMillis;
    private final Level level;

    @Override
    public ByteArrayOutputStream getData() throws IOException {
        ByteArrayOutputStream data = new ByteArrayOutputStream();

        data.write(9);

        data.write(writeString(message));
        data.write(writeLong(durationMillis));
        data.write(writeString(level.name().toLowerCase()));

        data.close();

        return data;
    }


    public enum Level {
        INFO,
        ERROR,
        NEUTRAL
    }
}

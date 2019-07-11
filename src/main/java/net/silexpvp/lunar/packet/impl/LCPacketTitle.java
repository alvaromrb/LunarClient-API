package net.silexpvp.lunar.packet.impl;

import lombok.RequiredArgsConstructor;
import net.silexpvp.lunar.packet.LCPacket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
public class LCPacketTitle implements LCPacket {

    private final TitleType type;
    private final String message;
    private final float scale;
    private final long displayMillis;
    private final long fadeInMillis;
    private final long fadeOutMillis;

    @Override
    public ByteArrayOutputStream getData() throws IOException {
        ByteArrayOutputStream data = new ByteArrayOutputStream();

        data.write(14);

        data.write(writeString(type.name().toLowerCase()));
        data.write(writeString(message));
        data.write(writeFloat(scale));
        data.write(writeLong(displayMillis));
        data.write(writeLong(fadeInMillis));
        data.write(writeLong(fadeOutMillis));

        data.close();

        return data;
    }

    public enum TitleType {
        NORMAL, SUBTITLE
    }
}

package net.silexpvp.lunar.packet.impl;

import lombok.RequiredArgsConstructor;
import net.silexpvp.lunar.packet.LCPacket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
public class LCPacketServerUpdate implements LCPacket {

    private final String server;

    @Override
    public ByteArrayOutputStream getData() throws IOException {
        ByteArrayOutputStream data = new ByteArrayOutputStream();

        data.write(11);

        data.write(writeString(server));

        data.close();

        return data;
    }
}

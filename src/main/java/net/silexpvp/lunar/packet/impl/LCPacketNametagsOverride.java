package net.silexpvp.lunar.packet.impl;

import lombok.RequiredArgsConstructor;
import net.silexpvp.lunar.packet.LCPacket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
public class LCPacketNametagsOverride implements LCPacket {

    private final UUID uniqueId;
    private final String[] nametags;

    @Override
    public ByteArrayOutputStream getData() throws IOException {
        ByteArrayOutputStream data = new ByteArrayOutputStream();

        data.write(7);

        data.write(getBytesFromUUID(uniqueId));
        data.write(writeVarInt(nametags.length));
        for (String name : nametags) {
            data.write(writeString(name));
        }

        data.close();

        return data;
    }
}

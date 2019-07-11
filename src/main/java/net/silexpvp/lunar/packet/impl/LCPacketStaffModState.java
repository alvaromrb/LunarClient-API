package net.silexpvp.lunar.packet.impl;

import lombok.RequiredArgsConstructor;
import net.silexpvp.lunar.packet.LCPacket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
public class LCPacketStaffModState implements LCPacket {

    private final Mod mod;
    private final boolean status;

    @Override
    public ByteArrayOutputStream getData() throws IOException {
        ByteArrayOutputStream data = new ByteArrayOutputStream();

        data.write(12);

        data.write(writeString(mod.name().toLowerCase()));
        data.write(writeBoolean(status));

        data.close();

        return data;
    }

    public enum Mod {
        XRAY, BUNNY_HOP, NAME_TAGS, NO_CLIP
    }
}

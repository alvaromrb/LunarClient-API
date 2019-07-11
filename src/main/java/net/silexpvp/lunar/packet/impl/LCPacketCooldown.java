package net.silexpvp.lunar.packet.impl;

import lombok.RequiredArgsConstructor;
import net.silexpvp.lunar.packet.LCPacket;
import org.bukkit.Material;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
public class LCPacketCooldown implements LCPacket {

    private final String message;
    private final long durationMillis;
    private final Material material;

    @Override
    public ByteArrayOutputStream getData() throws IOException {
        ByteArrayOutputStream data = new ByteArrayOutputStream();

        data.write(3);

        data.write(writeString(message));
        data.write(writeLong(durationMillis));
        data.write(writeInt(material.getId()));

        return data;
    }
}

package net.silexpvp.lunar.packet.impl;

import lombok.RequiredArgsConstructor;
import net.silexpvp.lunar.packet.LCPacket;
import org.bukkit.World;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
public class LCPacketUpdateWorld implements LCPacket {

    private final World world;

    @Override
    public ByteArrayOutputStream getData() throws IOException {
        ByteArrayOutputStream data = new ByteArrayOutputStream();

        data.write(15);

        data.write(getBytesFromUUID(world.getUID()));

        data.close();

        return data;
    }
}

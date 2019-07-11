package net.silexpvp.lunar.packet.impl.border;

import lombok.RequiredArgsConstructor;
import net.silexpvp.lunar.packet.LCPacket;
import org.bukkit.World;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
public class LCPacketWorldBorderRemove implements LCPacket {

    private final World world;

    @Override
    public ByteArrayOutputStream getData() throws IOException {
        ByteArrayOutputStream data = new ByteArrayOutputStream();

        data.write(21);

        data.write(getBytesFromUUID(world.getUID()));

        data.close();

        return data;
    }
}

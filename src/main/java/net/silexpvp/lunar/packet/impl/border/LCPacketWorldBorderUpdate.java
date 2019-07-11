package net.silexpvp.lunar.packet.impl.border;

import lombok.RequiredArgsConstructor;
import net.silexpvp.lunar.packet.LCPacket;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.UUID;

@RequiredArgsConstructor
public class LCPacketWorldBorderUpdate implements LCPacket {

    private final UUID world;

    private final int minX;
    private final int minZ;
    private final int maxX;
    private final int maxZ;

    @Override
    public ByteArrayOutputStream getData() throws IOException {
        ByteArrayOutputStream data = new ByteArrayOutputStream();

        data.write(22);

        data.write(getBytesFromUUID(world));

        data.write(writeInt(minX));
        data.write(writeInt(minZ));
        data.write(writeInt(maxX));
        data.write(writeInt(maxZ));

        data.close();

        return data;
    }
}

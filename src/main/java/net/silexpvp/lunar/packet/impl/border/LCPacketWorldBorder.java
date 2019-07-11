package net.silexpvp.lunar.packet.impl.border;

import lombok.RequiredArgsConstructor;
import net.silexpvp.lunar.packet.LCPacket;
import org.bukkit.World;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RequiredArgsConstructor
public class LCPacketWorldBorder implements LCPacket {

    private final World world;
    private final boolean cancels;
    private final boolean shrink;

    private final int color;

    private final int minX;
    private final int minZ;
    private final int maxX;
    private final int maxZ;

    @Override
    public ByteArrayOutputStream getData() throws IOException {
        ByteArrayOutputStream data = new ByteArrayOutputStream();

        data.write(20);

        data.write(getBytesFromUUID(world.getUID()));
        data.write(writeBoolean(cancels));
        data.write(writeBoolean(shrink));
        data.write(writeInt(color));
        data.write(writeInt(minX));
        data.write(writeInt(minZ));
        data.write(writeInt(maxX));
        data.write(writeInt(maxZ));

        data.close();

        return data;
    }
}

package net.silexpvp.lunar.packet.util;

import com.google.common.base.Charsets;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.UUID;

public interface BufferUtil {

    default byte[] getBytesFromUUID(UUID uuid) {
        ByteBuffer buffer = ByteBuffer.wrap(new byte[16]);

        buffer.putLong(uuid.getMostSignificantBits());
        buffer.putLong(uuid.getLeastSignificantBits());

        return buffer.array();
    }

    default byte[] writeInt(int value) throws IOException {
        ByteArrayOutputStream arrayStream = new ByteArrayOutputStream();
        DataOutputStream dataStream = new DataOutputStream(arrayStream);

        dataStream.writeInt(value);

        dataStream.close();
        arrayStream.close();

        return arrayStream.toByteArray();
    }

    default byte[] writeVarInt(int value) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        while ((value & -128) != 0) {
            os.write(value & 127 | 128);
            value >>>= 7;
        }

        os.write(value);

        os.close();

        return os.toByteArray();
    }

    default byte[] writeString(String value) throws IOException {
        ByteArrayOutputStream arrayStream = new ByteArrayOutputStream();

        byte[] bytes = value.getBytes(Charsets.UTF_8);

        arrayStream.write(writeVarInt(bytes.length));
        arrayStream.write(bytes);

        arrayStream.close();

        return arrayStream.toByteArray();
    }

    default byte[] writeLong(long value) throws IOException {
        ByteArrayOutputStream arrayStream = new ByteArrayOutputStream();
        DataOutputStream dataStream = new DataOutputStream(arrayStream);

        dataStream.writeLong(value);

        dataStream.close();
        arrayStream.close();

        return arrayStream.toByteArray();
    }

    default byte[] writeFloat(float value) throws IOException {
        ByteArrayOutputStream arrayStream = new ByteArrayOutputStream();
        DataOutputStream dataStream = new DataOutputStream(arrayStream);

        dataStream.writeFloat(value);

        dataStream.close();
        arrayStream.close();

        return arrayStream.toByteArray();
    }

    default byte[] writeBoolean(boolean value) throws IOException {
        ByteArrayOutputStream arrayStream = new ByteArrayOutputStream();
        DataOutputStream dataStream = new DataOutputStream(arrayStream);

        dataStream.writeBoolean(value);

        dataStream.close();
        arrayStream.close();

        return arrayStream.toByteArray();
    }
}

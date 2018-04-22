package ru.md.network.messages;

import ru.md.utils.properties.PropertiesManager;

import java.nio.ByteBuffer;

/**
 * Created by Vladimir on 01.12.2017.
 */
public class MessageConstructor {

    public static ByteBuffer createDisconnectMessage(int clientNum) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(PropertiesManager.getMaxBufferSize());

        byteBuffer.clear();
        byteBuffer.putInt(MessageType.Disconnect.ordinal());
        byteBuffer.putInt(clientNum);
        byteBuffer.flip();
        return byteBuffer;
    }
}

package ru.md.network.export;

import ru.md.network.messages.MessageType;

/**
 * Created by Vladimir on 30.11.2017.
 */
public class UserAction extends ExportableObject {
    private final MessageType messageType = MessageType.GameAction;

    @Override
    public long getMessageSize() {
        return 0;
    }

    @Override
    public Byte[] getMessageBytes() {
        return new Byte[0];
    }
}

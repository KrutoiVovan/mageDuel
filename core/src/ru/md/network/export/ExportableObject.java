package ru.md.network.export;

import ru.md.network.messages.MessageType;

/**
 * Created by Vladimir on 30.11.2017.
 */
public abstract class ExportableObject {

    private final MessageType messageType;

    protected ExportableObject(MessageType messageType) {
        this.messageType = messageType;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public abstract long getMessageSize();
    public abstract Byte[] getMessageBytes();
}

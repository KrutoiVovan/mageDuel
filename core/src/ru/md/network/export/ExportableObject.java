package ru.md.network.export;

/**
 * Created by Vladimir on 30.11.2017.
 */
public abstract class ExportableObject {

    public abstract long getMessageSize();
    public abstract Byte[] getMessageBytes();
}

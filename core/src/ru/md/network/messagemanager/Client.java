package ru.md.network.messagemanager;

import ru.md.utils.log.Logger;
import ru.md.utils.properties.PropertiesManager;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by Vladimir on 29.11.2017.
 */
/*КОНТРАКТ: внутреннее поле buffer
всегда должно находиться в состоянии read,
за исключением момента записи в него из канала.
    */
class Client {

    private final SocketChannel channel;
    private long hearthBit;
    private ByteBuffer buffer = ByteBuffer.allocate(PropertiesManager.getMaxBufferSize());
    private boolean havePartOfMessage = false;
    private int readedPartSize = 0, partFullSize = 0;
    ByteBuffer partialMessage = ByteBuffer.allocate(PropertiesManager.getMaxBufferSize());



    public Client(SocketChannel channel) {
        this.channel = channel;
        hearthBit = System.currentTimeMillis();
        buffer.clear();
        buffer.flip();
    }


    public long getHearthBit() {
        return hearthBit;
    }

    public void setHearthBit(long hearthBit) {
        this.hearthBit = hearthBit;
    }

    public void disconnect() throws IOException {
        channel.close();
    }

    public void sendBytes(ByteBuffer buffer) throws IOException {
        channel.write(buffer);
        buffer.rewind();
    }

    public ByteBuffer receivePackage() throws IOException {
        //обрабатываем остатки целых сообщений в буфере
        if(buffer.remaining() > 0 && !havePartOfMessage)
            return processSinglePackage();
        buffer.clear();
        //получаем новые данные из канала
        if (channel.read(buffer) <= 0)
            return null;
        buffer.flip();

        //обрабатываем новые данные
        if (havePartOfMessage) {
            return processPartialPackage();
        } else {
            return processSinglePackage();
        }
    }

    private ByteBuffer processPartialPackage() {
        ByteBuffer message = null;
        if (buffer.remaining() + readedPartSize >= partFullSize) {
            message = partialMessage.duplicate();
            while(message.position() < partFullSize)
                message.put(buffer.get());
            havePartOfMessage = false;
            partialMessage.clear();
            readedPartSize = 0;
            partFullSize = 0;
        }
        return message;
    }

    private ByteBuffer processSinglePackage() {
        int packageLength = buffer.getInt();
        ByteBuffer message = null;
        if (buffer.remaining() >= packageLength) {
            message = buffer.duplicate();
            message.position(buffer.position());
            message.limit(message.position() + packageLength);
            buffer.position(buffer.position() + packageLength);
        } else {
            partialMessage.clear();
            havePartOfMessage = true;
            readedPartSize = buffer.remaining();
            partFullSize = packageLength;
            while (buffer.remaining() > 0)
                partialMessage.put(buffer.get());
        }

        return message;
    }

    @Override
    public String toString() {
        String clientInfo = "[EMPTY INFO]";
        try{
            clientInfo = this.channel.getRemoteAddress().toString();
        }catch (IOException e){
            Logger.log(e);
        }
        return clientInfo;
    }
}

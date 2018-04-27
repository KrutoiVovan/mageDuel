package ru.md.network.messages;

/**
 * Created by Vladimir on 29.11.2017.
 */
public enum MessageType {
    Connect,
    Disconnect,
    SendMessage,
    GameAction,
    GameStart,
    HeartBit,
    Unknown;

    public MessageType getMessageType(int code){
        if(code < MessageType.values().length)
            return MessageType.values()[code];
        else return MessageType.Unknown;
    }

    public int getCode(){
        return this.ordinal();
    }
}

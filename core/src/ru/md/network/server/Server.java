package ru.md.network.server;

import ru.md.network.messagemanager.ServerMessageManager;
import ru.md.utils.log.LogLevel;
import ru.md.utils.log.Logger;
import ru.md.utils.properties.PropertiesManager;

import java.io.IOException;

//Класс сервера, скрывающий логику обработки сообщений
public class Server {
    private final ServerMessageManager messageManager;

    private Server() throws IOException {
        messageManager = new ServerMessageManager();
    }

    private Server(int port) throws IOException {
        messageManager = new ServerMessageManager(port, PropertiesManager.getDefaulCapacity());
    }

    public static Server startNewServer(int port) throws IOException {
        Server server = null;
        Logger.log("Trying to start server at default port " + port, LogLevel.INFO);
        server = new Server(port);
        return server;
    }


}

package ru.md.network.server;

import ru.md.network.messages.MessageConstructor;
import ru.md.utils.log.LogLevel;
import ru.md.utils.log.Logger;
import ru.md.utils.properties.PropertiesManager;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladimir on 29.11.2017.
 */
public class SimpleServer {

    private List<Client> clients;
    private ServerSocketChannel registrationChannel;
    private int clientCapacity;


    public SimpleServer() throws IOException {
        this(PropertiesManager.getServerPort(),
                PropertiesManager.getDefaulCapacity());
    }

    public SimpleServer(int port, int clientCapacity) throws IOException {
        this.clientCapacity = clientCapacity;
        clients = new ArrayList<Client>();
            registrationChannel = ServerSocketChannel.open();
            registrationChannel.bind(new InetSocketAddress(port));
            registrationChannel.configureBlocking(false);
    }

    /*
        Публичный API сетевой части сервера.
     */
    public boolean acceptClient() throws IOException {
        SocketChannel newChannel = registrationChannel.accept();
        int clientNum = getFreeSocket();
        if (newChannel != null && clientNum != -1) {
            Logger.log("Accepted new client from "
                            + newChannel.getRemoteAddress().toString() +
                            "\n new number " + clientNum,
                    LogLevel.INFO);
            newChannel.configureBlocking(false);
            Client acceptedClient = new Client(newChannel);
            clients.add(acceptedClient);
            return true;
        }
        return false;
    }

    public ByteBuffer receivePackage(int clientNum) throws IOException {
        return clients.get(clientNum).receivePackage();
    }

    public void broadcastBytes(ByteBuffer bytes) throws IOException {
        for(Client client: clients)
            client.sendBytes(bytes);
    }

    public void sendBytes(int clientNum, ByteBuffer bytes) throws IOException {
        clients.get(clientNum).sendBytes(bytes);
    }

    public void disconnectClient(int clientNum) throws IOException {
        disconnectClient(clients.get(clientNum));
    }

    public void disconnectTimeoutedClients() throws IOException {
        for (Client client : clients) {
            if (System.currentTimeMillis() - client.getHearthBit() > PropertiesManager.getTimeoutMillis())
                disconnectClient(client);
        }
    }

    public void shutDown() throws IOException {
        for(Client client: clients)
            client.disconnect();
        registrationChannel.close();
        Logger.log("Произведена остановка игрового сервера", LogLevel.INFO);
    }

    private void disconnectClient(Client client) throws IOException {
        ByteBuffer message = MessageConstructor.createDisconnectMessage(clients.indexOf(client));
        broadcastBytes(message);
        client.disconnect();
        clients.remove(client);
    }

    private int getFreeSocket() {
        if (clients.size() < clientCapacity)
            return clients.size();
        return -1;
    }
}

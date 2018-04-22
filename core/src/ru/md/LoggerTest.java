package ru.md;

import ru.md.network.server.SimpleServer;
import ru.md.utils.properties.PropertiesManager;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * Created by Vladimir on 30.11.2017.
 */
public class LoggerTest {

//    public static void main(String[] args) {
//        CharBuffer byffer = CharBuffer.allocate(12);
//        byffer.clear();
//        byffer.put('a');
//        byffer.put('b');
//        byffer.flip();
//        System.out.println(byffer.remaining());
//        System.out.println(byffer.get(0));
//        byffer.flip();
//        byffer.compact();
//        byffer.flip();
//        System.out.println(byffer.get(0));
//        System.out.println(byffer.remaining());
//    }

//    public static void main(String[] args) {
//        try {
//
//            Thread server = new Thread() {
//
//                @Override
//                public void run() {
//                    System.out.println("Сервер запущен");
//                    try {
//                        SimpleServer server1 = new SimpleServer();
//                        while(!server1.acceptClient())
//                            System.out.println("NOT ACCEPTABLE");
//                        Thread.sleep(1000);
//
//                        ByteBuffer bufy = null;
//                        while(bufy == null) bufy = server1.receivePackage(0);
//                        System.out.println(new String(bufy.array()));
//                        server1.shutDown();
//                    }catch (Throwable e){
//                        //lol
//                    }
//                }
//            };
//
//            server.start();
//
//            Thread.sleep(1000);
//
//            SocketChannel socketChannel = SocketChannel.open();
//            socketChannel.connect(new InetSocketAddress("127.0.0.1", PropertiesManager.getServerPort()));
//            ByteBuffer buf = ByteBuffer.allocate(2048);
//            socketChannel.configureBlocking(false);
//
//            buf.clear();
//            buf.putInt("Hello".getBytes().length);
//            buf.put("Hello".getBytes());
//            buf.flip();
//            socketChannel.write(buf);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

//    //Отсылаем 2 сообщения, которые нужно пересобирать в конце.
//    public static void main(String[] args) {
//        try {
//
//            Thread server = new Thread() {
//
//                @Override
//                public void run() {
//                    System.out.println("Сервер запущен");
//                    try {
//                        SimpleServer server1 = new SimpleServer();
//                        while(!server1.acceptClient())
//                            System.out.println("NOT ACCEPTABLE");
//                        Thread.sleep(1000);
//
//                        ByteBuffer bufy = null;
//                        while(bufy == null) bufy = server1.receivePackage(0);
//                        String res = new String(Arrays.copyOfRange(bufy.array(), bufy.position(), bufy.limit()));
//                        bufy = null;
//                        while (bufy == null) bufy = server1.receivePackage(0);
//                        System.out.println(new String(bufy.array()));
//                        server1.shutDown();
//                    }catch (Throwable e){
//                        //lol
//                    }
//                }
//            };
//
//            server.start();
//
//            Thread.sleep(1000);
//
//            SocketChannel socketChannel = SocketChannel.open();
//            socketChannel.connect(new InetSocketAddress("127.0.0.1", PropertiesManager.getServerPort()));
//            ByteBuffer buf = ByteBuffer.allocate(64);
//            socketChannel.configureBlocking(false);
//
//            buf.clear();
//            buf.putInt("HelloHelloHelloHelloHelloHelloHelloHelloHelloHel".getBytes().length);
//            buf.put("HelloHelloHelloHelloHelloHelloHelloHelloHelloHel".getBytes());
//            buf.flip();
//            socketChannel.write(buf);
//            buf.clear();
//            buf.putInt("HelloHelloHelloHelloHelloHelloHelloHelloHelloHel".getBytes().length);
//            buf.put("HelloHelloHelloHelloHelloHelloHelloHelloHelloHel".getBytes());
//            buf.flip();
//            socketChannel.write(buf);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }

    //Отсылаем 2 сообщения, которые нужно пересобирать в конце.
    public static void main(String[] args) {
        try {

            Thread server = new Thread() {

                @Override
                public void run() {
                    System.out.println("Сервер запущен");
                    try {
                        SimpleServer server1 = new SimpleServer();
                        while(!server1.acceptClient())
                            System.out.println("NOT ACCEPTABLE");
                        Thread.sleep(1000);

                        ByteBuffer bufy = null;
                        while(bufy == null) bufy = server1.receivePackage(0);
                        String res = new String(Arrays.copyOfRange(bufy.array(), bufy.position(), bufy.limit()));
                        System.out.println(res);
                        bufy = null;
                        while (bufy == null) bufy = server1.receivePackage(0);
                        System.out.println(new String(bufy.array()));
                        server1.shutDown();
                    }catch (Throwable e){
                        //lol
                    }
                }
            };

            server.start();

            Thread.sleep(1000);

            SocketChannel socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress("127.0.0.1", PropertiesManager.getServerPort()));
            ByteBuffer buf = ByteBuffer.allocate(64);
            socketChannel.configureBlocking(false);

            buf.clear();
            buf.putInt("HelloHelloHello".getBytes().length);
            buf.put("HelloHelloHello".getBytes());
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
            buf.putInt("HelloHelloHello".getBytes().length);
            buf.put("HelloHelloHello".getBytes());
            buf.flip();
            socketChannel.write(buf);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

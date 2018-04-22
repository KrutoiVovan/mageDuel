package ru.md.utils.properties;

import ru.md.utils.log.LogLevel;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Vladimir on 29.11.2017.
 */
public class PropertiesManager {

    private static List<LogLevel> logLevels = Arrays.asList(new LogLevel[]{LogLevel.INFO, LogLevel.SEVERE});
    private static String logFile = "log.out";
    private static String logDir = "log";
    private static String serverAddress = "127.0.0.1";
    private static int serverPort = 6665;
    private static int defaulCapacity = 4;
    private static long timeoutMillis = 15000;
    private static int maxBufferSize = 2048;
    private static int widht = 1368/4*2;
    private static int height = 1024/4*2;
    private static boolean fullscreen = false;
    private static float scale = 2.0f;
    private static float margin = 0.05f;
    private static float scaleZ = 1.9f;
    private static boolean debug = true;
    private static float frustumRadius = 1.0f;

    public static long getTimeoutMillis() {
        return timeoutMillis;
    }

    public static List<LogLevel> getLevels() {
        return logLevels;
    }

    public static String getLogFile() {
        return logDir + "/" + logFile;
    }

    public static String getLogDir() {
        return logDir;
    }

    public static String getServerAddress() {
        return serverAddress;
    }

    public static int getServerPort() {
        return serverPort;
    }

    public static int getDefaulCapacity() {
        return defaulCapacity;
    }

    public static int getMaxBufferSize() {
        return maxBufferSize;
    }

    public static int getHeight() {
        return height;
    }

    public static int getWidht() {
        return widht;
    }

    public static boolean isFullscreen() {
        return fullscreen;
    }

    public static float getScale() {
        return scale;
    }

    public static float getMargin() {
        return margin;
    }

    public static float getScaleZ() {
        return scaleZ;
    }

    public static boolean isDebug() {
        return debug;
    }

    public static float getFrustumRadius() {
        return frustumRadius;
    }
}

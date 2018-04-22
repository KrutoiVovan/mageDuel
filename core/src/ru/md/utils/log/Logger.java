package ru.md.utils.log;

import ru.md.utils.properties.PropertiesManager;

import java.io.*;
import java.util.Date;

/**
 * Created by Vladimir on 29.11.2017.
 */
public class Logger {

    private static final File logOutput = new File(PropertiesManager.getLogFile());
    private static FileOutputStream stream = null;
    private Logger(){}

    public static void log(Throwable e){
        log(e.getStackTrace().toString(), LogLevel.SEVERE);
    }

    public static void log(String message, LogLevel level){
        if(!checkLevel(level)) return;
        createLogFileIfAbsent();
        writeInFile(message, level);
    }

    private static boolean checkLevel(LogLevel level) {
        return PropertiesManager.getLevels().contains(level);
    }

    private static void createLogFileIfAbsent() {
        if (!logOutput.exists()) {
            try {
                new File(PropertiesManager.getLogDir()).mkdir();
                logOutput.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(stream == null)
            try {
                stream = new FileOutputStream(logOutput);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
    }

    private static void writeInFile(String message, LogLevel level) {
        byte[] bytes = ("[" + new Date().toString() + "] " + level.name() + ": " + message + "\n").getBytes();
        try {
            stream.write(bytes);
            stream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

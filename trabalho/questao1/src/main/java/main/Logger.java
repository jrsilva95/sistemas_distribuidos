package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    private static String formatDateTime(LocalDateTime localDateTime){
        return localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    public static void info(Object message){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(ANSI_YELLOW + formatDateTime(now) + " - " + message + ANSI_RESET);
    }

    public static void online(Object message){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(ANSI_GREEN + formatDateTime(now) + " - " + message + ANSI_RESET);
    }

    public static void error(Object message){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(ANSI_RED + formatDateTime(now) + " - " + message + ANSI_RESET);
    }

    public static void print(Object message){
        System.out.println(message);
    }

}

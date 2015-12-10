/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grea.antoine.utils;

import java.io.PrintStream;

/**
 *
 * @author antoine
 */
public class Log {

    public static PrintStream out = System.err;
    public static boolean MULTILINE = false;
    public static boolean CONTEXTUALIZED = false;
    public static Level level = Level.DEBUG;

    public static void v(Object toLog) {
        log(Level.VERBOSE, toLog);
    }

    public static void d(Object toLog) {
        log(Level.DEBUG, toLog);
    }

    public static void i(Object toLog) {
        log(Level.INFO, toLog);
    }

    public static void w(Object toLog) {
        log(Level.WARNING, toLog);
    }

    public static void e(Object toLog) {
        log(Level.ERROR, toLog);
    }

    public static void f(Object toLog) {
        log(Level.FATAL, toLog);
        System.exit(-1);
    }

    private static void log(Level level, Object toLog) {
        if(level.compareTo(Log.level) < 0)
            return;
        if(toLog instanceof Exception)
        {
            log(level, (Exception) toLog);
            return;
        }
        String message = "" + toLog;
        out.println(level + ""
                + (CONTEXTUALIZED ? caller() : "")
                + (message.length() > 20 && MULTILINE ? "\n\t" : " ")
                + message.replaceAll("\n", "\n\t")
        );
    }

    private static void log(Level level, Exception exception) {
        out.println(level + ""
                + (CONTEXTUALIZED ? caller() : "") + " "
                + (CONTEXTUALIZED ? exception : exception.getLocalizedMessage()));
//        exception.printStackTrace(out);
    }

    private static StackTraceElement caller() {
        for (StackTraceElement element : new Exception().getStackTrace()) {
            if (!element.getClassName().equals(Log.class.getName())) {
                return element;
            }
        }
        throw new RuntimeException("Method should be called from outside of Log class.");
    }

    public static enum Level {

        VERBOSE,
        DEBUG,
        INFO,
        WARNING,
        ERROR,
        FATAL;
        
        private String offset;
        static {
            int max = 0;
            for(Level level : values()) {
                int lenght = level.name().length() ;
                max = ((max < lenght) ? lenght : max);
            }
            for(Level level : values())
            {
                level.offset = String.format("%" + (max - level.name().length()+1) +"s", "");
            }
        }
        

        @Override
        public String toString() {
            return "[" + name() + ']' + offset;
        }

    }
}

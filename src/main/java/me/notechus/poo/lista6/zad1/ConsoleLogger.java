package me.notechus.poo.lista6.zad1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author notechus.
 */
public class ConsoleLogger implements ILogger {
    @Override
    public void log(String message) {
        LocalDateTime date = LocalDateTime.now();
        System.out.println(date.format(DateTimeFormatter.ofPattern(format)) + " - " + message);
    }
}

package me.notechus.poo.lista6.zad1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author notechus.
 */
public class FileLogger implements ILogger {

    private PrintWriter writer;
    private File file;

    public FileLogger(String fileName) {
        try {
            file = new File(fileName);
            writer = new PrintWriter(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void log(String message) {
        LocalDateTime date = LocalDateTime.now();
        writer.write(date.format(DateTimeFormatter.ofPattern(format)) + " - " + message);
        writer.flush();
    }
}

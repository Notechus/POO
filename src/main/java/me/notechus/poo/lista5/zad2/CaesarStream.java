package me.notechus.poo.lista5.zad2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author notechus.
 */
public class CaesarStream {

    private InputStream inputStream;
    private OutputStream outputStream;
    private StreamType type;
    private int shift;

    public CaesarStream(InputStream inputStream, int shift) {
        this.inputStream = inputStream;
        this.type = StreamType.INPUT;
        this.shift = shift;
    }

    public CaesarStream(OutputStream outputStream, int shift) {
        this.outputStream = outputStream;
        this.type = StreamType.OUTPUT;
        this.shift = shift;
    }

    public int read(byte[] bytes) throws IllegalAccessException, IOException {
        if (inputStream == null || !StreamType.INPUT.equals(type)) {
            throw new IllegalAccessException("Wrong stream type initialized: " + type);
        }

        int res = inputStream.read(bytes);

        if (res != -1) {
            for (int i = 0; i < res; i++) {
                bytes[i] -= shift;
            }
        }

        return res;
    }

    public void write(byte[] bytes) throws IllegalAccessException, IOException {
        if (outputStream == null || !StreamType.OUTPUT.equals(type)) {
            throw new IllegalAccessException("Wrong stream type initialized: " + type);
        }

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] += shift;
        }

        this.outputStream.write(bytes);
    }

    public enum StreamType {
        INPUT, OUTPUT
    }

}

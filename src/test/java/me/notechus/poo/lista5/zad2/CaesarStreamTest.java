package me.notechus.poo.lista5.zad2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

/**
 * @author notechus.
 */
public class CaesarStreamTest {

    private static final String message = "This is test message";
    private File testFile;

    @Before
    public void setUp() throws IOException {
        testFile = new File("test.txt");
        testFile.createNewFile();
    }

    @After
    public void teardown() {
        if (testFile != null) {
            testFile.delete();
        }
    }

    @Test
    public void testCaesarStream() throws IOException, IllegalAccessException {
        FileOutputStream ofstream = new FileOutputStream(testFile);
        FileInputStream ifstream = new FileInputStream(testFile);

        CaesarStream inputStream = new CaesarStream(ifstream, 3);
        CaesarStream outputStream = new CaesarStream(ofstream, 3);

        outputStream.write(message.getBytes());

        byte[] tmp = new byte[20];
        int read = inputStream.read(tmp);

        assertEquals(message.length(), read);
        assertEquals(message, new String(tmp).trim());
    }

}